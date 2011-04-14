package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class LightValue extends CoffeeSensorProtocolPacket {

	private short v;
	
	public LightValue(short v) {
		setCommandID(CoffeeSensorProtocol.LIGHT_VALUE);
		setShortValue(v);
		this.v = v;
	}
	
	public LightValue(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		v = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "LightValue:";
		myString += " [v: "+v+"]";
		return myString;
	}

	public short getV() {
		return v;
	}
	
}