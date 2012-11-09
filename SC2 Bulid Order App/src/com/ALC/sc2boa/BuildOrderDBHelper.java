package com.ALC.sc2boa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;


public class BuildOrderDBHelper extends SQLiteOpenHelper {
	
	//table where the builds are stored
	public static final String TABLE_BUILDORDERS = "buildorderstbl";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_BUILDNAME = "buildname";
	public static final String COLUMN_BUILDORDERINSTRUCTIONS = "buildorderinstructions";
	public static final String COLUMN_RACE = "buildorderrace"; 
	public static final String COLUMN_BUILD_RATING = "buildrating";  
	public static final String[] BUILDORDER_TBL_COLUMNS = {COLUMN_ID,COLUMN_BUILDNAME,COLUMN_BUILDORDERINSTRUCTIONS,COLUMN_RACE,COLUMN_BUILD_RATING};
	private static final String BUILDORDER_DATABASE_CREATE = "create table "
			+ TABLE_BUILDORDERS + "(" + 
			COLUMN_ID + " integer primary key autoincrement, " + 
			COLUMN_BUILDNAME+ " text unique not null, "+
			COLUMN_BUILDORDERINSTRUCTIONS+" text not null, "+
			COLUMN_RACE+" text not null, "+
			COLUMN_BUILD_RATING+" REAL );";
	
	//table with ratings
	//public static final String TABLE_BUILD_RATING = "buildratingsstbl";
	//public static final String COLUMN_BUILDORDER_RATING_ID = "_corresponding_bo_id";//matches BO id
	
	//public static final String[] BUILDRATINGS_TBL_COLUMNS = {COLUMN_BUILDORDER_RATING_ID,COLUMN_BUILD_RATING};
	/*private static final String BUILDRATING_DATABASE_CREATE = "create table "
			+ TABLE_BUILD_RATING + "(" +
			COLUMN_BUILDORDER_RATING_ID + " integer primary key, " + 
			COLUMN_BUILD_RATING+ " INTEGER not null);";*/
  
	//current version of db plus its name
	private static final String DATABASE_NAME = "buildorders.db";
	private static final int DATABASE_VERSION = 1;
	
	

	public BuildOrderDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	  
	@Override
	public void onCreate(SQLiteDatabase database) {
		Log.d(" BuildOrderDataBaseOpenHelper: ","oncreate: ");
		//execute commands to create the tables
		database.execSQL(BUILDORDER_DATABASE_CREATE);
		//database.execSQL(BUILDRATING_DATABASE_CREATE);
		
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

	
	
