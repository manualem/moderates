/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sintef.moderates.rxtx;

import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.sintef.moderates.rxtx.helper.RxTxHelper;
import org.sintef.moderates.rxtx.helper.SerialReader;
import org.sintef.moderates.rxtx.helper.SerialWriter;

/**
 *
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@DictionaryType({
    @DictionaryAttribute(name = "port", defaultValue = "/dev/ttyUSB0", optional = false),
    @DictionaryAttribute(name = "name", defaultValue = "defaultName", optional = false),
})
@ThirdParties({
    @ThirdParty(name = "org.kevoree.extra.osgi.rxtx", url = "mvn:org.kevoree.extra/org.kevoree.extra.osgi.rxtx/2.2.0")
})
@Library(name = "MODERATES::Devices")
@ComponentFragment
public abstract class AbstractRxTxDevice extends AbstractComponentType implements RxTxDevice{
    protected SerialReader serialReader;
    protected SerialWriter serialWriter;
    protected SerialPort serialPort;

    @Start
    public void start() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Starting "+ this.getClass().getName() +" "+ this.getDictionary().get("name"));
        try {
            serialPort = RxTxHelper.connect((String) this.getDictionary().get("port"), this);
            readSerialPort();
            writeSerialPort();
        } catch (Exception ex) {
           Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Stop
    public void stop() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Stopping "+ this.getClass().getName() +" " + this.getDictionary().get("name"));
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
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void writeSerialPort() {
        try {
            OutputStream out = serialPort.getOutputStream();
            serialWriter = new SerialWriter(out);
            serialWriter.start();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

}
