package no.sintef.modeartes.sensors.packets;

public abstract class IncomingMessage extends SimpleSensorProtocolPacket implements Cloneable {
	protected abstract IncomingMessage createPacket(byte[] packet);
}
