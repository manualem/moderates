package org.sintef.moderates.out;

import org.sintef.moderates.*;

public abstract class OutgoingRemoteArduinoMessage extends RemoteArduinoProtocolPacket {
	
	public OutgoingRemoteArduinoMessage() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
}

