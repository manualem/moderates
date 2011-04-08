#include <CoffeeSensor.h>
#include <XBee.h>

// Replace the address by the actual address of the target XBee gateway
CoffeeSensor _CoffeeSensor = CoffeeSensor(0x0013a200, 0x40331dc5);

extern void receiveCoffeeData(uint16_t temp, uint16_t dist, uint16_t light)
	// TODO: Implement the handler for message reception of the message CoffeeData
}

void setup()
{
	// initialize the CoffeeSensor protocol
	_CoffeeSensor.init_CoffeeSensor();
	
	// TODO: Add your own setup code here
}

void loop()
{
	// check for incomming messages for the CoffeeSensor protocol
	_CoffeeSensor.poll_CoffeeSensor();
	
	// TODO: Add any additional loop code here.
}
