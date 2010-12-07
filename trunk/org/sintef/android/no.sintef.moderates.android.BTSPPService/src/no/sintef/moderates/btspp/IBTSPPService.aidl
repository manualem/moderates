package no.sintef.moderates.btspp;

interface IBTSPPService {
	
	String getStatus();
	String getLog();
	void clearLog();
	void connect(in String deviceAddr);
	void disconnect();
	boolean isConnected();
	void send(in String msg);
	
}
