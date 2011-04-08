package org.sintef.moderates.in;

import org.sintef.moderates.*;

public abstract class IncomingRemoteArduinoMessage extends RemoteArduinoProtocolPacket implements Cloneable {
	public abstract IncomingRemoteArduinoMessage createPacket(byte[] packet);
}
