package com.ALC.sc2boa;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class ToolsActivity extends Activity {
	
	
	
	public void deleteDatabase(View view) {
		Log.d("ToolsActivity","Delete Database");
		
		
    	BuildOrderDBManager boc = new BuildOrderDBManager(this);
    	boc.deleteAllBuildOrders();
    	
    }
	
	public void addBuildOrder(View view) {
		Intent intent = new Intent(this, AddBuildOrderActivity.class);
        startActivity(intent);
    }
	public void addInitialData(View view) {
		Log.d("ToolsActivity","Add Initial Data");
    	BuildOrderDBManager boc = new BuildOrderDBManager(this);
    	boc.loadInitialBuildOrdersFromXML(this.getAssets());
		
    }
	public void loadDataFromWeb(View view) {
		Log.d("ToolsActivity","Add Initial Data");
		
    }
	public void displayDatabaseInformation(View view) {
		Log.d("ToolsActivity","Add Initial Data");
		
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        final Context context = this;
        
        
        
        //DeleteDatabaseButton
        //==============================================================
        Button button = (Button) findViewById(R.id.DeleteDBButton);
		button.setOnClickListener(new OnClickListener() {
 
		public void onClick(View arg0) {
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
 
			// set title
			alertDialogBuilder.setTitle("Delete Database");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Click yes to delete the database.")
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						//delete db if button pushed
						ToolsActivity.this.deleteDatabase(getCurrentFocus());
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
				
				
			}
		});
		
		//download builds from internet
		//=============================================================================
		// declare the dialog as a member field of your activity
		Button dlbuildsbutton = (Button) findViewById(R.id.LoadDataFromWebButton);
		dlbuildsbutton.setOnClickListener(new OnClickListener() {
			 
			public void onClick(View arg0) {
				Log.d("ToolsActivity","loadDataFromWebButton: clicked");
				ProgressDialog mProgressDialog;

				// instantiate it within the onCreate method
				mProgressDialog = new ProgressDialog(context);
				mProgressDialog.setMessage("Downloading Builds");
				mProgressDialog.setIndeterminate(false);
				mProgressDialog.setMax(100);
				mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				//mProgressDialog.

				// execute this when the downloader must be fired
				DownloadXMLBuildFile downloadFile = new DownloadXMLBuildFile(mProgressDialog,ToolsActivity.this);
				downloadFile.execute(BuildOrderDBManager.ACLwebsiteurl);
			}
		});
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tools, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
