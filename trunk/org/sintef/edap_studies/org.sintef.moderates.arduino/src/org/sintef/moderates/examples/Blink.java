package org.sintef.moderates.examples;

import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;
/*
Blink
Turns on an LED on for one second, then off for one second, repeatedly.

This example code is in the public domain.
*/
public class Blink extends RemoteArduino {

	public Blink(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		// initialize the digital pin as an output.
		// Pin 13 has an LED connected on most Arduino boards:
		pinMode(DigitalPin.PIN_13, PinMode.OUTPUT);
	}

	@Override
	protected void loop() {
		// set the LED on
		digitalWrite(DigitalPin.PIN_13, DigitalState.HIGH); 
		delay(1000); // wait for a second
		 // set the LED off
		digitalWrite(DigitalPin.PIN_13, DigitalState.LOW);
		delay(1000); // wait for a second
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new Blink("COM21");
		arduino.runArduinoProcess();
	}

}
