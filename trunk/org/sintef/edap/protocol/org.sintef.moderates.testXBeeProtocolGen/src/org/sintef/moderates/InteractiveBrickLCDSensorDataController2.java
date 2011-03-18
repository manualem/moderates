package org.sintef.moderates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.nio.ByteBuffer;


import java.util.logging.Level;
import java.util.logging.Logger;

public class InteractiveBrickLCDSensorDataController2 implements ActionListener, ProtocolHandler {

	private Logger log;
	
	private List<ProtocolHandler> handlers;

	public InteractiveBrickLCDSensorDataController2(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveBrickLCDSensorDataController2.class.getName()); 
		InteractiveBrickLCDSensorDataGUI2.init();
		InteractiveBrickLCDSensorDataGUI2.addListener(this);	
	}
	
	

	private void doSend(byte[] packet){
		IncomingBrickLCDSensorMessage data = BrickLCDSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
        	System.out.println(BrickLCDSensorProtocol.createMessageForIncomingPacket(packet)+" --> "+packet);
            for (ProtocolHandler h : handlers){
				h.receiveMsg(packet);
			}
        }
	}

	public void sendanalogValue() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.ANALOG_VALUE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short pin = null;
		Short val = null;
		try{
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI2.fieldanalogValue_pin.getText());
			bb.putShort(pin);
			val = Short.parseShort(InteractiveBrickLCDSensorDataGUI2.fieldanalogValue_val.getText());
			bb.putShort(val);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void senddigitalValue() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.DIGITAL_VALUE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short pin = null;
		Short val = null;
		try{
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI2.fielddigitalValue_pin.getText());
			bb.putShort(pin);
			val = Short.parseShort(InteractiveBrickLCDSensorDataGUI2.fielddigitalValue_val.getText());
			bb.putShort(val);
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
		packet[4] = BrickLCDSensorProtocol.PONG;
		doSend(packet);
	}


	public void receiveMessage(byte[] packet){
		IncomingBrickLCDSensorMessage data = BrickLCDSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			InteractiveBrickLCDSensorDataGUI2.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI2.sendButtonanalogValue) {
		 	sendanalogValue();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI2.sendButtondigitalValue) {
		 	senddigitalValue();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI2.sendButtonpong) {
		 	sendpong();
		 }
	}
	
	public static void main(String args[]){
		InteractiveBrickLCDSensorDataController2 controller = new InteractiveBrickLCDSensorDataController2();
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