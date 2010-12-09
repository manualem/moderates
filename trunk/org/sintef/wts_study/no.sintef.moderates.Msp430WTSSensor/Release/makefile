################################################################################
# Automatically-generated file. Do not edit!
################################################################################

-include ../makefile.init

RM := rm -rf

# All of the sources participating in the build are defined here
-include sources.mk
-include subdir.mk
-include src/subdir.mk
-include objects.mk

ifneq ($(MAKECMDGOALS),clean)
ifneq ($(strip $(C_DEPS)),)
-include $(C_DEPS)
endif
endif

-include ../makefile.defs

# Add inputs and outputs from these tool invocations to the build variables 

# All Target
all: SimpleTISensor

# Tool invocations
SimpleTISensor: $(OBJS) $(USER_OBJS)
	@echo 'Building target: $@'
	@echo 'Invoking: mspgcc GCC C Linker'
	msp430-gcc -L/usr/msp430/lib -mmcu=msp430x2274 -o"SimpleTISensor" $(OBJS) $(USER_OBJS) $(LIBS)
	@echo 'Finished building target: $@'
	@echo ' '

# Other Targets
clean:
	-$(RM) $(OBJS)$(C_DEPS) SimpleTISensor
	-@echo ' '

.PHONY: all clean dependents
.SECONDARY:

-include ../makefile.targets
