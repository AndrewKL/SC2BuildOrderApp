package com.ALC.sc2boa;


import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.widget.AdapterView.OnItemClickListener;

import android.view.View;


public class SelectBuildOrderActivity extends Activity {
	public final static String EXTRA_BuildName = "com.alc.sc2boa.BuildName";

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d("SelectBuildOrderActivity: ","onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_build_order);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d("SelectBuildOrderActivity: ","onCreate: getrace");
        //get the race
        Intent intent = getIntent();
        String race = intent.getStringExtra(MainActivity.EXTRA_RACE);
        Log.d("SelectBuildOrderActivity: ","onCreate: acces db");
        //access db and get builds
        BuildOrderDBManager BOC;// = new BuildOrderCollection(this);
        //BOC.open();
        List<BuildOrder> builds;// = new ArrayList<BuildOrder>();
        if(race.matches("all"))
        {
        	BOC = new BuildOrderDBManager(this);
        	//BOC.open();
        	//Log.d("SelectBuildOrderActivity: ", "onCreate: displaying all builds v2");
        	Log.d("SelectBuildOrderActivity: ", "onCreate: displaying all builds");
        	builds = BOC.GetAllBuildOrders();
        	
        	Log.d("SelectBuildOrderActivity: ", "onCreate: displaying all builds done");
        	
        }else{
        	BOC = new BuildOrderDBManager(this);
        	//BOC.open();
        	Log.d("SelectBuildOrderActivity: ", "onCreate: displaying "+race+" builds");
        	builds = BOC.GetBuildOrdersByRace(race);
        	
        }
        //BOC.close();
        Log.d("SelectBuildOrderActivity: ", "onCreate: creating list of buildnames");
        //setup the list of builds
        String[] buildnames = new String[builds.size()];
        for(int i = 0;i<builds.size();i++){
        	buildnames[i]=((BuildOrder)builds.get(i)).GetName();
        }
        Log.d("SelectBuildOrderActivity: ", "onCreate: setting up list view");
        ListView listView = (ListView) findViewById(R.id.BuildOrdersList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		  android.R.layout.simple_list_item_single_choice, android.R.id.text1, buildnames);

        		// Assign adapter to ListView
        listView.setAdapter(adapter); 
        Log.d("SelectBuildOrderActivity: ", "onCreate: done");
        
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
   
                // getting the selected build
                String buildname = ((TextView) view).getText().toString();
                Log.d("SelectBuildOrderActivity: ", "onCreate: onclick : "+buildname);
                Intent i = new Intent(getApplicationContext(), DisplayBuildOrderActivity.class);
                // sending data to new activity
                i.putExtra(EXTRA_BuildName, buildname);
                startActivity(i);
   
            }
          });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_select_build_order, menu);
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
