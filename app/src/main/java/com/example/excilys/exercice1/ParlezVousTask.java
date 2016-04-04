package com.example.excilys.exercice1;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by excilys on 04/04/16.
 */
public class ParlezVousTask extends AsyncTask {
    Activity activity;

    public ParlezVousTask (Activity activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        MainActivity mainActivity = (MainActivity) activity;

        ProgressBar progressBar = (ProgressBar) mainActivity.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        Log.d("PVT", "launch Intent !");
       mainActivity.launchConnectedActivity();
        Log.d("PVT", "Intent launched !");
    }

    @Override
    protected Object doInBackground(Object[] params) {
        MainActivity mainActivity = (MainActivity) activity;
        String user = mainActivity.getUsername();
        String pwd = mainActivity.getPassword();


        try{
            URL url = new URL("http://www.google.com/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                InputStreamToString inputStreamToString = new InputStreamToString();
                String inputString = inputStreamToString.convert(in);
                Log.d("PVT_result", inputString);

            }
            catch (Exception e){
                Log.e("ERROR_PVT", e.getMessage());
            }
            finally {
                urlConnection.disconnect();
            }

        } catch (Exception e) {
            Log.e("ERROR_PVT_2", e.getMessage());
        }

        return null;
    }

    public class InputStreamToString {

        public  String convert(InputStream is) {
            String line = "";
            StringBuilder builder = new StringBuilder();

            BufferedReader rd=new BufferedReader(new InputStreamReader(is));

            try {
                while ((line = rd.readLine()) != null) {
                    builder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return builder.toString();
        }
    }

}

