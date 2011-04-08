package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class pinMode_In extends IncomingRemoteArduinoMessage {

	private byte pin;
	private byte mode;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.get();
		position += (int) (Byte.SIZE/8);
		mode = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "pinMode:";
		myString += " [pin: "+pin+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public byte getPin() {
		return pin;
	}
	
	public byte getMode() {
		return mode;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new pinMode_In();
		result.setPacketData(packet);
		return result;
	}
	
}