package com.ALC.sc2boav2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.appspot.api.services.buildorderendpoint.*;

import com.appspot.api.services.onlinebuildorderendpoint.Onlinebuildorderendpoint;
import com.appspot.api.services.onlinebuildorderendpoint.Onlinebuildorderendpoint.Builder;
import com.appspot.api.services.onlinebuildorderendpoint.Onlinebuildorderendpoint.InsertOnlineBuildOrder;
import com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder;
import com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrderCollection;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class downloadAllBuildOrdersFromGAE extends AsyncTask<Object, Object, Object> {
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
	
	public downloadAllBuildOrdersFromGAE(ProgressDialog mDialog,Context context) {
		localBOs = new BuildOrderDBManager(context);
		dialog=mDialog;
	}
	
	
	

	
	@Override
	protected Object doInBackground(Object... arg0) {
		Log.d("downloadAllBuildsFromGAE","doinbackground");
		Builder endpointBuilder = new Onlinebuildorderendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }});
		
		Onlinebuildorderendpoint endpoint = CloudEndpointUtils.updateBuilder(endpointBuilder).build();
		Log.d("uploading BO ","endpointBuilder built");
		
		List<OnlineBuildOrder> collection = new ArrayList();
		try {
			;
			collection = endpoint.listOnlineBuildOrder().execute().getItems();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i<collection.size();i++){
			localBOs.addBuildOrder(BuildOrder.convertOnlineBuildOrderToBuildOrder(collection.get(i)));
		}
		
		
		
		
		
		
		/*for(int i=0;i<list.size();i++){
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
		}*/
		Log.d("uploading BO ","do in background finished");
		dialog.dismiss();
		return null;
	}
	
}
