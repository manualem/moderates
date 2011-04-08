package org.sintef.moderates;

import java.util.Hashtable;
import org.sintef.moderates.in.*;
import org.sintef.moderates.out.*;

public abstract class CurrentSensorProtocol {

	// Outgoing messages
	public static final byte START = 2; 
	public static final byte STOP = 3; 
	public static final byte PING = 66; 
	
	// incoming messages
	public static final byte CURRENT_DATA = 4; 
	public static final byte PONG = 67; 
	

	private static Hashtable<Byte, IncomingCurrentSensorMessage> incomingMsg;
	
	private static void createincomingMsg() {
		incomingMsg = new Hashtable<Byte, IncomingCurrentSensorMessage>();
		incomingMsg.put(CurrentSensorProtocol.CURRENT_DATA, new currentData_In()); 
		incomingMsg.put(CurrentSensorProtocol.PONG, new pong_In()); 
		incomingMsg.put(CurrentSensorProtocol.START, new start_In()); 
		incomingMsg.put(CurrentSensorProtocol.STOP, new stop_In()); 
		incomingMsg.put(CurrentSensorProtocol.PING, new ping_In()); 
	}
	
	public static IncomingCurrentSensorMessage createMessageForIncomingPacket(byte[] packet) {
		if(incomingMsg == null) createincomingMsg();
		byte packetType = packet[4];
		IncomingCurrentSensorMessage result = null;
		if (incomingMsg.containsKey(packetType)) {
			result = incomingMsg.get(packetType).createPacket(packet);
		}
		return result;
	}

	public static start_Out createstart() {
		start_Out result = new start_Out();
		return result;
	}
	
	public static stop_Out createstop() {
		stop_Out result = new stop_Out();
		return result;
	}
	
	public static ping_Out createping() {
		ping_Out result = new ping_Out();
		return result;
	}
	
	
	public static currentData_Out createcurrentData(short sensorMax, short current, short eff_current) {
		currentData_Out result = new currentData_Out(sensorMax, current, eff_current);
		return result;
	}
	
	public static pong_Out createpong() {
		pong_Out result = new pong_Out();
		return result;
	}
	
}
