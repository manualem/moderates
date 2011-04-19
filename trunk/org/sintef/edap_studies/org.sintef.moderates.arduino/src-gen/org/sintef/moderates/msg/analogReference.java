package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogReference extends RemoteArduinoProtocolPacket {

	private AnalogReference type;
	
	public analogReference(AnalogReference type) {
		setCommandID(RemoteArduinoProtocol.ANALOG_REFERENCE);
		setByteValue(type.getValue());
		this.type = type;
	}
	
	public analogReference(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		type =  AnalogReference.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleanalogReference(this);
	}

	@Override
	public String toString(){
		String myString = "analogReference:";
		myString += " [type: "+type+"]";
		return myString;
	}

	public AnalogReference getType() {
		return type;
	}
	
}