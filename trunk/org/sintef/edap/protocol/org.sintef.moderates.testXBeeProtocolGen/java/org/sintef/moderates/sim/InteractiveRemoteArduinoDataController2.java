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

public class InteractiveRemoteArduinoDataController2 implements ActionListener, ProtocolHandler {

	private Logger log;
	
	private List<ProtocolHandler> handlers;

	public InteractiveRemoteArduinoDataController2(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveRemoteArduinoDataController2.class.getName()); 
		InteractiveRemoteArduinoDataGUI2.init();
		InteractiveRemoteArduinoDataGUI2.addListener(this);	
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

	public void sendpinMode() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.PIN_MODE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte pin = null;
		Byte mode = null;
		try{
			pin = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldpinMode_pin.getText());
			bb.put(pin);
			mode = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldpinMode_mode.getText());
			bb.put(mode);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void senddigitalRead() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.DIGITAL_READ;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte pin = null;
		try{
			pin = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fielddigitalRead_pin.getText());
			bb.put(pin);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void senddigitalWrite() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.DIGITAL_WRITE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte pin = null;
		Byte value = null;
		try{
			pin = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fielddigitalWrite_pin.getText());
			bb.put(pin);
			value = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fielddigitalWrite_value.getText());
			bb.put(value);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendanalogReference() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.ANALOG_REFERENCE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte type = null;
		try{
			type = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldanalogReference_type.getText());
			bb.put(type);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendanalogRead() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.ANALOG_READ;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte pin = null;
		try{
			pin = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldanalogRead_pin.getText());
			bb.put(pin);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendanalogWrite() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.ANALOG_WRITE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte pin = null;
		Byte value = null;
		try{
			pin = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldanalogWrite_pin.getText());
			bb.put(pin);
			value = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldanalogWrite_value.getText());
			bb.put(value);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendping() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.PING;
		doSend(packet);
	}

	public void sendattachInterrupt() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.ATTACH_INTERRUPT;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte interrupt = null;
		Byte mode = null;
		try{
			interrupt = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldattachInterrupt_interrupt.getText());
			bb.put(interrupt);
			mode = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fieldattachInterrupt_mode.getText());
			bb.put(mode);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void senddetachInterrupt() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = RemoteArduinoProtocol.DETACH_INTERRUPT;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Byte interrupt = null;
		try{
			interrupt = Byte.parseByte(InteractiveRemoteArduinoDataGUI2.fielddetachInterrupt_interrupt.getText());
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
			InteractiveRemoteArduinoDataGUI2.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtonpinMode) {
		 	sendpinMode();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtondigitalRead) {
		 	senddigitalRead();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtondigitalWrite) {
		 	senddigitalWrite();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtonanalogReference) {
		 	sendanalogReference();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtonanalogRead) {
		 	sendanalogRead();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtonanalogWrite) {
		 	sendanalogWrite();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtonping) {
		 	sendping();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtonattachInterrupt) {
		 	sendattachInterrupt();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUI2.sendButtondetachInterrupt) {
		 	senddetachInterrupt();
		 }
	}
	
	public static void main(String args[]){
		InteractiveRemoteArduinoDataController2 controller = new InteractiveRemoteArduinoDataController2();
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