package no.sintef.modeartes.sensors.packets;

public class GetName extends OutgoingMessage {
	
	public GetName() {
		setCommandID(SimpleSensorProtocol.GET_NAME);
	}
	
}
