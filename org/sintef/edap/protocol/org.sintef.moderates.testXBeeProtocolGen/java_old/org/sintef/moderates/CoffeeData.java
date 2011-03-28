package org.sintef.moderates;

import java.nio.ByteBuffer;

public class CoffeeData extends IncomingCoffeeSensorMessage {

	private short temp;
	private short dist;
	private short light;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		temp = bb.getShort();
		dist = bb.getShort();
		light = bb.getShort();
		
	}

	@Override
	public String toString(){
		String myString = "CoffeeData\n";
		myString += "\t-temp: "+temp+"\n";
		myString += "\t-dist: "+dist+"\n";
		myString += "\t-light: "+light+"\n";
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
	protected IncomingCoffeeSensorMessage createPacket(byte[] packet) {
		IncomingCoffeeSensorMessage result = new CoffeeData();
		result.setPacketData(packet);
		return result;
	}
	
}