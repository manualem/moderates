package org.sintef.moderates.in;

import org.sintef.moderates.*;

public abstract class IncomingCoffeeSensorMessage extends CoffeeSensorProtocolPacket implements Cloneable {
	public abstract IncomingCoffeeSensorMessage createPacket(byte[] packet);
}
