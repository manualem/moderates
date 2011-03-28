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


import java.util.logging.Level;
import java.util.logging.Logger;

public class InteractiveCoffeeSensorDataController implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;

	public InteractiveCoffeeSensorDataController(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCoffeeSensorDataController.class.getName()); 
		InteractiveCoffeeSensorDataGUI.init();
		InteractiveCoffeeSensorDataGUI.addListener(this);	
	}
	
	

	private void doSend(byte[] packet){
		IncomingCoffeeSensorMessage data = CoffeeSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
        	System.out.println(CoffeeSensorProtocol.createMessageForIncomingPacket(packet)+" --> "+packet);
            for (ProtocolHandler h : handlers){
				h.receiveMsg(packet);
			}
        }
	}


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