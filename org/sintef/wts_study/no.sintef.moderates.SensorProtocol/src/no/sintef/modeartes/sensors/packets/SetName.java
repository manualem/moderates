package no.sintef.modeartes.sensors.packets;

public class SetName extends OutgoingMessage {
	
	public SetName(String value) {
		setCommandID(SimpleSensorProtocol.SET_NAME);
		setStringValue(value);
	}
	
}
