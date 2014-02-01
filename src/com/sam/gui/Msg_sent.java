package com.sam.gui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Msg_sent extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sent);
		TextView tv = (TextView) findViewById(R.id.TextView1);
		tv.setText( getIntent().getExtras().getString("sent") );
		
		// Intent for calling after message has been sent
		
		
		
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:"+PhoneNumber.no));
		startActivity(callIntent);
		
		
		
	}

}
