package com.ALC.sc2boav2;

import com.ALC.sc2boav2.R;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
//import android.text.Html;
import android.text.method.ScrollingMovementMethod;

public class DisplayDatabaseInformationActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_database_information);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        //get text view
        TextView textview=(TextView)findViewById(R.id.DatabaseInformationTextAreaTextView);
        
        //format and display build order information
        String eol = System.getProperty("line.separator");
        StringBuilder text = new StringBuilder();
        BuildOrderDBManager dbManager = new BuildOrderDBManager(this); 
        
        SQLiteDatabase database = dbManager.GetDB();
        
        //get databases
        String getDBsQuery = "SELECT name FROM sqlite_master " +
        		"WHERE type='table' " +
        		"AND name != 'android_metadata' " +
        		"AND name != 'sqlite_sequence' " +
        		"ORDER BY name;";
        Cursor dbcursor = database.rawQuery(getDBsQuery, null);
        text.append("Number of databases: "+dbcursor.getCount()+eol);
        while(dbcursor.moveToNext()) {
        	text.append(dbcursor.getString(0));
        	
        	text.append(eol);
        	String countquery = "SELECT COUNT(*) FROM "+dbcursor.getString(0);
        	Cursor rowcursor = database.rawQuery(countquery, null);
        	if(rowcursor.moveToFirst())text.append(rowcursor.getString(0)+eol);
        	rowcursor.close();
        	//print the contents of the current db
        	String printallquery = "SELECT * FROM "+dbcursor.getString(0);
        	Cursor currentrowcursor = database.rawQuery(printallquery, null);
        	while(currentrowcursor.moveToNext()){
        		text.append(currentrowcursor.getString(0));
        		text.append("    "+currentrowcursor.getString(1));
            	
            	text.append(eol);
        	}
        	currentrowcursor.close();
        	
        	
        }
        dbcursor.close();
        text.append(eol);
        text.append("printing ratings db"+eol);
        //text.append("contains rating column: "+)
        
    	
        
        //print information about dbs
        
        //send string builder to the text field
        textview.setText(text.toString());
        textview.setMovementMethod(new ScrollingMovementMethod());
        textview.setTextSize(20);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_database_information, menu);
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
