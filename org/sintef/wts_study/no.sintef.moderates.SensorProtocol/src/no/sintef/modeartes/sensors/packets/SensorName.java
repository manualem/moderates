package no.sintef.modeartes.sensors.packets;

public class SensorName extends IncomingMessage {
	
	private String name;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		name = ""; 
		for(int i=2; i<getLength(); i++) {
			name = name + (char)data[4+i];
		}
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	protected IncomingMessage createPacket(byte[] packet) {
		SensorName result = new SensorName();
		result.setPacketData(packet);
		return result;
	}
}
