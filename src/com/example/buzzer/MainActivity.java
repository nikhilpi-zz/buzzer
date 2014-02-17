package com.example.buzzer;


import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.view.MotionEvent;
import android.view.View;



public class MainActivity extends Activity {

	private Button forward, left, back, right; 

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
				if (event.getAction()==MotionEvent.ACTION_DOWN){
					Serial.WriteSerial("LED1ON");
				}else{
					Serial.WriteSerial("LED1OFF");
				}
	                
	            return true;
			}
		});
        
        right.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN){
					Serial.WriteSerial("LED2ON");
				}else{
					Serial.WriteSerial("LED2OFF");
				}
	                
	            return true;
			}
		});
        
        back.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN){
					Serial.WriteSerial("LED3ON");
				}else{
					Serial.WriteSerial("LED3OFF");
				}
	                
	            return true;
			}
		});
        
        left.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN){
					Serial.WriteSerial("LED4ON");
				}else{
					Serial.WriteSerial("LED4OFF");
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