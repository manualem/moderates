package org.sintef.moderates.rxtx;

import org.sintef.moderates.rxtx.helper.SerialReader;
import org.sintef.moderates.rxtx.helper.RxTxHelper;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * This Kevoree component encapsulates the RFID reader hardware component
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "pushRFIDtag", type = PortType.MESSAGE, async = true)
})
@DictionaryType({
    @DictionaryAttribute(name = "port", defaultValue = "/dev/ttyUSB0", optional = false)
})
@ThirdParties({
    @ThirdParty(name = "org.kevoree.extra.osgi.rxtx", url = "mvn:org.kevoree.extra/org.kevoree.extra.osgi.rxtx/2.2.0")
})
@Library(name = "MODERATES::Devices")
@ComponentType
public class RFIDComponent extends AbstractComponentType implements RxTxDevice {

    private SerialReader serialReader;
    private SerialPort serialPort;

    @Start
    public void start() {
        Logger.getLogger(RFIDComponent.class.getName()).log(Level.INFO, "Starting RFIDComponent");
        try {
            serialPort = RxTxHelper.connect((String) this.getDictionary().get("port"), this);
            readSerialPort();
        } catch (Exception ex) {
            Logger.getLogger(RFIDComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Stop
    public void stop() {
        Logger.getLogger(RFIDComponent.class.getName()).log(Level.INFO, "Stopping RFIDComponent");
        if (serialReader != null) {
            serialReader.shutdown();
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
            Logger.getLogger(RFIDComponent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(RFIDComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
