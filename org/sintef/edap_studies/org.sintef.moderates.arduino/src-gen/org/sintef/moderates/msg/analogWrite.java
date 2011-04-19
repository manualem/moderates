package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class analogWrite extends RemoteArduinoProtocolPacket {

	private PWMPin pin;
	private byte value;
	
	public analogWrite(PWMPin pin, byte value) {
		setCommandID(RemoteArduinoProtocol.ANALOG_WRITE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setByteValue(value);
		this.value = value;
	}
	
	public analogWrite(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin =  PWMPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		value = 		bb.get()
		;
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleanalogWrite(this);
	}

	@Override
	public String toString(){
		String myString = "analogWrite:";
		myString += " [pin: "+pin+"]";
		myString += " [value: "+value+"]";
		return myString;
	}

	public PWMPin getPin() {
		return pin;
	}
	
	public byte getValue() {
		return value;
	}
	
}