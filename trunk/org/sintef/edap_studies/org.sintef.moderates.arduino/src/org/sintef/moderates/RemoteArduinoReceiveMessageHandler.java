package org.sintef.moderates;

import org.sintef.moderates.msg.analogRead;
import org.sintef.moderates.msg.analogReadResult;
import org.sintef.moderates.msg.analogReference;
import org.sintef.moderates.msg.analogWrite;
import org.sintef.moderates.msg.attachInterrupt;
import org.sintef.moderates.msg.detachInterrupt;
import org.sintef.moderates.msg.digitalRead;
import org.sintef.moderates.msg.digitalReadResult;
import org.sintef.moderates.msg.digitalWrite;
import org.sintef.moderates.msg.interruptNotification;
import org.sintef.moderates.msg.pinMode;
import org.sintef.moderates.msg.ping;
import org.sintef.moderates.msg.pong;

public abstract class RemoteArduinoReceiveMessageHandler implements
		RemoteArduinoMessageHandler {

	@Override
	public void handlepinMode(pinMode msg) {
		// Do nothing
	}

	@Override
	public void handledigitalRead(digitalRead msg) {
		// Do nothing
	}

	@Override
	public void handledigitalWrite(digitalWrite msg) {
		// Do nothing
	}

	@Override
	public void handleanalogReference(analogReference msg) {
		// Do nothing
	}

	@Override
	public void handleanalogRead(analogRead msg) {
		// Do nothing
	}

	@Override
	public void handleanalogWrite(analogWrite msg) {
		// Do nothing
	}

	@Override
	public void handleping(ping msg) {
		// Do nothing
	}

	@Override
	public void handleattachInterrupt(attachInterrupt msg) {
		// Do nothing
	}

	@Override
	public void handledetachInterrupt(detachInterrupt msg) {
		// Do nothing
	}
}
