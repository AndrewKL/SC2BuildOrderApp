package com.ALC.sc2boa.buildordertools;

import java.io.IOException;

import com.ALC.sc2boa.CloudEndpointUtils;
import com.ALC.sc2boaserver.*;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.os.AsyncTask;

public class downloadBuildOrderFromGAE extends AsyncTask {
	

	@Override
	protected Object doInBackground(Object... arg0) {
		
		Builder endpointBuilder = new BuildOrderEndpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
				public void initialize(HttpRequest httpRequest) { }
				});
				           
				           BuildOrderEndpoint endpoint = CloudEndpointUtils.updateBuilder(endpointBuilder).build();
				            try {
				BuildOrder result = endpoint.insertNote(note).execute();
				           } catch (IOException e) {
				//Handle exception
				}
		// TODO Auto-generated method stub
		return null;
	}

}
