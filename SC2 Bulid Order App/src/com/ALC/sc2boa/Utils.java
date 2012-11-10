package com.ALC.sc2boa;

//import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Utils {
	public static void PrintBuildOrderDB(BuildOrderDBManager BOC)
	{
		/*BOC.open();
		SQLiteDatabase db = BOC.GetDB();
		
		//getting all the dbs and printing them
		String getDBsQuery = "SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;";
		Cursor cursor = db.rawQuery(getDBsQuery, null);
		Log.d("Debug DB","printing tables number dbs: "+cursor.getCount());
		for(int i=0;i<cursor.getCount();i++){
			cursor.moveToPosition(i);
			Log.d("DB tables: ",cursor.getString(0));
		}
		
		
		//getting all the builds in the build order tbl and printing them
		Log.d("Debug DB","printing all build names");
		String [] namecolumn = {BuildOrderDataBaseOpenHelper.COLUMN_BUILDNAME};
		cursor = db.query(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS,
				namecolumn, null, null, null, null, null);
		Log.d("Debug DB","printing builds number builds: "+cursor.getCount());
		for(int i=0;i<cursor.getCount();i++){
			cursor.moveToPosition(i);
			Log.d("DB build: ",cursor.getString(0));
		}
		
		//printing all builds
		Log.d("Debug DB","printing full builds");*/
		
		SQLiteDatabase db = BOC.GetDB();
		Cursor cursor = db.query(BuildOrderDBHelper.TABLE_BUILDORDERS,
				BuildOrderDBHelper.BUILDORDER_TBL_COLUMNS, null, null, null, null, null);
		Log.d("Debug DB","printing full builds number builds: "+cursor.getCount());
		Log.d("Debug DB","printing full builds number of columns: "+cursor.getColumnCount());
		for(int i =0;i<cursor.getColumnCount();i++){
			Log.d("Debug DB","printing full builds row names fields: "+cursor.getColumnName(i));
		}/*
		cursor.moveToFirst();
		Log.d("Debug DB","printing first column index _id: "+cursor.getColumnIndex(BuildOrderDataBaseOpenHelper.COLUMN_ID));
		Log.d("Debug DB","printing first index _id: "+cursor.getLong(cursor.getColumnIndex(BuildOrderDataBaseOpenHelper.COLUMN_ID)));
		
		//Log.d("Debug DB","printing first BO: "+BuildOrderCollection.cursorToBuildOrder(cursor));
		
		for(int i=0;i<cursor.getCount();i++){
			cursor.moveToPosition(i);
			Log.d("DB build: ","full build: "+BuildOrderCollection.cursorToBuildOrder(cursor));
		}
		
		BOC.close();
		*/
		
		/*
		Log.d("Uils.TestDB","GetAllBuildOrders: start");
		BOC.open();
		SQLiteDatabase database = BOC.GetDB();
		//sesesesese
		
		Log.d("Uils.TestDB","GetAllBuildOrders: opened db");
		List<BuildOrder> buildOrders = new ArrayList<BuildOrder>();
		
		//String[] namecolumn = BuildOrderDataBaseOpenHelper.COLUMNS;
		Log.d("Uils.TestDB","GetAllBuildOrders: query");
		Cursor cursor = database.query(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS,
				BuildOrderDataBaseOpenHelper.COLUMNS, null, null, null, null, null);
		Log.d("Uils.TestDB","GetAllBuildOrders: query finished");

	    cursor.moveToFirst();
	    Log.d("Uils.TestDB","GetAllBuildOrders: numberofbuilds: "+cursor.getColumnCount());
	    for(int i=0;i<cursor.getCount();i++){
	    	
			cursor.moveToPosition(i);
			
			BuildOrder BO = BuildOrderCollection.cursorToBuildOrder(cursor);
			Log.d("Uils.TestDB","getallbuilds: looping: "+i+" "+BO);
		    buildOrders.add(BO);
			
	    }
	    
	    // Make sure to close the cursor
	    cursor.close();
	    BOC.close();*/
		
		//List<BuildOrder> list = BOC.GetAllBuildOrders();
		
		
		
		
	}
	public static String convertTextToHTML(String string){
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		char eol = System.getProperty("line.separator").charAt(0);
		for(int i =0;i<string.length();i++){
			if(string.charAt(i)==eol){
				sb.append("<br>");
			}else {
				sb.append(string.charAt(i));
			}
		}
		sb.append("</p>");
		return sb.toString();
	}
	public static void convertBuildOrderInstToHTML(List<BuildOrder> list){
		for(int i =0;i<list.size();i++){
			list.get(i).setBuildOrderInstructions(convertTextToHTML(list.get(i).GetOrderInstructions()));
		}
	}

}
