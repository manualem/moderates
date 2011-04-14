package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class TemperatureValue extends CoffeeSensorProtocolPacket {

	private short v;
	
	public TemperatureValue(short v) {
		setCommandID(CoffeeSensorProtocol.TEMPERATURE_VALUE);
		setShortValue(v);
		this.v = v;
	}
	
	public TemperatureValue(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		v = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "TemperatureValue:";
		myString += " [v: "+v+"]";
		return myString;
	}

	public short getV() {
		return v;
	}
	
}