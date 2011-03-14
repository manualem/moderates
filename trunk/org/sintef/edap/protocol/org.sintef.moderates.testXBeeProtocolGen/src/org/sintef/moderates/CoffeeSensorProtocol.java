package org.sintef.moderates;

import java.util.Hashtable;

public abstract class CoffeeSensorProtocol {

	// Outgoing messages
	
	// incoming messages
	public static final byte COFFEE_DATA = 33; 
	

	private static Hashtable<Byte, IncomingCoffeeSensorMessage> incomingMsg;
	
	private static void createincomingMsg() {
		incomingMsg = new Hashtable<Byte, IncomingCoffeeSensorMessage>();
		incomingMsg.put(CoffeeSensorProtocol.COFFEE_DATA, new CoffeeData()); 
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


}
