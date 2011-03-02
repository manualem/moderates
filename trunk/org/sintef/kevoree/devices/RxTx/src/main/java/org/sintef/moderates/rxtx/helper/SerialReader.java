package org.sintef.moderates.rxtx.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sintef.moderates.rxtx.RxTxDevice;

public class SerialReader extends Thread {

    InputStream in;
    boolean alive;
    RxTxDevice device;

    public SerialReader(InputStream in, RxTxDevice device) {
        this.in = in;
        this.device = device;
        alive = true;
    }

    public void shutdown() {
        try {
            alive = false;
            sleep(200);
            in.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SerialReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        //System.out.println(device.getClass().getName()+".SerialReader.run");
        while (alive) {
            byte[] buffer = new byte[1024];
            int len = -1;
            try {
                String data = "";
                while ((len = this.in.read(buffer)) > -1) {
                    data += new String(buffer, 0, len);
                    if (data.endsWith("\n") || data.endsWith("\u0003") || data.endsWith("\u0A0D")) {
                        break;
                    }
                }
                device.push(data.trim().replace("\u0002", "").replace("\u0003", "").replace("\u0A0D", ""));
                sleep(100);
                //System.out.println();
            } catch (InterruptedException ex) {
                Logger.getLogger(SerialReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                 Logger.getLogger(SerialReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //System.out.println(device.getClass().getName()+".SerialReader has been shut down");
    }
}
