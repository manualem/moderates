package no.sintef.modeartes.sensors.packets;

public abstract class OutgoingMessage extends SimpleSensorProtocolPacket {
	
	public OutgoingMessage() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
}
