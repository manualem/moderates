package no.sintef.moderates.btspp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Looper;
import android.util.Log;

public class BTSPPConnectionTask extends Thread {

	protected String DevAddr = "0A:07:08:0A:25:31";
	
	protected BluetoothAdapter bluetoothAdapter;
	protected BluetoothDevice device;
	protected BluetoothSocket socket;
	
	protected InputStream in;
	protected OutputStream out;
	
	protected boolean stop = false;
	protected boolean connected = false;
	
	public boolean isConnected() {
		return connected;
	}
	
	protected StringBuffer log = new StringBuffer();

	protected String buffer = "";
	protected ReentrantLock bufferLock;
	
	protected BTSPPConnectionTask(String DevAddr) {
		this.DevAddr = DevAddr;
		bufferLock = new ReentrantLock();
	}
	
	public String readData() {
		String result = "";
		bufferLock.lock();
		try {
			result = buffer;
			buffer = "";
		}
		finally {
			bufferLock.unlock();
		}
		return result;
	}
	
	public void run() {
		
		Looper.prepare();
		
		try {
			
			// Try to connect
			writeLine("Connecting..."); 
			connect();
			
			if (in != null && out != null) {
				writeLine("Connection established sucessfully.");
				connected = true;
				while(!stop) {
					
					if (in.available() > 0) {
						int c = in.read();
						if (c == 13) c = 10; // display a proper "\n" 
						//write(""+((char)c));
						bufferLock.lock();
						try {
						buffer = buffer + ((char)c);
						}
						finally {
							bufferLock.unlock();
						}
					}
					else {
						Thread.sleep(100);
					}
				}
			}
			else {
				writeLine("Connection failed."); 
			}
			
		} catch (IOException e) {
			writeLine(e.getClass() + " : " + e.getMessage());
		} catch (InterruptedException e) {
			writeLine(e.getClass() + " : " + e.getMessage());
		}
		finally {
			connected = false;
			close();
		}
	}	
	
	public void disconnect() {
		stop = true;
	}
	
	public void send(String msg) {
		if (out == null) {
			writeLine("Sending failed: not connected.");
			return;
		}
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(out));
		try {
			w.write(msg);
			w.flush();
			writeLine("Sent :" + msg);
		} catch (IOException e) {
			writeLine(e.getClass() + " : " + e.getMessage());
		}
	}
	
	public void connect() {
  	  // Get local Bluetooth adapter
      bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

      // If the adapter is null, then Bluetooth is not supported
      if (bluetoothAdapter == null) {
      	writeLine("No Bluetooth adapter found.");
      	return;
      }
      
      device = bluetoothAdapter.getRemoteDevice(DevAddr);
      
      writeLine("Device Name: " + device.getName());
      
      
      writeLine("Creating Socket..."); 
      
      try {
    	//BluetoothSocket socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
		Method m = device.getClass().getMethod("createRfcommSocket", new Class[] { int.class });
		  socket = (BluetoothSocket)m.invoke(device, Integer.valueOf(1));
	  } catch (Exception e) {
		  writeLine(e.getClass() + " : " + e.getMessage());
	  } 
      
      writeLine("Connecting Socket..."); 
      
      try {
    	  socket.connect();
    	  in = socket.getInputStream();
    	  out = socket.getOutputStream();
	  } catch (IOException e) {
		  writeLine(e.getClass() + " : " + e.getMessage());
	  }
	}
	
	public void close() {
		 stop = true;
		 writeLine("Closing bluetooth socket...");
		 
		 if (socket == null) return;
		 
		 try {
			 socket.close();
		} catch (IOException e) {writeLine(e.getClass() + " : " + e.getMessage());}

		writeLine("Closed.");
	}
	
	 protected void writeLine(String msg) {
		 log.append(msg + "\n");
	 }
	 
	 public String getLog() {
		 return log.toString();
	 }
	 
	 public void clearLog() {
		 log = new StringBuffer();
	 }
	
}
