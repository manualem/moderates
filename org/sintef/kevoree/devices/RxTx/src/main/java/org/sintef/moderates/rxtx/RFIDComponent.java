package org.sintef.moderates.rxtx;

import org.sintef.moderates.rxtx.helper.RxTxHelper;

import java.util.HashMap;

import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;

/**
 * This Kevoree component encapsulates the RFID reader hardware component
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "pushRFIDtag", type = PortType.MESSAGE, async = true)
})
@ComponentType
public class RFIDComponent extends AbstractRxTxDevice {

    @Override
    public void push(Object msg) {
        String tag = (String) msg;
        tag.replace("\u0002", "");//<STX>
        tag.replace(System.getProperty("line.separator"), "");//<CR><LF>
        tag.replace("\u0003", "");//<ETX>
        tag.replace("", "");
        //System.out.println("RFID tag = " + tag);
        if (this.isPortBinded("pushRFIDtag")) {
            //System.out.println("Pushing RFID tag");
            this.getPortByName("pushRFIDtag", MessagePort.class).process(tag);
        }
    }

    public static void main(String[] args) {
        System.out.println("main");
        RFIDComponent rfid = new RFIDComponent();
        HashMap dico = new HashMap();
        dico.put("port", "COM6"/*"/dev/ttyUSB1"*/);
        rfid.setDictionary(dico);
        try {
            RxTxHelper.connect((String)dico.get("port"),rfid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
