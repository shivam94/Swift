package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends Activity {
	String imageuri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		 imageuri = intent.getStringExtra("passedstring");
		 ImageView imageview=(ImageView)findViewById(R.id.imageView1);
		 Loadimage(imageview);

	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}*/
	private void Loadimage(ImageView imageview)
	{
		Bitmap bitmap;
		BitmapFactory.Options option = new BitmapFactory.Options();
		option.inJustDecodeBounds=false;
		option.inSampleSize=2;
		bitmap=BitmapFactory.decodeFile(imageuri, option);
		imageview.setImageBitmap(bitmap);
		
		
	}
	public void add(View view)
	{
		
		
		EditText edittext=(EditText)findViewById(R.id.editText1);
	    String description=edittext.getText().toString();
	    
		fileload.totalpage=fileload.totalpage+1;
		int index=fileload.totalpage;
		imagedata item=new imagedata("picture",description,imageuri,index);
		fileload.data[index]=item;
		
		Intent intent=new Intent(this,MainActivity.class);
		
		startActivity(intent);
	}

}
