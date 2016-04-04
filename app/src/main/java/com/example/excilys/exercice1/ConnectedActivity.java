package com.example.excilys.exercice1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by excilys on 04/04/16.
 */
public class ConnectedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);

        TextView textView = (TextView) findViewById(R.id.textView_username);

        String username = getIntent().getStringExtra("username");
        textView.setText( username + " ! ");
    }

}
