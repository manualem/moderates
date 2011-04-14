package org.sintef.moderates;

import org.sintef.moderates.msg.*;

public abstract class CoffeeSensorProtocol {

	//Enumerations

	public static final byte GET_TEMPERATURE = 1; 
	public static final byte GET_DISTANCE = 3; 
	public static final byte GET_LIGHT = 5; 
	public static final byte SUBSCRIBE_MOTION = 7; 
	public static final byte UNSUBSCRIBE_MOTION = 8; 
	public static final byte SUBSCRIBE_LIGHT_CHANGE = 11; 
	public static final byte UNSUBSCRIBE_LIGHT_CHANGE = 12; 
	public static final byte SUBSCRIBE_TEMPERATURE_CHANGE = 15; 
	public static final byte UNSUBSCRIBE_TEMPERATURE_CHANGE = 16; 
	public static final byte SUBSCRIBE_RAW_DATA = 19; 
	public static final byte GET_RAW_DATA = 20; 
	public static final byte PING = 66; 
	public static final byte TEMPERATURE_VALUE = 2; 
	public static final byte DISTANCE_VALUE = 4; 
	public static final byte LIGHT_VALUE = 6; 
	public static final byte APPROACHING_MOTION = 9; 
	public static final byte LEAVING_MOTION = 10; 
	public static final byte LIGHT_ON = 13; 
	public static final byte LIGHT_OFF = 14; 
	public static final byte TEMPERATURE_INCREASE = 17; 
	public static final byte TEMPERATURE_DECREASE = 18; 
	public static final byte RAW_DATA = 21; 
	public static final byte PONG = 67; 
	
	public static FixedSizePacket createMessageFromPacket(byte[] packet) {
		byte packetType = packet[4];
		FixedSizePacket result = null;
		switch(packetType){
			case GET_TEMPERATURE: result = new GetTemperature(packet); break; 
			case GET_DISTANCE: result = new GetDistance(packet); break; 
			case GET_LIGHT: result = new GetLight(packet); break; 
			case SUBSCRIBE_MOTION: result = new subscribeMotion(packet); break; 
			case UNSUBSCRIBE_MOTION: result = new unsubscribeMotion(packet); break; 
			case SUBSCRIBE_LIGHT_CHANGE: result = new subscribeLightChange(packet); break; 
			case UNSUBSCRIBE_LIGHT_CHANGE: result = new unsubscribeLightChange(packet); break; 
			case SUBSCRIBE_TEMPERATURE_CHANGE: result = new subscribeTemperatureChange(packet); break; 
			case UNSUBSCRIBE_TEMPERATURE_CHANGE: result = new unsubscribeTemperatureChange(packet); break; 
			case SUBSCRIBE_RAW_DATA: result = new subscribeRawData(packet); break; 
			case GET_RAW_DATA: result = new getRawData(packet); break; 
			case PING: result = new ping(packet); break; 
			case TEMPERATURE_VALUE: result = new TemperatureValue(packet); break; 
			case DISTANCE_VALUE: result = new DistanceValue(packet); break; 
			case LIGHT_VALUE: result = new LightValue(packet); break; 
			case APPROACHING_MOTION: result = new approachingMotion(packet); break; 
			case LEAVING_MOTION: result = new leavingMotion(packet); break; 
			case LIGHT_ON: result = new lightON(packet); break; 
			case LIGHT_OFF: result = new lightOFF(packet); break; 
			case TEMPERATURE_INCREASE: result = new temperatureIncrease(packet); break; 
			case TEMPERATURE_DECREASE: result = new temperatureDecrease(packet); break; 
			case RAW_DATA: result = new rawData(packet); break; 
			case PONG: result = new pong(packet); break; 
			default: break;
		}
		return result;
	}

	public static FixedSizePacket createGetTemperature() {
		GetTemperature result = new GetTemperature();
		return result;
	}
	
	public static FixedSizePacket createGetDistance() {
		GetDistance result = new GetDistance();
		return result;
	}
	
	public static FixedSizePacket createGetLight() {
		GetLight result = new GetLight();
		return result;
	}
	
	public static FixedSizePacket createsubscribeMotion() {
		subscribeMotion result = new subscribeMotion();
		return result;
	}
	
	public static FixedSizePacket createunsubscribeMotion() {
		unsubscribeMotion result = new unsubscribeMotion();
		return result;
	}
	
	public static FixedSizePacket createsubscribeLightChange() {
		subscribeLightChange result = new subscribeLightChange();
		return result;
	}
	
	public static FixedSizePacket createunsubscribeLightChange() {
		unsubscribeLightChange result = new unsubscribeLightChange();
		return result;
	}
	
	public static FixedSizePacket createsubscribeTemperatureChange() {
		subscribeTemperatureChange result = new subscribeTemperatureChange();
		return result;
	}
	
	public static FixedSizePacket createunsubscribeTemperatureChange() {
		unsubscribeTemperatureChange result = new unsubscribeTemperatureChange();
		return result;
	}
	
	public static FixedSizePacket createsubscribeRawData(short interval) {
		subscribeRawData result = new subscribeRawData(interval);
		return result;
	}
	
	public static FixedSizePacket creategetRawData() {
		getRawData result = new getRawData();
		return result;
	}
	
	public static FixedSizePacket createping() {
		ping result = new ping();
		return result;
	}
	
	
	public static FixedSizePacket createTemperatureValue(short v) {
		TemperatureValue result = new TemperatureValue(v);
		return result;
	}
	
	public static FixedSizePacket createDistanceValue(short v) {
		DistanceValue result = new DistanceValue(v);
		return result;
	}
	
	public static FixedSizePacket createLightValue(short v) {
		LightValue result = new LightValue(v);
		return result;
	}
	
	public static FixedSizePacket createapproachingMotion() {
		approachingMotion result = new approachingMotion();
		return result;
	}
	
	public static FixedSizePacket createleavingMotion(short minimalDist) {
		leavingMotion result = new leavingMotion(minimalDist);
		return result;
	}
	
	public static FixedSizePacket createlightON() {
		lightON result = new lightON();
		return result;
	}
	
	public static FixedSizePacket createlightOFF() {
		lightOFF result = new lightOFF();
		return result;
	}
	
	public static FixedSizePacket createtemperatureIncrease(short before, short current) {
		temperatureIncrease result = new temperatureIncrease(before, current);
		return result;
	}
	
	public static FixedSizePacket createtemperatureDecrease(short before, short current) {
		temperatureDecrease result = new temperatureDecrease(before, current);
		return result;
	}
	
	public static FixedSizePacket createrawData(short temp, short dist, short light) {
		rawData result = new rawData(temp, dist, light);
		return result;
	}
	
	public static FixedSizePacket createpong() {
		pong result = new pong();
		return result;
	}
	
}
