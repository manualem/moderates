package org.sintef.moderates;

import org.sintef.moderates.msg.*;

public interface RemoteArduinoMessageHandler {

	public void handlepinMode(pinMode msg);
	public void handledigitalRead(digitalRead msg);
	public void handledigitalWrite(digitalWrite msg);
	public void handleanalogReference(analogReference msg);
	public void handleanalogRead(analogRead msg);
	public void handleanalogWrite(analogWrite msg);
	public void handleping(ping msg);
	public void handleattachInterrupt(attachInterrupt msg);
	public void handledetachInterrupt(detachInterrupt msg);
	
	public void handledigitalReadResult(digitalReadResult msg);
	public void handleanalogReadResult(analogReadResult msg);
	public void handlepong(pong msg);
	public void handleinterruptNotification(interruptNotification msg);
}
