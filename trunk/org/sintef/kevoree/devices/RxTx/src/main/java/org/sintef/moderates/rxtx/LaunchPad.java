package org.sintef.moderates.rxtx;

import org.sintef.moderates.rxtx.helper.SerialWriter;
import org.sintef.moderates.rxtx.helper.SerialReader;
import org.sintef.moderates.rxtx.helper.RxTxHelper;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * This Kevoree component encapsulates the XBee/USB component
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "forwardOnPress", type = PortType.MESSAGE, async = true),
    @RequiredPort(name = "forwardOnRelease", type = PortType.MESSAGE, async = true)
})
@Provides({
    @ProvidedPort(name = "turnOnGreenLED", type = PortType.MESSAGE, async = true),
    @ProvidedPort(name = "turnOffGreenLED", type = PortType.MESSAGE, async = true),
    @ProvidedPort(name = "turnOnRedLED", type = PortType.MESSAGE, async = true),
    @ProvidedPort(name = "turnOffRedLED", type = PortType.MESSAGE, async = true),
    @ProvidedPort(name = "chatWithLaunchPad", type = PortType.MESSAGE, async = true)
})
@DictionaryType({
    @DictionaryAttribute(name = "port", defaultValue = "/dev/ttyACM0", optional = false),
    @DictionaryAttribute(name = "name", defaultValue = "LaunchPad", optional = false)
})
@ThirdParties({
    @ThirdParty(name = "org.kevoree.extra.osgi.rxtx", url = "mvn:org.kevoree.extra/org.kevoree.extra.osgi.rxtx/2.2.0")
})
@Library(name = "MODERATES::Devices")
@ComponentType
public class LaunchPad extends AbstractComponentType implements RxTxDevice {

    private SerialReader serialReader;
    private SerialWriter serialWriter;
    private SerialPort serialPort;

    @Start
    public void start() {
        Logger.getLogger(LaunchPad.class.getName()).log(Level.INFO, "Starting LaunchPad " + this.getDictionary().get("name"));
        try {
            serialPort = RxTxHelper.connect((String) this.getDictionary().get("port"), this);
            readSerialPort();
            writeSerialPort();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Stop
    public void stop() {
        Logger.getLogger(LaunchPad.class.getName()).log(Level.INFO, "Stopping LaunchPad " + this.getDictionary().get("name"));
        if (serialReader != null) {
            serialReader.shutdown();
        }
        if (serialWriter != null) {
            serialWriter.shutdown();
        }
        if (serialPort != null) {
            serialPort.close();
        }
    }

    private void readSerialPort() {
        InputStream in = null;
        try {
            in = serialPort.getInputStream();
            serialReader = new SerialReader(in, this);
            serialReader.start();
        } catch (IOException ex) {
            Logger.getLogger(LaunchPad.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(LaunchPad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void writeSerialPort() {
        try {
            OutputStream out = serialPort.getOutputStream();
            serialWriter = new SerialWriter(out);
            serialWriter.start();
        } catch (IOException ex) {
            Logger.getLogger(LaunchPad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Port(name = "turnOnGreenLED", method = "turnOnGreenLED")
    public void turnOnGreenLED(Object o) {
        serialWriter.setMsg("G");
    }

    @Port(name = "turnOffGreenLED", method = "turnOffGreenLED")
    public void turnOffGreenLED(Object o) {
        serialWriter.setMsg("g");
    }

    @Port(name = "turnOnRedLED", method = "turnOnRedLED")
    public void turnOnRedLED(Object o) {
        serialWriter.setMsg("R");
    }

    @Port(name = "turnOffRedLED", method = "turnOffRedLED")
    public void turnOffRedLED(Object o) {
        serialWriter.setMsg("r");
    }

    @Port(name = "chatWithLaunchPad", method = "chatWithLaunchPad")
    public void chatWithLaunchPad(Object o) {
        if (o instanceof String) {
            String cmd = (String) o;
            if (cmd.length() == 1) {
                char c = cmd.charAt(0);
                switch (c) {
                    case 'g':
                        turnOffGreenLED(null);
                        break;
                    case 'G':
                        turnOnGreenLED(null);
                        break;
                    case 'r':
                        turnOffRedLED(null);
                        break;
                    case 'R':
                        turnOnRedLED(null);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void push(Object data) {
        String status = (String) data;
        Logger.getLogger(LaunchPad.class.getName()).log(Level.INFO, "LaunchPad: status = " + status);
        if (status.equals("P")) {
            if (this.isPortBinded("forwardOnPress")) {
                this.getPortByName("forwardOnPress", MessagePort.class).process(data);
            }
        } else if (status.equals("R")) {
            if (this.isPortBinded("forwardOnRelease")) {
                this.getPortByName("forwardOnRelease", MessagePort.class).process(data);
            }
        } else {
            Logger.getLogger(LaunchPad.class.getName()).log(Level.WARNING, "LaunchPad: status = " + status + " is unknown");
        }
    }

    public static void main(String[] args) {
    }
}
