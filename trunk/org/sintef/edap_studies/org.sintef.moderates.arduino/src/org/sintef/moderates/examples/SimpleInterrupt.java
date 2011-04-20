package org.sintef.moderates.examples;

import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.InterruptPin;
import org.sintef.moderates.InterruptTrigger;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;
/*
This example shows how to use external interrupt of the
arduino board.
*/
public class SimpleInterrupt extends RemoteArduino {

	final DigitalPin ledPin = DigitalPin.PIN_9; // Analog output pin that the LED is attached to
	
	public SimpleInterrupt(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		// initialize the digital pin as an output.
		// Pin 13 has an LED connected on most Arduino boards:
		pinMode(ledPin, PinMode.OUTPUT);
		// with a button connected on pin2, this will generate an
		// interrupt when the button is pressed
		attachInterrupt(InterruptPin.PIN_2_INT0, InterruptTrigger.CHANGE);
	}

	@Override
	protected void loop() {
		// Do Nothing
		delay(1000); // wait for a second
	}

	
	@Override
	protected void interrupt0() {
		// This operation gets invoked when an INT0 is generated
		DigitalState button_state = digitalRead(DigitalPin.PIN_2);
		System.out.println("INT0: Toggling the LED on " + ledPin + " button state is " + button_state);
		digitalWrite(ledPin, button_state);
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new SimpleInterrupt("COM21");
		arduino.runArduinoProcess();
	}

}
