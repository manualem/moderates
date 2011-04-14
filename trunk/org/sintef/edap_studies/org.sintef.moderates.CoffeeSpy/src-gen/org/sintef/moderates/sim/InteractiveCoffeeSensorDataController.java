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

public class InteractiveCoffeeSensorDataController implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;
	
	private SimpleDateFormat dateFormat;

	public InteractiveCoffeeSensorDataController(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCoffeeSensorDataController.class.getName());
		dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");
		InteractiveCoffeeSensorDataGUI.init();
		InteractiveCoffeeSensorDataGUI.addListener(this);
		InteractiveCoffeeSensorDataGUI.handler = this;	
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

	public void sendTemperatureValue() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short v = null;
		try{
			v = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldTemperatureValue_v.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createTemperatureValue(v);
			doSend(fsp);
		}
	}

	public void sendDistanceValue() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short v = null;
		try{
			v = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldDistanceValue_v.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createDistanceValue(v);
			doSend(fsp);
		}
	}

	public void sendLightValue() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short v = null;
		try{
			v = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldLightValue_v.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createLightValue(v);
			doSend(fsp);
		}
	}

	public void sendapproachingMotion() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createapproachingMotion();	
		doSend(fsp);
	}

	public void sendleavingMotion() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short minimalDist = null;
		try{
			minimalDist = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldleavingMotion_minimalDist.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createleavingMotion(minimalDist);
			doSend(fsp);
		}
	}

	public void sendlightON() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createlightON();	
		doSend(fsp);
	}

	public void sendlightOFF() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createlightOFF();	
		doSend(fsp);
	}

	public void sendtemperatureIncrease() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short before = null;
		Short current = null;
		try{
			before = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldtemperatureIncrease_before.getText());
			current = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldtemperatureIncrease_current.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createtemperatureIncrease(before, current);
			doSend(fsp);
		}
	}

	public void sendtemperatureDecrease() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short before = null;
		Short current = null;
		try{
			before = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldtemperatureDecrease_before.getText());
			current = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldtemperatureDecrease_current.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createtemperatureDecrease(before, current);
			doSend(fsp);
		}
	}

	public void sendrawData() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short temp = null;
		Short dist = null;
		Short light = null;
		try{
			temp = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldrawData_temp.getText());
			dist = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldrawData_dist.getText());
			light = Short.parseShort(InteractiveCoffeeSensorDataGUI.fieldrawData_light.getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = CoffeeSensorProtocol.createrawData(temp, dist, light);
			doSend(fsp);
		}
	}

	public void sendpong() {
		FixedSizePacket fsp = null;
		fsp = CoffeeSensorProtocol.createpong();	
		doSend(fsp);
	}


	public void receiveMessage(byte[] packet){
		FixedSizePacket data = CoffeeSensorProtocol.createMessageFromPacket(packet);
		if (data != null) {
			InteractiveCoffeeSensorDataGUI.print(data.getClass().getSimpleName(), "["+dateFormat.format(new Date(System.currentTimeMillis()))+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonTemperatureValue) {
		 	sendTemperatureValue();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonDistanceValue) {
		 	sendDistanceValue();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonLightValue) {
		 	sendLightValue();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonapproachingMotion) {
		 	sendapproachingMotion();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonleavingMotion) {
		 	sendleavingMotion();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonlightON) {
		 	sendlightON();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonlightOFF) {
		 	sendlightOFF();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtontemperatureIncrease) {
		 	sendtemperatureIncrease();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtontemperatureDecrease) {
		 	sendtemperatureDecrease();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonrawData) {
		 	sendrawData();
		 }
		 else if ( ae.getSource() == InteractiveCoffeeSensorDataGUI.sendButtonpong) {
		 	sendpong();
		 }
	}
	
	public static void main(String args[]){
		InteractiveCoffeeSensorDataController controller = new InteractiveCoffeeSensorDataController();
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