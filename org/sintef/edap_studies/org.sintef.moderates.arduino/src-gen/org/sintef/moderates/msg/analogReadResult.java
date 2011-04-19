package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogReadResult extends RemoteArduinoProtocolPacket {

	private short value;
	
	public analogReadResult(short value) {
		setCommandID(RemoteArduinoProtocol.ANALOG_READ_RESULT);
		setShortValue(value);
		this.value = value;
	}
	
	public analogReadResult(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		value = 
		bb.getShort()
		;
		position += (int) (Short.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleanalogReadResult(this);
	}

	@Override
	public String toString(){
		String myString = "analogReadResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public short getValue() {
		return value;
	}
	
}