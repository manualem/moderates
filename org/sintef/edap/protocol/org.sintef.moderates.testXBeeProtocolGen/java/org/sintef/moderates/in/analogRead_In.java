package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogRead_In extends IncomingRemoteArduinoMessage {

	private byte pin;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "analogRead:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public byte getPin() {
		return pin;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new analogRead_In();
		result.setPacketData(packet);
		return result;
	}
	
}