package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogWrite_In extends IncomingRemoteArduinoMessage {

	private byte pin;
	private byte value;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.get();
		position += (int) (Byte.SIZE/8);
		value = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "analogWrite:";
		myString += " [pin: "+pin+"]";
		myString += " [value: "+value+"]";
		return myString;
	}

	public byte getPin() {
		return pin;
	}
	
	public byte getValue() {
		return value;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new analogWrite_In();
		result.setPacketData(packet);
		return result;
	}
	
}