package org.sintef.moderates;

public abstract class IncomingCoffeeSensorMessage extends CoffeeSensorProtocolPacket implements Cloneable {
	protected abstract IncomingCoffeeSensorMessage createPacket(byte[] packet);
}
