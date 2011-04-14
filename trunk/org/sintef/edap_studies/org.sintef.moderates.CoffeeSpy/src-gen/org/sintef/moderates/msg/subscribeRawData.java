package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class subscribeRawData extends CoffeeSensorProtocolPacket {

	private short interval;
	
	public subscribeRawData(short interval) {
		setCommandID(CoffeeSensorProtocol.SUBSCRIBE_RAW_DATA);
		setShortValue(interval);
		this.interval = interval;
	}
	
	public subscribeRawData(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		interval = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "subscribeRawData:";
		myString += " [interval: "+interval+"]";
		return myString;
	}

	public short getInterval() {
		return interval;
	}
	
}