/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sintef.moderates.rxtx.helper;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sintef.moderates.rxtx.RxTxDevice;

/**
 *
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
public final class RxTxHelper {

    public static void registerPort(String port) {
        String prop = System.getProperty("gnu.io.rxtx.SerialPorts");
        if (prop == null) {
            prop = "";
        }
        if (!prop.contains(port)) {
            prop += port + ":";
            System.setProperty("gnu.io.rxtx.SerialPorts", prop);
        }
        //System.out.println("gnu.io.rxtx.SerialPorts = " + prop);

        prop = System.getProperty("javax.comm.rxtx.SerialPorts");
        if (prop == null) {
            prop = "";
        }
        if (!prop.contains(port)) {
            prop += port + ":";
            System.setProperty("javax.comm.rxtx.SerialPorts", prop);
        }
        //System.out.println("javax.comm.rxtx.SerialPorts = " + prop);
    }

    /**
     * Get the serial port with default configuration (for ID20, XBee)
     * @param port
     * @return
     * @throws Exception
     */
    public static SerialPort connect(String port, RxTxDevice device) throws Exception {
        return RxTxHelper.connect(port, device, 9600, SerialPort.DATABITS_8, SerialPort.PARITY_NONE, SerialPort.STOPBITS_1, SerialPort.FLOWCONTROL_RTSCTS_OUT);
    }

    public static SerialPort connect(String port, RxTxDevice device, int bitPerSec, int dataBits, int parity, int stopBits, int flowControl) throws Exception {
        Logger.getLogger(RxTxHelper.class.getName()).log(Level.INFO, "Try to connect "+device.getClass().getName()+" on " + port);

        RxTxHelper.registerPort(port);

        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
        if (portIdentifier.isCurrentlyOwned()) {
            Logger.getLogger(RxTxHelper.class.getName()).log(Level.SEVERE, "Error: Port is currently in use");
            return null;
        } else {
            CommPort commPort = portIdentifier.open(device.getClass().getName(), 2000);

            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(bitPerSec, dataBits, stopBits, parity);
                serialPort.setFlowControlMode(flowControl);

                return serialPort;
            } else {
                Logger.getLogger(RxTxHelper.class.getName()).log(Level.SEVERE, "Error: Only serial ports are handled by RxTxHelper");
                return null;
            }
        }
    }
}
