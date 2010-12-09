package no.sintef.modeartes.sensors.packets;

import java.nio.ByteBuffer;

public class SensorStatus extends IncomingMessage {

	private short interval;
	private short min_alarm;
	private short max_alarm;
	private short batt_alarm;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		ByteBuffer bb = ByteBuffer.wrap(data, 6, 10);
		interval = bb.getShort();
		min_alarm = bb.getShort();
		max_alarm = bb.getShort();
		batt_alarm = bb.getShort();
	}

	public short getInterval() {
		return interval;
	}

	public short getMin_alarm() {
		return min_alarm;
	}

	public short getMax_alarm() {
		return max_alarm;
	}

	public short getBatt_alarm() {
		return batt_alarm;
	}
	
	@Override
	protected IncomingMessage createPacket(byte[] packet) {
		SensorStatus result = new SensorStatus();
		result.setPacketData(packet);
		return result;
	}
	
}
