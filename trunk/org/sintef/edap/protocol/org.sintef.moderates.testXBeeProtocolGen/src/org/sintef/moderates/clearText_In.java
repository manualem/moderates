package org.sintef.moderates;

import java.nio.ByteBuffer;

public class clearText_In extends IncomingBrickLCDSensorMessage {

	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "clearText:";
		return myString;
	}



	@Override
	protected IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new clearText_In();
		result.setPacketData(packet);
		return result;
	}
	
}