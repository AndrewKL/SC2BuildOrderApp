package com.ALC.sc2boa;

import java.io.File;
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

public class BuildOrderDBManager {
	
	public static final String ACLwebsiteurl ="https://sites.google.com/a/andrewlongconsulting.com/www/sc2boa/initialbuildordersfile.xml?attredirects=0&d=1";
	private SQLiteDatabase database;
	private BuildOrderDBHelper dbHelper;
	//private String[] allColumns;
	
	public BuildOrderDBManager(Context context)
	{
		dbHelper = new BuildOrderDBHelper(context);
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
	    dbHelper.close();
	}
	
	private void open() throws SQLException {
		//Log.d("BODBM: ", "open db connection");
	    database = dbHelper.getWritableDatabase();
	}
	
	/**
	 * Adds Build Order.
	 * 
	 * @param BO
	 */
	public void addBuildOrder(BuildOrder BO) {
		Log.d("BODBM: ", "addBuildOrder... ");
		this.open();
		
		//create new row
	    ContentValues values = new ContentValues();
	    values.put(BuildOrderDBHelper.COLUMN_BUILDNAME, BO.GetName());
	    values.put(BuildOrderDBHelper.COLUMN_BUILDORDERINSTRUCTIONS, BO.GetOrderInstructions());
	    values.put(BuildOrderDBHelper.COLUMN_RACE, BO.GetRace());
	    
	    //insert in to db plus set the id of the new BO
	    BO.setId(database.insert(BuildOrderDBHelper.TABLE_BUILDORDERS, null, values));
	    this.close();
	}
	
	public void updateBuildOrder(BuildOrder BO) {
		Log.d("BODBM: ", "addBuildOrder... ");
		this.open();
		
		//create new updated row
	    ContentValues values = new ContentValues();
	    values.put(BuildOrderDBHelper.COLUMN_BUILDNAME, BO.GetName());
	    values.put(BuildOrderDBHelper.COLUMN_BUILDORDERINSTRUCTIONS, BO.GetOrderInstructions());
	    values.put(BuildOrderDBHelper.COLUMN_RACE, BO.GetRace());
	    
	    //update db
	    database.update(BuildOrderDBHelper.TABLE_BUILDORDERS, values, BuildOrderDBHelper.COLUMN_ID+"="+BO.getId(), null);
	    
	    this.close();
	}
	
	
	public void addBuildOrderList(List<BuildOrder> bos) {
		Log.d("BODBM: ", "addBuildOrderList number of builds to add:"+bos.size());
		for(int i =0;i<bos.size();i++){
			this.addBuildOrder(bos.get(i));
		}
	}
	
	public ArrayList<BuildOrder> GetAllBuildOrders()
	{
		this.open();
		//query the db and get a list of all builds
		ArrayList<BuildOrder> buildOrders = new ArrayList<BuildOrder>();
		Cursor cursor = database.query(BuildOrderDBHelper.TABLE_BUILDORDERS,
				BuildOrderDBHelper.COLUMNS, null, null, null, null, null);
		
		//scan through the new list and add BOs to new array list
		cursor.moveToFirst();
		for(int i=0;i<cursor.getCount();i++){
			cursor.moveToPosition(i);
			BuildOrder BO = BuildOrderDBManager.cursorToBuildOrder(cursor);
		    buildOrders.add(BO);
	    }
	    
	    // Make sure to close the cursor
	    cursor.close();
	    this.close();
	    return buildOrders;
	}
	
	public ArrayList<BuildOrder> GetBuildOrdersByRace(String race)
	{
		this.open();
		
		ArrayList<BuildOrder> buildOrders = new ArrayList<BuildOrder>();
		Log.d("BuildOrderCollection: ","GetBuildOrdersByRace: query");
		Cursor cursor = database.query(BuildOrderDBHelper.TABLE_BUILDORDERS,
				BuildOrderDBHelper.COLUMNS, BuildOrderDBHelper.COLUMN_RACE+"= '"+race+"' ", null, null, null, null);
		
		//query the db and get a list of a specific races builds
	    cursor.moveToFirst();
	    for(int i=0;i<cursor.getCount();i++){
			cursor.moveToPosition(i);
			BuildOrder BO = BuildOrderDBManager.cursorToBuildOrder(cursor);
		    buildOrders.add(BO);
	    }
	    
	    // Make sure to close the cursor
	    cursor.close();
	    this.close();
	    return buildOrders;
	}
	
	public static BuildOrder cursorToBuildOrder(Cursor cursor) {
	    BuildOrder BO = new BuildOrder();
	    BO.setId(cursor.getLong(cursor.getColumnIndex(BuildOrderDBHelper.COLUMN_ID)));
	    BO.setBuildName(cursor.getString(cursor.getColumnIndex(BuildOrderDBHelper.COLUMN_BUILDNAME)));
	    BO.setBuildOrderInstructions(cursor.getString(cursor.getColumnIndex(BuildOrderDBHelper.COLUMN_BUILDORDERINSTRUCTIONS)));
	    BO.setRace(cursor.getString(cursor.getColumnIndex(BuildOrderDBHelper.COLUMN_RACE)));
	    return BO;
	}
	public void deleteBuildOrder(BuildOrder BO) {
	    long id = BO.getId();
	    System.out.println("BuildOrder deleted with id: " + id);
	    database.delete(BuildOrderDBHelper.TABLE_BUILDORDERS, BuildOrderDBHelper.COLUMN_ID
	        + " = " + id, null);
	}
	public BuildOrder GetBuildOderByName(String buildname) {
		this.open();
		Cursor cursor = database.query(BuildOrderDBHelper.TABLE_BUILDORDERS,
				BuildOrderDBHelper.COLUMNS, BuildOrderDBHelper.COLUMN_BUILDNAME+"= '"+buildname+"' ", null, null, null, null);
		cursor.moveToFirst();
		BuildOrder bo = BuildOrderDBManager.cursorToBuildOrder(cursor);
		this.close();
		return bo;
	}
	public BuildOrder GetBuildOderByid(long id) {
		this.open();
		Cursor cursor = database.query(BuildOrderDBHelper.TABLE_BUILDORDERS,
				BuildOrderDBHelper.COLUMNS, BuildOrderDBHelper.COLUMN_ID+"= '"+id+"' ", null, null, null, null);
		cursor.moveToFirst();
		BuildOrder bo = BuildOrderDBManager.cursorToBuildOrder(cursor);
		this.close();
		return bo;
	}
	public void deleteAllBuildOrders(){
		this.open();
		String statement = "DELETE FROM "+BuildOrderDBHelper.TABLE_BUILDORDERS;
		database.execSQL(statement);
		this.close();
	}
	
	public static void loadInitialBuilds(final Context context){
		Log.d("BuildOrderDBManager", "loadInitialBuilds: supposedly old thread: ");
		Thread thread = new Thread(new Runnable() {
	        public void run() {
	        	Log.d("BuildOrderDBManager", "loadInitialBuilds: supposedly a new thread: ");
	            BuildOrderDBManager BODBM = new BuildOrderDBManager(context);
	            BODBM.loadInitialBuildOrdersFromXML(context.getAssets());
	        }
		});
		thread.run();
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
	
	public void loadBuildsXMLFile(String path){
		File file = new File(path);
		try {
			XMLBuildOrderReader bor = new XMLBuildOrderReader(file);
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
