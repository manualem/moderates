/* Powered by EDAP */

#include <avr/io.h>
#include <util/delay.h>
#include <inttypes.h>
#include <avr/interrupt.h>
#include <stdlib.h>
#include "USART.h"

#define FOSC    8000000
#define BAUD    9600
#define UBRR    FOSC/16/BAUD-1

void (*USART_receive_byte_listener)(char) = 0x0;
void register_USART_receive_byte_listener(void(*listener)(char)) {
	USART_receive_byte_listener = listener;
}
void USART_receive_byte(char b) {
	if (USART_receive_byte_listener != 0) USART_receive_byte_listener(b);
}

void init_USART() {
    UBRR0 = UBRR;                       // Set Baudrate
    UCSR0C = (3 << UCSZ00);               // Character Size 8 bit
    UCSR0B |= _BV(RXEN0) | _BV(TXEN0);  // Receiver and Transmitter Enable
}

void pool_USART(){
	 if (UCSR0A & (1 << RXC0)) {
		 char c = UDR0;
		 USART_receive_byte(c);
	 }
}

void USART_send_character(char b) {
	/* Wait for empty transmit buffer */
	while (!(UCSR0A & (1 << UDRE0)));
	/* Send one character */
	UDR0 = b;
}

void USART_send_message(char * message) {
	int i = 0;
	while(message[i] != 0) {
		USART_send_character(message[i]);
		i++;
	}
}
