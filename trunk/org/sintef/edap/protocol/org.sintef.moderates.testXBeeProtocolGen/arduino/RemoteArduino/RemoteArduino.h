
// ensure this library description is only included once
#ifndef RemoteArduino_h
#define RemoteArduino_h

// include types & constants of Wiring core API
#include "WConstants.h"
#undef abs
#undef round

#include <inttypes.h>

// include the Xbee lib
#include "../XBee/XBee.h"

// Operations which implements the logic to execute when messages are received.
extern void receivepinMode(uint8_t pin, uint8_t mode);
extern void receivedigitalRead(uint8_t pin);
extern void receivedigitalWrite(uint8_t pin, uint8_t value);
extern void receiveanalogReference(uint8_t type);
extern void receiveanalogRead(uint8_t pin);
extern void receiveanalogWrite(uint8_t pin, uint8_t value);
extern void receiveping();
extern void receiveattachInterrupt(uint8_t interrupt, uint8_t mode);
extern void receivedetachInterrupt(uint8_t interrupt);

class RemoteArduino
{
  public:
	// Constructor which takes the address of the target XBee as parameter
    RemoteArduino(uint32_t, uint32_t);
	// Standard init and pool operations to be called in setup and loop
	void init_RemoteArduino();
	void poll_RemoteArduino();
	// Operations for sending all messages
    void senddigitalReadResult(uint8_t value);
    void sendanalogReadResult(uint16_t value);
    void sendpong();
    void sendinterruptNotification(uint8_t interrupt);

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
