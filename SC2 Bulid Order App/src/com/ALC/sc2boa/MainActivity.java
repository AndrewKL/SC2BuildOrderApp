package com.ALC.sc2boa;

//import java.io.IOException;
//import java.util.List;

//import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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
        return true;
    }
    
    
    /** Called when the user clicks the add build button */
    public void addBuild(View view) {
    	Intent intent = new Intent(this, AddBuildOrderActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
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
    	BuildOrderCollection boc;
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Log.d("MainActivity","menuselect: settings");
                return true;
            case R.id.Menu_debugDB:
            	Log.d("MainActivity","menuselect: DebugDB");
            	boc = new BuildOrderCollection(this);
            	Utils.PrintBuildOrderDB(boc);
            	return true;
            case R.id.Menu_adddefaultdata:
            	Log.d("MainActivity","menuselect: Add Default Data");
            	boc = new BuildOrderCollection(this);
            	boc.addDefaultData();
            	return true;
            case R.id.Menu_addinitaldata:
            	Log.d("MainActivity","menuselect: Add Initial Data");
            	boc = new BuildOrderCollection(this);
            	boc.loadInitialBuildOrdersFromXML(this.getAssets());
				return true;
            case R.id.Menu_deletedb:
            	Log.d("MainActivity","menuselect: Delete Database");
            	boc = new BuildOrderCollection(this);
            	boc.deleteAllBuildOrders();
				return true;
				
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
