package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogReadResult_In extends IncomingRemoteArduinoMessage {

	private short value;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		value = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "analogReadResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public short getValue() {
		return value;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new analogReadResult_In();
		result.setPacketData(packet);
		return result;
	}
	
}