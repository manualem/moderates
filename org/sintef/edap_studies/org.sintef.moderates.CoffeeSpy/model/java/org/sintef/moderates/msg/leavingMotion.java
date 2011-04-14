package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class leavingMotion extends CoffeeSensorProtocolPacket {

	private short minimalDist;
	
	public leavingMotion(short minimalDist) {
		setCommandID(CoffeeSensorProtocol.LEAVING_MOTION);
		setShortValue(minimalDist);
		this.minimalDist = minimalDist;
	}
	
	public leavingMotion(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		minimalDist = bb.getShort();
		position += (int) (Short.SIZE/8);
		
	}

	@Override
	public String toString(){
		String myString = "leavingMotion:";
		myString += " [minimalDist: "+minimalDist+"]";
		return myString;
	}

	public short getMinimalDist() {
		return minimalDist;
	}
	
}