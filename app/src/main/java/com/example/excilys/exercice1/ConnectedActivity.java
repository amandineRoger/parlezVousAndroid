package com.example.excilys.exercice1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_deco, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_deco:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setPositiveButton("Déconnexion", listener);
                alertDialogBuilder.setNegativeButton("Annuler", listener);
                alertDialogBuilder.setMessage("Attention, vous allez être déconnecté ! Continuer ?");

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }


    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }
    };

}
