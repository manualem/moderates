package no.sintef.modeartes.sensors.packets;

public class SetInterval extends OutgoingMessage {
	
	public SetInterval(short value) {
		setCommandID(SimpleSensorProtocol.SET_INTERVAL);
		setShortValue(value);
	}
	
}
