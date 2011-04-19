package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class attachInterrupt extends RemoteArduinoProtocolPacket {

	private InterruptPin interrupt;
	private InterruptTrigger mode;
	
	public attachInterrupt(InterruptPin interrupt, InterruptTrigger mode) {
		setCommandID(RemoteArduinoProtocol.ATTACH_INTERRUPT);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
		setByteValue(mode.getValue());
		this.mode = mode;
	}
	
	public attachInterrupt(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		ByteBuffer bb = ByteBuffer.wrap(data, 5, 10);
		interrupt =  InterruptPin.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		mode =  InterruptTrigger.fromValue(		bb.get()
		);
		position += (int) (Byte.SIZE/8);
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleattachInterrupt(this);
	}

	@Override
	public String toString(){
		String myString = "attachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
	public InterruptTrigger getMode() {
		return mode;
	}
	
}