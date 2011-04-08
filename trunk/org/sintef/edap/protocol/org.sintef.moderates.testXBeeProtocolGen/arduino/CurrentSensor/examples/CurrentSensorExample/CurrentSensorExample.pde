#include <CurrentSensor.h>
#include <XBee.h>

// Replace the address by the actual address of the target XBee gateway
CurrentSensor _CurrentSensor = CurrentSensor(0x0013a200, 0x40331dc5);

extern void receivestart() {
	// TODO: Implement the handler for message reception of the message start
}
extern void receivestop() {
	// TODO: Implement the handler for message reception of the message stop
}
extern void receiveping() {
	// TODO: Implement the handler for message reception of the message ping
}

void setup()
{
	// initialize the CurrentSensor protocol
	_CurrentSensor.init_CurrentSensor();
	
	// TODO: Add your own setup code here
}

void loop()
{
	// check for incomming messages for the CurrentSensor protocol
	_CurrentSensor.poll_CurrentSensor();
	
	// TODO: Add any additional loop code here.
}
