package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class getValue_In extends IncomingBrickLCDSensorMessage {

	private short pin;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "getValue:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public short getPin() {
		return pin;
	}
	


	@Override
	public IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new getValue_In();
		result.setPacketData(packet);
		return result;
	}
	
}