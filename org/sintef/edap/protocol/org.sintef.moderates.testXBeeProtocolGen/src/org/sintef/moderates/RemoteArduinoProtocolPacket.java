package org.sintef.moderates;

import java.nio.ByteBuffer;

public abstract class RemoteArduinoProtocolPacket extends FixedSizePacket {
	
	private int position = 5;
	
	public RemoteArduinoProtocolPacket() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
	
	protected byte getCommandID(){
		return data[4];
	}
	
	protected void setByteValue(Byte v) {
		int positionModifier = (int) (Byte.SIZE/8);
		ByteBuffer bb = ByteBuffer.wrap(data, position, positionModifier);
		bb.put(v);
		position += positionModifier;
	}
	
	protected void setShortValue(Short v) {
		int positionModifier = (int) (Short.SIZE/8);
		ByteBuffer bb = ByteBuffer.wrap(data, position, positionModifier);
		bb.putShort(v);
		position += positionModifier;
	}
	
	protected void setStringValue(String v) {
		int positionModifier = 8;
		if (v.length() > 8) v = v.substring(0, 8-1);
		ByteBuffer bb = ByteBuffer.wrap(data, position, positionModifier);
		bb.put(v.getBytes());
		position += positionModifier;
	}
	
}