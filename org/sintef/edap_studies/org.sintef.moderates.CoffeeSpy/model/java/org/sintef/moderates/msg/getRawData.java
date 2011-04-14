package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class getRawData extends CoffeeSensorProtocolPacket {

	
	public getRawData() {
		setCommandID(CoffeeSensorProtocol.GET_RAW_DATA);
	}
	
	public getRawData(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "getRawData:";
		return myString;
	}

}