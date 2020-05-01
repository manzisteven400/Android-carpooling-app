package com.pt.taxi.gcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;
import com.pt.taxi.R;
import com.pt.taxi.activities.SplashActivity;

/**
 * {@link IntentService} responsible for handling GCM messages.
 */
public class GCMIntentService extends GCMBaseIntentService {
	private final String TAG = "GCMIntentService";

	public static final String KEY_MSG = "message";

	private static int NOTIFICATION_ID = 0;

	public GCMIntentService() {
		super(GcmManager.SENDER_ID);
	}

	@Override
	protected void onError(Context arg0, String arg1) {
		Log.e(TAG, "onError: " + arg1);
	}

	@Override
	protected void onMessage(Context context, Intent data) {
		Log.e(TAG, "onMessage: " + data);
		// sendNotification(context, data);
		Intent intent = new Intent("custom-event-name");
		// You can also include some extra data.
		intent.putExtra("message", data.getStringExtra(KEY_MSG));
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
		// For Vibrator
		if (data.getStringExtra(KEY_MSG).equals("KO")) {
			Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			v.vibrate(1000);
			// For Sound
			Uri notification = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),
					notification);
			r.play();
		} else {
			sendNotification(context, data);
			Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			v.vibrate(1000);
			// For Sound
			Uri notification = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),
					notification);
			r.play();
		}
	}

	@Override
	protected void onRegistered(Context context, String registrationId) {
		Log.e(TAG, "onRegistered: " + registrationId);
		new GcmManager(context).setRegistrationId(context, registrationId);
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		Log.e(TAG, "onUnregistered:  " + arg1);
	}

	// Put the GCM message into a notification and post it.
	private void sendNotification(Context context, Intent data) {
		String msg = data.getStringExtra(KEY_MSG);

		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Intent intent = new Intent(context, SplashActivity.class);
		intent.putExtra("pushNotification", true);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);

		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle(context.getString(R.string.app_name))
				.setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
				.setContentText(msg).setAutoCancel(true);
		mBuilder.setContentIntent(contentIntent);
		NOTIFICATION_ID = NOTIFICATION_ID + 1;
		mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}

}
