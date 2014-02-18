package com.example.buzzer;


import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



public class MainActivity extends Activity {

	private Button forward, left, back, right; 
	private boolean isWriting = false;
	private static final String TAG = "SerialReader";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        Serial.initializeSerial();

        forward = (Button)findViewById(R.id.forward);
        left = (Button)findViewById(R.id.left);
        back = (Button)findViewById(R.id.back);
        right = (Button)findViewById(R.id.right);
        
        
        forward.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN && !isWriting){
					Serial.WriteSerial("LED1ON");
					isWriting = true;
					Log.d(TAG, "LED 1 on");
				}else if (isWriting && event.getAction()==MotionEvent.ACTION_UP){
					Serial.WriteSerial("LED1OFF");
					isWriting = false;
					Log.d(TAG, "LED 1 off");
				}
	                
	            return true;
			}
		});
        
        right.setOnTouchListener(new View.OnTouchListener() {
			
        	@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN && !isWriting){
					Serial.WriteSerial("LED2ON");
					isWriting = true;
					Log.d(TAG, "LED 2 on");
				}else if (isWriting && event.getAction()==MotionEvent.ACTION_UP){
					Serial.WriteSerial("LED2OFF");
					isWriting = false;
					Log.d(TAG, "LED 2 off");
				}
	                
	            return true;
			}
		});
        
        back.setOnTouchListener(new View.OnTouchListener() {
			
        	@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN && !isWriting){
					Serial.WriteSerial("LED3ON");
					isWriting = true;
					Log.d(TAG, "LED 3 on");
				}else if (isWriting && event.getAction()==MotionEvent.ACTION_UP){
					Serial.WriteSerial("LED3OFF");
					isWriting = false;
					Log.d(TAG, "LED 3 off");
				}
	                
	            return true;
			}
		});
        
        left.setOnTouchListener(new View.OnTouchListener() {
			
        	@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN && !isWriting){
					Serial.WriteSerial("LED4ON");
					isWriting = true;
					Log.d(TAG, "LED 4 on");
				}else if (isWriting && event.getAction()==MotionEvent.ACTION_UP){
					Serial.WriteSerial("LED4OFF");
					isWriting = false;
					Log.d(TAG, "LED 4 off");
				}
	                
	            return true;
			}
		});




    }

    @Override
    public void onDestroy(){
    	Serial.end();
        super.onDestroy();
    }


}