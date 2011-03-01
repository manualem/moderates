package org.sintef.moderates.rxtx;

import org.sintef.moderates.rxtx.helper.SerialWriter;
import org.sintef.moderates.rxtx.helper.SerialReader;
import org.sintef.moderates.rxtx.helper.RxTxHelper;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
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
    @RequiredPort(name = "forwardData", type = PortType.MESSAGE, async = true)
})
@Provides({
    @ProvidedPort(name = "sendDataOTA", type = PortType.MESSAGE, async = true)
})
@DictionaryType({
    @DictionaryAttribute(name = "port", defaultValue = "/dev/ttyUSB0", optional = false),
    @DictionaryAttribute(name = "name", defaultValue = "defaultName", optional = false),
    @DictionaryAttribute(name = "timeout", defaultValue = "250", optional = false),
    @DictionaryAttribute(name = "increment", defaultValue = "1.5", optional = false),
    @DictionaryAttribute(name = "retry", defaultValue = "4", optional = false)
})
@ThirdParties({
    @ThirdParty(name = "org.kevoree.extra.osgi.rxtx", url = "mvn:org.kevoree.extra/org.kevoree.extra.osgi.rxtx/2.2.0")
})
@Library(name = "MODERATES::Devices")
@ComponentType
public class XBeeGateway extends AbstractComponentType implements RxTxDevice {

    private SerialReader serialReader;
    private SerialWriter serialWriter;
    private SerialPort serialPort;

    @Start
    public void start() {
        Logger.getLogger(XBeeGateway.class.getName()).log(Level.INFO, "Starting XBeeGateway " + this.getDictionary().get("name"));
        try {
            serialPort = RxTxHelper.connect((String) this.getDictionary().get("port"), this);
            readSerialPort();
            writeSerialPort();
            sendDataOTA("");//just to init
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Stop
    public void stop() {
        Logger.getLogger(XBeeGateway.class.getName()).log(Level.INFO, "Stopping XBeeGateway " + this.getDictionary().get("name"));
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
            Logger.getLogger(XBeeGateway.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(XBeeGateway.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void writeSerialPort() {
        try {
            OutputStream out = serialPort.getOutputStream();
            serialWriter = new SerialWriter(out);
            serialWriter.start();
        } catch (IOException ex) {
            Logger.getLogger(XBeeGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Port(name = "sendDataOTA", method = "sendDataOTA")
    public void sendDataOTA(Object o) {
        if (o instanceof String) {
            Logger.getLogger(XBeeGateway.class.getName()).log(Level.INFO, "XBeeGateway: writing on serial port to send message over the air: " + o);
            serialWriter.setMsg((String) o);
        } else {
            Logger.getLogger(XBeeGateway.class.getName()).log(Level.WARNING, "XBeeGateway: Cannot handle " + o.getClass().getName() + " in XBeeGateway.pullData");
        }
    }

    public void push(Object data) {
        if (this.isPortBinded("forwardData")) {
            Logger.getLogger(XBeeGateway.class.getName()).log(Level.INFO, "XBeeGateway: forwarding data: "+data);
            this.getPortByName("forwardData", MessagePort.class).process(data);
        }

    }

    public static void main(String[] args) {
        System.out.println("main");
        XBeeGateway xbee1 = new XBeeGateway();
        HashMap dico = new HashMap();
        dico.put("port", "/dev/ttyUSB0");
        xbee1.setDictionary(dico);
        try {
            xbee1.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        XBeeGateway xbee2 = new XBeeGateway();
        HashMap dico2 = new HashMap();
        dico2.put("port", "/dev/ttyUSB2");
        xbee2.setDictionary(dico2);
        try {
            xbee2.start();
            xbee2.sendDataOTA("Test XBee");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
