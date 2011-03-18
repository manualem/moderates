package org.sintef.moderates;

import java.nio.ByteBuffer;

public class pong_In extends IncomingBrickLCDSensorMessage {

	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "pong:";
		return myString;
	}



	@Override
	protected IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new pong_In();
		result.setPacketData(packet);
		return result;
	}
	
}