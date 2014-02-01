package com.sam.gui;

import java.security.Provider;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Settings extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		// Listener for WiFi Settings
		
		Button wifi = (Button) findViewById(R.id.wifiSettings);
		wifi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ComponentName toLunch = new ComponentName("com.android.settings","com.android.settings.wifi.WifiSettings");
				Intent intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
				startActivity(intent);
				
				
			}
		});
		
		

		
		// Listener for Location Settings
		
		Button location = (Button) findViewById(R.id.locationSettings);
		location.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ComponentName toLunch = new ComponentName("com.android.settings","com.android.settings.LocationSettings");
				Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivity(intent);
				
			}
		});
		
		
		
		// Listener for data roaming
		
		Button dataRoam = (Button) findViewById(R.id.dataRoaming);
		dataRoam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ComponentName toLaunch = new ComponentName("com.android.phone","com.android.phone.Settings");
				Intent intent = new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
				intent.setComponent(toLaunch);
				startActivity(intent);
				
				
			}
		});
		
		
		
		//Listener for Prompting user to enter his her cell number
		
		Button mobNet = (Button) findViewById(R.id.mobileNetwork);
		mobNet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(Settings.this,PhoneNumber.class);
				startActivity(intent);
				
				
				//ComponentName toLaunch = new ComponentName("com.android.phone","com.android.phone.Settings");
				//Intent intent = new Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
				//intent.setComponent(toLaunch);
				//startActivity(intent);
				
				
			}
		});
		
		
		
		
	}
	
	

}

