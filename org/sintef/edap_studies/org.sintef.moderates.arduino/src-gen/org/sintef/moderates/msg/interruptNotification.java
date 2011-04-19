package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class interruptNotification extends RemoteArduinoProtocolPacket {

	private InterruptPin interrupt;
	
	public interruptNotification(InterruptPin interrupt) {
		setCommandID(RemoteArduinoProtocol.INTERRUPT_NOTIFICATION);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
	}
	
	public interruptNotification(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		interrupt =  InterruptPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleinterruptNotification(this);
	}

	@Override
	public String toString(){
		String myString = "interruptNotification:";
		myString += " [interrupt: "+interrupt+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
}