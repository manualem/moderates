package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class digitalWrite extends RemoteArduinoProtocolPacket {

	private DigitalPin pin;
	private DigitalState value;
	
	public digitalWrite(DigitalPin pin, DigitalState value) {
		setCommandID(RemoteArduinoProtocol.DIGITAL_WRITE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setByteValue(value.getValue());
		this.value = value;
	}
	
	public digitalWrite(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin =  DigitalPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		value =  DigitalState.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handledigitalWrite(this);
	}

	@Override
	public String toString(){
		String myString = "digitalWrite:";
		myString += " [pin: "+pin+"]";
		myString += " [value: "+value+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
	public DigitalState getValue() {
		return value;
	}
	
}