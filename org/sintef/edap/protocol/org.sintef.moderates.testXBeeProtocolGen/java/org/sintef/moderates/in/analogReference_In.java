package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogReference_In extends IncomingRemoteArduinoMessage {

	private byte type;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		type = bb.get();
		position += (int) (Byte.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "analogReference:";
		myString += " [type: "+type+"]";
		return myString;
	}

	public byte getType() {
		return type;
	}
	


	@Override
	public IncomingRemoteArduinoMessage createPacket(byte[] packet) {
		IncomingRemoteArduinoMessage result = new analogReference_In();
		result.setPacketData(packet);
		return result;
	}
	
}