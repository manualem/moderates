package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class digitalReadResult_In extends IncomingRemoteArduinoMessage {

	private byte value;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		value = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "digitalReadResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public byte getValue() {
		return value;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new digitalReadResult_In();
		result.setPacketData(packet);
		return result;
	}
	
}