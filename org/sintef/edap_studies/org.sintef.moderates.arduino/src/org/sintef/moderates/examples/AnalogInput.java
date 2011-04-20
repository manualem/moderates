package org.sintef.moderates.examples;

import org.sintef.moderates.AnalogPin;
import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.PWMPin;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;
/*
Analog Input
Demonstrates analog input by reading an analog sensor on analog pin 0 and
turning on and off a light emitting diode(LED)  connected to digital pin 13. 
The amount of time the LED will be on and off depends on
the value obtained by analogRead(). 

The circuit:
* Potentiometer attached to analog input 0
* center pin of the potentiometer to the analog pin
* one side pin (either one) to ground
* the other side pin to +5V
* LED anode (long leg) attached to digital output 13
* LED cathode (short leg) attached to ground

* Note: because most Arduinos have a built-in LED attached 
to pin 13 on the board, the LED is optional.


Created by David Cuartielles
Modified 4 Sep 2010
By Tom Igoe

Ported to JAVA by SINTEF (2011)

This example code is in the public domain.

http://arduino.cc/en/Tutorial/AnalogInput

*/

public class AnalogInput extends RemoteArduino {

	// These constants won't change.  They're used to give names
	// to the pins used:
	final AnalogPin sensorPin = AnalogPin.A_1;  // Analog input pin that the potentiometer is attached to
	final DigitalPin ledPin = DigitalPin.PIN_9; // Analog output pin that the LED is attached to

	int sensorValue = 0;        // value read from the pot
	
	public AnalogInput(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		pinMode(ledPin, PinMode.OUTPUT);  
	}

	@Override
	protected void loop() {
		 // read the value from the sensor:
		  sensorValue = analogRead(sensorPin);    
		  // turn the ledPin on
		  digitalWrite(ledPin, DigitalState.HIGH);  
		  // stop the program for <sensorValue> milliseconds:
		  delay(sensorValue);          
		  // turn the ledPin off:        
		  digitalWrite(ledPin, DigitalState.LOW);   
		  // stop the program for for <sensorValue> milliseconds:
		  delay(sensorValue);   
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new AnalogInput("COM21");
		arduino.runArduinoProcess();
	}

}
