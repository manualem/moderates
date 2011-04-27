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
public class EEPROM extends RemoteArduino {

	public EEPROM(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		
	}

	@Override
	protected void loop() {
		System.out.print("");
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new EEPROM("COM21");
		arduino.runArduinoProcess();
	}

}
