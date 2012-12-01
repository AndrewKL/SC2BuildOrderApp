package com.ALC.SC2BOAserver.tests;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.List;


import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.dao.SC2BOADAOSimpleDBImpl;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;


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
	public void populateDB(){
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
		
		
	}
	
	//@Test
	public void deleteEverthing(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
		
		doa.deleteAllOnlineBuildOrders();
		doa.deleteAllUsers();
		System.out.println("deleted everything");
	}
	
	

}
