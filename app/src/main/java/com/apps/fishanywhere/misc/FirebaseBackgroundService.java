package com.apps.fishanywhere.misc;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.legacy.content.WakefulBroadcastReceiver;

import com.apps.fishanywhere.view.activity.SplashActivity;

public class FirebaseBackgroundService extends WakefulBroadcastReceiver {

    private static final String TAG = "FirebaseService";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "I'm in!!!");

        if (intent.getExtras() != null) {
            for (String key : intent.getExtras().keySet()) {
                Object value = intent.getExtras().get(key);
                Log.e("FirebaseDataReceiver", "Key: " + key + " Value: " + value);
                if(key.equalsIgnoreCase("gcm.notification.body") && value != null) {
//                    Bundle bundle = new Bundle();
                    Intent backgroundIntent = new Intent(context, SplashActivity.class);
                    backgroundIntent.putExtra("pushnotification", "yes");
//                    backgroundIntent.putExtras(bundle);
                    context.startService(backgroundIntent);
                }
            }
        }
    }
}
