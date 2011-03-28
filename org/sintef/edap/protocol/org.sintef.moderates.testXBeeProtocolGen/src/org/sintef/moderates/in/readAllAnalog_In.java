package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class readAllAnalog_In extends IncomingBrickLCDSensorMessage {

	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "readAllAnalog:";
		return myString;
	}



	@Override
	public IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new readAllAnalog_In();
		result.setPacketData(packet);
		return result;
	}
	
}