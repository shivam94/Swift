package com.example.app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;





 public class fileload extends Activity {
	
	 private String filename= "content.txt";
	public static int totalpage=0;
	public static imagedata[] data=new imagedata[1000];
	static public String error;
	static public int visit=0;
	
	public int  readdata()
	{
		BufferedReader read;
		int i=1;
		String url;
		String name;
		String description;
		int page;
		
		try
		{
		InputStream stream=openFileInput(filename);
		InputStreamReader file=new InputStreamReader(stream);
		read=new BufferedReader(file);
		totalpage=Integer.parseInt(read.readLine());
		for(i=1;i<=totalpage;i++)
		{
			page=Integer.parseInt(read.readLine());
			name=read.readLine();
			
			url=read.readLine();
			description=read.readLine();
			fileload.data[i]=new imagedata(name,description,url,page);
		}
		read.close();
		}
		catch (Exception e)
		{
			error=e.getMessage();
			return 0;
		}
		return 1;
		
		
	}
	public void writdata() 
	{
		int i=1;
		
		
		try
		{ 
	      FileOutputStream write=openFileOutput(filename,Context.MODE_PRIVATE);
		  
		  write.write(totalpage);
		  for(i=1;i<=totalpage;i++)
		  {
			  write.write(fileload.data[i].page);
			  write.write((fileload.data[i].name).getBytes());
			  write.write(fileload.data[i].url.getBytes());
			  write.write(fileload.data[i].description.getBytes());
			 
			 
			  
		  }
		  write.close();
		}
		catch (Exception e)
		{
			error=e.getMessage();
		}
		
	}
	
	

}
