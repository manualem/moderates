package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class detachInterrupt_In extends IncomingRemoteArduinoMessage {

	private byte interrupt;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		interrupt = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "detachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		return myString;
	}

	public byte getInterrupt() {
		return interrupt;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new detachInterrupt_In();
		result.setPacketData(packet);
		return result;
	}
	
}