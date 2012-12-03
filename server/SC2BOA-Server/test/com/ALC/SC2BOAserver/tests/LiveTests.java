package com.ALC.SC2BOAserver.tests;

import static org.junit.Assert.*;

import org.junit.Test;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;




import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.dao.SC2BOADAOSimpleDBImpl;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.DEBUG;


public class LiveTests {

	@Test
	public void listCurrentUsers() {
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
		
		List<User> users = doa.getUsers();
		
		System.out.println("total users: "+users.size());
		System.out.println("==============");
		for(int i =0;i<users.size();i++){
			System.out.println("username: "+users.get(i).getUsername());		
		}
		
		
		
	}
	
	@Test
	public void listAllBuilds(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
		
		List<OnlineBuildOrder> builds = doa.getAllOnlineBuildOrders();
		
		System.out.println("total builds: "+builds.size());
		System.out.println("==============");
		for(int i =0;i<builds.size();i++){
			System.out.println("buildname: "+builds.get(i).getBuildName());		
		}
	}
	
	//@Test
	public void populateDBWithRandomData(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
		
		for(int i =0;i<10;i++){
			OnlineBuildOrder buildorder = new OnlineBuildOrder();
			buildorder.setBuildName("testbuild "+i);
			buildorder.setBuildOrderInstructions("1 2 3 4 5 622");
			buildorder.setRace("zerg");
			
			doa.addOnlineBuildOrder(buildorder);
			
		}
		for(int i =0;i<10;i++){
			User user = new User();
			user.setPassword("12345");
			user.setUsername("testuser"+i);
			user.setEmail("testuser2@google.com");
			doa.saveUser(user);
			
		}
		System.out.println("finished");
		
		
	}
	
	@Test
	public void populateDBWithXMLData(){
		//SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
		File xmlfile = new File("src/META-INF/initialbuildordersfile.xml");
		System.out.println("xmlfile: "+xmlfile.getAbsolutePath());
		System.out.println("xmlfile can read"+xmlfile.canRead());
		
		List<OnlineBuildOrder> list =new ArrayList<OnlineBuildOrder>();
		try {
			list = getBuildsFromFile(xmlfile);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("list: "+list.size());
		System.out.println("finished");
		
		
	}
	
	public static List<OnlineBuildOrder> getBuildsFromFile(File file) throws XmlPullParserException, IOException{
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        System.out.println("parser implementation class is "+xpp.getClass());
        List<OnlineBuildOrder> list = new ArrayList<OnlineBuildOrder>();
        
        
        int eventType = xpp.getEventType();
        while (eventType != xpp.END_DOCUMENT) {
            if(eventType == xpp.START_DOCUMENT) {
                System.out.println("Start document");
            } else if(eventType == xpp.END_DOCUMENT) {
                System.out.println("End document");
            } else if(eventType == xpp.START_TAG) {
                System.out.println("Start tag "+xpp.getName());
            } else if(eventType == xpp.END_TAG) {
                System.out.println("End tag "+xpp.getName());
            } else if(eventType == xpp.TEXT) {
                System.out.println("Text "+xpp.getText());
            }
            eventType = xpp.next();
        }
		
		
		return null;
	}
	
	
	
	
	//@Test
	public void deleteEverthing(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
		
		doa.deleteAllOnlineBuildOrders();
		doa.deleteAllUsers();
		System.out.println("deleted everything");
	}
	
	

}
