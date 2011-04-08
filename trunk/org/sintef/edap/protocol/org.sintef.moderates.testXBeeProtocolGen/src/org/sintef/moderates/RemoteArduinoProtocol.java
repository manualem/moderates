package org.sintef.moderates;

import java.util.Hashtable;
import org.sintef.moderates.in.*;
import org.sintef.moderates.out.*;

public abstract class RemoteArduinoProtocol {

	// Outgoing messages
	public static final byte PIN_MODE = 2; 
	public static final byte DIGITAL_READ = 4; 
	public static final byte DIGITAL_WRITE = 3; 
	public static final byte ANALOG_REFERENCE = 6; 
	public static final byte ANALOG_READ = 7; 
	public static final byte ANALOG_WRITE = 9; 
	public static final byte PING = 66; 
	public static final byte ATTACH_INTERRUPT = 21; 
	public static final byte DETACH_INTERRUPT = 22; 
	
	// incoming messages
	public static final byte DIGITAL_READ_RESULT = 5; 
	public static final byte ANALOG_READ_RESULT = 8; 
	public static final byte PONG = 67; 
	public static final byte INTERRUPT_NOTIFICATION = 23; 
	

	private static Hashtable<Byte, IncomingRemoteArduinoMessage> incomingMsg;
	
	private static void createincomingMsg() {
		incomingMsg = new Hashtable<Byte, IncomingRemoteArduinoMessage>();
		incomingMsg.put(RemoteArduinoProtocol.DIGITAL_READ_RESULT, new digitalReadResult_In()); 
		incomingMsg.put(RemoteArduinoProtocol.ANALOG_READ_RESULT, new analogReadResult_In()); 
		incomingMsg.put(RemoteArduinoProtocol.PONG, new pong_In()); 
		incomingMsg.put(RemoteArduinoProtocol.INTERRUPT_NOTIFICATION, new interruptNotification_In()); 
		incomingMsg.put(RemoteArduinoProtocol.PIN_MODE, new pinMode_In()); 
		incomingMsg.put(RemoteArduinoProtocol.DIGITAL_READ, new digitalRead_In()); 
		incomingMsg.put(RemoteArduinoProtocol.DIGITAL_WRITE, new digitalWrite_In()); 
		incomingMsg.put(RemoteArduinoProtocol.ANALOG_REFERENCE, new analogReference_In()); 
		incomingMsg.put(RemoteArduinoProtocol.ANALOG_READ, new analogRead_In()); 
		incomingMsg.put(RemoteArduinoProtocol.ANALOG_WRITE, new analogWrite_In()); 
		incomingMsg.put(RemoteArduinoProtocol.PING, new ping_In()); 
		incomingMsg.put(RemoteArduinoProtocol.ATTACH_INTERRUPT, new attachInterrupt_In()); 
		incomingMsg.put(RemoteArduinoProtocol.DETACH_INTERRUPT, new detachInterrupt_In()); 
	}
	
	public static IncomingRemoteArduinoMessage createMessageForIncomingPacket(byte[] packet) {
		if(incomingMsg == null) createincomingMsg();
		byte packetType = packet[4];
		IncomingRemoteArduinoMessage result = null;
		if (incomingMsg.containsKey(packetType)) {
			result = incomingMsg.get(packetType).createPacket(packet);
		}
		return result;
	}

	public static pinMode_Out createpinMode(byte pin, byte mode) {
		pinMode_Out result = new pinMode_Out(pin, mode);
		return result;
	}
	
	public static digitalRead_Out createdigitalRead(byte pin) {
		digitalRead_Out result = new digitalRead_Out(pin);
		return result;
	}
	
	public static digitalWrite_Out createdigitalWrite(byte pin, byte value) {
		digitalWrite_Out result = new digitalWrite_Out(pin, value);
		return result;
	}
	
	public static analogReference_Out createanalogReference(byte type) {
		analogReference_Out result = new analogReference_Out(type);
		return result;
	}
	
	public static analogRead_Out createanalogRead(byte pin) {
		analogRead_Out result = new analogRead_Out(pin);
		return result;
	}
	
	public static analogWrite_Out createanalogWrite(byte pin, byte value) {
		analogWrite_Out result = new analogWrite_Out(pin, value);
		return result;
	}
	
	public static ping_Out createping() {
		ping_Out result = new ping_Out();
		return result;
	}
	
	public static attachInterrupt_Out createattachInterrupt(byte interrupt, byte mode) {
		attachInterrupt_Out result = new attachInterrupt_Out(interrupt, mode);
		return result;
	}
	
	public static detachInterrupt_Out createdetachInterrupt(byte interrupt) {
		detachInterrupt_Out result = new detachInterrupt_Out(interrupt);
		return result;
	}
	
	
	public static digitalReadResult_Out createdigitalReadResult(byte value) {
		digitalReadResult_Out result = new digitalReadResult_Out(value);
		return result;
	}
	
	public static analogReadResult_Out createanalogReadResult(short value) {
		analogReadResult_Out result = new analogReadResult_Out(value);
		return result;
	}
	
	public static pong_Out createpong() {
		pong_Out result = new pong_Out();
		return result;
	}
	
	public static interruptNotification_Out createinterruptNotification(byte interrupt) {
		interruptNotification_Out result = new interruptNotification_Out(interrupt);
		return result;
	}
	
}
