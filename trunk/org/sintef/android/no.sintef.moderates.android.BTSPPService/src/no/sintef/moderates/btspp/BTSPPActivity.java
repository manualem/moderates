package no.sintef.moderates.btspp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class BTSPPActivity extends Activity {
 
	
	
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
		registerReceiver(receiver, new IntentFilter(BTSPPService.BROADCAST_CHAR_RECEPTION));
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
			        	write(""+intent.getExtras().get("data"));
			          }
			        });
			 }
		 }
	 };

	/***************************************************************************
	 *                              GUI
	 ***************************************************************************/
	
	 protected void initGUI() {
		 setContentView(R.layout.console);
	        
	        final Button buttonConnect = (Button) findViewById(R.id.ButtonClose);
	        buttonConnect.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					finish();
				}
			});
	        
	        final Button buttonSend = (Button) findViewById(R.id.ButtonSend);
	        buttonSend.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					send();
				}
			});
	        
	        final Button buttonClear = (Button) findViewById(R.id.ButtonClear);
	        buttonClear.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					clear();
				}
			});
	        
	        final Button buttonConfig = (Button) findViewById(R.id.ButtonConfig);
	        buttonConfig.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					// open the controller activity for the service
					Intent i = new Intent(BTSPPActivity.this, BTSPPServiceController.class);
					startActivity(i);
				}
			});
	        
	        
	        final CheckBox cbLine = (CheckBox) findViewById(R.id.CheckBoxLine);
	        cbLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					unregisterReceiver(receiver);
					if (cbLine.isChecked()) {
						registerReceiver(receiver, new IntentFilter(BTSPPService.BROADCAST_LINE_RECEPTION));
					}
					else {
						registerReceiver(receiver, new IntentFilter(BTSPPService.BROADCAST_CHAR_RECEPTION));
					}
				}
			});
			
	        clear();
	        
	 }
	 
		public void writeLine(String msg) {
	    	write(msg + "\n");
	    }
	    
	    public void write(String msg) {
	    	TextView tv = (TextView) findViewById(R.id.TextViewLog);
	    	tv.append(msg);
	    	// Update the scroll once the text view has been updated.
	    	if (tv.getHandler() != null) {
		    	tv.getHandler().post(new Runnable() {
			        public void run() {
			        	ScrollView sv = (ScrollView) findViewById(R.id.ScrollViewLog);
			        	sv.fullScroll(View.FOCUS_DOWN);
			          }
			        });
	    	}
	    }
	    
	    public void clear() {
	    	TextView tv = (TextView) findViewById(R.id.TextViewLog);
	    	tv.setText("");
	    }
	    
	/***************************************************************************
	 *                               ACTIONS
	 ***************************************************************************/
    
    protected void send() {
    	EditText et = (EditText)findViewById(R.id.EditTextInput);
    	String msg = et.getText().toString();
		
    	Intent intent = new Intent(BTSPPService.MESSAGE_TO_SEND);
    	intent.putExtra("data", msg);
		sendBroadcast(intent);
		
	}
    
}