package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class digitalRead extends RemoteArduinoProtocolPacket {

	private DigitalPin pin;
	
	public digitalRead(DigitalPin pin) {
		setCommandID(RemoteArduinoProtocol.DIGITAL_READ);
		setByteValue(pin.getValue());
		this.pin = pin;
	}
	
	public digitalRead(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin =  DigitalPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handledigitalRead(this);
	}

	@Override
	public String toString(){
		String myString = "digitalRead:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
}