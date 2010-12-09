package no.sintef.modeartes.sensors.packets;

import java.util.Hashtable;

public abstract class SimpleSensorProtocol {

	// Outgoing messages
	public static final byte GET_DATA = 1;
	public static final byte GET_STATUS = 2;
	public static final byte GET_NAME = 3;
	
	public static final byte RESET_MIN_MAX = 10;
	public static final byte SET_MIN_ALARM = 11;
	public static final byte SET_MAX_ALARM = 12;
	public static final byte SET_BATT_ALARM = 13;
	public static final byte SET_INTERVAL = 14;
	public static final byte SET_NAME = 15;
	
	// incoming messages
	public static final byte SENSOR_DATA = 64;
	public static final byte SENSOR_STATUS = 65;
	public static final byte SENSOR_NAME = 66;
	

	private static Hashtable<Byte, IncomingMessage> incomingMsg;
	
	private static void createincomingMsg() {
		incomingMsg = new Hashtable<Byte, IncomingMessage>();
		incomingMsg.put(SimpleSensorProtocol.SENSOR_DATA, new SensorData());
		incomingMsg.put(SimpleSensorProtocol.SENSOR_STATUS, new SensorStatus());
		incomingMsg.put(SimpleSensorProtocol.SENSOR_NAME, new SensorName());
		
	}
	
	public static IncomingMessage createMessageForIncomingPacket(byte[] packet) {
		if(incomingMsg == null) createincomingMsg();
		byte packetType = packet[4];
		IncomingMessage result = null;
		if (incomingMsg.containsKey(packetType)) {
			result = incomingMsg.get(packetType).createPacket(packet);
		}
		return result;
	}

	public static GetData createGetData() {
		GetData result = new GetData();
		return result;
	}
	
	public static GetName createGetName() {
		GetName result = new GetName();
		return result;
	}
	
	public static GetStatus createGetStatus() {
		GetStatus result = new GetStatus();
		return result;
	}
	
	public static ResetMinMax ResetMinMax() {
		ResetMinMax result = new ResetMinMax();
		return result;
	}
	
	public static SetBattAlarm createSetBattAlarm(short value) {
		SetBattAlarm result = new SetBattAlarm(value);
		return result;
	}
	
	public static SetInterval createSetInterval(short value) {
		SetInterval result = new SetInterval(value);
		return result;
	}
	
	public static SetMaxAlarm createSetMaxAlarm(short value) {
		SetMaxAlarm result = new SetMaxAlarm(value);
		return result;
	}
	
	public static SetMinAlarm createSetMinAlarm(short value) {
		SetMinAlarm result = new SetMinAlarm(value);
		return result;
	}
	
	public static SetName createSetName(String name) {
		SetName result = new SetName(name);
		return result;
	}
	
}
