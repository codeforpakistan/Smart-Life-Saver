package com.sam.gui;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class SMS extends Activity {

	 Button btnSendSMS;
	 EditText txtPhoneNo;
	 EditText txtMessage;
	 
	 String lati;
	 String longi;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_activity);
		
		
		lati = getIntent().getExtras().getString("lati");
		longi = getIntent().getExtras().getString("longi");
		
		
		// btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
	      //  txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
	        //txtMessage = (EditText) findViewById(R.id.txtMessage);
	 
	       // btnSendSMS.setOnClickListener(new View.OnClickListener() 
	        //{
	           // public void onClick(View v) 
	         //   {                
	               // String phoneNo = txtPhoneNo.getText().toString();
	                //String message = txtMessage.getText().toString();                 
	                //if (phoneNo.length()>0 && message.length()>0)
		// Universal Fone Number...EditText name is foneNo.
		   // LayoutInflater factory = getLayoutInflater();
		    //View fon = factory.inflate(R.layout.phonenumber, null);
		    //EditText fone = (EditText) fon.findViewById(R.id.foneNo);
		    
			 
	                    sendSMS(PhoneNumber.no, "EMERGENCY::" +
	                    		"REACH HERE ASAP::" +
	                    		"https://maps.google.com/?q="+lati+","+longi+"");                
	                    
	                //else
	                 //   Toast.makeText(getBaseContext(), 
	                     //   "Please enter both phone number and message.", 
	                   //     Toast.LENGTH_SHORT).show();
	           // }
	       // });        
		
	        
	        
		
		
		
		
	}
	
	
	
	
	
	private void sendSMS(String phoneNumber, String message)
    {        
		Intent intent = new Intent(this,Msg_sent.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0,
        intent.putExtra("sent", "The Message has been Sent!"), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);  
       
    }  
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		// Commented the below line when integrated SMS and Accelerometer modules 
		
	//	getMenuInflater().inflate(R.menu.sm, menu);
		return true;
	}

}
