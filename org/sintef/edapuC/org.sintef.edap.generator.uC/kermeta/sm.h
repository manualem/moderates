
#ifndef SM_H_
#define SM_H_

// set the number of state machines (including composite states)
#define EDAP_SM_COUNT 	3

// Define all the states, !!! Composite states first !!!
#define SMID_Root_State			0	// fixed
#define SMID_State_SA 			1
#define SMID_State_SB 			2
#define SMID_State_SA_S1		3
#define SMID_State_SA_S2		4
#define SMID_State_SB_S3		5
#define SMID_State_SB_S4		6

// define a variable to store the current state
static int SMID_Current_State[EDAP_SM_COUNT];

// define the entry and exit code for states which need it.
// all composite states should have an "on entry" to initialize there sub state
static void _on_entry_SMID_State_SA();
static void _on_entry_SMID_State_SB();

// define the incoming events
static u_int8 SMID_evt_RESET();
static u_int8 SMID_evt_x();
static u_int8 SMID_evt_y();
static u_int8 SMID_evt_a(int u, int v);
static u_int8 SMID_evt_x(char* c);

// Implementation of the entry and exit code
static void _on_entry_SMID_State_SA() {
	SMID_Current_State[SMID_State_SA] = SMID_State_SA_S1; // if no history
	// more entry code here
	// call the _on_entry of the initial state if it has some code (or it is a composite)
}
static void _on_entry_SMID_State_SB() {
	SMID_Current_State[SMID_State_SA] = SMID_State_SB_S3; // if no history
}

static u_int8 SMID_evt_RESET() {
	SMID_Current_State[SMID_Root_State] = SMID_State_SA;
	_on_entry_SMID_State_SA();
}

static u_int8 SMID_evt_x() {
	if (SMID_Current_State[SMID_Root_State] == SMID_State_SA /* && some guard */) {
		// _on_exit_SMID_State_SA(); // if anything there
		// some actions
		SMID_Current_State[SMID_Root_State] = SMID_State_SB;
		_on_entry_SMID_State_SB();
	}
	if(SMID_Current_State[SMID_Root_State] == SMID_State_SB && SMID_Current_State[SMID_State_SB] == SMID_State_SB_S4 /* && some guard */ ) {

	}
}
static u_int8 SMID_evt_y();
static u_int8 SMID_evt_a(int u, int v);
static u_int8 SMID_evt_x(char* c);


#endif
