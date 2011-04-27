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
public class Autoscroll extends RemoteArduino {

	public Autoscroll(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		lcd_begin((byte)16,(byte)2);
	}

	@Override
	protected void loop() {
		// set the cursor to (0,0):
		  lcd_setCursor((byte)0, (byte)0);
		  // print from 0 to 9:
		  for (int thisChar = 0; thisChar < 10; thisChar++) {
		   lcd_print(""+thisChar);
		   delay(500);
		  }

		  // set the cursor to (16,1):
		  lcd_setCursor((byte)16,(byte)1);
		  // set the display to automatically scroll:
		  lcd_autoscroll();
		  // print from 0 to 9:
		  for (int thisChar = 0; thisChar < 10; thisChar++) {
		    lcd_print(""+thisChar);
		    delay(500);
		  }
		  // turn off automatic scrolling
		  lcd_noAutoscroll();
		  
		  // clear screen for the next loop:
		  lcd_clear();
	}

	public static void main(String[] args) {
		RemoteArduino arduino = new Autoscroll("COM21");
		arduino.runArduinoProcess();
	}

}
