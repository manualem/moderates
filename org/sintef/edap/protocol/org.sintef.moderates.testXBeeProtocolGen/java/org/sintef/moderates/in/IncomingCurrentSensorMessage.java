package org.sintef.moderates.in;

import org.sintef.moderates.*;

public abstract class IncomingCurrentSensorMessage extends CurrentSensorProtocolPacket implements Cloneable {
	public abstract IncomingCurrentSensorMessage createPacket(byte[] packet);
}
