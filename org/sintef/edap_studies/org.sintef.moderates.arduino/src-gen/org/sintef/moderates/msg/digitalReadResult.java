package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class digitalReadResult extends RemoteArduinoProtocolPacket {

	private DigitalState value;
	
	public digitalReadResult(DigitalState value) {
		setCommandID(RemoteArduinoProtocol.DIGITAL_READ_RESULT);
		setByteValue(value.getValue());
		this.value = value;
	}
	
	public digitalReadResult(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		value =  DigitalState.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handledigitalReadResult(this);
	}

	@Override
	public String toString(){
		String myString = "digitalReadResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public DigitalState getValue() {
		return value;
	}
	
}