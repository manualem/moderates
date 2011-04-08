package org.sintef.moderates.out;

import org.sintef.moderates.*;

public abstract class OutgoingCurrentSensorMessage extends CurrentSensorProtocolPacket {
	
	public OutgoingCurrentSensorMessage() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
}

