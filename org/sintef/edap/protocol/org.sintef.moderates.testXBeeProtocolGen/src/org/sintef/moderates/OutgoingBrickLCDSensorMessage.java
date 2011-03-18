package org.sintef.moderates;

public abstract class OutgoingBrickLCDSensorMessage extends BrickLCDSensorProtocolPacket {
	
	public OutgoingBrickLCDSensorMessage() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
}

