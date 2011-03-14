package org.sintef.moderates;

import java.nio.ByteBuffer;

public class CoffeeData extends IncomingCoffeeSensorMessage {

	private short temp;
	private short dist;
	private short light;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		ByteBuffer bb = ByteBuffer.wrap(data, 6, 10);
		temp = bb.getShort();
		dist = bb.getShort();
		light = bb.getShort();
		
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