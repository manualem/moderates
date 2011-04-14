package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class unsubscribeLightChange extends CoffeeSensorProtocolPacket {

	
	public unsubscribeLightChange() {
		setCommandID(CoffeeSensorProtocol.UNSUBSCRIBE_LIGHT_CHANGE);
	}
	
	public unsubscribeLightChange(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "unsubscribeLightChange:";
		return myString;
	}

}