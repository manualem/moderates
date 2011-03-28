package org.sintef.moderates.sim;

import org.sintef.moderates.*;
import org.sintef.moderates.in.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.nio.ByteBuffer;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

import java.util.logging.Level;
import java.util.logging.Logger;

@Provides({
    @ProvidedPort(name = "in", type = PortType.MESSAGE)
})
@Requires({
    @RequiredPort(name = "out", type = PortType.MESSAGE)
})
@Library(name = "Moderates::Stub")
@ComponentType
public class InteractiveCoffeeSensorDataController extends AbstractComponentType implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;

	public InteractiveCoffeeSensorDataController(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCoffeeSensorDataController.class.getName()); 
		InteractiveCoffeeSensorDataGUI.init();
		InteractiveCoffeeSensorDataGUI.addListener(this);	
	}
	
	@Start
    public void start() {
    	log.log(Level.INFO, "InteractiveCoffeeSensorDataController has been started");
    }

    @Stop
    public void stop() {
    	log.log(Level.INFO, "InteractiveCoffeeSensorDataController has been stopped");
    }

    @Update
    public void update() {
    
    }
	

	private void doSend(byte[] packet){
		IncomingCoffeeSensorMessage data = CoffeeSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			if (this.isPortBinded("out")) {
           		this.getPortByName("out", MessagePort.class).process(packet);
          		log.log(Level.INFO, "Message sent "+packet);
        	} else {
        		log.log(Level.WARNING, "No component connected to output port. Cannot send message: "+result);
        	}
            for (ProtocolHandler h : handlers){
				h.receiveMsg(packet);
			}
        }
	}


	@Port(name="in", method="receiveMessage")
	public void receiveMessage(byte[] packet){
		IncomingCoffeeSensorMessage data = CoffeeSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			InteractiveCoffeeSensorDataGUI.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	}
	
	public static void main(String args[]){
		InteractiveCoffeeSensorDataController controller = new InteractiveCoffeeSensorDataController();
	}
	
	@Override
	public void register(ProtocolHandler handler) {
		handlers.add(handler);
	}

	@Override
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}
}