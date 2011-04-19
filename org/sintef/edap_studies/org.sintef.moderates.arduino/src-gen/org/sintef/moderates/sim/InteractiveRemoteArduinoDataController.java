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





public class InteractiveRemoteArduinoDataController implements ActionListener, RemoteArduinoClientObserver, RemoteArduinoSubject {


	private List<RemoteArduinoObserver> handlers;
	
	private SimpleDateFormat dateFormat;

	public InteractiveRemoteArduinoDataController(){
		handlers = new LinkedList<RemoteArduinoObserver>();
		dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");
		InteractiveRemoteArduinoDataGUI.init();
		InteractiveRemoteArduinoDataGUI.addListener(this);
		InteractiveRemoteArduinoDataGUI.handler = this;	
	}
	
	

	private void doSend(FixedSizePacket data){
		if (data != null) {
        	System.out.println(data+" --> "+data.getPacket());
            for (RemoteArduinoObserver h : handlers){
				h.receiveMsg(data.getPacket());
			}
        }
        else {
        	System.out.println("Data is null");
        }
	}

	public void senddigitalReadResult() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		DigitalState value = null;
		try{
			value = (DigitalState)InteractiveRemoteArduinoDataGUI.fielddigitalReadResult_value.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createdigitalReadResult(value);
			doSend(fsp);
		}
	}

	public void sendanalogReadResult() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short value = null;
		try{
			value = Short.parseShort(InteractiveRemoteArduinoDataGUI.fieldanalogReadResult_value.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createanalogReadResult(value);
			doSend(fsp);
		}
	}

	public void sendpong() {
		FixedSizePacket fsp = null;
		fsp = RemoteArduinoProtocol.createpong();	
		doSend(fsp);
	}

	public void sendinterruptNotification() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		InterruptPin interrupt = null;
		try{
			interrupt = (InterruptPin)InteractiveRemoteArduinoDataGUI.fieldinterruptNotification_interrupt.getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = RemoteArduinoProtocol.createinterruptNotification(interrupt);
			doSend(fsp);
		}
	}


	public void receiveMessage(byte[] packet){
		FixedSizePacket data = RemoteArduinoProtocol.createMessageFromPacket(packet);
		if (data != null) {
			InteractiveRemoteArduinoDataGUI.print(data.getClass().getSimpleName(), "["+dateFormat.format(new Date(System.currentTimeMillis()))+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
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
	


	//Methods defined in the Observer pattern specific to RemoteArduino 
	@Override
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}
	
	@Override
	public void register(RemoteArduinoObserver observer) {
		handlers.add(observer);
	}

	@Override
	public void unregister(RemoteArduinoObserver observer) {
		handlers.remove(observer);
	}
}