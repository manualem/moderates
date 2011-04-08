package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class attachInterrupt_In extends IncomingRemoteArduinoMessage {

	private byte interrupt;
	private byte mode;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		interrupt = bb.get();
		position += (int) (Byte.SIZE/8);
		mode = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "attachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public byte getInterrupt() {
		return interrupt;
	}
	
	public byte getMode() {
		return mode;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new attachInterrupt_In();
		result.setPacketData(packet);
		return result;
	}
	
}