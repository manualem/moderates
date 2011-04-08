package org.sintef.moderates;

public abstract class FixedSizePacket {

	protected byte[] data;
	
	public byte[] getPacket() {
		return data;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i< 16; i++) {
			result += Byte.toString(data[i]) + ' ';
		}
		return result;
	}
	
	public static String toString(byte msg[]) {
		String result = "";
		for (int i = 0; i< msg.length; i++) {
			result += Byte.toString(msg[i]) + ' ';
		}
		return result;
	}
	
	public FixedSizePacket() {
		data = new byte[16];
	}
	
	public void setPacketData(byte[] packet) {
		this.data = packet;
	}
	
	public void setSourceAddress(byte address) {
		data[0] = address;
	}
	public byte getSourceAddress() {
		return data[0];
	}
	
	public void setTargetAddress(byte address) {
		data[1] = address;
	}
	public byte getTargetAddress() {
		return data[1];
	}
	
	public void setFrameNumber(byte frame) {
		data[2] = frame;
	}
	public byte getFrameNumber() {
		return data[2];
	}
	
	public void setLength(byte length) {
		if (length > 10) length = 10;
		data[3] = length;
	}
	public byte getLength() {
		return data[3];
	}
	
	public byte[] getRawData() {
		byte[] result = new byte[getLength()];
		for(int i=0; i<getLength();i++) {
			result[i] = data[i+4];
		}
		return result;
	}
	
	public void setRawData(byte[] ndata) {
		int i = 0;
		while (i < ndata.length && i < 10) {
			data[i+4] = ndata[i];
			i++;
		}
		setLength((byte)i);
	}
	
}
