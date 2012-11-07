package com.ALC.sc2boa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;

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
        BuildOrderDBManager boc = new BuildOrderDBManager(this);
        BuildOrder bo = boc.GetBuildOderByName(buildname);
        
        String eol = System.getProperty("line.separator");
        String text = "<p><b>Build:</b> "+bo.GetName()+"</p>"+eol+
        "<p><b>Race:</b> "+bo.GetRaceHTML()+"</p>"+eol+
        		bo.GetOrderInstructions();
        textview.setText(Html.fromHtml(text));
        //textview.setText(text);
        textview.setMovementMethod(new ScrollingMovementMethod());
        textview.setTextSize(20);
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
