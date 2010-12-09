package no.sintef.modeartes.sensors.packets;

public class GetStatus extends OutgoingMessage {
	
	public GetStatus() {
		setCommandID(SimpleSensorProtocol.GET_STATUS);
	}
	
}
