package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class unsubscribeRawData extends CoffeeSensorProtocolPacket {

	
	public unsubscribeRawData() {
		setCommandID(CoffeeSensorProtocol.UNSUBSCRIBE_RAW_DATA);
	}
	
	public unsubscribeRawData(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "unsubscribeRawData:";
		return myString;
	}

}