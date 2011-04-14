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





public class InteractiveCoffeeSensorDataControllerClient implements ActionListener, CoffeeSensorObserver, CoffeeSensorClientSubject {


	private List<CoffeeSensorClientObserver> handlers;
	
	private SimpleDateFormat dateFormat;

	public InteractiveCoffeeSensorDataControllerClient(){
		handlers = new LinkedList<CoffeeSensorClientObserver>();
		dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");
		InteractiveCoffeeSensorDataGUIClient.init();
		InteractiveCoffeeSensorDataGUIClient.addListener(this);
		InteractiveCoffeeSensorDataGUIClient.handler = this;	
	}
	
	

	private void doSend(FixedSizePacket data){
		if (data != null) {
        	System.out.println(data+" --> "+data.getPacket());
            for (CoffeeSensorClientObserver h : handlers){
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
			interval = Short.parseShort(InteractiveCoffeeSensorDataGUIClient.fieldsubscribeRawData_interval.getText());
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

	public void sendunsubscribeRawData() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createunsubscribeRawData();	
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
			InteractiveCoffeeSensorDataGUIClient.print(data.getClass().getSimpleName(), "["+dateFormat.format(new Date(System.currentTimeMillis()))+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonGetTemperature) {
		 	sendGetTemperature();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonGetDistance) {
		 	sendGetDistance();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonGetLight) {
		 	sendGetLight();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonsubscribeMotion) {
		 	sendsubscribeMotion();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonunsubscribeMotion) {
		 	sendunsubscribeMotion();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonsubscribeLightChange) {
		 	sendsubscribeLightChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonunsubscribeLightChange) {
		 	sendunsubscribeLightChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonsubscribeTemperatureChange) {
		 	sendsubscribeTemperatureChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonunsubscribeTemperatureChange) {
		 	sendunsubscribeTemperatureChange();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonsubscribeRawData) {
		 	sendsubscribeRawData();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtongetRawData) {
		 	sendgetRawData();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonunsubscribeRawData) {
		 	sendunsubscribeRawData();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUIClient.sendButtonping) {
		 	sendping();
		 }
	}
	
	public static void main(String args[]){
		InteractiveCoffeeSensorDataControllerClient controller = new InteractiveCoffeeSensorDataControllerClient();
	}
	


	//Methods defined in the Observer pattern specific to CoffeeSensor 
	@Override
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}
	
	@Override
	public void register(CoffeeSensorClientObserver observer) {
		handlers.add(observer);
	}

	@Override
	public void unregister(CoffeeSensorClientObserver observer) {
		handlers.remove(observer);
	}
}