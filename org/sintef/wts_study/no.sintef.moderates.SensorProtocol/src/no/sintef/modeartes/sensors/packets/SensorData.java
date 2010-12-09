package no.sintef.modeartes.sensors.packets;

import java.nio.ByteBuffer;

public class SensorData extends IncomingMessage {
	
	private short temp;
	private short min;
	private short max;
	private short batt;

	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		ByteBuffer bb = ByteBuffer.wrap(data, 6, 10);
		temp = bb.getShort();
		min = bb.getShort();
		max = bb.getShort();
		batt = bb.getShort();
	}
	
	public short getTemp() {
		return temp;
	}

	public short getMin() {
		return min;
	}

	public short getMax() {
		return max;
	}

	public short getBatt() {
		return batt;
	}

	@Override
	protected IncomingMessage createPacket(byte[] packet) {
		SensorData result = new SensorData();
		result.setPacketData(packet);
		return result;
	}
	
}
