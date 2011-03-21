/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : Button 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"

#ifndef BUTTON_H_
#define BUTTON_H_

void init_Button();
void poll_Button();


void register_Button_receive_press_listener(void(*listener)(int));
void register_Button_receive_release_listener(void(*listener)(int));

#endif /* BUTTON_H_ */