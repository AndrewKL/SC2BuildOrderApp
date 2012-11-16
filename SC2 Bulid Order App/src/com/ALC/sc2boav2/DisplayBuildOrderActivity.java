package com.ALC.sc2boav2;

import com.ALC.sc2boav2.R;
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
	BuildOrder buildorder;
	
	public static final String EXTRA_edited_build = "com.ALC.sc2boav2.edited_build";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_build_order);//set layout
        getActionBar().setDisplayHomeAsUpEnabled(true);//add action bar
        
        //get the textview
        TextView textview=(TextView)findViewById(R.id.BuildOrderTextAreaTextView);
        
        //get the right build order either by the build order name or the build order id
        Intent intent = getIntent();
        String buildname = intent.getStringExtra(SelectBuildOrderActivity.EXTRA_BuildName);
        if(buildname!=null){
        	BuildOrderDBManager boc = new BuildOrderDBManager(this);
            buildorder = boc.GetBuildOderByName(buildname);
        } else{
        	long buildid =  intent.getLongExtra(SelectBuildOrderActivity.EXTRA_Buildid, 1L);
            BuildOrderDBManager BOC = new BuildOrderDBManager(this);
            buildorder = BOC.GetBuildOrderByid(buildid);
        }
        
        //format and display build order information
        String eol = System.getProperty("line.separator");
        String text = "<p><b>Build:</b> "+buildorder.GetName()+"</p>"+eol+
        "<p><b>Race:</b> "+buildorder.GetRaceHTML()+"</p>"+eol+
        		buildorder.GetOrderInstructions();
        textview.setText(Html.fromHtml(text));
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
            case android.R.id.home://go back
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.menu_editBuildorder://edit the build will be displayed in the actionbar 
            	Intent intent = new Intent(this, EditBuildOrderActivity.class);
                intent.putExtra(SelectBuildOrderActivity.EXTRA_Buildid,buildorder.getId());
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
