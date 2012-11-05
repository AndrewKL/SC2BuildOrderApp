package com.ALC.sc2boa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class DisplayBuildOrderActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_build_order);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //get the text box
        TextView textview=(TextView)findViewById(R.id.BuildOrderTextAreaTextView); 
        //get the right build order
        Intent intent = getIntent();
        String buildname = intent.getStringExtra(SelectBuildOrderActivity.EXTRA_BuildName);
        BuildOrderCollection boc = new BuildOrderCollection(this);
        BuildOrder bo = boc.GetBuildOderByName(buildname);
        
        String eol = System.getProperty("line.separator");
        String text = "Build: "+bo.GetName()+eol+
        "Race: "+bo.GetRace()+eol+
        		bo.GetOrderInstructions();
        textview.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_build_order, menu);
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
