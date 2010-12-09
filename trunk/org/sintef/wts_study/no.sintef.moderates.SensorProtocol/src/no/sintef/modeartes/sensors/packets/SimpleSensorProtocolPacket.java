package no.sintef.modeartes.sensors.packets;

import java.nio.ByteBuffer;

public abstract class SimpleSensorProtocolPacket extends FixedSizePacket {
	
	public SimpleSensorProtocolPacket() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
	
	protected byte getCommandID(){
		return data[4];
	}
	
	protected void setShortValue(Short v) {
		ByteBuffer bb = ByteBuffer.wrap(data, 6, 2);
		bb.putShort(v);		
	}
	
	protected void setStringValue(String v) {
		if (v.length() > 8) v = v.substring(0, 7);
		ByteBuffer bb = ByteBuffer.wrap(data, 6, 8);
		bb.put(v.getBytes());	
	}
}
