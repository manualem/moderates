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

	public void senddisplayText() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.DISPLAY_TEXT;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short line = null;
		String msg = null;
		try{
			line = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fielddisplayText_line.getText());
			bb.putShort(line);
			msg = InteractiveBrickLCDSensorDataGUI.fielddisplayText_msg.getText();
			if (msg.length() > 8) msg = msg.substring(0, 8-1);
			bb.put(msg.getBytes());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendclearText() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.CLEAR_TEXT;
		doSend(packet);
	}

	public void sendreadAllAnalog() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.READ_ALL_ANALOG;
		doSend(packet);
	}

	public void sendreadAnalog() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.READ_ANALOG;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short pin = null;
		try{
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldreadAnalog_pin.getText());
			bb.putShort(pin);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendsetDigital() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.SET_DIGITAL;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short pin = null;
		Short direction = null;
		try{
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldsetDigital_pin.getText());
			bb.putShort(pin);
			direction = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldsetDigital_direction.getText());
			bb.putShort(direction);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendsetValue() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.SET_VALUE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short pin = null;
		Short val = null;
		try{
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldsetValue_pin.getText());
			bb.putShort(pin);
			val = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldsetValue_val.getText());
			bb.putShort(val);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			doSend(packet);
		}
	}

	public void sendgetValue() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = BrickLCDSensorProtocol.GET_VALUE;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short pin = null;
		try{
			pin = Short.parseShort(InteractiveBrickLCDSensorDataGUI.fieldgetValue_pin.getText());
			bb.putShort(pin);
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
		packet[4] = BrickLCDSensorProtocol.PING;
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
		 if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtondisplayText) {
		 	senddisplayText();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonclearText) {
		 	sendclearText();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonreadAllAnalog) {
		 	sendreadAllAnalog();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonreadAnalog) {
		 	sendreadAnalog();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonsetDigital) {
		 	sendsetDigital();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonsetValue) {
		 	sendsetValue();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtongetValue) {
		 	sendgetValue();
		 }
		 else if ( ae.getSource() == InteractiveBrickLCDSensorDataGUI.sendButtonping) {
		 	sendping();
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