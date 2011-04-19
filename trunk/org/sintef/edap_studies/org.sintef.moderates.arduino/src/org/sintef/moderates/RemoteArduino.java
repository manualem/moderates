package org.sintef.moderates;

import org.sintef.moderates.comm.Serial4RemoteArduino;
import org.sintef.moderates.msg.analogReadResult;
import org.sintef.moderates.msg.digitalReadResult;
import org.sintef.moderates.msg.interruptNotification;
import org.sintef.moderates.msg.pong;
import org.sintef.moderates.observer.RemoteArduinoObserver;

public abstract class RemoteArduino {
	
	private MessageHandler messageHandler;
	private Serial4RemoteArduino serial;
	
	public RemoteArduino(String port) {
		serial = new Serial4RemoteArduino(port);
		messageHandler = new MessageHandler();
		serial.register(messageHandler);
	}
	
	// Asynchronous remote call. No expected result.
	public void pinMode(DigitalPin pin, PinMode mode) {
		// Create message using the factory
		FixedSizePacket p = RemoteArduinoProtocol.createpinMode(pin, mode);
		// Send the message on the serial line
		serial.receiveMsg(p.getPacket());
	}
	
	public void digitalWrite(DigitalPin pin, DigitalState value) {
		// Create message using the factory
		FixedSizePacket p = RemoteArduinoProtocol.createdigitalWrite(pin, value);
		// Send the message on the serial line
		serial.receiveMsg(p.getPacket());
	}
	
	// Synchronous request with an expected response
	private DigitalState digitalRead_result;
	private boolean digitalRead_result_available;
	private Object digitalReadMonitor = "digitalReadMonitor";
	public DigitalState digitalRead(DigitalPin pin) {
		digitalRead_result_available = false;
		// Create message using the factory
		FixedSizePacket p = RemoteArduinoProtocol.createdigitalRead(pin);
		// Create message using the factory
		serial.receiveMsg(p.getPacket());
		try {
			synchronized(digitalReadMonitor) {
				digitalReadMonitor.wait(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (digitalRead_result_available) return digitalRead_result;
		else {
			// The exception alternative
			//throw new Error("Timeout waiting for the result of digitalRead");
			// The error message alternative
			System.err.println("Timeout waiting for the result of digitalRead");
			return DigitalState.LOW; // need to return something
		}
	}
	
	/* ******************************************************
	 * JAVA Version of common Arduino operations
	 ********************************************************/
	
	public void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/* ******************************************************
	 * Operation to be implemented by the application
	 ********************************************************/

	protected abstract void setup();
	protected abstract void loop();
	
	/* ******************************************************
	 * Operation to manage the application execution
	 ********************************************************/
	
	public void runArduinoProcess() {
		if (process != null) process.stopArduino();
		process = new RemoteArduinoProcess();
		process.start();
	}
	
	public void stopArduinoProcess() {
		if (process != null) process.stopArduino();
		process = null;
	}
	
	private RemoteArduinoProcess process;
	private class RemoteArduinoProcess extends Thread {
		
		protected boolean stop = false;
		
		public void stopArduino() {
			stop = true;
		}
		
		public void run() {
			setup();
			while(!stop) {
				loop();
				try {
					// Just to avoid blocking everything else if the 
					// application loop does not have delays
					Thread.sleep(5); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/* ******************************************************
	 * Handlers for the incoming messages
	 ********************************************************/
	
	private class MessageHandler extends RemoteArduinoReceiveMessageHandler implements RemoteArduinoObserver {
		
		@Override
		// Incoming messages from RemoteArduino arrive here
		public void receiveMsg(byte[] msg) {
			RemoteArduinoProtocolPacket p = (RemoteArduinoProtocolPacket)RemoteArduinoProtocol.createMessageFromPacket(msg);
			p.acceptMessage(messageHandler);
		}
		
		@Override
		public void handledigitalReadResult(digitalReadResult msg) {
			digitalRead_result = msg.getValue();
			digitalRead_result_available = true;
			synchronized(digitalReadMonitor) {
				digitalReadMonitor.notify();
			}
		}
	
		@Override
		public void handleanalogReadResult(analogReadResult msg) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void handlepong(pong msg) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void handleinterruptNotification(interruptNotification msg) {
			// TODO Auto-generated method stub
			
		}
	}
}
