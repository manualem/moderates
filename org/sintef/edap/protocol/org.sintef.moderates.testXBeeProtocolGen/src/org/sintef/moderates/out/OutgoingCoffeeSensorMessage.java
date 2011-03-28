package org.sintef.moderates.out;

import org.sintef.moderates.*;

public abstract class OutgoingCoffeeSensorMessage extends CoffeeSensorProtocolPacket {
	
	public OutgoingCoffeeSensorMessage() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
}

