package org.sintef.moderates.rxtx;


import java.util.HashMap;
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
    @RequiredPort(name = "forwardData", type = PortType.MESSAGE, async = true)
})
@Provides({
    @ProvidedPort(name = "sendDataOTA", type = PortType.MESSAGE, async = true)
})
@ComponentType
public class XBeeGateway extends AbstractRxTxDevice {

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
