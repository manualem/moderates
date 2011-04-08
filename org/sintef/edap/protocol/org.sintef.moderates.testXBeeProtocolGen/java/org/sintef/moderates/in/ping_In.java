package org.sintef.moderates.in;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class ping_In extends IncomingCurrentSensorMessage {

	
	@Override
	public void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "ping:";
		return myString;
	}



	@Override
	public IncomingCurrentSensorMessage createPacket(byte[] packet) {
		IncomingCurrentSensorMessage result = new ping_In();
		result.setPacketData(packet);
		return result;
	}
	
}