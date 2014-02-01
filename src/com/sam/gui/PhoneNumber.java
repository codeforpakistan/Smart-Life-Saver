package com.sam.gui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneNumber extends Activity {

	
	public static String no;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phonenumber);
		
		final EditText fone = (EditText) findViewById(R.id.foneNo);	
		Button save = (Button) findViewById(R.id.save);
		
		
		LoadPreferences();
		no = fone.getText().toString(); 
		TextView vi = (TextView) findViewById(R.id.textView1);
		vi.setText(fone.getText().toString());
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				SavePreferences("foneNo", fone.getText().toString());
				LoadPreferences();
				
				
			}
		});
		
		}
	
	
	 private void SavePreferences(String key,String value)
	  {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor ed = sp.edit();
		ed.putString(key,value);
		ed.commit();
		
		}
	
	
	
	
	private void LoadPreferences(){
	    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
	    String str = sp.getString("foneNo", "");
	    EditText fone = (EditText) findViewById(R.id.foneNo);
		fone.setText(str);
	    
	   }
	
	
}
