package org.sintef.moderates;

import java.nio.ByteBuffer;

public class readAnalog_In extends IncomingBrickLCDSensorMessage {

	private short pin;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "readAnalog:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public short getPin() {
		return pin;
	}
	


	@Override
	protected IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new readAnalog_In();
		result.setPacketData(packet);
		return result;
	}
	
}