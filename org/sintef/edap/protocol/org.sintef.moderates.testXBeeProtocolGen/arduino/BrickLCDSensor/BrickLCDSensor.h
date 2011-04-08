
// ensure this library description is only included once
#ifndef BrickLCDSensor_h
#define BrickLCDSensor_h

// include types & constants of Wiring core API
#include "WConstants.h"
#undef abs
#undef round

#include <inttypes.h>

// include the Xbee lib
#include "../XBee/XBee.h"

// Operations which implements the logic to execute when messages are received.
extern void receivedisplayText(uint16_t line, char * msg);
extern void receiveclearText();
extern void receivereadAllAnalog();
extern void receivereadAnalog(uint16_t pin);
extern void receivesetDigital(uint16_t pin, uint16_t direction);
extern void receivesetValue(uint16_t pin, uint16_t val);
extern void receivegetValue(uint16_t pin);
extern void receiveping();

class BrickLCDSensor
{
  public:
	// Constructor which takes the address of the target XBee as parameter
    BrickLCDSensor(uint32_t, uint32_t);
	// Standard init and pool operations to be called in setup and loop
	void init_BrickLCDSensor();
	void poll_BrickLCDSensor();
	// Operations for sending all messages
    void sendanalogValue(uint16_t pin, uint16_t val);
    void senddigitalValue(uint16_t pin, uint16_t val);
    void sendpong();

  private:
	// the address of the target XBee
	XBee xbee;
	XBeeAddress64 addr64;
	ZBTxRequest zbTx;
	ZBTxStatusResponse txStatus;
	ZBRxResponse rx;
	uint8_t payload[16];
	// private operation which parses incomming message and calls
	// the corresponding exten functions
    void parseIncommingMessage(uint8_t data[]);
};

#endif
