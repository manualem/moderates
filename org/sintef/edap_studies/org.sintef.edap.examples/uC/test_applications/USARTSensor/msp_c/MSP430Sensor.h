/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : MSP430Sensor 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"

#ifndef MSP430SENSOR_H_
#define MSP430SENSOR_H_


void poll_MSP430Sensor();

void MSP430Sensor_send_mesure_temperature();
void MSP430Sensor_send_mesure_voltage();

void register_MSP430Sensor_receive_temperature_value_listener(void(*listener)(int));
void register_MSP430Sensor_receive_voltage_value_listener(void(*listener)(int));

#endif /* MSP430SENSOR_H_ */