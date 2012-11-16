package com.ALC.sc2boav2;

import java.io.IOException;

//import com.appspot.api.services.buildorderendpoint.*;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
/*
public class downloadAllBuildOrdersFromGAE extends AsyncTask<Object, Object, Object> {
	ProgressDialog dialog;
	BuildOrderDBManager localBOs;
	
	
	//starts the download
	public static void downloadAllBuilds(String ammount,Context context){
    	Log.d("downloadallbuildsfromGAE: ","instantiate");
    	ProgressDialog mDialog = new ProgressDialog(context);
        mDialog.setMessage("Please wait...");
        mDialog.setCancelable(false);
        mDialog.show();
        new downloadAllBuildOrdersFromGAE(mDialog, context).execute();
        
        
    }
	
	public downloadAllBuildOrdersFromGAE(ProgressDialog mDialog,Context context) {
		localBOs = new BuildOrderDBManager(context);
		dialog=mDialog;
	}
	
	
	BuildOrderCollection list;

	
	@Override
	protected Object doInBackground(Object... arg0) {
		
		Builder endpointBuilder = new Buildorderendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }});
		
		Buildorderendpoint endpoint = CloudEndpointUtils.updateBuilder(endpointBuilder).build();
		list = null;
		try {
			list  = endpoint.listBuildOrder().execute();
		} catch (IOException e) {
				//Handle exception
		}
		
		return null;
	}
	protected void onPostExecute(Long result) {
		Log.d("downloadAllBuilds: ","onPostExecute :");
		dialog.dismiss();
        
    }

}*/
