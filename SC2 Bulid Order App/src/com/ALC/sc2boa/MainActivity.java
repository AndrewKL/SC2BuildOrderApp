package com.ALC.sc2boa;

//import java.io.IOException;
//import java.util.List;

//import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
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
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	class BuildOrderGenerator {

	}

	public final static String EXTRA_MESSAGE = "com.alc.sc2boa.MESSAGE";
	public final static String EXTRA_RACE = "com.alc.sc2boa.RACE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        
        checkDatabase();
        
        return true;
    }
    
    
    private void checkDatabase() {
		BuildOrderDBManager dbmanager = new BuildOrderDBManager(this);
		//open dialog to dl more builds if there are none in the db
		if(dbmanager.getNumberOfBuilds()==0){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
			 
			// set title
			alertDialogBuilder.setTitle("New BuildOrder Database Available");
 
			// set dialog message
			alertDialogBuilder.setMessage("Would you like to download builds from the web?");
			alertDialogBuilder.setCancelable(false);
			alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						//load db if button pushed
						MainActivity.this.loadDataFromWeb(getCurrentFocus());
					}
				  });
			alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});
 
			// create and show alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		}
	}
		
		

    protected void loadDataFromWeb(View currentFocus) {
    	Log.d("ToolsActivity","loadDataFromWebButton: clicked");
		ProgressDialog mProgressDialog;

		// instantiate it within the onCreate method
		mProgressDialog = new ProgressDialog(MainActivity.this);
		mProgressDialog.setMessage("Downloading Builds");
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		//mProgressDialog.

		// execute this when the downloader must be fired
		DownloadXMLBuildFile downloadFile = new DownloadXMLBuildFile(mProgressDialog,MainActivity.this);
		downloadFile.execute(BuildOrderDBManager.ACLwebsiteurl);
		
	}
		
		
		
	

	/** Called when the user clicks the add build button */
    public void addBuild(View view) {
    	Intent intent = new Intent(this, AddBuildOrderActivity.class);
        startActivity(intent);
    }
    
    public void displayTools(View view) {
    	Intent intent = new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the list all builds button */
    public void listAllBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "all");
        startActivity(intent);
    }
    
    /** Called when the user clicks the list zerg builds button */
    public void listZergBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "zerg");
        startActivity(intent);
    }
    
    /** Called when the user clicks the list terran builds button */
    public void listTerranBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "terran");
        startActivity(intent);
    }
    /** Called when the user clicks the list protoss builds button */
    public void listProtossBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "protoss");
        startActivity(intent);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    	//BuildOrderDBManager boc;
        switch (item.getItemId()) {
            /*case R.id.menu_settings:
                Log.d("MainActivity","menuselect: settings");
                return true;
            case R.id.Menu_debugDB:
            	Log.d("MainActivity","menuselect: DebugDB");
            	boc = new BuildOrderDBManager(this);
            	Utils.PrintBuildOrderDB(boc);
            	return true;
            case R.id.Menu_adddefaultdata:
            	Log.d("MainActivity","menuselect: Add Default Data");
            	boc = new BuildOrderDBManager(this);
            	boc.addDefaultData();
            	return true;
            case R.id.Menu_addinitaldata:
            	Log.d("MainActivity","menuselect: Add Initial Data");
            	BuildOrderDBManager.loadInitialBuilds(this);
            	Log.d("MainActivity","menuselect: Add Initial Data finished");
            	
				return true;
            case R.id.Menu_deletedb:
            	Log.d("MainActivity","menuselect: Delete Database");
            	boc = new BuildOrderDBManager(this);
            	boc.deleteAllBuildOrders();
				return true;*/
				
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
