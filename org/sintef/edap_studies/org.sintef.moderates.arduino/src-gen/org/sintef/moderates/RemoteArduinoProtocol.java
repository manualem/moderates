package org.sintef.moderates;

import org.sintef.moderates.msg.*;

public abstract class RemoteArduinoProtocol {

	public static final byte PIN_MODE = 2; 
	public static final byte DIGITAL_READ = 4; 
	public static final byte DIGITAL_WRITE = 3; 
	public static final byte ANALOG_REFERENCE = 6; 
	public static final byte ANALOG_READ = 7; 
	public static final byte ANALOG_WRITE = 9; 
	public static final byte PING = 66; 
	public static final byte ATTACH_INTERRUPT = 21; 
	public static final byte DETACH_INTERRUPT = 22; 
	public static final byte DIGITAL_READ_RESULT = 5; 
	public static final byte ANALOG_READ_RESULT = 8; 
	public static final byte PONG = 67; 
	public static final byte INTERRUPT_NOTIFICATION = 23; 
	
	public static FixedSizePacket createMessageFromPacket(byte[] packet) {
		byte packetType = packet[4];
		FixedSizePacket result = null;
		switch(packetType){
			case PIN_MODE: result = new pinMode(packet); break; 
			case DIGITAL_READ: result = new digitalRead(packet); break; 
			case DIGITAL_WRITE: result = new digitalWrite(packet); break; 
			case ANALOG_REFERENCE: result = new analogReference(packet); break; 
			case ANALOG_READ: result = new analogRead(packet); break; 
			case ANALOG_WRITE: result = new analogWrite(packet); break; 
			case PING: result = new ping(packet); break; 
			case ATTACH_INTERRUPT: result = new attachInterrupt(packet); break; 
			case DETACH_INTERRUPT: result = new detachInterrupt(packet); break; 
			case DIGITAL_READ_RESULT: result = new digitalReadResult(packet); break; 
			case ANALOG_READ_RESULT: result = new analogReadResult(packet); break; 
			case PONG: result = new pong(packet); break; 
			case INTERRUPT_NOTIFICATION: result = new interruptNotification(packet); break; 
			default: break;
		}
		return result;
	}

	public static FixedSizePacket createpinMode(DigitalPin pin, PinMode mode) {
		pinMode result = new pinMode(pin, mode);
		return result;
	}
	
	public static FixedSizePacket createdigitalRead(DigitalPin pin) {
		digitalRead result = new digitalRead(pin);
		return result;
	}
	
	public static FixedSizePacket createdigitalWrite(DigitalPin pin, DigitalState value) {
		digitalWrite result = new digitalWrite(pin, value);
		return result;
	}
	
	public static FixedSizePacket createanalogReference(AnalogReference type) {
		analogReference result = new analogReference(type);
		return result;
	}
	
	public static FixedSizePacket createanalogRead(AnalogPin pin) {
		analogRead result = new analogRead(pin);
		return result;
	}
	
	public static FixedSizePacket createanalogWrite(PWMPin pin, byte value) {
		analogWrite result = new analogWrite(pin, value);
		return result;
	}
	
	public static FixedSizePacket createping() {
		ping result = new ping();
		return result;
	}
	
	public static FixedSizePacket createattachInterrupt(InterruptPin interrupt, InterruptTrigger mode) {
		attachInterrupt result = new attachInterrupt(interrupt, mode);
		return result;
	}
	
	public static FixedSizePacket createdetachInterrupt(InterruptPin interrupt) {
		detachInterrupt result = new detachInterrupt(interrupt);
		return result;
	}
	
	
	public static FixedSizePacket createdigitalReadResult(DigitalState value) {
		digitalReadResult result = new digitalReadResult(value);
		return result;
	}
	
	public static FixedSizePacket createanalogReadResult(short value) {
		analogReadResult result = new analogReadResult(value);
		return result;
	}
	
	public static FixedSizePacket createpong() {
		pong result = new pong();
		return result;
	}
	
	public static FixedSizePacket createinterruptNotification(InterruptPin interrupt) {
		interruptNotification result = new interruptNotification(interrupt);
		return result;
	}
	
}
