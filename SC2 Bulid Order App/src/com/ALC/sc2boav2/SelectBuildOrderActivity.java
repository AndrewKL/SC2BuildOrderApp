package com.ALC.sc2boav2;

import java.util.ArrayList;

import com.ALC.sc2boav2.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;


public class SelectBuildOrderActivity extends Activity {
	public final static String EXTRA_BuildName = "com.ALC.sc2boav2.BuildName";
	public static final String EXTRA_Buildid = "com.ALC.sc2boa.Buildid";
	BuildOrderAdapter boAdapter;
	private EditText searchText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_build_order);//set layout
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        //get the race
        Intent intent = getIntent();
        String race = intent.getStringExtra(MainActivity.EXTRA_RACE);

        //access db and get builds
        BuildOrderDBManager buildOrderDB= new BuildOrderDBManager(this);
        ArrayList<BuildOrder> builds;
        if(race.matches("all")){
        	builds = buildOrderDB.GetAllBuildOrders();
        }else{
        	builds = buildOrderDB.GetBuildOrdersByRace(race);
        }
        //Log.d("SelectBuildOrderActivity: ", "onCreate: creating list of buildnames");
        
        //send list of builds to the listview 
        ListView listView = (ListView) findViewById(R.id.BuildOrdersList);
        boAdapter = new BuildOrderAdapter(this,R.layout.row,builds);
        
        // Assign adapter to ListView and setup listener
        listView.setAdapter(boAdapter);         
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
