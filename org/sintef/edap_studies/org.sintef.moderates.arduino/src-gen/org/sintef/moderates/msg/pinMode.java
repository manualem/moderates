package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class pinMode extends RemoteArduinoProtocolPacket {

	private DigitalPin pin;
	private PinMode mode;
	
	public pinMode(DigitalPin pin, PinMode mode) {
		setCommandID(RemoteArduinoProtocol.PIN_MODE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setByteValue(mode.getValue());
		this.mode = mode;
	}
	
	public pinMode(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		pin =  DigitalPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		mode =  PinMode.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handlepinMode(this);
	}

	@Override
	public String toString(){
		String myString = "pinMode:";
		myString += " [pin: "+pin+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
	public PinMode getMode() {
		return mode;
	}
	
}