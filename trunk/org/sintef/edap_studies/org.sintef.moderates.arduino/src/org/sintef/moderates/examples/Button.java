package org.sintef.moderates.examples;

import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;

public class Button extends RemoteArduino {

	// the number of the pushbutton pin
	final DigitalPin buttonPin = DigitalPin.PIN_8;
	// the number of the LED pin
	final DigitalPin ledPin =  DigitalPin.PIN_13;
	
	// variable for reading the pushbutton status
	DigitalState buttonState = DigitalState.LOW;         
	
	public Button(String port) {
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

		// read the state of the pushbutton value:
		buttonState = digitalRead(buttonPin);
		// check if the pushbutton is pressed.
		// if it is, the buttonState is HIGH:
		if (buttonState == DigitalState.HIGH) {     
			// turn LED on:    
			digitalWrite(ledPin, DigitalState.HIGH);  
		} 
		else {
			// turn LED off:
			digitalWrite(ledPin, DigitalState.LOW); 
		}
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new Button("COM21");
		arduino.runArduinoProcess();
	}

}
