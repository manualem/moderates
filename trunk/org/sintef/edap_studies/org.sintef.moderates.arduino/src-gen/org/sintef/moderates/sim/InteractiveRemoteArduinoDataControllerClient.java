package org.sintef.moderates.sim;

import org.sintef.moderates.*;
import org.sintef.moderates.observer.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;





public class InteractiveRemoteArduinoDataControllerClient implements ActionListener, RemoteArduinoObserver, RemoteArduinoClientSubject {


	private List<RemoteArduinoClientObserver> handlers;
	
	private SimpleDateFormat dateFormat;

	public InteractiveRemoteArduinoDataControllerClient(){
		handlers = new LinkedList<RemoteArduinoClientObserver>();
		dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");
		InteractiveRemoteArduinoDataGUIClient.init();
		InteractiveRemoteArduinoDataGUIClient.addListener(this);
		InteractiveRemoteArduinoDataGUIClient.handler = this;	
	}
	
	

	private void doSend(FixedSizePacket data){
		if (data != null) {
        	System.out.println(data+" --> "+data.getPacket());
            for (RemoteArduinoClientObserver h : handlers){
				h.receiveMsg(data.getPacket());
			}
        }
        else {
        	System.out.println("Data is null");
        }
	}

	public void sendpinMode() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		DigitalPin pin = null;
		PinMode mode = null;
		try{
			pin = (DigitalPin)InteractiveRemoteArduinoDataGUIClient.fieldpinMode_pin.getSelectedItem();
			mode = (PinMode)InteractiveRemoteArduinoDataGUIClient.fieldpinMode_mode.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createpinMode(pin, mode);
			doSend(fsp);
		}
	}

	public void senddigitalRead() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		DigitalPin pin = null;
		try{
			pin = (DigitalPin)InteractiveRemoteArduinoDataGUIClient.fielddigitalRead_pin.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createdigitalRead(pin);
			doSend(fsp);
		}
	}

	public void senddigitalWrite() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		DigitalPin pin = null;
		DigitalState value = null;
		try{
			pin = (DigitalPin)InteractiveRemoteArduinoDataGUIClient.fielddigitalWrite_pin.getSelectedItem();
			value = (DigitalState)InteractiveRemoteArduinoDataGUIClient.fielddigitalWrite_value.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createdigitalWrite(pin, value);
			doSend(fsp);
		}
	}

	public void sendanalogReference() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		AnalogReference type = null;
		try{
			type = (AnalogReference)InteractiveRemoteArduinoDataGUIClient.fieldanalogReference_type.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createanalogReference(type);
			doSend(fsp);
		}
	}

	public void sendanalogRead() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		AnalogPin pin = null;
		try{
			pin = (AnalogPin)InteractiveRemoteArduinoDataGUIClient.fieldanalogRead_pin.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createanalogRead(pin);
			doSend(fsp);
		}
	}

	public void sendanalogWrite() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		PWMPin pin = null;
		Byte value = null;
		try{
			pin = (PWMPin)InteractiveRemoteArduinoDataGUIClient.fieldanalogWrite_pin.getSelectedItem();
			value = Byte.parseByte(InteractiveRemoteArduinoDataGUIClient.fieldanalogWrite_value.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createanalogWrite(pin, value);
			doSend(fsp);
		}
	}

	public void sendping() {
		FixedSizePacket fsp = null;
		fsp = RemoteArduinoProtocol.createping();	
		doSend(fsp);
	}

	public void sendattachInterrupt() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		InterruptPin interrupt = null;
		InterruptTrigger mode = null;
		try{
			interrupt = (InterruptPin)InteractiveRemoteArduinoDataGUIClient.fieldattachInterrupt_interrupt.getSelectedItem();
			mode = (InterruptTrigger)InteractiveRemoteArduinoDataGUIClient.fieldattachInterrupt_mode.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createattachInterrupt(interrupt, mode);
			doSend(fsp);
		}
	}

	public void senddetachInterrupt() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		InterruptPin interrupt = null;
		try{
			interrupt = (InterruptPin)InteractiveRemoteArduinoDataGUIClient.fielddetachInterrupt_interrupt.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createdetachInterrupt(interrupt);
			doSend(fsp);
		}
	}


	public void receiveMessage(byte[] packet){
		FixedSizePacket data = RemoteArduinoProtocol.createMessageFromPacket(packet);
		if (data != null) {
			InteractiveRemoteArduinoDataGUIClient.print(data.getClass().getSimpleName(), "["+dateFormat.format(new Date(System.currentTimeMillis()))+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtonpinMode) {
		 	sendpinMode();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtondigitalRead) {
		 	senddigitalRead();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtondigitalWrite) {
		 	senddigitalWrite();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtonanalogReference) {
		 	sendanalogReference();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtonanalogRead) {
		 	sendanalogRead();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtonanalogWrite) {
		 	sendanalogWrite();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtonping) {
		 	sendping();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtonattachInterrupt) {
		 	sendattachInterrupt();
		 }
		 else if ( ae.getSource() == InteractiveRemoteArduinoDataGUIClient.sendButtondetachInterrupt) {
		 	senddetachInterrupt();
		 }
	}
	
	public static void main(String args[]){
		InteractiveRemoteArduinoDataControllerClient controller = new InteractiveRemoteArduinoDataControllerClient();
	}
	


	//Methods defined in the Observer pattern specific to RemoteArduino 
	@Override
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}
	
	@Override
	public void register(RemoteArduinoClientObserver observer) {
		handlers.add(observer);
	}

	@Override
	public void unregister(RemoteArduinoClientObserver observer) {
		handlers.remove(observer);
	}
}