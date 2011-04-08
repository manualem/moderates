#include <RemoteArduino.h>
#include <XBee.h>

// Replace the address by the actual address of the target XBee gateway
RemoteArduino _RemoteArduino = RemoteArduino(0x0013a200, 0x40331dc5);

extern void receivepinMode(uint8_t pin, uint8_t mode) {
	// TODO: Implement the handler for message reception of the message pinMode
}
extern void receivedigitalRead(uint8_t pin) {
	// TODO: Implement the handler for message reception of the message digitalRead
}
extern void receivedigitalWrite(uint8_t pin, uint8_t value) {
	// TODO: Implement the handler for message reception of the message digitalWrite
}
extern void receiveanalogReference(uint8_t type) {
	// TODO: Implement the handler for message reception of the message analogReference
}
extern void receiveanalogRead(uint8_t pin) {
	// TODO: Implement the handler for message reception of the message analogRead
}
extern void receiveanalogWrite(uint8_t pin, uint8_t value) {
	// TODO: Implement the handler for message reception of the message analogWrite
}
extern void receiveping() {
	// TODO: Implement the handler for message reception of the message ping
}
extern void receiveattachInterrupt(uint8_t interrupt, uint8_t mode) {
	// TODO: Implement the handler for message reception of the message attachInterrupt
}
extern void receivedetachInterrupt(uint8_t interrupt) {
	// TODO: Implement the handler for message reception of the message detachInterrupt
}

void setup()
{
	// initialize the RemoteArduino protocol
	_RemoteArduino.init_RemoteArduino();
	
	// TODO: Add your own setup code here
}

void loop()
{
	// check for incomming messages for the RemoteArduino protocol
	_RemoteArduino.poll_RemoteArduino();
	
	// TODO: Add any additional loop code here.
}
