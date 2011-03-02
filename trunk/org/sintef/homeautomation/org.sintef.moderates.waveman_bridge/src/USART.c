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

//-----------------------------------------------------------------------------
// Implementation of the FIFO buffer for received characters
//-----------------------------------------------------------------------------

#define USART_BUFFER_SIZE 32

volatile char usart_buffer[USART_BUFFER_SIZE]; // circular buffer fifo
volatile int usart_buffer_front = 0;
volatile int usart_buffer_tail = 0;

volatile uint8_t outbuf_idx = 0;
volatile char outbuf[USART_BUFFER_SIZE];

int usart_buffer_empty() {
	if (usart_buffer_front == usart_buffer_tail) return 1;
	else return 0;
}

int usart_buffer_full() {
	if ( (usart_buffer_tail + 1) % USART_BUFFER_SIZE == usart_buffer_front ) return 1;
	else return 0;
}

void usart_buffer_queue(char c) {
	if (!usart_buffer_full()) {
		usart_buffer[usart_buffer_tail] = c;
		usart_buffer_tail = (usart_buffer_tail + 1) % USART_BUFFER_SIZE;
	}
}

char usart_buffer_dequeue() {
	char result = 0;
	if (!usart_buffer_empty()) {
		result = usart_buffer[usart_buffer_front];
		usart_buffer_front = (usart_buffer_front + 1) % USART_BUFFER_SIZE;
	}
	return result;
}

void (*USART_receive_byte_listener)(char) = 0x0;
void register_USART_receive_byte_listener(void(*listener)(char)) {
	USART_receive_byte_listener = listener;
}
void USART_receive_byte(char b) {
	if (USART_receive_byte_listener != 0) USART_receive_byte_listener(b);
}

void (*USART_receive_msg_listener)(char*) = 0x0;
void register_USART_receive_msg_listener(void(*listener)(char*)) {
	USART_receive_msg_listener = listener;
}
void USART_receive_msg(char * msg) {
	if (USART_receive_msg_listener != 0) USART_receive_msg_listener(msg);
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

		 if (c == '\n' || c == 0x0D || c == 0x0A) {
			 outbuf[outbuf_idx] = 0;
			 outbuf_idx = 0;
			 USART_receive_msg(outbuf);
		 }
		 else if (outbuf_idx < USART_BUFFER_SIZE-1) {
			 outbuf[outbuf_idx++] = c;
		 }
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

void USART_transmit_Hex8(int value) {
	static const char hex[] = "0123456789ABCDEF";
	USART_send_character(hex[(value>>4) & 0x0f] );
	USART_send_character(hex[value & 0x0f] );
}
