package com.example.cosda.glassmaps;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    private View mView;
    Handler hand = new Handler();
    double Longitude;
    double Latitude;
    private MapDisplay customCanvas;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    private View buildView() {
        View view = View.inflate(this, R.layout.main, null);
    //    customCanvas = (MapDisplay) findViewById(R.id.signature_canvas);
        hand.postDelayed(run, 1000);
        return view;
    }

    public String getLocation() {
        GPSTracker gps = new GPSTracker(this);
        String Location;
        Latitude = gps.getLatitude();
        Longitude = gps.getLongitude();
        Location = Latitude + ", " + Longitude;
        return Location;
    }

    Runnable run = new Runnable()
    {
        @Override
        public void run() {
            AsyncTaskRunner runner = new AsyncTaskRunner();
            runner.execute();
        }
    };

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 9; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }
        @Override
        protected void onPostExecute(String result) {
            //TextView txt = (TextView) findViewById(R.id.footer);
            Toast.makeText(getBaseContext(),getLocation(), Toast.LENGTH_LONG).show();
            //txt.setText(getLocation());
            Log.d("GlassGPS",getLocation());
            Log.d("update", "update");

            hand.postDelayed(run, 1000);
        }
    }

}