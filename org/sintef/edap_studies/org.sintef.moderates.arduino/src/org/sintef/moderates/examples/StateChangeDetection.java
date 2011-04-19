package org.sintef.moderates.examples;

import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;


public class StateChangeDetection extends RemoteArduino {

	// the number of the pushbutton pin
	final DigitalPin buttonPin = DigitalPin.PIN_8;
	// the number of the LED pin
	final DigitalPin ledPin = DigitalPin.PIN_13;

	// counter for the number of button presses
	int buttonPushCounter = 0;
	// current state of the button
	DigitalState buttonState = DigitalState.LOW;
	// previous state of the button
	DigitalState lastButtonState = DigitalState.LOW;

	public StateChangeDetection(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		// initialize the LED pin as an output:
		pinMode(ledPin, PinMode.OUTPUT);
		// initialize the pushbutton pin as an input:
		pinMode(buttonPin, PinMode.INPUT);
	}

	@Override
	protected void loop() {

		// read the pushbutton input pin:
		buttonState = digitalRead(buttonPin);

		// compare the buttonState to its previous state
		if (buttonState != lastButtonState) {
			// if the state has changed, increment the counter
			if (buttonState == DigitalState.HIGH) {
				// if the current state is HIGH then the button
				// wend from off to on:
				buttonPushCounter++;
				System.out.println("on");
				System.out.print("number of button pushes:  ");
				System.out.println(buttonPushCounter);
			} else {
				// if the current state is LOW then the button
				// wend from on to off:
				System.out.println("off");
			}

			// save the current state as the last state,
			// for next time through the loop
			lastButtonState = buttonState;
		}

		// turns on the LED every four button pushes by
		// checking the modulo of the button push counter.
		// the modulo function gives you the remainder of
		// the division of two numbers:
		if (buttonPushCounter % 4 == 0) {
			digitalWrite(ledPin, DigitalState.HIGH);
		} else {
			digitalWrite(ledPin, DigitalState.LOW);
		}
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new StateChangeDetection("COM21");
		arduino.runArduinoProcess();
	}

}
