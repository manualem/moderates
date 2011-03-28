package org.sintef.moderates.in;

import org.sintef.moderates.*;

public abstract class IncomingBrickLCDSensorMessage extends BrickLCDSensorProtocolPacket implements Cloneable {
	public abstract IncomingBrickLCDSensorMessage createPacket(byte[] packet);
}
