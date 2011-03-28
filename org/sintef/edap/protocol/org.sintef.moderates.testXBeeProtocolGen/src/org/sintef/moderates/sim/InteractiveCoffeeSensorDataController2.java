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

public class InteractiveCoffeeSensorDataController2 implements ActionListener, ProtocolHandler {

	private Logger log;
	
	private List<ProtocolHandler> handlers;

	public InteractiveCoffeeSensorDataController2(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCoffeeSensorDataController2.class.getName()); 
		InteractiveCoffeeSensorDataGUI2.init();
		InteractiveCoffeeSensorDataGUI2.addListener(this);	
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

	public void sendCoffeeData() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = CoffeeSensorProtocol.COFFEE_DATA;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short temp = null;
		Short dist = null;
		Short light = null;
		try{
			temp = Short.parseShort(InteractiveCoffeeSensorDataGUI2.fieldCoffeeData_temp.getText());
			bb.putShort(temp);
			dist = Short.parseShort(InteractiveCoffeeSensorDataGUI2.fieldCoffeeData_dist.getText());
			bb.putShort(dist);
			light = Short.parseShort(InteractiveCoffeeSensorDataGUI2.fieldCoffeeData_light.getText());
			bb.putShort(light);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}


	public void receiveMessage(byte[] packet){
		IncomingCoffeeSensorMessage data = CoffeeSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			InteractiveCoffeeSensorDataGUI2.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveCoffeeSensorDataGUI2.sendButtonCoffeeData) {
		 	sendCoffeeData();
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
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}	
}