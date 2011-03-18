package org.sintef.moderates;

import java.nio.ByteBuffer;

public class digitalValue_In extends IncomingBrickLCDSensorMessage {

	private short pin;
	private short val;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.getShort();
		position += (int) (Short.SIZE/8);
		val = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "digitalValue:";
		myString += " [pin: "+pin+"]";
		myString += " [val: "+val+"]";
		return myString;
	}

	public short getPin() {
		return pin;
	}
	
	public short getVal() {
		return val;
	}
	


	@Override
	protected IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new digitalValue_In();
		result.setPacketData(packet);
		return result;
	}
	
}