package no.sintef.modeartes.sensors.packets;

public class ResetMinMax extends OutgoingMessage {
	
	public ResetMinMax() {
		setCommandID(SimpleSensorProtocol.RESET_MIN_MAX);
	}
	
}
