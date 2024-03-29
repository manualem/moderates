/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : USART 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"

#ifndef USART_H_
#define USART_H_

void init_USART();
void poll_USART();

void USART_send_transmit(char * msg);
void USART_send_transmit_byte(char b);
void USART_send_transmit_Hex8(int value);
void USART_send_transmit_hexdump(char * ptr, int len);

void register_USART_receive_receive_byte_listener(void(*listener)(char));

#endif /* USART_H_ */
