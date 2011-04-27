#include <RemoteArduino.h>
#include <EEPROM.h>
#include <LiquidCrystal.h>

RemoteArduino _RemoteArduino = RemoteArduino();
LiquidCrystal lcd(10, 11, 12, 13, 14, 15, 16);

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

void receivetone(uint8_t pin, uint16_t frequency, uint16_t duration) {
  if (duration  == 0) tone(pin, frequency);
  else tone(pin, frequency, duration);
}
void receivenoTone(uint8_t pin) {
  noTone(pin);
}

void receiveeeprom_read(uint16_t address) {
  uint8_t result = EEPROM.read(address);
  _RemoteArduino.sendeeprom_value(result);
}
void receiveeeprom_sync_write(uint16_t address, uint8_t value) {
  EEPROM.write(address, value);
   _RemoteArduino.sendeeprom_write_ack();
}
void receiveeeprom_write(uint16_t address, uint8_t value) {
  EEPROM.write(address, value);
}
void receivelcd_autoscroll() {
  lcd.autoscroll();
}
void receivelcd_begin(uint8_t col, uint8_t row) {
  lcd.begin(col, row);
}
void receivelcd_blink() {
  lcd.blink();
}
void receivelcd_clear() {
lcd.clear();
}
void receivelcd_create(uint8_t rs, uint8_t rw, uint8_t enable, uint8_t d4, uint8_t d5, uint8_t d6, uint8_t d7) {
  lcd = LiquidCrystal(rs, rw, enable, d4, d5, d6, d7);
}
void receivelcd_create_default() {
  lcd = LiquidCrystal(10, 11, 12, 13, 14, 15, 16);
}
void receivelcd_cursor() {
  lcd.cursor();
}
void receivelcd_display() {
  lcd.display();
}
void receivelcd_home() {
  lcd.home();
}
void receivelcd_leftToRight() {
  lcd.leftToRight();
}
void receivelcd_noAutoscroll() {
  lcd.noAutoscroll();
}
void receivelcd_noBlink() {
  lcd.noBlink();
}
void receivelcd_noCursor() {
  lcd.noCursor();
}
void receivelcd_noDisplay() {
  lcd.noDisplay();
}
void receivelcd_print(char * data) {
  lcd.print(data);
}
void receivelcd_rightToLeft() {
  lcd.rightToLeft();
}
void receivelcd_scrollDisplayLeft() {
  lcd.scrollDisplayLeft();
}
void receivelcd_scrollDisplayRight() {
  lcd.scrollDisplayRight();
}
void receivelcd_setCursor(uint8_t col, uint8_t row) {
  lcd.setCursor(col, row);
}
void receivelcd_write(uint8_t data) {
  lcd.write(data);
}

void setup()
{
	// initialize the RemoteArduino protocol
	_RemoteArduino.init_RemoteArduino();
        lcd.begin(16, 2);
        lcd.clear();
	lcd.print(" Remote Arduino ");
        lcd.setCursor(0, 1);
        lcd.print(" V0.1 (C)SINTEF");
	// TODO: Add your own setup code here
}

void loop()
{
	// check for incomming messages for the RemoteArduino protocol
	_RemoteArduino.poll_RemoteArduino();
	
	// TODO: Add any additional loop code here.
}
