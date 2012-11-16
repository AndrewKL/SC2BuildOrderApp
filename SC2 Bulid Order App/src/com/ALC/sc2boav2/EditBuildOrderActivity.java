package com.ALC.sc2boav2;

import com.ALC.sc2boav2.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class EditBuildOrderActivity extends Activity {
	private BuildOrder buildorder;
	
	private Spinner racespinner;
	private EditText boNameField;
	private EditText boInstructionsField;
	RatingBar boRatingBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_build_order);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        //get build order from db
        Intent intent = getIntent();
        long buildid =  intent.getLongExtra(SelectBuildOrderActivity.EXTRA_Buildid, 1L);
        Log.d("EditBOActivity:","onCreate: buildid: "+buildid);
        BuildOrderDBManager BOC = new BuildOrderDBManager(this);
        buildorder = BOC.GetBuildOrderByid(buildid);
        
        //get text fields and spinners
        boNameField=(EditText)findViewById(R.id.EditBuildOrderNameTextField);
        boNameField.setText(buildorder.GetName());
        racespinner = (Spinner)findViewById(R.id.EditRaceSpinner);
        racespinner.setSelection(buildorder.GetRaceInt(), true);
        boInstructionsField=(EditText)findViewById(R.id.EditBuildOrderInstructionsTextArea);
        boInstructionsField.setText(buildorder.GetOrderInstructions());
        boRatingBar = (RatingBar)findViewById(R.id.EditRatingBar);
        //boRatingBar.setMax(5);
        //Log.d("editBO: ","onCreate: "+BOC.getBuildOrderRating(buildorder.getId()));
        boRatingBar.setRating(buildorder.getRating());
        //boRatingBar.setNumStars(BOC.getBuildOrderRating(buildorder.getId()));
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_edit_build_order, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            	//display newly updated build
                Intent parentActivityIntent = new Intent(this, DisplayBuildOrderActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                parentActivityIntent.putExtra(SelectBuildOrderActivity.EXTRA_Buildid, buildorder.getId());
                startActivity(parentActivityIntent);
                finish();
                return true; 
            case R.id.menu_finished_edit:
            	Log.d("EditBuildOrderActivity: ","accepting edits");
            	this.acceptEdits(this.getCurrentFocus());
            	return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
	public void acceptEdits(View view) {
		EditText editText = (EditText) findViewById(R.id.EditBuildOrderNameTextField);
        buildorder.setBuildName(editText.getText().toString());
        
        editText = (EditText) findViewById(R.id.EditBuildOrderInstructionsTextArea);
        buildorder.setBuildOrderInstructions(editText.getText().toString());
        
        Spinner mySpinner = (Spinner)findViewById(R.id.EditRaceSpinner);
        buildorder.setRace(mySpinner.getSelectedItem().toString().toLowerCase());
        
        //setting rating
        buildorder.setRating(boRatingBar.getRating());
        
        Log.d("EditBuildOrderActivity: ", "Inserting... "+buildorder.toString());
        BuildOrderDBManager BOC = new BuildOrderDBManager(this);
        BOC.updateBuildOrder(buildorder);
        
        
        
        
        // close up this activity
        Intent parentActivityIntent = new Intent(this, DisplayBuildOrderActivity.class);
        parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        parentActivityIntent.putExtra(SelectBuildOrderActivity.EXTRA_Buildid, buildorder.getId());
        startActivity(parentActivityIntent);
        finish();
		
	}

}
