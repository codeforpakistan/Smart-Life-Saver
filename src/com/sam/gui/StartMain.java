package com.sam.gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StartMain extends Activity implements SensorEventListener,LocationListener {
	
	
   //GPRS TextViews
	TextView latii;
	TextView longii;
	//ENds
	
	
	private float mLastX, mLastY, mLastZ;
	private boolean mInitialized;
	private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private final float NOISE = (float) 1.0;
    
    float X;
    float Y;
    float Z;
  
    
	     
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_main);
        mInitialized = false;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        
        
        // Adding the Gprs code here => INTEGRATING SMS+ACCL+GPRS
        
        
        latii = (TextView) findViewById(R.id.lati);
		longii = (TextView) findViewById(R.id.longi);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Location loc = new Location(LOCATION_SERVICE);
		
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, this);
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,0, this);
		double lati = loc.getLatitude();
        double longi = loc.getLongitude();
        latii.setText(Double.toString(lati));
        longii.setText(Double.toString(longi));
	
        
        // INTEGRATION ENDSSSSSSSSS
        
        
        
        
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		
		
		
		// TextViews for x , y and z axis to display current values
		TextView tvX= (TextView)findViewById(R.id.x_axis);
		TextView tvY= (TextView)findViewById(R.id.y_axis);
		TextView tvZ= (TextView)findViewById(R.id.z_axis);
		
		// TextViews for x , y and z axis to display previous values
		//TextView mTvX = (TextView) findViewById(R.id.mTvX);
		//TextView mTvY = (TextView) findViewById(R.id.mTvY);
		//TextView mTvZ = (TextView) findViewById(R.id.mTvZ);
		
		ImageView iv = (ImageView)findViewById(R.id.image);
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		if (!mInitialized) {
			mLastX = x;
			mLastY = y;
			mLastZ = z;
			tvX.setText("0.0");
			tvY.setText("0.0");
			tvZ.setText("0.0");
			mInitialized = true;
		} else {
			float deltaX = Math.abs(mLastX - x);
			float deltaY = Math.abs(mLastY - y);
			float deltaZ = Math.abs(mLastZ - z);
			
			X = deltaX;
			Y = deltaY;
			Z = deltaZ;
			
			
			if (deltaX < NOISE) deltaX = (float)0.0;
			if (deltaY < NOISE) deltaY = (float)0.0;
			if (deltaZ < NOISE) deltaZ = (float)0.0;
			mLastX = x;
			mLastY = y;
			mLastZ = z;
			
			tvX.setText(Float.toString(deltaX));
			tvY.setText(Float.toString(deltaY));
			tvZ.setText(Float.toString(deltaZ));
			
			
			
	
			
		
			
			
			iv.setVisibility(View.VISIBLE);
			if (deltaX > deltaY) {
				iv.setImageResource(R.drawable.horizontal);
			} else if (deltaY > deltaX) {
				iv.setImageResource(R.drawable.vertical);
			} else {
				iv.setVisibility(View.INVISIBLE);
			}
			
			// Send SMS just for testing ............................. Apply algo here
			
			double g = 9.81;
			double gMagnitude = 4;
			
			float gx = deltaX;
			float gy = deltaY;
			float gz = deltaZ;
			
			double accl = Math.sqrt(gx*gx + gy*gy + gz*gz);
			
			
			if ( accl > gMagnitude*g )
			{
				Intent intent = new Intent(StartMain.this, SMS.class);
				intent.putExtra("lati", latii.getText());
				intent.putExtra("longi", longii.getText());
				startActivity(intent);
				//mSensorManager.unregisterListener(this);
			}
			
		}
	}
	
	
	// Override methods for GPRS ......StartsssSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
		 double lati = location.getLatitude();
         double longi = location.getLongitude();
         latii.setText(Double.toString(lati));
         longii.setText(Double.toString(longi));
		
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	
	// Override methods for GPRS ......ENDSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs
	
	
}