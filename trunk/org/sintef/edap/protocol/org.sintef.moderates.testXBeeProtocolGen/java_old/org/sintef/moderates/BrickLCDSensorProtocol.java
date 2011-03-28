package org.sintef.moderates;

import java.util.Hashtable;
import org.sintef.moderates.in.*;
import org.sintef.moderates.out.*;

public abstract class BrickLCDSensorProtocol {

	// Outgoing messages
	public static final byte DISPLAY_TEXT = 1; 
	public static final byte CLEAR_TEXT = 2; 
	public static final byte READ_ALL_ANALOG = 3; 
	public static final byte READ_ANALOG = 4; 
	public static final byte SET_DIGITAL = 6; 
	public static final byte SET_VALUE = 7; 
	public static final byte GET_VALUE = 8; 
	public static final byte PING = 66; 
	
	// incoming messages
	public static final byte ANALOG_VALUE = 5; 
	public static final byte DIGITAL_VALUE = 9; 
	public static final byte PONG = 67; 
	

	private static Hashtable<Byte, IncomingBrickLCDSensorMessage> incomingMsg;
	
	private static void createincomingMsg() {
		incomingMsg = new Hashtable<Byte, IncomingBrickLCDSensorMessage>();
		incomingMsg.put(BrickLCDSensorProtocol.ANALOG_VALUE, new analogValue_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.DIGITAL_VALUE, new digitalValue_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.PONG, new pong_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.DISPLAY_TEXT, new displayText_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.CLEAR_TEXT, new clearText_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.READ_ALL_ANALOG, new readAllAnalog_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.READ_ANALOG, new readAnalog_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.SET_DIGITAL, new setDigital_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.SET_VALUE, new setValue_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.GET_VALUE, new getValue_In()); 
		incomingMsg.put(BrickLCDSensorProtocol.PING, new ping_In()); 
	}
	
	public static IncomingBrickLCDSensorMessage createMessageForIncomingPacket(byte[] packet) {
		if(incomingMsg == null) createincomingMsg();
		byte packetType = packet[4];
		IncomingBrickLCDSensorMessage result = null;
		if (incomingMsg.containsKey(packetType)) {
			result = incomingMsg.get(packetType).createPacket(packet);
		}
		return result;
	}

	public static displayText_Out createdisplayText(short line, String msg) {
		displayText_Out result = new displayText_Out(line, msg);
		return result;
	}
	
	public static clearText_Out createclearText() {
		clearText_Out result = new clearText_Out();
		return result;
	}
	
	public static readAllAnalog_Out createreadAllAnalog() {
		readAllAnalog_Out result = new readAllAnalog_Out();
		return result;
	}
	
	public static readAnalog_Out createreadAnalog(short pin) {
		readAnalog_Out result = new readAnalog_Out(pin);
		return result;
	}
	
	public static setDigital_Out createsetDigital(short pin, short direction) {
		setDigital_Out result = new setDigital_Out(pin, direction);
		return result;
	}
	
	public static setValue_Out createsetValue(short pin, short val) {
		setValue_Out result = new setValue_Out(pin, val);
		return result;
	}
	
	public static getValue_Out creategetValue(short pin) {
		getValue_Out result = new getValue_Out(pin);
		return result;
	}
	
	public static ping_Out createping() {
		ping_Out result = new ping_Out();
		return result;
	}
	
	
	public static analogValue_Out createanalogValue(short pin, short val) {
		analogValue_Out result = new analogValue_Out(pin, val);
		return result;
	}
	
	public static digitalValue_Out createdigitalValue(short pin, short val) {
		digitalValue_Out result = new digitalValue_Out(pin, val);
		return result;
	}
	
	public static pong_Out createpong() {
		pong_Out result = new pong_Out();
		return result;
	}
	
}
