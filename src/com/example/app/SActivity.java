package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s);
		  Thread thread = new Thread() {
			    @Override
			    public void run() {
			        try {
			        	
			        	
			        	
			        	Thread.sleep(2000);
			        	
			        } catch (InterruptedException e) {
			        }finally
			        {
			        	finish();
			        }

			        runOnUiThread(new Runnable() {
			            @Override
			            public void run() {
			            	
			            	startActivity(new Intent(getBaseContext(),MainActivity.class));
			            }
			        });
			    }
			};
			 thread.start();
	}
	

	
}
