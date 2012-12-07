package com.ALC.SC2BOAserver.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.dao.SC2BOADAOSimpleDBImpl;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.DEBUG;


public class SC2BOADAOSimpleDBImplUnitTests {

	@Test
	public void testSC2BOADOAOnlineBuildOrderFunctions() {
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		
		//delete all build orders
		doa.deleteAllOnlineBuildOrders();
		
		//add build order several build orders
		int numberofbuilds=10;
		generateBuildOrders(doa,numberofbuilds);
		
		
		//get all build orders
		List<OnlineBuildOrder> list = doa.getAllOnlineBuildOrders();
		System.out.println("list count: "+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("current build: "+list.get(i).getBuildName()+" id: "+list.get(i).getId());
		}
		
		//list = doa.getAllOnlineBuildOrders();
		int size = list.size();
		
		assertTrue(size==numberofbuilds);
		DEBUG.d("getting buildorders by id");
		for(int i=0;i<list.size();i++){
			OnlineBuildOrder buildorder = doa.getOnlineBuildOrder(list.get(i).getId());
			System.out.println("current buildorder: "+buildorder.getBuildName()+" id: "+buildorder.getId());
		}
		
		//delete all build orders
		doa.deleteAllOnlineBuildOrders();
		list = doa.getAllOnlineBuildOrders();
		size = list.size();
		
		assertTrue(size==0);
	}
	
	public void generateBuildOrders(SC2BOADAO doa,int numberofbuilds){
		
		for(int i = 0;i<numberofbuilds;i++){
			OnlineBuildOrder buildorder = new OnlineBuildOrder();
			buildorder.setBuildName("testbuild "+i);
			buildorder.setBuildOrderInstructions("1 2 3 4 5 6"+ i);
			buildorder.setRace("terran");
			
			doa.addOnlineBuildOrder(buildorder);
		}
	}
	
	
	
	//User related methods
		
	//public void deleteUser (User user);//TODO
	//public void deleteAllUsers();
	//public User getUser (String username);
	//public void saveUser (User user);
	@Test
	public void testSC2BOADAOUserFunctions(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		DEBUG.d("deleting all users");
		doa.deleteAllUsers();
		DEBUG.d("generating users");
		//addings newusers
		int numberofusers=10;
		generateUsers(doa,numberofusers);
		DEBUG.d("getting all users users");
		List<User> list = doa.getUsers();
		System.out.println("list count: "+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("current user: "+list.get(i).getUsername()+" id: "+list.get(i).getId()+" pw: "+list.get(i).getPassword());
		}
		assertTrue(list.size()==numberofusers);
		DEBUG.d("getting users by email");
		for(int i=0;i<list.size();i++){
			User requesteduser = doa.getUserByEmail(list.get(i).getEmail());
			System.out.println("current user: "+requesteduser.getUsername()+" id: "+requesteduser.getId()+" pw: "+requesteduser.getPassword());
		}
		DEBUG.d("getting users by id");
		for(int i=0;i<list.size();i++){
			User requesteduser = doa.getUserByID(list.get(i).getId());
			System.out.println("current user: "+requesteduser.getUsername()+" id: "+requesteduser.getId()+" pw: "+requesteduser.getPassword());
		}
		DEBUG.d("test authorities");
		for(int i=0;i<list.size();i++){
			User requesteduser = doa.getUserByID(list.get(i).getId());
			System.out.println("current user: "+requesteduser.getUsername()+" Numb auths: "+requesteduser.getAuthorities().size());
		}
		
		/*DEBUG.d("deleting user");
		
		
		doa.deleteUser(list.get(0));
		list = doa.getUsers();
		assertTrue(list.size()==numberofusers);*/
		
		DEBUG.d("deleting all users");
		//cleanup
		doa.deleteAllUsers();
		list = doa.getUsers();
		assertTrue(list.size()==0);
	}
	
