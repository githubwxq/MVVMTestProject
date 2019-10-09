package com.example.mvvmtestproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifecycleActivity extends AppCompatActivity {

    Button btn;
    private static final int REQUEST_LOCATION_PERMISSION_CODE = 1;

    private LocationListener mGpsListener = new MyLocationListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LifecycleActivity.this,"sdfadfafaf",Toast.LENGTH_SHORT).show();
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_LOCATION_PERMISSION_CODE);
        } else {
            bindLocationListener();
        }

    }

    private void bindLocationListener() {
        new BoundLocationListener().bindLocationListenerIn(this, mGpsListener, getApplicationContext());
    }

    private class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            Log.e("wxq","onLocationChanged");
              btn.setText("location"+location.getLatitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.e("wxq","onStatusChanged");
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.e("wxq","onProviderEnabled");
            Toast.makeText(LifecycleActivity.this,"onProviderEnabled",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.e("wxq","onProviderDisabled");
        }
    }
}
