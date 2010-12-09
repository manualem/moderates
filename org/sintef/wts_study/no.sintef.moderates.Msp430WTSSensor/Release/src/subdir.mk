################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/LED.c \
../src/MSP430Sensor.c \
../src/RF2500.c \
../src/Timer.c \
../src/WTS.c \
../src/WTSClient.c 

OBJS += \
./src/LED.o \
./src/MSP430Sensor.o \
./src/RF2500.o \
./src/Timer.o \
./src/WTS.o \
./src/WTSClient.o 

C_DEPS += \
./src/LED.d \
./src/MSP430Sensor.d \
./src/RF2500.d \
./src/Timer.d \
./src/WTS.d \
./src/WTSClient.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: mspgcc GCC C Compiler'
	msp430-gcc -I/usr/msp430/include -O3 -Wall -c -fmessage-length=0 -mmcu=msp430x2274 -o"$@" "$<" && \
	echo -n '$(@:%.o=%.d)' $(dir $@) > '$(@:%.o=%.d)' && \
	msp430-gcc -MM -MG -P -w -I/usr/msp430/include -O3 -Wall -c -fmessage-length=0 -mmcu=msp430x2274  "$<" >> '$(@:%.o=%.d)'
	@echo 'Finished building: $<'
	@echo ' '


