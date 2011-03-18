package org.sintef.moderates;

public abstract class IncomingBrickLCDSensorMessage extends BrickLCDSensorProtocolPacket implements Cloneable {
	protected abstract IncomingBrickLCDSensorMessage createPacket(byte[] packet);
}
