package com.ALC.SC2BOAserver.tests;

import java.util.ArrayList;
import java.util.List;

import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrderCollection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/test-beans.xml","/WEB-INF/application-context.xml"})
@ContextConfiguration({"file:test/applicationContext.xml","/test-beans.xml"})    


public class OnlineBuildOrderControllerTest {

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
 
	@Test
	public void restJsonClientTest() {
		System.out.println("starting test");
		
		
  
		OnlineBuildOrderCollection builds = restTemplate.getForObject("http://localhost:8080/SC2BOA-Server/rest/buildorder/getall.json", OnlineBuildOrderCollection.class);
		System.out.println("got collection");
		List<OnlineBuildOrder> buildorder = builds.getBuilds();//restTemplate.getForObject("http://localhost:8080/SC2BOA-Server/rest/buildorder/getall.json", List.class);
		System.out.println("got builds");
  
		Assert.assertNotNull(buildorder);
		Assert.assertTrue(buildorder.size() > 0);
	}
 
	
}
