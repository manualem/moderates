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

public class InteractiveBrickLCDSensorDataController implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;

	public InteractiveBrickLCDSensorDataController(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveBrickLCDSensorDataController.class.getName()); 
		InteractiveBrickLCDSensorDataGUI.init();
		InteractiveBrickLCDSensorDataGUI.addListener(this);	
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
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldanalogValue_pin.getText());
			bb.putShort(pin);
			val = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldanalogValue_val.getText());
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
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fielddigitalValue_pin.getText());
			bb.putShort(pin);
			val = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fielddigitalValue_val.getText());
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
			InteractiveBrickLCDSensorDataGUI.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonanalogValue) {
		 	sendanalogValue();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtondigitalValue) {
		 	senddigitalValue();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonpong) {
		 	sendpong();
		 }
	}
	
	public static void main(String args[]){
		InteractiveBrickLCDSensorDataController controller = new InteractiveBrickLCDSensorDataController();
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