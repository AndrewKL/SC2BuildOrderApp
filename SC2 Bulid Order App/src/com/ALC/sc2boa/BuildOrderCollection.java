package com.ALC.sc2boa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BuildOrderCollection {
	
	private SQLiteDatabase database;
	private BuildOrderDataBaseOpenHelper dbHelper;
	//private String[] allColumns;
	
	public BuildOrderCollection(Context context)
	{
		Log.d("BOC: ", "creating dbhelper");
		dbHelper = new BuildOrderDataBaseOpenHelper(context);
		Log.d("BOC: ", "done");
		//allColumns=BuildOrderDataBaseOpenHelper.COLUMNS;
		
	
	}
	public void addDefaultData()
	{
		
		this.addBuildOrder(BuildOrderResources.terranbuild);
		this.addBuildOrder(BuildOrderResources.zergbuild);
		this.addBuildOrder(BuildOrderResources.protossbuild);
		
	}
	
	public SQLiteDatabase GetDB()
	{
		this.open();
		return database;
	}
	
	private void close() {
		Log.d("BOC: ", "close db connection");
	    dbHelper.close();
	}
	
	private void open() throws SQLException {
		Log.d("BOC: ", "open db connection");
	    database = dbHelper.getWritableDatabase();
	}
	
	/**
	 * Adds Build Order.
	 * 
	 * must open db connection first via open() and then call close() afterwords
	 * @param BO
	 */
	public void addBuildOrder(BuildOrder BO) {
		Log.d("BOC: ", "addBuildOrder... "+BO);
		this.open();
		//database = dbHelper.getWritableDatabase();
	    ContentValues values = new ContentValues();
	    values.put(BuildOrderDataBaseOpenHelper.COLUMN_BUILDNAME, BO.GetName());
	    values.put(BuildOrderDataBaseOpenHelper.COLUMN_BUILDORDERINSTRUCTIONS, BO.GetOrderInstructions());
	    values.put(BuildOrderDataBaseOpenHelper.COLUMN_RACE, BO.GetRace());
	    
	    BO.setId(database.insert(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS, null,
	        values));
	    this.close();
	    
	}
	public void addBuildOrderList(List<BuildOrder> bos) {
		Log.d("BOC: ", "addBuildOrderList number of builds to add:"+bos.size());
		for(int i =0;i<bos.size();i++){
			this.addBuildOrder(bos.get(i));
		}
	
	}
	
	public List<BuildOrder> GetAllBuildOrders()
	{
		Log.d("BuildOrderCollection: ","GetAllBuildOrders: opened db");
		this.open();
		
		
		List<BuildOrder> buildOrders = new ArrayList<BuildOrder>();
		
		//String[] namecolumn = BuildOrderDataBaseOpenHelper.COLUMNS;
		Log.d("BuildOrderCollection: ","GetAllBuildOrders: query");
		Cursor cursor = database.query(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS,
				BuildOrderDataBaseOpenHelper.COLUMNS, null, null, null, null, null);
		Log.d("BuildOrderCollection: ","GetAllBuildOrders: query finished");

	    cursor.moveToFirst();
	    Log.d("BuildOrderCollection: ","GetAllBuildOrders: numberofbuilds: "+cursor.getCount());
	    for(int i=0;i<cursor.getCount();i++){
	    	
			cursor.moveToPosition(i);
			
			BuildOrder BO = BuildOrderCollection.cursorToBuildOrder(cursor);
			Log.d("BuildOrderCollection: ","getallbuilds: adding: "+BO);
		    buildOrders.add(BO);
			
	    }
	    
	    // Make sure to close the cursor
	    cursor.close();
	    this.close();
	    return buildOrders;
	}
	
	public List<BuildOrder> GetBuildOrdersByRace(String race)
	{
		Log.d("BuildOrderCollection: ","GetBuildOrdersByRace: race: "+race);
		this.open();
		
		
		List<BuildOrder> buildOrders = new ArrayList<BuildOrder>();
		
		//String[] namecolumn = BuildOrderDataBaseOpenHelper.COLUMNS;
		Log.d("BuildOrderCollection: ","GetBuildOrdersByRace: query");
		Cursor cursor = database.query(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS,
				BuildOrderDataBaseOpenHelper.COLUMNS, BuildOrderDataBaseOpenHelper.COLUMN_RACE+"= '"+race+"' ", null, null, null, null);
		Log.d("BuildOrderCollection: ","GetBuildOrdersByRace: query finished");

	    cursor.moveToFirst();
	    Log.d("BuildOrderCollection: ","GetBuildOrdersByRace: numberofbuilds: "+cursor.getCount());
	    for(int i=0;i<cursor.getCount();i++){
	    	
			cursor.moveToPosition(i);
			
			BuildOrder BO = BuildOrderCollection.cursorToBuildOrder(cursor);
			Log.d("BuildOrderCollection: ","getallbuilds: adding: "+BO);
		    buildOrders.add(BO);
			
	    }
	    
	    // Make sure to close the cursor
	    cursor.close();
	    this.close();
	    return buildOrders;
	}
	
	public static BuildOrder cursorToBuildOrder(Cursor cursor) {
	    BuildOrder BO = new BuildOrder();
	    BO.setId(cursor.getLong(cursor.getColumnIndex(BuildOrderDataBaseOpenHelper.COLUMN_ID)));
	    BO.setBuildName(cursor.getString(cursor.getColumnIndex(BuildOrderDataBaseOpenHelper.COLUMN_BUILDNAME)));
	    BO.setBuildOrderInstructions(cursor.getString(cursor.getColumnIndex(BuildOrderDataBaseOpenHelper.COLUMN_BUILDORDERINSTRUCTIONS)));
	    BO.setRace(cursor.getString(cursor.getColumnIndex(BuildOrderDataBaseOpenHelper.COLUMN_RACE)));
	    return BO;
	}
	public void deleteBuildOrder(BuildOrder BO) {
	    long id = BO.getId();
	    System.out.println("BuildOrder deleted with id: " + id);
	    database.delete(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS, BuildOrderDataBaseOpenHelper.COLUMN_ID
	        + " = " + id, null);
	}
	public BuildOrder GetBuildOderByName(String buildname) {
		this.open();
		Cursor cursor = database.query(BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS,
				BuildOrderDataBaseOpenHelper.COLUMNS, BuildOrderDataBaseOpenHelper.COLUMN_BUILDNAME+"= '"+buildname+"' ", null, null, null, null);
		cursor.moveToFirst();
		BuildOrder bo = BuildOrderCollection.cursorToBuildOrder(cursor);
		this.close();
		return bo;
	}
	public void deleteAllBuildOrders(){
		this.open();
		String statement = "DELETE FROM "+BuildOrderDataBaseOpenHelper.TABLE_BUILDORDERS;
		database.execSQL(statement);
		this.close();
	}
	
	public void loadInitialBuildOrdersFromXML(AssetManager assetManager){
		try {
			XMLBuildOrderReader bor = new XMLBuildOrderReader(assetManager);
			List<BuildOrder> list = bor.GetBuildOrders();
			Utils.convertBuildOrderInstToHTML(list);
			this.addBuildOrderList(list);
		} catch (XmlPullParserException e) {
			Log.d("MainActivity: ","xml pull parser error");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d("MainActivity: ","missing file");
			e.printStackTrace();
		}
	}
	
		

}
