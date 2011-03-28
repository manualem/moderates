package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class setDigital_In extends IncomingBrickLCDSensorMessage {

	private short pin;
	private short direction;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin = bb.getShort();
		position += (int) (Short.SIZE/8);
		direction = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "setDigital:";
		myString += " [pin: "+pin+"]";
		myString += " [direction: "+direction+"]";
		return myString;
	}

	public short getPin() {
		return pin;
	}
	
	public short getDirection() {
		return direction;
	}
	


	@Override
	public IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new setDigital_In();
		result.setPacketData(packet);
		return result;
	}
	
}