package com.ALC.sc2boa.buildordertools;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
//based on code by cristian from stackexchange
//slightly modified
//usually, subclasses of AsyncTask are declared inside the activity class.
//that way, you can easily modify the UI thread from here
public class DownloadXMLBuildFile extends AsyncTask<String, Integer, String> {
	ProgressDialog mProgressDialog;
	Context context;
	public DownloadXMLBuildFile(ProgressDialog pd,Context cont){
		super();
		mProgressDialog = pd;
		context = cont;
	}
	
	
	@Override
	protected String doInBackground(String... sUrl) {
		String filename = null;
	    try {
	    	 Log.d("DownloadFile","doInBackGround");
	    	 filename = Environment.getExternalStorageDirectory().getPath()+"/"+"downloadedbuildorders.xml";
	         URL url = new URL(sUrl[0]);
	         URLConnection connection = url.openConnection();
	         connection.connect();
	         Log.d("DownloadFile","doInBackGround got url");
	         // this will be useful so that you can show a typical 0-100% progress bar
	         int fileLength = connection.getContentLength();
	         Log.d("DownloadFile","doInBackGround filelength:"+fileLength);

	         // download the file
	         InputStream input = new BufferedInputStream(url.openStream());
	         OutputStream output = new FileOutputStream(filename);

	         byte data[] = new byte[1024];
	         long total = 0;
	         int count;
	         while ((count = input.read(data)) != -1) {
	        	 
	             total += count;
	             //mProgressDialog.setMessage("downloaded: "+total);
	             // publishing the progress....
	             //Log.d("DownloadFile","doInBackGround file%: "+(total * 100 / fileLength));
	             publishProgress((int) (total * 100 / fileLength));
	             output.write(data, 0, count);
	         }
	         publishProgress(100);
	         Log.d("DownloadFile","doInBackGround got file");
	         output.flush();
	         output.close();
	         input.close();
	         BuildOrderDBManager bodb = new BuildOrderDBManager(context);
	         bodb.loadBuildsXMLFile(filename);
	         
	         
	     } catch (Exception e) {
	    	 Log.d("DownloadFile: ","ERROR "+e.getMessage());
	     }
	    
	     return filename;
	}
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        mProgressDialog.setProgress(progress[0]);
    }
    
    protected void onPostExecute(String result) {
    	
		Toast toast = Toast.makeText(context,  "Database Downloaded", Toast.LENGTH_SHORT);
		toast.show();
		//TODO			//fix string
        mProgressDialog.dismiss();
    }
	

 
 
}