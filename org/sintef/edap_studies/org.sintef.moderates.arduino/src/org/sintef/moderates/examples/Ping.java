package org.sintef.moderates.examples;

import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;
/*
This example pings the arduino and outputs its response time
*/
public class Ping extends RemoteArduino {

	public Ping(String port) {
		super(port);
	}

	@Override
	protected void setup() {

	}

	@Override
	protected void loop() {

		// store the current time
		long time = System.currentTimeMillis();
		// send the ping message to the arduino and wait for the pong message
		boolean alive = ping();
		// compute the time interval
		time = System.currentTimeMillis() - time;
		if (alive) {
			System.out.println("Reply from Arduino: time=" + time + "ms");
		}
		else {
			System.out.println("Request timed out (after " + time + "ms)");
		}
		delay(1000); // wait for a second
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new Ping("COM21");
		arduino.runArduinoProcess();
	}

}
