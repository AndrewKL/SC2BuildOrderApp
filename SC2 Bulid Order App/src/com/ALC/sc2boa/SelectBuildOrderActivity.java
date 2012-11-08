package com.ALC.sc2boa;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.widget.AdapterView.OnItemClickListener;

import android.view.View;


public class SelectBuildOrderActivity extends Activity {
	public final static String EXTRA_BuildName = "com.alc.sc2boa.BuildName";
	BuildOrderAdapter boAdapter;
	private EditText searchText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d("SelectBuildOrderActivity: ","onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_build_order);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //Log.d("SelectBuildOrderActivity: ","onCreate: getrace");
        
        
        //get the race
        Intent intent = getIntent();
        String race = intent.getStringExtra(MainActivity.EXTRA_RACE);
        //Log.d("SelectBuildOrderActivity: ","onCreate: acces db");
        //access db and get builds
        
        BuildOrderDBManager BOC;
        ArrayList<BuildOrder> builds;
        if(race.matches("all"))
        {
        	BOC = new BuildOrderDBManager(this);
        	//Log.d("SelectBuildOrderActivity: ", "onCreate: displaying all builds");
        	builds = BOC.GetAllBuildOrders();
        	
        	//Log.d("SelectBuildOrderActivity: ", "onCreate: displaying all builds done");
        	
        }else{
        	BOC = new BuildOrderDBManager(this);
        	//BOC.open();
        	//Log.d("SelectBuildOrderActivity: ", "onCreate: displaying "+race+" builds");
        	builds = BOC.GetBuildOrdersByRace(race);
        	
        }
        //BOC.close();
        Log.d("SelectBuildOrderActivity: ", "onCreate: creating list of buildnames");
        //setup the list of builds
        //Log.d("SelectBuildOrderActivity: ", "onCreate: setting up list view");
        ListView listView = (ListView) findViewById(R.id.BuildOrdersList);
        //BuildOrder[] buildsArray = (BuildOrder[])builds.toArray(new BuildOrder[builds.size()]);
        boAdapter = new BuildOrderAdapter(this,R.layout.row,builds);
        
        // Assign adapter to ListView
        listView.setAdapter(boAdapter); 
        //Log.d("SelectBuildOrderActivity: ", "onCreate: done");
        
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            	TextView tv = ((TextView)((LinearLayout) view).getChildAt(1));// getting the selected build
                String buildname = tv.getText().toString();
                Log.d("SelectBuildOrderActivity: ", "onCreate: onclick : "+buildname);
                Intent i = new Intent(getApplicationContext(), DisplayBuildOrderActivity.class);
                // sending data to new activity
                i.putExtra(EXTRA_BuildName, buildname);
                startActivity(i);
            }
          });
        
        //setting up search box
        searchText = (EditText) findViewById(R.id.SearchBox);
        searchText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boAdapter.getFilter().filter(s);
                Log.d("SelectBuildOrderActivity","updating searchable text: "+boAdapter.getCount());
            }});
        
        
    }
    //private TextWatcher searchTextWatcher = 
    

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
