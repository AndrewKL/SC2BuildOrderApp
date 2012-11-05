package com.ALC.sc2boa;

import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

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
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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
    	
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Log.d("MainActivity","menuselect: settings");
                return true;
            case R.id.Menu_debugDB:
            	Log.d("MainActivity","menuselect: DebugDB");
            	BuildOrderCollection boc = new BuildOrderCollection(this);
            	Utils.PrintBuildOrderDB(boc);
            	return true;
            case R.id.Menu_adddefaultdata:
            	Log.d("MainActivity","menuselect: Add Default Data");
            	BuildOrderCollection boc2 = new BuildOrderCollection(this);
            	boc2.addDefaultData();
            	return true;
            case R.id.Menu_addinitaldata:
            	Log.d("MainActivity","menuselect: Add Initial Data");
				try {
					XMLBuildOrderReader bor = new XMLBuildOrderReader(this.getAssets());
					BuildOrderCollection bocollection = new BuildOrderCollection(this);
					bocollection.addBuildOrderList(bor.GetBuildOrders());
				} catch (XmlPullParserException e) {
					Log.d("MainActivity: ","xml pull parser error");
					e.printStackTrace();
				} catch (IOException e) {
					Log.d("MainActivity: ","missing file");
					e.printStackTrace();
				}
            	return true;
            	
            
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
