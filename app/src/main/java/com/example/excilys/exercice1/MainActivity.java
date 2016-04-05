package com.example.excilys.exercice1;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    public static final String PREF_NAME = "credentials";
    private static final String USERNAME = "username";
    private static final String PWD = "password";

    private EditText usernameField;
    private EditText passwordField;
    private  ParlezVousSMSReceiver receiver;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        IntentFilter anotherFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        receiver = new ParlezVousSMSReceiver();
//        registerReceiver(receiver, filter);
        registerReceiver(receiver, anotherFilter);

        usernameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);

        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        String username = settings.getString(USERNAME, null);
        String password = settings.getString(PWD, null);

        if (username != null) {
            usernameField.setText(username);
            if (password != null) passwordField.setText(password);
        }

        Log.i(TAG, "onCreate !");

    }

    public void sendListener (View view){
        Toast.makeText(this, "Toast !", Toast.LENGTH_SHORT).show();
        ParlezVousTask pvt = new ParlezVousTask(this);
        pvt.execute();
    }

    public void viderListener(View view){
        usernameField.setText("");
        passwordField.setText("");
    }


    public String getUsername(){
        return usernameField.getText().toString();
    }

    public String getPassword(){
        return passwordField.getText().toString();
    }




    public void launchConnectedActivity(){
        Intent intent = new Intent(this, ConnectedActivity.class);
        intent.putExtra(USERNAME, getUsername());

        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USERNAME, getUsername());
        editor.putString(PWD, getPassword());
        editor.commit();

        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy !");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause !");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume !");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState !");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState !");
    }

}
