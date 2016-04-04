package com.example.excilys.exercice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate !");

    }

    public void sendListener (View view){
        Toast.makeText(this, "Toast !", Toast.LENGTH_SHORT).show();
        ParlezVousTask pvt = new ParlezVousTask(this);
        pvt.execute();
    }

    public void viderListener(View view){
        usernameField = (EditText) findViewById(R.id.username);
        usernameField.setText("");
        passwordField = (EditText) findViewById(R.id.password);
        passwordField.setText("");
    }


    public String getUsername(){
        return usernameField.getText().toString();
    }

    public String getPassword(){
        return passwordField.getText().toString();
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
