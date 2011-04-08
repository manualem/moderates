#include <BrickLCDSensor.h>
#include <XBee.h>

// Replace the address by the actual address of the target XBee gateway
BrickLCDSensor _BrickLCDSensor = BrickLCDSensor(0x0013a200, 0x40331dc5);

extern void receivedisplayText(uint16_t line, char * msg) {
	// TODO: Implement the handler for message reception of the message displayText
}
extern void receiveclearText() {
	// TODO: Implement the handler for message reception of the message clearText
}
extern void receivereadAllAnalog() {
	// TODO: Implement the handler for message reception of the message readAllAnalog
}
extern void receivereadAnalog(uint16_t pin) {
	// TODO: Implement the handler for message reception of the message readAnalog
}
extern void receivesetDigital(uint16_t pin, uint16_t direction) {
	// TODO: Implement the handler for message reception of the message setDigital
}
extern void receivesetValue(uint16_t pin, uint16_t val) {
	// TODO: Implement the handler for message reception of the message setValue
}
extern void receivegetValue(uint16_t pin) {
	// TODO: Implement the handler for message reception of the message getValue
}
extern void receiveping() {
	// TODO: Implement the handler for message reception of the message ping
}

void setup()
{
	// initialize the BrickLCDSensor protocol
	_BrickLCDSensor.init_BrickLCDSensor();
	
	// TODO: Add your own setup code here
}

void loop()
{
	// check for incomming messages for the BrickLCDSensor protocol
	_BrickLCDSensor.poll_BrickLCDSensor();
	
	// TODO: Add any additional loop code here.
}
