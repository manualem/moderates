package org.sintef.moderates.rxtx.virtual.wm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * This Kevoree component (virtually) encapsulates the WaveMan RingBell device.
 * Note that this component does not directly interact with the devices.
 * Rather, it should receive (logical) messages from the RF2Ways components corresponding
 * to the physical reception of a command (by the RF2Ways component). This does not
 * ensure that the command has physically been received by the device.
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "outputMessage", type = PortType.MESSAGE),
    @RequiredPort(name = "onRing", type = PortType.MESSAGE)
})
@Provides({
    @ProvidedPort(name = "inputMessage", type = PortType.MESSAGE, async = true)
})
@DictionaryType({
    @DictionaryAttribute(name = "WMaddress", defaultValue = "10", optional = false),
    @DictionaryAttribute(name = "WMRing", defaultValue = "0E", optional = false)
})
@Library(name = "MODERATES::Devices")
@ComponentType
public class RingBell extends AbstractComponentType {

    private String wmAddr;
    private String wmRing;

    @Start
    public void start() {
        Logger.getLogger(RingBell.class.getName()).log(Level.INFO, "RingBell: START");
        wmAddr = (String) this.getDictionary().get("WMaddress");
        wmRing = (String) this.getDictionary().get("WMRing");
    }

    @Stop
    public void stop() {
        Logger.getLogger(RingBell.class.getName()).log(Level.INFO, "RingBell: STOP");
    }

    @Port(name = "inputMessage", method = "inputMessage")
    public void inputMessage(Object o) {
        if (o instanceof String) {
            String msg = ((String) o).trim();
            if (msg.startsWith("WM")) {
                msg = msg.replace("WM ", "");
                if (msg.startsWith(wmAddr) && msg.endsWith(wmRing)) {
                    Logger.getLogger(RingBell.class.getName()).log(Level.INFO, "RingBell has been activated: " + msg);
                    if (this.isPortBinded("outputMessage")) {
                        this.getPortByName("outputMessage", MessagePort.class).process("RingBell has been activated");
                    }
                    if (this.isPortBinded("onRing")) {
                        this.getPortByName("onRing", MessagePort.class).process(null);
                    }
                }
            }
        }
    }
}
