package no.sintef.moderates.btspp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class BTSPPService extends Service {

	public static final String BROADCAST_LINE_RECEPTION="no.sintef.moderates.btspp.LineReception";
	public static final String BROADCAST_CHAR_RECEPTION="no.sintef.moderates.btspp.CharReception";
	public static final String BROADCAST_STATUS="no.sintef.moderates.btspp.StatusMessage";
	public static final String MESSAGE_TO_SEND="no.sintef.moderates.btspp.MessageToSend";

	
	protected IBTSPPService implementation;

	/***************************************************************************
	 *                       Service Lifecycle
	 ***************************************************************************/
	
	@Override
	public IBinder onBind(Intent intent) {
		return (IBinder)implementation;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		implementation = BTSPPServiceImpl.getInstance(this);
		mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		beingDestroyed = true;
		try {
			if (implementation.isConnected()) implementation.disconnect();
			implementation.clearLog();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		implementation = null;
		unregisterReceiver(message_receiver);
		mNM.cancel(0);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		beingDestroyed = false;
		showNotification("BT SPP Service Started", R.drawable.btspps_inactive);
		registerReceiver(message_receiver, new IntentFilter(BTSPPService.MESSAGE_TO_SEND));
		return super.onStartCommand(intent, flags, startId);
	}
	
	/***************************************************************************
	 *                       Incomming intents
	 ***************************************************************************/
	
	private BroadcastReceiver message_receiver = new BroadcastReceiver() {
		 public void onReceive(Context context, final Intent intent) {
			
			 try {
				 if (intent.getExtras().containsKey("data")) {
					 //Toast.makeText(BTSPPService.this, "send: " + intent.getExtras().getString("data"), Toast.LENGTH_LONG).show();
					 try {
						if (implementation != null && implementation.isConnected()) {
							 implementation.send(intent.getExtras().getString("data"));
						 }
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				 }
			 }
			 catch (Exception e) {
				 Toast.makeText(BTSPPService.this, "ERROR: " + e + " - " + e.getMessage(), Toast.LENGTH_LONG).show();
			}
		 }
	 };
	
	
	/***************************************************************************
	 *                       Notifications
	 ***************************************************************************/
	boolean beingDestroyed = false;
	NotificationManager mNM;
	
    protected void showNotification(String message, int icon) {

    	if (beingDestroyed) return;
    	
    	Notification notification = new Notification(icon, message, System.currentTimeMillis());
    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, BTSPPServiceController.class), 0);
    	notification.setLatestEventInfo(this, message, message, contentIntent);

        mNM.notify(0, notification);
    }

	
	

}
