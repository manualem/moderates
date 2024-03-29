/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : RF2500 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"

#ifndef RF2500_H_
#define RF2500_H_

void init_RF2500();
void poll_RF2500();

void RF2500_send_set_address(int address);
void RF2500_send_set_channel(int channel);
void RF2500_send_transmit(int addr, char * msg);
void RF2500_send_power_on();
void RF2500_send_power_off();

void register_RF2500_receive_receive_listener(void(*listener)(int, char *, int, int, int));

#endif /* RF2500_H_ */
