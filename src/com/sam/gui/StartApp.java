package com.sam.gui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class StartApp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startapp);

		
		// START BEING REGISTERED FOR LISTENER STARTS
		
		ImageButton start = (ImageButton) findViewById(R.id.start);
	    start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(StartApp.this,StartMain.class);
				startActivity(intent);
				
			}
		});
		
		
		
		
		
		
	 // START BEING REGISTERED FOR LISTENER ENDSSSSSSSSSSSSSSSSSS
		
		
		
		
		
		
		// Settings BEING REGISTERED FOR LISTENER STARTS
		
		ImageButton settings = (ImageButton) findViewById(R.id.settings);
		settings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Toast.makeText(getBaseContext(), "I am OnClickListener", Toast.LENGTH_SHORT).show();
				
				
				// code for settings
				
		//		final ComponentName toLaunch = new ComponentName("com.android.settings","com.android.settings.Settings");
			//	final Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
				//intent.addCategory(Intent.CATEGORY_LAUNCHER);
				//intent.setComponent(toLaunch);
				//intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				
				
				// code after editing for next activity
				
				Intent intent = new Intent(StartApp.this, Settings.class);
				startActivity(intent);
				
				
			}
		});
		
		
		
		// HELP BEING REGISTERED FOR LISTENER
		
		ImageButton help = (ImageButton) findViewById(R.id.help);
		help.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(StartApp.this, Help.class);
				startActivity(intent);
				
				}
		});
		
		
		// ABOUT BEING REGISTERED FOR LISTENER
		
		ImageButton about = (ImageButton) findViewById(R.id.about);
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(StartApp.this, About.class);
				startActivity(intent);
				
				
			}
		});
		
		
		
		
	}
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
