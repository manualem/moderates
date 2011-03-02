package org.sintef.moderates.rxtx;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
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
@ComponentType
public class LaunchPad extends AbstractRxTxDevice {


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
