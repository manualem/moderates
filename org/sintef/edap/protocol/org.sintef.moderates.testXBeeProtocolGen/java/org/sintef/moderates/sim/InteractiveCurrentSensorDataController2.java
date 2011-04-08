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

public class InteractiveCurrentSensorDataController2 implements ActionListener, ProtocolHandler {

	private Logger log;
	
	private List<ProtocolHandler> handlers;

	public InteractiveCurrentSensorDataController2(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCurrentSensorDataController2.class.getName()); 
		InteractiveCurrentSensorDataGUI2.init();
		InteractiveCurrentSensorDataGUI2.addListener(this);	
	}
	
	

	private void doSend(byte[] packet){
		IncomingCurrentSensorMessage data = CurrentSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
        	System.out.println(CurrentSensorProtocol.createMessageForIncomingPacket(packet)+" --> "+packet);
            for (ProtocolHandler h : handlers){
				h.receiveMsg(packet);
			}
        }
	}

	public void sendstart() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = CurrentSensorProtocol.START;
		doSend(packet);
	}

	public void sendstop() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = CurrentSensorProtocol.STOP;
		doSend(packet);
	}

	public void sendping() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = CurrentSensorProtocol.PING;
		doSend(packet);
	}


	public void receiveMessage(byte[] packet){
		IncomingCurrentSensorMessage data = CurrentSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			InteractiveCurrentSensorDataGUI2.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveCurrentSensorDataGUI2.sendButtonstart) {
		 	sendstart();
		 }
		 else if ( ae.getSource() == InteractiveCurrentSensorDataGUI2.sendButtonstop) {
		 	sendstop();
		 }
		 else if ( ae.getSource() == InteractiveCurrentSensorDataGUI2.sendButtonping) {
		 	sendping();
		 }
	}
	
	public static void main(String args[]){
		InteractiveCurrentSensorDataController2 controller = new InteractiveCurrentSensorDataController2();
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