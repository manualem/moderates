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

public class InteractiveRemoteArduinoDataController implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;

	public InteractiveRemoteArduinoDataController(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveRemoteArduinoDataController.class.getName()); 
		InteractiveRemoteArduinoDataGUI.init();
		InteractiveRemoteArduinoDataGUI.addListener(this);	
	}
	
	

	private void doSend(byte[] packet){
		IncomingRemoteArduinoMessage data = RemoteArduinoProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
        	System.out.println(RemoteArduinoProtocol.createMessageForIncomingPacket(packet)+" --> "+packet);
            for (ProtocolHandler h : handlers){
				h.receiveMsg(packet);
			}
        }
	}

	public void senddigitalReadResult() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.DIGITAL_READ_RESULT;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte value = null;
		try{
			value = Byte.parseByte(InteractiveRemoteArduinoDataGUI.fielddigitalReadResult_value.getText());
			bb.put(value);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendanalogReadResult() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.ANALOG_READ_RESULT;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short value = null;
		try{
			value = Short.parseShort(InteractiveRemoteArduinoDataGUI.fieldanalogReadResult_value.getText());
			bb.putShort(value);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendpong() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.PONG;
		doSend(packet);
	}

	public void sendinterruptNotification() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.INTERRUPT_NOTIFICATION;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte interrupt = null;
		try{
			interrupt = Byte.parseByte(InteractiveRemoteArduinoDataGUI.fieldinterruptNotification_interrupt.getText());
			bb.put(interrupt);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}


	public void receiveMessage(byte[] packet){
		IncomingRemoteArduinoMessage data = RemoteArduinoProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			InteractiveRemoteArduinoDataGUI.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveRemoteArduinoDataGUI.sendButtondigitalReadResult) {
		 	senddigitalReadResult();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI.sendButtonanalogReadResult) {
		 	sendanalogReadResult();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI.sendButtonpong) {
		 	sendpong();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI.sendButtoninterruptNotification) {
		 	sendinterruptNotification();
		 }
	}
	
	public static void main(String args[]){
		InteractiveRemoteArduinoDataController controller = new InteractiveRemoteArduinoDataController();
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