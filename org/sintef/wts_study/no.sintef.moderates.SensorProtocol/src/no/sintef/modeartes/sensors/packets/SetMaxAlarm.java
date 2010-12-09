package no.sintef.modeartes.sensors.packets;

public class SetMaxAlarm extends OutgoingMessage {
	
	public SetMaxAlarm(short value) {
		setCommandID(SimpleSensorProtocol.SET_MAX_ALARM);
		setShortValue(value);
	}
	
}
