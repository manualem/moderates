package no.sintef.modeartes.sensors.packets;

public class GetData extends OutgoingMessage {
	
	public GetData() {
		setCommandID(SimpleSensorProtocol.GET_DATA);
	}
	
}
