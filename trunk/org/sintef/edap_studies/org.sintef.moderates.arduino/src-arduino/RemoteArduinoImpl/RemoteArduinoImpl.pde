#include <RemoteArduino.h>

RemoteArduino _RemoteArduino = RemoteArduino();

void interrupt0() {
  _RemoteArduino.sendinterruptNotification(0);
}

void interrupt1() {
   _RemoteArduino.sendinterruptNotification(1);
}

extern void receivepinMode(uint8_t pin, uint8_t mode) {
  pinMode(pin, mode);
}
extern void receivedigitalRead(uint8_t pin) {
  int result = digitalRead(pin);
  _RemoteArduino.senddigitalReadResult(result);
}
extern void receivedigitalWrite(uint8_t pin, uint8_t value) {
  digitalWrite(pin, value);
}
extern void receiveanalogReference(uint8_t type) {
  analogReference(type);
}
extern void receiveanalogRead(uint8_t pin) {
  int result = analogRead(pin);
  _RemoteArduino.sendanalogReadResult(result);
}
extern void receiveanalogWrite(uint8_t pin, uint8_t value) {
  analogWrite(pin, value);
}
extern void receiveping() {
  _RemoteArduino.sendpong();
}
extern void receiveattachInterrupt(uint8_t interrupt, uint8_t mode) {
  if (interrupt == 0) attachInterrupt(0, interrupt0, mode);
  else if (interrupt == 1) attachInterrupt(1, interrupt1, mode);
}
extern void receivedetachInterrupt(uint8_t interrupt) {
  detachInterrupt(interrupt);
}

void setup()
{
         pinMode(13, OUTPUT);   
        digitalWrite(13, HIGH);
	// initialize the RemoteArduino protocol
	_RemoteArduino.init_RemoteArduino();
	
	// TODO: Add your own setup code here
}

void loop()
{
  
        digitalWrite(13, LOW); 
	// check for incomming messages for the RemoteArduino protocol
	_RemoteArduino.poll_RemoteArduino();
	
	// TODO: Add any additional loop code here.
}
