package com.ALC.sc2boa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

//import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class XMLBuildOrderReader {
	
	private XmlPullParserFactory factory;
	private XmlPullParser xpp;
	
	
	public XMLBuildOrderReader(AssetManager assetManager) throws XmlPullParserException, IOException
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open("initialbuildordersfile.xml")));
		
		factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        xpp = factory.newPullParser();
        
        

        xpp.setInput(reader);
	}
	
	
	public List<BuildOrder> GetBuildOrders()
	{
		ArrayList<BuildOrder> list = new ArrayList<BuildOrder>();
		BuildOrder bo;
		
		
		int eventType;
		try {
			eventType = xpp.getEventType();
			//bo = new BuildOrder();
		
	        while (eventType != XmlPullParser.END_DOCUMENT) {
	        	
	        	if(eventType == XmlPullParser.START_DOCUMENT) //case start of xml file
	        	{
	        		Log.d("XMLBuildOrderReader","Start document");
	        	}
	        	else if(eventType == XmlPullParser.END_DOCUMENT) //case end of xml file
	        	{
	        		Log.d("XMLBOR","End document");
	        	} else if(eventType == XmlPullParser.START_TAG) //case reading in a new tag
	        	{
	        		//Log.d("XMLBOR","Start tag "+xpp.getName());
	        		
	        		if(xpp.getName().matches("buildorder"))
	        		{
	        			//Log.d("XMLBOR","reading build order "+xpp.getName());
	        			list.add(readBuildOrder(xpp));
	        		}
	        		//Log.d("XMLBOR","Start tag "+xpp.getName());
	        		
	        	} else if(eventType == XmlPullParser.END_TAG) //case end of tag
	        	{
	        		//Log.d("XMLBOR","End tag "+xpp.getName());
	        	} else if(eventType == XmlPullParser.TEXT) 
	        	{
	        		//Log.d("XMLBOR","Text "+xpp.getText());
	        	}
	        	//list.add(bo);
	        	eventType = xpp.next();
	        }
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return list;
	}
	
	private static BuildOrder readBuildOrder(XmlPullParser xpp) throws XmlPullParserException, IOException{
		BuildOrder bo = new BuildOrder();
		int eventType = xpp.next();
		bo = new BuildOrder();
		while (eventType!=XmlPullParser.END_DOCUMENT&&eventType!=XmlPullParser.END_TAG) {
        	
        	if(eventType == XmlPullParser.START_TAG) //case reading in a new tag
        	{
        		//Log.d("XMLBOR","Start tag "+xpp.getName());
        		if(xpp.getName().matches("buildname"))
        		{
        			//Log.d("XMLBOR","readBuildOrder buildname"+xpp.getName());
        			bo.setBuildName(safeNextText(xpp));
        			
        			
        		} else if(xpp.getName().matches("race"))
        		{
        			//Log.d("XMLBOR","readBuildOrder race"+xpp.getName());
        			bo.setRace(safeNextText(xpp));
        		}
        		else if(xpp.getName().matches("buildinstructions"))
        		{
        			//Log.d("XMLBOR","readBuildOrder buildinstructions"+xpp.getName());
        			bo.setRace(safeNextText(xpp));
        			
        		}else{
        			Log.d("XMLBOR","readBuildOrder ERROR"+xpp.nextText());
        			
        		}
        		
        		//Log.d("XMLBOR","Start tag "+xpp.getName());
        		
        	} else if(eventType == XmlPullParser.TEXT) 
        	{
        		//Log.d("XMLBOR","readBuildOrder Text "+xpp.getText());
        	}
        	//Log.d("XMLBOR","readBuildOrder current BO "+bo);
        	eventType = xpp.next();
        }
		Log.d("XMLBOR","readBuildOrder finished bo: "+bo);
		
		return bo;
		
	}
	
	private static String safeNextText(XmlPullParser parser)
	          throws XmlPullParserException, IOException {//as mandated by google 
	      String result = parser.nextText();
	      if (parser.getEventType() != XmlPullParser.END_TAG) {
	          parser.nextTag();
	      }
	      return result;
	  }
	
	

}
