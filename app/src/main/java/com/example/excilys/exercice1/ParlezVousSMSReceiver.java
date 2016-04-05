package com.example.excilys.exercice1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by excilys on 05/04/16.
 */
public class ParlezVousSMSReceiver extends BroadcastReceiver {

    private final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private final String AVION = "android.intent.action.AIRPLANE_MODE";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SMS", "onReceive");

        if (intent.getAction().equals(ACTION_SMS_RECEIVED)) {
            Toast.makeText(context, "Vous avez reçu un SMS !", Toast.LENGTH_SHORT).show();
        }

        if (intent.getAction().equals(AVION)){
            Toast.makeText(context, "Vous avez changé le mode avion !", Toast.LENGTH_SHORT).show();
        }
    }
}
