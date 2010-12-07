package no.sintef.moderates.btspp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.Service;
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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class BTSPPServiceController extends Activity {

	
	protected boolean isServiceRunning() {
	   ActivityManager m = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
       for (ActivityManager.RunningServiceInfo s :  m.getRunningServices(100)) {
    	   if(s.service.getClassName().equals("no.sintef.moderates.btspp.BTSPPService")) return true;
       }
       return false;
	}
	
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
		if (isServiceRunning() && btService == null) {
			Intent i = new Intent(BTSPPServiceController.this, BTSPPService.class);
			bindService(i, btServiceConnection, Context.BIND_AUTO_CREATE);
		}
		registerReceiver(status_receiver, new IntentFilter(BTSPPService.BROADCAST_STATUS));
	}
    
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (btService != null) {
			unbindService(btServiceConnection);
			btService = null;
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(status_receiver);
	}
	
	/***************************************************************************
	 *               Connection with the service / intents
	 ***************************************************************************/
	
	private BroadcastReceiver status_receiver = new BroadcastReceiver() {
		 public void onReceive(Context context, final Intent intent) {
			 if (intent.getExtras().containsKey("status")) {
				 runOnUiThread(new Runnable() {
			        public void run() {
			        	write(intent.getExtras().getString("status") + "\n");
			          }
			        });
			 }
		 }
	 };
	 
	 protected IBTSPPService btService;
	    
	    /**
	     * Class for interacting with the main interface of the service.
	     */
	    private ServiceConnection btServiceConnection = new ServiceConnection()  {
	        public void onServiceConnected(ComponentName className, IBinder service) {
	        	btService = IBTSPPService.Stub.asInterface(service);
	        	TextView tv = (TextView) findViewById(R.controller_id.TextViewLog);
		    	
	        	try {
					tv.setText(btService.getLog());
				} catch (Exception e) {
					writeLine("[Controller] Error : " + e);
					e.printStackTrace();
				}
				
	        	writeLine("[Controller] : Connected to service");
	        }

	        public void onServiceDisconnected(ComponentName className) {
	        	btService = null;
	        	writeLine("[Controller] : Unepectedly disconnected from service");

	        }
	    };
	
	/***************************************************************************
	 *                              GUI
	 ***************************************************************************/
	
	 protected void initGUI() {
		 setContentView(R.layout.controller);
	        
	        final Button buttonStart = (Button) findViewById(R.controller_id.ButtonStart);
	        buttonStart.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (!isServiceRunning()) {
						Intent i = new Intent(BTSPPServiceController.this, BTSPPService.class);
						startService(i);
						bindService(i, btServiceConnection, Context.BIND_AUTO_CREATE);
					}
					else {
						writeLine("[Controller] : Service is already running");
					}
				}
			});
	        
	        final Button buttonStop = (Button) findViewById(R.controller_id.ButtonStop);
	        buttonStop.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (isServiceRunning()) {
						Intent i = new Intent(BTSPPServiceController.this, BTSPPService.class);
						unbindService(btServiceConnection);
						btService = null;
						stopService(i);
					}
					else {
						writeLine("[Controller] : Service is not running");
					}
				}
			});
	        
	        final Button buttonConsole = (Button) findViewById(R.controller_id.ButtonConsole);
	        buttonConsole.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent(BTSPPServiceController.this, BTSPPActivity.class);
					startActivity(i);
				}
			});
	        
	        final Button buttonBTConnect = (Button) findViewById(R.controller_id.ButtonBTConnect);
	        buttonBTConnect.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (btService != null) {
						try {
							if (!btService.isConnected()) btService.connect("0A:07:08:0A:25:31");
							else writeLine("Bluetooth device already connected");
						} catch (RemoteException e) {
							writeLine("[Controller] : " + e.getMessage());
						}
					}
					else {
						writeLine("[Controller] : Service is not running or not bound");
					}
				}
			});
	        
	        final Button buttonBTDisconnect = (Button) findViewById(R.controller_id.ButtonBTDisconnect);
	        buttonBTDisconnect.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (btService != null) {
						try {
							if (btService.isConnected()) btService.disconnect();
							else writeLine("No bluetooth device connected");
						} catch (RemoteException e) {
							writeLine("[Controller] : " + e.getMessage());
						}
					}
					else {
						writeLine("[Controller] : Service is not running or not bound");
					}
				}
			});
	        
	        final Button buttonClear = (Button) findViewById(R.controller_id.ButtonClear);
	        buttonClear.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (btService != null) {
						try {
							btService.clearLog();
						} catch (RemoteException e) {
							writeLine("[Controller] : " + e.getMessage());
						}
					}
					clearView();
				}
			});
	        
	        final Button buttonQuit = (Button) findViewById(R.controller_id.ButtonQuit);
	        buttonQuit.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					finish();
				}
			});
	        
	        clearView();
	 }
	 
		public void writeLine(String msg) {
	    	write(msg + "\n");
	    }
	    
	    public void write(String msg) {
	    	TextView tv = (TextView) findViewById(R.controller_id.TextViewLog);
	    	tv.append(msg);
	    	// Update the scroll once the text view has been updated.
	    	
	    	if (tv.getHandler() != null) {
		    	tv.getHandler().post(new Runnable() {
			        public void run() {
			        	ScrollView sv = (ScrollView) findViewById(R.controller_id.ScrollViewLog);
			        	sv.fullScroll(View.FOCUS_DOWN);
			          }
			        });
	    	}
	    }
	    
	    public void clearView() {
	    	TextView tv = (TextView) findViewById(R.controller_id.TextViewLog);
	    	tv.setText("");
	    }
	
	

}
