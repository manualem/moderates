package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class rawData extends CoffeeSensorProtocolPacket {

	private short temp;
	private short dist;
	private short light;
	
	public rawData(short temp, short dist, short light) {
		setCommandID(CoffeeSensorProtocol.RAW_DATA);
		setShortValue(temp);
		this.temp = temp;
		setShortValue(dist);
		this.dist = dist;
		setShortValue(light);
		this.light = light;
	}
	
	public rawData(byte[] packet) {
		setPacketData(packet);
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
		String myString = "rawData:";
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
	
}