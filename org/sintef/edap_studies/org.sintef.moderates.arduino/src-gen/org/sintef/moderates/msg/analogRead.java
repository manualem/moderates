package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogRead extends RemoteArduinoProtocolPacket {

	private AnalogPin pin;
	
	public analogRead(AnalogPin pin) {
		setCommandID(RemoteArduinoProtocol.ANALOG_READ);
		setByteValue(pin.getValue());
		this.pin = pin;
	}
	
	public analogRead(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin =  AnalogPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleanalogRead(this);
	}

	@Override
	public String toString(){
		String myString = "analogRead:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public AnalogPin getPin() {
		return pin;
	}
	
}