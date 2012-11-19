package com.ALC.sc2boav2;

import java.io.IOException;
import java.util.ArrayList;

import com.appspot.api.services.onlinebuildorderendpoint.Onlinebuildorderendpoint;
import com.appspot.api.services.onlinebuildorderendpoint.Onlinebuildorderendpoint.Builder;
import com.appspot.api.services.onlinebuildorderendpoint.Onlinebuildorderendpoint.InsertOnlineBuildOrder;
import com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


public class UploadAllBuildsToGAE extends AsyncTask<Object, Object, Object> {
	ProgressDialog dialog;
	BuildOrderDBManager localBOs;
	
	
	//starts the download
	public static void uploadAllBuilds(Context context){
    	Log.d("downloadallbuildsfromGAE: ","instantiate");
    	ProgressDialog mDialog = new ProgressDialog(context);
        mDialog.setMessage("Please wait...");
        mDialog.setCancelable(false);
        mDialog.show();
        new UploadAllBuildsToGAE(mDialog, context).execute();
        
    }
	
	public UploadAllBuildsToGAE(ProgressDialog mDialog,Context context) {
		localBOs = new BuildOrderDBManager(context);
		dialog=mDialog;
	}
	
	
	

	
	@Override
	protected Object doInBackground(Object... arg0) {
		Log.d("UploadAllBuildsToGAE","doinbackground");
		Builder endpointBuilder = new Onlinebuildorderendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }});
		
		Onlinebuildorderendpoint endpoint = CloudEndpointUtils.updateBuilder(endpointBuilder).build();
		Log.d("uploading BO ","endpointBuilder built");
		ArrayList<BuildOrder> list = localBOs.GetAllBuildOrders();
		for(int i=0;i<list.size();i++){
			BuildOrder bo = list.get(i);
			try {
				//Log.d("uploading BO ","trying to insert a BO"+bo.toString());
				OnlineBuildOrder obo = bo.getOnlineBuildOrder();
				Log.d("uploading oBO ","obo name: "+obo.getBuildName());
				
				InsertOnlineBuildOrder results = endpoint.insertOnlineBuildOrder(obo);
				results.execute();
				Log.d("uploading BO ","inserted BO : "+results.getLastStatusCode()+"  "+results.getLastStatusMessage());
			} catch (IOException e) {
				Log.d("uploading BO shit happened",e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		Log.d("uploading BO ","do in background finished");
		dialog.dismiss();
		return null;
	}
	



}
