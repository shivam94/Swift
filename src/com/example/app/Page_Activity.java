package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Page_Activity extends Activity {

	 public int index=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_);
		Intent in=getIntent();
		try
		{index=in.getIntExtra("pageno",1);
		String imageuri=fileload.data[index].url;
		String name=fileload.data[index].name;
		String description=fileload.data[index].description;
		ImageView imageview=(ImageView)findViewById(R.id.imageView1);
		Bitmap bitmap;
		BitmapFactory.Options option = new BitmapFactory.Options();
		option.inJustDecodeBounds=false;
		option.inSampleSize=2;
		bitmap=BitmapFactory.decodeFile(imageuri, option);
		imageview.setImageBitmap(bitmap);
		TextView textview=(TextView)findViewById(R.id.textView1);
		textview.setText(description);
		if(index>=fileload.totalpage)
		{
			Button b=(Button)findViewById(R.id.button1);
			b.setEnabled(false);
		}
		
		}
		catch (Exception e)
		{
			TextView textview=(TextView)findViewById(R.id.textView1);
			textview.setText(e.getMessage());
		}
		
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.page_, menu);
		return true;
	}*/
	public void nextpage(View view)
	{
		Intent intent=new Intent(this,Page_Activity.class);
		index=index+1;
		intent.putExtra("pageno",index);
		startActivity(intent);
	}
	

}
