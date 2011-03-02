package org.sintef.moderates.rxtx;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;

/**
 * This Kevoree component encapsulates the RF emitter/receiver made by Franck Fleurey
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "forwardESIC", type = PortType.MESSAGE, async = true),
    @RequiredPort(name = "forwardWM", type = PortType.MESSAGE, async = true)
})
@Provides({
    @ProvidedPort(name = "sendWMCommand", type = PortType.MESSAGE, async = true)
})
@ComponentType
public class RF2Ways extends AbstractRxTxDevice {

    @Port(name = "sendWMCommand", method = "sendWMCommand")
    public void sendWMCommand(Object o) {
        if (o instanceof String) {
            String msg = (String) o;
            if (msg.startsWith("WMB")) {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: sending WM command: " + msg);
                serialWriter.setMsg((String) o);
            } else {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.WARNING, "RF2Ways: Bad command: " + msg);
            }
        } else {
            Logger.getLogger(RF2Ways.class.getName()).log(Level.WARNING, "RF2Ways: Cannot handle " + o.getClass().getName());
        }
    }

    public void push(Object data) {
        if (data instanceof String) {
            String sData = (String) data;
            if (sData.startsWith("ESIC")) {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: forwarding ESIC data: " + data);
                this.getPortByName("forwardESIC", MessagePort.class).process(data);
            } else if (sData.startsWith("WM")) {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: forwarding WM data: " + data);
                this.getPortByName("forwardWM", MessagePort.class).process(data);
            }
        }
    }
}
