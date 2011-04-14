package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class temperatureIncrease extends CoffeeSensorProtocolPacket {

	private short before;
	private short current;
	
	public temperatureIncrease(short before, short current) {
		setCommandID(CoffeeSensorProtocol.TEMPERATURE_INCREASE);
		setShortValue(before);
		this.before = before;
		setShortValue(current);
		this.current = current;
	}
	
	public temperatureIncrease(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		before = bb.getShort();
		position += (int) (Short.SIZE/8);
		current = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "temperatureIncrease:";
		myString += " [before: "+before+"]";
		myString += " [current: "+current+"]";
		return myString;
	}

	public short getBefore() {
		return before;
	}
	
	public short getCurrent() {
		return current;
	}
	
}