package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class CoffeeData_In extends IncomingCoffeeSensorMessage {

	private short temp;
	private short dist;
	private short light;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		temp = bb.getShort();
		position += (int) (Short.SIZE/8);
		dist = bb.getShort();
		position += (int) (Short.SIZE/8);
		light = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "CoffeeData:";
		myString += " [temp: "+temp+"]";
		myString += " [dist: "+dist+"]";
		myString += " [light: "+light+"]";
		return myString;
	}

	public short getTemp() {
		return temp;
	}
	
	public short getDist() {
		return dist;
	}
	
	public short getLight() {
		return light;
	}
	


	@Override
	public IncomingCoffeeSensorMessage createPacket(byte[] packet) {
		IncomingCoffeeSensorMessage result = new CoffeeData_In();
		result.setPacketData(packet);
		return result;
	}
	
}