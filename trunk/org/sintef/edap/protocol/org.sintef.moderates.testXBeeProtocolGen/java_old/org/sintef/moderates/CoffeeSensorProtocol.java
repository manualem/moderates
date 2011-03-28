package org.sintef.moderates;

import java.util.Hashtable;
import org.sintef.moderates.in.*;
import org.sintef.moderates.out.*;

public abstract class CoffeeSensorProtocol {

	// Outgoing messages
	public static final byte COFFEE_DATA = 33; 
	
	// incoming messages
	

	private static Hashtable<Byte, IncomingCoffeeSensorMessage> incomingMsg;
	
	private static void createincomingMsg() {
		incomingMsg = new Hashtable<Byte, IncomingCoffeeSensorMessage>();
		incomingMsg.put(CoffeeSensorProtocol.COFFEE_DATA, new CoffeeData_In()); 
	}
	
	public static IncomingCoffeeSensorMessage createMessageForIncomingPacket(byte[] packet) {
		if(incomingMsg == null) createincomingMsg();
		byte packetType = packet[4];
		IncomingCoffeeSensorMessage result = null;
		if (incomingMsg.containsKey(packetType)) {
			result = incomingMsg.get(packetType).createPacket(packet);
		}
		return result;
	}

	public static CoffeeData_Out createCoffeeData(short temp, short dist, short light) {
		CoffeeData_Out result = new CoffeeData_Out(temp, dist, light);
		return result;
	}
	
	
}
