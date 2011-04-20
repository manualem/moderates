package org.sintef.moderates.examples;

import org.sintef.moderates.AnalogPin;
import org.sintef.moderates.DigitalPin;
import org.sintef.moderates.DigitalState;
import org.sintef.moderates.PWMPin;
import org.sintef.moderates.PinMode;
import org.sintef.moderates.RemoteArduino;
/*
Analog input, analog output, serial output

Reads an analog input pin, maps the result to a range from 0 to 255
and uses the result to set the pulsewidth modulation (PWM) of an output pin.
Also prints the results to the serial monitor.

The circuit:
* potentiometer connected to analog pin 0.
 Center pin of the potentiometer goes to the analog pin.
 side pins of the potentiometer go to +5V and ground
* LED connected from digital pin 9 to ground

created 29 Dec. 2008
Modified 4 Sep 2010
by Tom Igoe

Ported to JAVA by SINTEF

This example code is in the public domain.

*/
public class AnalogInOutSerial extends RemoteArduino {

	// These constants won't change.  They're used to give names
	// to the pins used:
	final AnalogPin analogInPin = AnalogPin.A_1;  // Analog input pin that the potentiometer is attached to
	final PWMPin analogOutPin = PWMPin.PWM_PIN_9; // Analog output pin that the LED is attached to

	int sensorValue = 0;        // value read from the pot
	int outputValue = 0;        // value output to the PWM (analog out)
	
	public AnalogInOutSerial(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		
	}

	@Override
	protected void loop() {
		  // read the analog in value:
		  sensorValue = analogRead(analogInPin);            
		  // map it to the range of the analog out:
		  outputValue = map(sensorValue, 0, 1023, 0, 255);  
		  // change the analog out value:
		  analogWrite(analogOutPin, (byte)outputValue);           

		  // print the results to the serial monitor:
		  System.out.print("sensor = " );                       
		  System.out.print(sensorValue);      
		  System.out.print("\t output = ");      
		  System.out.println(outputValue);   

		  // wait 10 milliseconds before the next loop
		  // for the analog-to-digital converter to settle
		  // after the last reading:
		  delay(10); 
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new AnalogInOutSerial("COM21");
		arduino.runArduinoProcess();
	}

}
