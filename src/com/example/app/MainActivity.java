package com.example.app;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textview;
	public fileload file = new fileload();
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      if(fileload.visit==0)
      {
        startActivity(new Intent(this,SActivity.class));
        fileload.visit=1;
      }
		 
		
      
        int response=file.readdata();
        if(response==0)
        {
        	 TextView textview=(TextView)findViewById(R.id.textView1);
      	   textview.setText(fileload.error);
      	 
        	
        }
        if(fileload.totalpage<1)
        {
        	Button b=(Button)findViewById(R.id.button2);
        	b.setEnabled(false);
        }
        
       
        	
       
        
       
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
  
   String uri;
   public void startcamera(View view)
   {
	   Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	   intent.setType("image/*");
		
	   startActivityForResult(intent,1);
	   
   }
   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
     if (resultCode == Activity.RESULT_OK && requestCode == 1) {
       Uri selectedImage= data.getData();
       String[] filePathColumn = { MediaStore.Images.Media.DATA };

		Cursor cursor = getContentResolver().query(selectedImage,
				filePathColumn, null, null, null);
		cursor.moveToFirst();

		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		String picturePath = cursor.getString(columnIndex);
		cursor.close();
		Intent passing=new Intent(this,SecondActivity.class);
       passing.putExtra("passedstring", picturePath);
       startActivity(passing);
       
      
     }
    
     
    
   }
   public void viewbook(View view)
   {
	   Intent i=new Intent(this,Page_Activity.class);
	   i.putExtra("pageno",1);
	   startActivity(i);
   }
   public void save(View view)
   {
	   fileload write=new fileload();
	   write.writdata();
	   
	   fileload.visit=0;
	   Intent intent = new Intent(Intent.ACTION_MAIN);
	   intent.addCategory(Intent.CATEGORY_HOME);
	   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	   finish();
	   startActivity(intent);
	   
	   
	  
	   
   }
   public void usecamera(View view)
   {
	   Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
	   startActivityForResult(intent, 0);
	   
   }


    
}
