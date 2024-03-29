/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : WTSClient 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"

#include "WTSClient.h"


#include "RF2500.h"
#include <string.h>
// Implemetation of void globals_WTSClient()

struct wts_packet {
	uint8_t code;
	uint8_t alarm;
	uint16_t v1;
	uint16_t v2;
	uint16_t v3;
	uint16_t v4;
};

static uint8_t packet_ready;

static struct wts_packet in_packet;
static struct wts_packet out_packet;

void RF2500_receive_packet(int src_addr, char* data, int length, int rssi, int lqi) {
	memcpy(&in_packet, data, length);
	packet_ready = 1;
}


void (*WTSClient_receive_GetData_listener)() = 0x0;
void register_WTSClient_receive_GetData_listener(void(*listener)()) {
	WTSClient_receive_GetData_listener = listener;
}
void WTSClient_receive_GetData() {
	if (WTSClient_receive_GetData_listener != 0) WTSClient_receive_GetData_listener();
}
void (*WTSClient_receive_GetStatus_listener)() = 0x0;
void register_WTSClient_receive_GetStatus_listener(void(*listener)()) {
	WTSClient_receive_GetStatus_listener = listener;
}
void WTSClient_receive_GetStatus() {
	if (WTSClient_receive_GetStatus_listener != 0) WTSClient_receive_GetStatus_listener();
}
void (*WTSClient_receive_GetName_listener)() = 0x0;
void register_WTSClient_receive_GetName_listener(void(*listener)()) {
	WTSClient_receive_GetName_listener = listener;
}
void WTSClient_receive_GetName() {
	if (WTSClient_receive_GetName_listener != 0) WTSClient_receive_GetName_listener();
}
void (*WTSClient_receive_ResetMinMax_listener)() = 0x0;
void register_WTSClient_receive_ResetMinMax_listener(void(*listener)()) {
	WTSClient_receive_ResetMinMax_listener = listener;
}
void WTSClient_receive_ResetMinMax() {
	if (WTSClient_receive_ResetMinMax_listener != 0) WTSClient_receive_ResetMinMax_listener();
}
void (*WTSClient_receive_SetMinAlarm_listener)(int) = 0x0;
void register_WTSClient_receive_SetMinAlarm_listener(void(*listener)(int)) {
	WTSClient_receive_SetMinAlarm_listener = listener;
}
void WTSClient_receive_SetMinAlarm(int value) {
	if (WTSClient_receive_SetMinAlarm_listener != 0) WTSClient_receive_SetMinAlarm_listener(value);
}
void (*WTSClient_receive_SetMaxAlarm_listener)(int) = 0x0;
void register_WTSClient_receive_SetMaxAlarm_listener(void(*listener)(int)) {
	WTSClient_receive_SetMaxAlarm_listener = listener;
}
void WTSClient_receive_SetMaxAlarm(int value) {
	if (WTSClient_receive_SetMaxAlarm_listener != 0) WTSClient_receive_SetMaxAlarm_listener(value);
}
void (*WTSClient_receive_SetBattAlarm_listener)(int) = 0x0;
void register_WTSClient_receive_SetBattAlarm_listener(void(*listener)(int)) {
	WTSClient_receive_SetBattAlarm_listener = listener;
}
void WTSClient_receive_SetBattAlarm(int value) {
	if (WTSClient_receive_SetBattAlarm_listener != 0) WTSClient_receive_SetBattAlarm_listener(value);
}
void (*WTSClient_receive_SetInterval_listener)(int) = 0x0;
void register_WTSClient_receive_SetInterval_listener(void(*listener)(int)) {
	WTSClient_receive_SetInterval_listener = listener;
}
void WTSClient_receive_SetInterval(int value) {
	if (WTSClient_receive_SetInterval_listener != 0) WTSClient_receive_SetInterval_listener(value);
}
void (*WTSClient_receive_SetName_listener)(char *) = 0x0;
void register_WTSClient_receive_SetName_listener(void(*listener)(char *)) {
	WTSClient_receive_SetName_listener = listener;
}
void WTSClient_receive_SetName(char * new_name) {
	if (WTSClient_receive_SetName_listener != 0) WTSClient_receive_SetName_listener(new_name);
}

void init_WTSClient() {
// Implemetation of void init_WTSClient()
	packet_ready = 0;
	init_RF2500();
	register_RF2500_receive_receive_listener(RF2500_receive_packet);
}
void poll_WTSClient(){
// Implemetation of void poll_WTSClient()
	poll_RF2500();
	if (packet_ready) {
		packet_ready = 0;
		switch (in_packet.code) {
			case 1 : WTSClient_receive_GetData();
			case 2 : WTSClient_receive_GetStatus();
			case 3 : WTSClient_receive_GetName();
			case 10 : WTSClient_receive_ResetMinMax();
			case 11 : WTSClient_receive_SetMinAlarm(in_packet.v1);
			case 12 : WTSClient_receive_SetMaxAlarm(in_packet.v1);
			case 13 : WTSClient_receive_SetBattAlarm(in_packet.v1);
			case 14 : WTSClient_receive_SetInterval(in_packet.v1);
			case 15 : WTSClient_receive_SetName((char*)&in_packet.v1);
			default: break;
		}
	}
}


void WTSClient_send_SensorData(int temp, int min, int max, int batt) {
	out_packet.code = 64;
	out_packet.v1 = temp;
	out_packet.v2 = min;
	out_packet.v3 = max;
	out_packet.v4 = batt;
	RF2500_send_transmit(0, (char*)(&out_packet));
}
void WTSClient_send_SensorStatus(int interval, int min_alarm, int max_alarm, int batt_alarm) {
	out_packet.code = 65;
	out_packet.v1 = interval;
	out_packet.v2 = min_alarm;
	out_packet.v3 = max_alarm;
	out_packet.v4 = batt_alarm;
	RF2500_send_transmit(0, (char*)(&out_packet));
}
void WTSClient_send_SensorName(char * name) {
	out_packet.code = 66;
	strcpy((char*)&(out_packet.v1), name);
	RF2500_send_transmit(0, (char*)(&out_packet));
}