	public void generateUsers(SC2BOADAO doa,int numberofusers){
		
		for(int i = 0;i<numberofusers;i++){
			User user = new User();
			user.setPassword("password 12345"+i);
			user.setUsername("user "+i);
			user.setEmail("user"+i+"@google.com");
			user.addAuthority(new GrantedAuthorityImpl("ROLE_USER"));
			doa.saveUser(user);
		}
	}
	public void generateAdmins(SC2BOADAO doa,int numberofusers){
		
		for(int i = 0;i<numberofusers;i++){
			User user = new User();
			user.setPassword("password 12345"+i);
			user.setUsername("Admin"+i);
			user.setEmail("admin"+i+"@google.com");
			user.addAuthority(new GrantedAuthorityImpl("ROLE_ADMIN"));
			doa.saveUser(user);
		}
	}
	
	/*//build order related methods
	
	//public void addOnlineBuildOrder(OnlineBuildOrder buildorder);
	//public void deleteOnlineBuildOrder(OnlineBuildOrder buildorder);
	//public void deleteOnlineBuildOrder(String buildorderId);
	//public void deleteAllOnlineBuildOrders();
	//public List<OnlineBuildOrder> getAllOnlineBuildOrders();
	
	
	
	//default builds
	public void setDefaultBuilds(List<OnlineBuildOrder> list);
	*/
	
	
	
	
	//public List<OnlineBuildOrder> getDefaultBuilds();
	@Test
	public void testUserBuildList(){
		
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		DEBUG.d("wiping db clean");
		//delete all build orders
		doa.deleteAllOnlineBuildOrders();
		doa.deleteAllUsers();
		
		DEBUG.d("generating users");
		//add build order several build orders
		int numberofbuilds=10;
		generateBuildOrders(doa,numberofbuilds);
		
		DEBUG.d("generating users");
		//adding new users
		int numberofusers=10;
		generateUsers(doa,numberofusers);
		
		DEBUG.d("generating user with build list");
		List<OnlineBuildOrder> list = doa.getAllOnlineBuildOrders();
		System.out.println("number of builds: "+list.size());
		
		list = list.subList(0, list.size()/2);	
		System.out.println("trimmed number of builds: "+list.size());
		DEBUG.d("list of builds created created");
		User user = new User();
		user.setPassword("password 12345");
		user.setUsername("userwithbuilds");
		user.setEmail("userwithbuilds@google.com");
		user.setBuilds(OnlineBuildOrder.convertBuildsToIds(list));
		DEBUG.d("created user");
		doa.saveUser(user);
		DEBUG.d("saved user");
		
		User user2 = doa.getUserByEmail("userwithbuilds@google.com");
		
		DEBUG.d("new user with builds: "+user2.getUsername()+" number of user builds: "+user2.getBuilds().size());
		assertTrue(user2.getBuilds().size()==list.size());
		
	}
	//public void saveUser (User user);
	
	
	
	
	@Test
	public void testDefaultBuilds(){
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		DEBUG.d("wiping db clean");
		//delete all build orders
		doa.deleteAllOnlineBuildOrders();
		doa.deleteAllUsers();
		
		DEBUG.d("generating users");
		//add build order several build orders
		int numberofbuilds=10;
		generateBuildOrders(doa,numberofbuilds);
		
		DEBUG.d("generating users");
		//adding new users
		int numberofusers=10;
		generateUsers(doa,numberofusers);
		
		DEBUG.d("generating builds list  for default");
		List<OnlineBuildOrder> list = doa.getAllOnlineBuildOrders();
		System.out.println("number of builds: "+list.size());
		
		list = list.subList(0, list.size()/2);	
		System.out.println("trimmed number of builds: "+list.size());
		DEBUG.d("setting default builds list");
		doa.setDefaultBuilds(list);
		DEBUG.d("getting default builds list");
		list = doa.getDefaultBuilds();
		DEBUG.d("total number of default builds: "+list.size());
		
		
		
		
	}
	
	//public User getUser (String username);
	//public User getUserByEmail(String email);
	//public List<User> getUsers ();
	@Test
	public void testGetUser(){
		//TODO
		SC2BOADAO doa = new SC2BOADAOSimpleDBImpl(true);
		List<User> list = doa.getUsers();
		System.out.println("list count: "+list.size());
		for(int i=0;i<list.size();i++){
			if(list.get(i)!=null)System.out.println("current user: "+list.get(i).getUsername()+" id: "+list.get(i).getId()+" pw: "+list.get(i).getPassword());
		}
		//test getuser
		for(int i=0;i<list.size();i++){
			User user = doa.getUserByID(list.get(i).getId());
		}
		
	}
	
	
}
