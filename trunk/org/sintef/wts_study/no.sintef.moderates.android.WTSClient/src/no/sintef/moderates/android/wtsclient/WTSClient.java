package no.sintef.moderates.android.wtsclient;

import no.sintef.modeartes.sensors.packets.OutgoingMessage;
import no.sintef.modeartes.sensors.packets.SetBattAlarm;
import no.sintef.modeartes.sensors.packets.SetMaxAlarm;
import no.sintef.modeartes.sensors.packets.SetMinAlarm;
import no.sintef.modeartes.sensors.packets.SetName;
import no.sintef.modeartes.sensors.packets.SimpleSensorProtocol;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WTSClient extends Activity {
    
	public static final String BROADCAST_LINE_RECEPTION="no.sintef.moderates.btspp.LineReception";
	public static final String BROADCAST_CHAR_RECEPTION="no.sintef.moderates.btspp.CharReception";
	public static final String BROADCAST_STATUS="no.sintef.moderates.btspp.StatusMessage";
	public static final String MESSAGE_TO_SEND="no.sintef.moderates.btspp.MessageToSend";
	
	/***************************************************************************
	 *                       Activity Lifecycle
	 ***************************************************************************/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGUI();
    }

	@Override
	protected void onResume() {
		super.onResume();
		// Get Events from the BT Service
		registerReceiver(receiver, new IntentFilter(BROADCAST_CHAR_RECEPTION));
	}
    
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(receiver);
	}

	/***************************************************************************
	 *               Connection with the service / intents
	 ***************************************************************************/
	
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		 public void onReceive(Context context, final Intent intent) {
			 if (intent.getExtras().containsKey("data")) {
				 runOnUiThread(new Runnable() {
			        public void run() {
			        	//write(""+intent.getExtras().get("data"));
			          }
			        });
			 }
		 }
	 };
	 
		/***************************************************************************
		 *                              GUI
		 ***************************************************************************/
		
		 protected void initGUI() {
			 setContentView(R.layout.main);
		        
		        final Button buttonAlarmBattSet = (Button) findViewById(R.id.ButtonAlarmBattSet);
		        buttonAlarmBattSet.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						EditText et = (EditText) findViewById(R.id.EditTextAlarmBatt);
						try {
							short value = (short)(Float.parseFloat(et.getText().toString()) * 10.0f);
							SetBattAlarm message = SimpleSensorProtocol.createSetBattAlarm(value);
							send(message); // Send the message to the sensor
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						send(SimpleSensorProtocol.createGetStatus()); // to update values according to the sensor
					}
				});
		        
		        final Button buttonAlarmMaxSet = (Button) findViewById(R.id.ButtonAlarmMaxSet);
		        buttonAlarmMaxSet.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						EditText et = (EditText) findViewById(R.id.EditTextAlarmMax);
						try {
							short value = (short)(Float.parseFloat(et.getText().toString()) * 10.0f);
							SetMaxAlarm message = SimpleSensorProtocol.createSetMaxAlarm(value);
							send(message); // Send the message to the sensor
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						send(SimpleSensorProtocol.createGetStatus()); // to update values according to the sensor
					}
				});
		        
		        final Button buttonAlarmMinSet = (Button) findViewById(R.id.ButtonAlarmMinSet);
		        buttonAlarmMinSet.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						EditText et = (EditText) findViewById(R.id.EditTextAlarmMin);
						try {
							short value = (short)(Float.parseFloat(et.getText().toString()) * 10.0f);
							SetMinAlarm message = SimpleSensorProtocol.createSetMinAlarm(value);
							send(message); // Send the message to the sensor
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						send(SimpleSensorProtocol.createGetStatus()); // to update values according to the sensor
					}
				});
		        
		        final Button buttonSensorNameSet = (Button) findViewById(R.id.ButtonSensorNameSet);
		        buttonSensorNameSet.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						EditText et = (EditText) findViewById(R.id.EditTextSensorName);
						try {
							String value = et.getText().toString();
							SetName message = SimpleSensorProtocol.createSetName(value);
							send(message); // Send the message to the sensor
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						send(SimpleSensorProtocol.createGetName()); // to update values according to the sensor
					}
				});
		        
		        OnClickListener requestStatusUpdate = new OnClickListener() {
					public void onClick(View v) {
						send(SimpleSensorProtocol.createGetStatus());
					}
				};
				
				OnClickListener requestDataUpdate = new OnClickListener() {
					public void onClick(View v) {
						send(SimpleSensorProtocol.createGetData());
					}
				};
				
				OnClickListener requestNameUpdate = new OnClickListener() {
					public void onClick(View v) {
						send(SimpleSensorProtocol.createGetName());
					}
				};
		        
				final Button buttonAlarmBattUpdate = (Button) findViewById(R.id.ButtonAlarmBattUpdate);
				buttonAlarmBattUpdate.setOnClickListener(requestStatusUpdate);
			    
			    final Button buttonAlarmMaxUpdate = (Button) findViewById(R.id.ButtonAlarmMaxUpdate);
			    buttonAlarmMaxUpdate.setOnClickListener(requestStatusUpdate);
			    
			    final Button buttonAlarmMinUpdate = (Button) findViewById(R.id.ButtonAlarmMinUpdate);
			    buttonAlarmMinUpdate.setOnClickListener(requestStatusUpdate);
			    
			    final Button buttonBattUpdate = (Button) findViewById(R.id.ButtonBattUpdate);
			    buttonBattUpdate.setOnClickListener(requestDataUpdate);
			    
			    final Button buttonTemperatureUpdate = (Button) findViewById(R.id.ButtonTemperatureUpdate);
			    buttonTemperatureUpdate.setOnClickListener(requestDataUpdate);
			    
			    final Button buttonTempMinUpdate = (Button) findViewById(R.id.ButtonTempMinUpdate);
			    buttonTempMinUpdate.setOnClickListener(requestDataUpdate);
			    
			    final Button buttonTempMaxUpdate = (Button) findViewById(R.id.ButtonTempMaxUpdate);
			    buttonTempMaxUpdate.setOnClickListener(requestDataUpdate);
			    
			    final Button buttonSensorNameUpdate = (Button) findViewById(R.id.ButtonSensorNameUpdate);
			    buttonSensorNameUpdate.setOnClickListener(requestNameUpdate);
				
		 }
		    
		/***************************************************************************
		 *                               ACTIONS
		 ***************************************************************************/
	    
	    protected void send(OutgoingMessage msg) {
	    	Log.d("MsgToSend", msg.toString());
	    	Intent intent = new Intent(MESSAGE_TO_SEND);
	    	intent.putExtra("data", msg.getRawData().toString());
			sendBroadcast(intent);
			
		}
	
}