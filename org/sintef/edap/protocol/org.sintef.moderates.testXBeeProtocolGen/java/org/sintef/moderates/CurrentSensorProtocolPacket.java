package org.sintef.moderates;

import java.nio.ByteBuffer;

public abstract class CurrentSensorProtocolPacket extends FixedSizePacket {
	
	private int position = 5;
	
	public CurrentSensorProtocolPacket() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
	
	protected byte getCommandID(){
		return data[4];
	}
	
	protected void setShortValue(Short v) {
		int positionModifier = (int) (Short.SIZE/8);
		ByteBuffer bb = ByteBuffer.wrap(data, position, positionModifier);
		bb.putShort(v);
		position += positionModifier;
	}
	
}