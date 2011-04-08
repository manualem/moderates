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

public class InteractiveCurrentSensorDataController implements ActionListener, ProtocolHandler {

	private Logger log;

	private List<ProtocolHandler> handlers;

	public InteractiveCurrentSensorDataController(){
		handlers = new LinkedList<ProtocolHandler>();
		log = Logger.getLogger(InteractiveCurrentSensorDataController.class.getName()); 
		InteractiveCurrentSensorDataGUI.init();
		InteractiveCurrentSensorDataGUI.addListener(this);	
	}
	
	

	private void doSend(byte[] packet){
		IncomingCurrentSensorMessage data = CurrentSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
        	System.out.println(CurrentSensorProtocol.createMessageForIncomingPacket(packet)+" --> "+packet);
            for (ProtocolHandler h : handlers){
				h.receiveMsg(packet);
			}
        }
	}

	public void sendcurrentData() {
		byte packet[] = new byte[16];
		packet[3] = 16;
		packet[4] = CurrentSensorProtocol.CURRENT_DATA;
		boolean valid = true;
		ByteBuffer bb = ByteBuffer.wrap(packet, 5, 10);
		Short sensorMax = null;
		Short current = null;
		Short eff_current = null;
		try{
			sensorMax = Short.parseShort(InteractiveCurrentSensorDataGUI.fieldcurrentData_sensorMax.getText());
			bb.putShort(sensorMax);
			current = Short.parseShort(InteractiveCurrentSensorDataGUI.fieldcurrentData_current.getText());
			bb.putShort(current);
			eff_current = Short.parseShort(InteractiveCurrentSensorDataGUI.fieldcurrentData_eff_current.getText());
			bb.putShort(eff_current);
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
		packet[4] = CurrentSensorProtocol.PONG;
		doSend(packet);
	}


	public void receiveMessage(byte[] packet){
		IncomingCurrentSensorMessage data = CurrentSensorProtocol.createMessageForIncomingPacket(packet);
		if (data != null) {
			InteractiveCurrentSensorDataGUI.print(data.getClass().getSimpleName().substring(0,data.getClass().getSimpleName().length()-3), "["+System.currentTimeMillis()+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveCurrentSensorDataGUI.sendButtoncurrentData) {
		 	sendcurrentData();
		 }
		 else if ( ae.getSource() == InteractiveCurrentSensorDataGUI.sendButtonpong) {
		 	sendpong();
		 }
	}
	
	public static void main(String args[]){
		InteractiveCurrentSensorDataController controller = new InteractiveCurrentSensorDataController();
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