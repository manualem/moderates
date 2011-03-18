package org.sintef.moderates;

public class pong_Out extends OutgoingBrickLCDSensorMessage {
	
	public pong_Out() {
		setCommandID(BrickLCDSensorProtocol.PONG);
	}

}