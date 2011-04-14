package org.sintef.moderates.sim;

import org.sintef.moderates.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.nio.ByteBuffer;


import java.util.logging.Level;
import java.util.logging.Logger;

public class InteractiveCoffeeSensorDataController2 implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;
	
	private SimpleDateFormat dateFormat;

	public InteractiveCoffeeSensorDataController2(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCoffeeSensorDataController2.class.getName());
		dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");
		InteractiveCoffeeSensorDataGUI2.init();
		InteractiveCoffeeSensorDataGUI2.addListener(this);
		InteractiveCoffeeSensorDataGUI2.handler = this;	
	}
	
	

	private void doSend(FixedSizePacket data){
		if (data != null) {
        	System.out.println(data+" --> "+data.getPacket());
            for (ProtocolHandler h : handlers){
				h.receiveMsg(data.getPacket());
			}
        }
        else {
        	System.out.println("Data is null");
        }
	}

	public void sendGetTemperature() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createGetTemperature();	
		doSend(fsp);
	}

	public void sendGetDistance() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createGetDistance();	
		doSend(fsp);
	}

	public void sendGetLight() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createGetLight();	
		doSend(fsp);
	}

	public void sendsubscribeMotion() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createsubscribeMotion();	
		doSend(fsp);
	}

	public void sendunsubscribeMotion() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createunsubscribeMotion();	
		doSend(fsp);
	}

	public void sendsubscribeLightChange() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createsubscribeLightChange();	
		doSend(fsp);
	}

	public void sendunsubscribeLightChange() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createunsubscribeLightChange();	
		doSend(fsp);
	}

	public void sendsubscribeTemperatureChange() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createsubscribeTemperatureChange();	
		doSend(fsp);
	}

	public void sendunsubscribeTemperatureChange() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createunsubscribeTemperatureChange();	
		doSend(fsp);
	}

	public void sendsubscribeRawData() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short interval = null;
		try{
			interval = Short.parseShort(InteractiveCoffeeSensorDataGUI2.fieldsubscribeRawData_interval.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createsubscribeRawData(interval);
			doSend(fsp);
		}
	}

	public void sendgetRawData() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.creategetRawData();	
		doSend(fsp);
	}

	public void sendping() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createping();	
		doSend(fsp);
	}


	public void receiveMessage(byte[] packet){
		FixedSizePacket data = CoffeeSensorProtocol.createMessageFromPacket(packet);
		if (data != null) {
			InteractiveCoffeeSensorDataGUI2.print(data.getClass().getSimpleName(), "["+dateFormat.format(new Date(System.currentTimeMillis()))+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonGetTemperature) {
		 	sendGetTemperature();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonGetDistance) {
		 	sendGetDistance();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonGetLight) {
		 	sendGetLight();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonsubscribeMotion) {
		 	sendsubscribeMotion();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonunsubscribeMotion) {
		 	sendunsubscribeMotion();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonsubscribeLightChange) {
		 	sendsubscribeLightChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonunsubscribeLightChange) {
		 	sendunsubscribeLightChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonsubscribeTemperatureChange) {
		 	sendsubscribeTemperatureChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonunsubscribeTemperatureChange) {
		 	sendunsubscribeTemperatureChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonsubscribeRawData) {
		 	sendsubscribeRawData();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtongetRawData) {
		 	sendgetRawData();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonping) {
		 	sendping();
		 }
	}
	
	public static void main(String args[]){
		InteractiveCoffeeSensorDataController2 controller = new InteractiveCoffeeSensorDataController2();
	}
	
	@Override
	public void register(ProtocolHandler handler) {
		handlers.add(handler);
	}
	
	@Override
	public void unregister(ProtocolHandler handler) {
		handlers.remove(handler);
	}	

	@Override
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}
}