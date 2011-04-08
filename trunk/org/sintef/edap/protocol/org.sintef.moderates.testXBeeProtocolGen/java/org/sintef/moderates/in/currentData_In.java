package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class currentData_In extends IncomingCurrentSensorMessage {

	private short sensorMax;
	private short current;
	private short eff_current;
	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		sensorMax = bb.getShort();
		position += (int) (Short.SIZE/8);
		current = bb.getShort();
		position += (int) (Short.SIZE/8);
		eff_current = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "currentData:";
		myString += " [sensorMax: "+sensorMax+"]";
		myString += " [current: "+current+"]";
		myString += " [eff_current: "+eff_current+"]";
		return myString;
	}

	public short getSensorMax() {
		return sensorMax;
	}
	
	public short getCurrent() {
		return current;
	}
	
	public short getEff_current() {
		return eff_current;
	}
	


	@Override
	public IncomingCurrentSensorMessage createPacket(byte[] packet) {
		IncomingCurrentSensorMessage result = new currentData_In();
		result.setPacketData(packet);
		return result;
	}
	
}