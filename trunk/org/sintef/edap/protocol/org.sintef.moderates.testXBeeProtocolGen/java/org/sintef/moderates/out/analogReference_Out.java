package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class analogReference_Out extends OutgoingRemoteArduinoMessage {
	
	public analogReference_Out(byte type) {
		setCommandID(RemoteArduinoProtocol.ANALOG_REFERENCE);
		setByteValue(type);
	}

}