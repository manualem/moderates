package no.sintef.modeartes.sensors.packets;

public class SetMinAlarm extends OutgoingMessage {
	
	public SetMinAlarm(short value) {
		setCommandID(SimpleSensorProtocol.SET_MIN_ALARM);
		setShortValue(value);
	}
	
}
