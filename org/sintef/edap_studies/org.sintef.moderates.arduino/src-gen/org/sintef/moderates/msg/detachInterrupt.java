package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class detachInterrupt extends RemoteArduinoProtocolPacket {

	private InterruptPin interrupt;
	
	public detachInterrupt(InterruptPin interrupt) {
		setCommandID(RemoteArduinoProtocol.DETACH_INTERRUPT);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
	}
	
	public detachInterrupt(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		interrupt =  InterruptPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handledetachInterrupt(this);
	}

	@Override
	public String toString(){
		String myString = "detachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
}