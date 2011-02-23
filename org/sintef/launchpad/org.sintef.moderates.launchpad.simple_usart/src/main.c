//#include <msp430x20x2.h>
#include <io.h>
#include <signal.h>

#include "USART.h"
#include "LED.h"
#include "Button.h"

#define UART_TXD   0x02                     // TXD on P1.1 (Timer0_A.OUT0)
#define UART_RXD   0x04                     // RXD on P1.2 (Timer0_A.CCI1A)

void usart_receive_char(char c) {

	switch (c) {
	case 'r': LED_send_light_off(1); break;
	case 'R': LED_send_light_on(1); break;
	case 'g': LED_send_light_off(2); break;
	case 'G': LED_send_light_on(2); break;
	case 't': USART_send_transmit_byte('t'); break;
	default: break;
	}
}

void button_press(int b) {
	USART_send_transmit_byte('P');
}

void button_release(int b) {
	USART_send_transmit_byte('R');
}

int main() {
	// initialize CPU
	WDTCTL = WDTPW + WDTHOLD;               // Stop watchdog timer

	DCOCTL = 0x00;                          // Set DCOCLK to 1MHz
	BCSCTL1 = CALBC1_1MHZ;
	DCOCTL = CALDCO_1MHZ;

	P1OUT = 0x00;                           // Initialize all GPIO
	P1SEL = UART_TXD + UART_RXD;            // Timer function for TXD/RXD pins
	P1DIR = 0xFF & ~UART_RXD;               // Set all pins but RXD to output
	P2OUT = 0x00;
	P2SEL = 0x00;
	P2DIR = 0xFF;

	// initialize devices
	init_USART();
	init_LED();
	init_Button();

	register_USART_receive_receive_byte_listener(usart_receive_char);
	register_Button_receive_press_listener(button_press);
	register_Button_receive_release_listener(button_release);

	__enable_interrupt();

	// main loop
	while(1) {
		poll_USART();
		poll_Button();
	}

	return 0;
}
