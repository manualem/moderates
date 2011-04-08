package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class stop_In extends IncomingCurrentSensorMessage {

	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "stop:";
		return myString;
	}



	@Override
	public IncomingCurrentSensorMessage createPacket(byte[] packet) {
		IncomingCurrentSensorMessage result = new stop_In();
		result.setPacketData(packet);
		return result;
	}
	
}