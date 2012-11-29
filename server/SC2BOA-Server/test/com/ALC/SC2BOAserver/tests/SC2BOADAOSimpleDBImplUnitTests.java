package com.ALC.SC2BOAserver.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.dao.SC2BOADAOSimpleDBImpl;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;


public class SC2BOADAOSimpleDBImplUnitTests {

	@Test
	public void testSC2BOADOAOnlineBuildOrderFunctions() {
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		
		//delete all build orders
		doa.deleteAllOnlineBuildOrders();
		
		//add build order several build orders
		int numberofbuilds=20;
		for(int i = 0;i<numberofbuilds;i++){
			OnlineBuildOrder buildorder = new OnlineBuildOrder();
			buildorder.setBuildName("testbuild "+i);
			buildorder.setBuildOrderInstructions("1 2 3 4 5 6"+ i);
			buildorder.setRace("terran");
			
			doa.addOnlineBuildOrder(buildorder);
			
		}
		
		
		//get all build orders
		List<OnlineBuildOrder> list = doa.getAllOnlineBuildOrders();
		System.out.println("list count: "+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("current build: "+list.get(i).getBuildName()+" id: "+list.get(i).getId());
		}
		int size = list.size();
		
		assertTrue(size==numberofbuilds);
		
		
		//cleanup 
		doa.deleteAllOnlineBuildOrders();
		
		
		
	}
	
	@Test
	public void testSC2BOADAOUserFunctions(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		doa.deleteAllUsers();
		int numberofusers=10;
		for(int i = 0;i<numberofusers;i++){
			User user = new User();
			user.setPassword("password 12345"+i);
			user.setUsername("user "+i);
			user.setEmail("user"+i+"@google.com");
			doa.saveUser(user);
		}
		
		List<User> list = doa.getUsers();
		System.out.println("list count: "+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("current user: "+list.get(i).getUsername()+" id: "+list.get(i).getId()+" pw: "+list.get(i).getPassword()+"  authorities: "+list.get(i).getAuthorities());
		}
		assertTrue(list.size()==numberofusers);
		
		doa.deleteAllUsers();
	}

}
