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

#include "MSP430Sensor.h"

// Implemetation of void globals_MSP430Sensor()


#include <signal.h>

#define TEMP_REQUEST 	1<<0
#define VOLTAGE_REQUEST 1<<1
#define ADC_REQUEST 	1<<2

int request = 0;
int request_channel = 0;

#define	tempOffset	*((int*)0x10F4)

// Returns the temperature of the device in degrees celsus
int getTemperature() {
 		//int tempOffset = *((int *)0x10F4); // Initialize temperature offset coefficient
 		volatile long result;
 		int i;
 		ADC10CTL1 = INCH_10 + ADC10DIV_4;       // Temp Sensor ADC10CLK/5
	    ADC10CTL0 = SREF_1 + ADC10SHT_3 + REFON + ADC10ON + ADC10IE + ADC10SR;
	    for(i=0; i<250; i++) __no_operation();   // delay to allow reference to settle
	    ADC10CTL0 |= ENC + ADC10SC;             // Sampling and conversion start
	    __bis_SR_register(CPUOFF + GIE);        // LPM0 with interrupts enabled
	    result = ADC10MEM;
	    ADC10CTL0 &= ~ENC;
	    ADC10CTL0 &= ~(REFON + ADC10ON);        // turn off A/D to save power
	    // oC = ((A10/1024)*1500mV)-986mV)*1/3.55mV = A10*423/1024 - 278
	    // the temperature is transmitted as an integer where 32.1 = 321
	    // hence 4230 instead of 423
	    result = (((result - 673) * 4230) / 1024);
	    if (tempOffset != 0xFFFF) result += tempOffset;
	    return (int)result;
}
 
int getVoltage() {
	 	int result, i;
	 	ADC10CTL1 = INCH_11;                     // AVcc/2
	    ADC10CTL0 = SREF_1 + ADC10SHT_2 + REFON + ADC10ON + ADC10IE + REF2_5V;
	    for(i=0; i<250; i++) __no_operation();  // delay to allow reference to settle
	    ADC10CTL0 |= ENC + ADC10SC;             // Sampling and conversion start
	    __bis_SR_register(CPUOFF + GIE);        // LPM0 with interrupts enabled
	    result = ADC10MEM;
	    ADC10CTL0 &= ~ENC;
	    ADC10CTL0 &= ~(REFON + ADC10ON);        // turn off A/D to save power
	    result = (result*25)/512;
	    return result;
}
 
// ADC10 interrupt service routine - Needed to mesure temperature and voltage
interrupt(ADC10_VECTOR) wakeup ADC10_ISR(void)
{
  __bic_SR_register_on_exit(CPUOFF);        // Clear CPUOFF bit from 0(SR)
}
 


void (*MSP430Sensor_receive_temperature_value_listener)(int) = 0x0;
void register_MSP430Sensor_receive_temperature_value_listener(void(*listener)(int)) {
	MSP430Sensor_receive_temperature_value_listener = listener;
}
void MSP430Sensor_receive_temperature_value(int v) {
	if (MSP430Sensor_receive_temperature_value_listener != 0) MSP430Sensor_receive_temperature_value_listener(v);
}
void (*MSP430Sensor_receive_voltage_value_listener)(int) = 0x0;
void register_MSP430Sensor_receive_voltage_value_listener(void(*listener)(int)) {
	MSP430Sensor_receive_voltage_value_listener = listener;
}
void MSP430Sensor_receive_voltage_value(int v) {
	if (MSP430Sensor_receive_voltage_value_listener != 0) MSP430Sensor_receive_voltage_value_listener(v);
}


void poll_MSP430Sensor(){
// Implemetation of void poll_MSP430Sensor()

	if (request & TEMP_REQUEST) {
		MSP430Sensor_receive_temperature_value(getTemperature());
	}
	if (request & VOLTAGE_REQUEST) {
		MSP430Sensor_receive_voltage_value(getVoltage());
	}
	if (request & ADC_REQUEST) {
		// NOT YET IMPLEMENTED
	}
	request = 0;

}
void MSP430Sensor_send_mesure_temperature() {
// Implemetation of void MSP430Sensor_send_mesure_temperature()

	request |= TEMP_REQUEST; 

}
void MSP430Sensor_send_mesure_voltage() {
// Implemetation of void MSP430Sensor_send_mesure_voltage()

	request |= VOLTAGE_REQUEST;

}
