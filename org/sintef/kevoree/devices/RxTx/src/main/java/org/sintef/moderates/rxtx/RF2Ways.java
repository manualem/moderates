package org.sintef.moderates.rxtx;

import gnu.io.SerialPort;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.sintef.moderates.rxtx.helper.RxTxHelper;

/**
 * This Kevoree component encapsulates the RF emitter/receiver made by Franck Fleurey
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "forwardESIC", type = PortType.MESSAGE),
    @RequiredPort(name = "forwardWM", type = PortType.MESSAGE),
    @RequiredPort(name = "otherOutput", type = PortType.MESSAGE)
})
@Provides({
    @ProvidedPort(name = "sendWMCommand", type = PortType.MESSAGE, async = true)
})
@ComponentType
public class RF2Ways extends AbstractRxTxDevice {

    @Start
    public void start() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Starting "+ this.getClass().getName() +" "+ this.getDictionary().get("name"));
        try {
            serialPort = RxTxHelper.connect((String) this.getDictionary().get("port"), this, 9600, SerialPort.DATABITS_8, SerialPort.PARITY_NONE, SerialPort.STOPBITS_2, SerialPort.FLOWCONTROL_NONE);
            readSerialPort();
            writeSerialPort();
        } catch (Exception ex) {
           Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Port(name = "sendWMCommand", method = "sendWMCommand")
    public void sendWMCommand(Object o) {
        if (o instanceof String) {
            String msg = ((String) o).trim();
            if (msg.startsWith("WMB")) {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: sending WM command: " + msg);
                serialWriter.setMsg(msg+"\r\n");
                //serialWriter.setMsg(msg+"\u1013");
                //serialWriter.setMsg(msg+"\u0A0D");
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
                this.getPortByName("forwardESIC", MessagePort.class).process(System.currentTimeMillis()+" "+sData);
            } else if (sData.startsWith("WM")) {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: forwarding WM data: " + data);
                this.getPortByName("forwardWM", MessagePort.class).process(sData);
            } else {
                Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: forwarding inputs: " + data);
                this.getPortByName("otherOutput", MessagePort.class).process(sData);
            }
        } else {
            Logger.getLogger(RF2Ways.class.getName()).log(Level.INFO, "RF2Ways: not forwarded: " + data);
        }
    }
}
