package org.sintef.moderates.rxtx.helper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerialWriter extends Thread {

    OutputStream out;
    boolean alive;
    //boolean newMsg;
    List<String> msg;

    public SerialWriter(OutputStream out) {
        this.out = out;
        this.msg = new LinkedList<String>();
        alive = true;
        //newMsg = false;
    }

    public void setMsg(String msg){
        this.msg.add("\u0002"+msg.trim()+"\n\u0003");
        //this.msg = msg.trim();
        //this.msg = "\u0002"+this.msg+"\n\u0003";
        //newMsg = true;
        //System.out.println("SerialWriter.setMsg("+msg+")");
    }

    public void shutdown() {
        try {
            alive = false;
            sleep(200);
            out.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        //System.out.println("SerialWriter.run");
        try {
            while (alive) {
                if (msg.size() > 0) {
                    System.out.println("Writing "+msg.get(0)+" on serial port");
                    this.out.write(msg.get(0).getBytes());
                    //newMsg = false;
                    msg.remove(0);
                }
                if (msg.isEmpty()){
                    sleep(100);
                } else {
                    sleep(10);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(SerialWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
