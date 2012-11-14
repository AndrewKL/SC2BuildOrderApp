package com.ALC.sc2boa.ui;


import com.ALC.sc2boa.MainActivity;
import com.ALC.sc2boa.R;
import com.ALC.sc2boa.R.array;
import com.ALC.sc2boa.R.id;
import com.ALC.sc2boa.R.layout;
import com.ALC.sc2boa.R.menu;
import com.ALC.sc2boa.buildordertools.BuildOrder;
import com.ALC.sc2boa.buildordertools.BuildOrderDBManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;


public class AddBuildOrderActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_build_order);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        
        //set up race selection spinner
        Spinner spinner = (Spinner) findViewById(R.id.racespinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.races_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_build_order, menu);
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
    
    /** Called when the user clicks the add build order button
     *  adds the build order and then returns
     *  
     *  */
    public void addBuildOrder(View view) {
    	//Log.d("AddBuildOrderActivity: ", "addBuildOrder: start");
    	BuildOrder bo = new BuildOrder();
    	EditText editText = (EditText) findViewById(R.id.BuildOrderNameTextField);
        bo.setBuildName(editText.getText().toString());
        
        editText = (EditText) findViewById(R.id.BuildOrderInstructionsTextArea);
        bo.setBuildOrderInstructions(editText.getText().toString());
        
        Spinner mySpinner = (Spinner)findViewById(R.id.racespinner);
        String race = mySpinner.getSelectedItem().toString();
        race = race.toLowerCase();//comes in with an uppercase first letter
        //Log.d("AddBuildOrderActivity: ", "addBuildOrder: racespinner v2: "+race);
        bo.setRace(race);
        
        
        
        Log.d("AddBuildOrderActivity: ", "Inserting... "+bo.toString());
        BuildOrderDBManager BOC = new BuildOrderDBManager(this);
        BOC.addBuildOrder(bo);
        
        
        
    	Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    
    

}
