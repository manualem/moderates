package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class subscribeLightChange extends CoffeeSensorProtocolPacket {

	
	public subscribeLightChange() {
		setCommandID(CoffeeSensorProtocol.SUBSCRIBE_LIGHT_CHANGE);
	}
	
	public subscribeLightChange(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "subscribeLightChange:";
		return myString;
	}

}