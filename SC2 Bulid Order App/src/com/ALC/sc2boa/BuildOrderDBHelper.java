package com.ALC.sc2boa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;


public class BuildOrderDBHelper extends SQLiteOpenHelper {




  public static final String TABLE_BUILDORDERS = "buildorderstbl";
  
  
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_BUILDNAME = "buildname";
  public static final String COLUMN_BUILDORDERINSTRUCTIONS = "buildorderinstructions";
  public static final String COLUMN_RACE = "buildorderrace";
  
  public static final String[] COLUMNS = {COLUMN_ID,COLUMN_BUILDNAME,COLUMN_BUILDORDERINSTRUCTIONS,COLUMN_RACE};

  private static final String DATABASE_NAME = "buildorders.db";
  private static final int DATABASE_VERSION = 1;

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
  + TABLE_BUILDORDERS + "(" + 
		  COLUMN_ID + " integer primary key autoincrement, " + 
      COLUMN_BUILDNAME+ " text unique not null, "+
      COLUMN_BUILDORDERINSTRUCTIONS+" text not null, "+
      COLUMN_RACE+" text not null);";

  public BuildOrderDBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }
  
  

  @Override
  public void onCreate(SQLiteDatabase database) {
	  Log.d(" BuildOrderDataBaseOpenHelper: ","oncreate: ");
	  database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(BuildOrderDBHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDORDERS);
    onCreate(db);
  }

} 

	
	
