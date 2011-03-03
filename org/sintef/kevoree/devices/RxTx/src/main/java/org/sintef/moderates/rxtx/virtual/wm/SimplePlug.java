package org.sintef.moderates.rxtx.virtual.wm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * This Kevoree component (virtually) encapsulates the WaveMan SimplePlug (on/off) device.
 * Note that this component does not directly interact with the devices.
 * Rather, it should receive (logical) messages from the RF2Ways components corresponding
 * to the physical reception of a command (by the RF2Ways component). This does not
 * ensure that the command has physically been received by the device.
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "outputMessage", type = PortType.MESSAGE, async = true),
    @RequiredPort(name = "onOn", type = PortType.MESSAGE, async = true),
    @RequiredPort(name = "onOff", type = PortType.MESSAGE, async = true)
})
@Provides({
    @ProvidedPort(name = "inputMessage", type = PortType.MESSAGE, async = true)
})
@DictionaryType({
    @DictionaryAttribute(name = "WMaddress", defaultValue = "10", optional = false),
    @DictionaryAttribute(name = "WMOn", defaultValue = "0E", optional = false),
    @DictionaryAttribute(name = "WMOff", defaultValue = "00", optional = false)
})
@Library(name = "MODERATES::Devices")
@ComponentType
public class SimplePlug extends AbstractComponentType {

    private String wmAddr;
    private String wmOn;
    private String wmOff;

    @Start
    public void start() {
        Logger.getLogger(SimplePlug.class.getName()).log(Level.INFO, "SimpleSwitch: START");
        wmAddr = (String) this.getDictionary().get("WMaddress");
        wmOn = (String) this.getDictionary().get("WMOn");
        wmOff = (String) this.getDictionary().get("WMOff");
    }

    @Stop
    public void stop() {
        Logger.getLogger(SimplePlug.class.getName()).log(Level.INFO, "SimpleSwitch: STOP");
    }

    @Port(name = "inputMessage", method = "inputMessage")
    public void inputMessage(Object o) {
        if (o instanceof String) {
            String msg = ((String) o).trim();
            if (msg.startsWith("WM")) {
                msg = msg.replace("WM ", "");
                if (msg.startsWith(wmAddr) && msg.endsWith(wmOn)) {
                    Logger.getLogger(SimplePlug.class.getName()).log(Level.INFO, "SimpleSwitch has been turned on: " + msg);
                    if (this.isPortBinded("outputMessage")) {
                        this.getPortByName("outputMessage", MessagePort.class).process("SimpleSwitch has been turned on");
                    }
                    if (this.isPortBinded("onOn")) {
                        this.getPortByName("onOn", MessagePort.class).process(null);
                    }
                } else if (msg.startsWith(wmAddr) && msg.endsWith(wmOff)) {
                    Logger.getLogger(SimplePlug.class.getName()).log(Level.INFO, "SimpleSwitch has been turned off: " + msg);
                    if (this.isPortBinded("outputMessage")) {
                        this.getPortByName("outputMessage", MessagePort.class).process("SimpleSwitch has been turned off");
                    }
                    if (this.isPortBinded("onOff")) {
                        this.getPortByName("onOff", MessagePort.class).process(null);
                    }
                }
            }
        }
    }
}
