package org.sintef.moderates;

import java.nio.ByteBuffer;

public class displayText_In extends IncomingBrickLCDSensorMessage {

	private short line;
	private String msg;
	
	@Override
	protected void setPacketData(byte[] packet) {
		super.setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		line = bb.getShort();
		position += (int) (Short.SIZE/8);
		 msg = ""; 
		for(int i=position; i<Math.min(position+8, getLength()); i++) {
			 msg =  msg + (char)data[i];
		}
		position += 8;
		
	}

	@Override
	public String toString(){
		String myString = "displayText:";
		myString += " [line: "+line+"]";
		myString += " [msg: "+msg+"]";
		return myString;
	}

	public short getLine() {
		return line;
	}
	
	public String getMsg() {
		return msg;
	}
	


	@Override
	protected IncomingBrickLCDSensorMessage createPacket(byte[] packet) {
		IncomingBrickLCDSensorMessage result = new displayText_In();
		result.setPacketData(packet);
		return result;
	}
	
}