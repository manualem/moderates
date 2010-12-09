package no.sintef.modeartes.sensors.packets;

public class SetBattAlarm extends OutgoingMessage {
	
	public SetBattAlarm(short value) {
		setCommandID(SimpleSensorProtocol.SET_BATT_ALARM);
		setShortValue(value);
	}
	
}
