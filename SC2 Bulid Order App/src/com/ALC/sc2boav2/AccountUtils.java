package com.ALC.sc2boav2;

import java.io.IOException;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class AccountUtils {
	public static final String scope = "www.google.com";//TODO what should I put here?
	public static String token;
	
	public static String[] getAccountNames(Context context) {
		Log.d("AccountUtils: ","getAccountNames");
	    AccountManager accountManager = AccountManager.get(context);
	    Account[] accounts = accountManager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
	    String[] names = new String[accounts.length];
	    for (int i = 0; i < names.length; i++) {
	        names[i] = accounts[i].name;
	    }
	    return names;
	}
	
	public static void setToken(Context context,String email,String scope){
		Log.d("setToken: ", "googleplayservices status: "+GooglePlayServicesUtil.isGooglePlayServicesAvailable(context));
		
		Log.d("AccountUtils: ","setToken");
		//do not call on ui thread
		GetTokenAsyncTask gettoken = new GetTokenAsyncTask(context,scope,email);
		gettoken.execute();
	}
	private static class GetTokenAsyncTask extends AsyncTask<Object, Object, Object>{
		Context context;
		String scope;
		String email;
		ProgressDialog mDialog;
		
		public GetTokenAsyncTask(Context contextin,String scopein,String emailin){
			this.context=contextin;
			this.scope=scopein;
			this.email=emailin;
			mDialog = new ProgressDialog(context);
	        mDialog.setMessage("Getting Google Auth Token...");
	        mDialog.setCancelable(false);
	        mDialog.show();
	        Log.d("AccountUtils: ","setToken: finished dialog");
		}

		@Override
		protected Object doInBackground(Object... arg0) {
			Log.d("AccountUtils: ","setToken: do in background");
			
	        
	        try {
				token = GoogleAuthUtil.getToken(context, email, scope);
			} catch (IOException e) {
				Log.d("AccountUtils: ","setToken: do in background: IOEXception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GoogleAuthException e) {
				Log.d("AccountUtils: ","setToken: do in background: GoogleAuthEXception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        mDialog.dismiss();
	        Log.d("AccountUtils: ","setToken: do in background: finished");
			return null;
		}
		
	}
	

}
