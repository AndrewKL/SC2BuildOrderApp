/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.ALC.SC2BOAserver.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.ALC.SC2BOAserver.aws.S3StorageManager;
import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.Configuration;
import com.ALC.SC2BOAserver.util.StageUtils;

import com.spaceprogram.simplejpa.EntityManagerFactoryImpl;

public class SC2BOADAOSimpleDBImpl implements SC2BOADAO {
	private static final String DefaultBuildsListUser = "DefaultBuildsUser-012344322341234123412344";//this user holds the list of default builds
	
	

    private static Map<String, String> properties;// = new HashMap<String, String>();
    static {
        init(false);
    }

    private static EntityManagerFactoryImpl factory;// = new EntityManagerFactoryImpl("TravelLog" + StageUtils.getResourceSuffixForCurrentStage(), properties);
    
    
    public SC2BOADAOSimpleDBImpl(){
    	
    }
    public SC2BOADAOSimpleDBImpl(Boolean isatest){
    	if(isatest)init(isatest);
    }
    
	private static void init(Boolean isatest) {
		String testingarea = "";
		if(isatest)testingarea="test";
		properties = new HashMap<String, String>();
		properties.put(
                "lobBucketName",
                S3StorageManager.getKey().toLowerCase() + "-sc2boa"+testingarea+"-lob"
                        + StageUtils.getResourceSuffixForCurrentStage());
        Configuration config = Configuration.getInstance();
        if ( config.getServiceEndpoint(Configuration.S3_ENDPOINT_KEY) != null ) {
            properties.put("s3endpoint", config.getServiceEndpoint(Configuration.S3_ENDPOINT_KEY));
        }
        if ( config.getServiceEndpoint(Configuration.SIMPLE_DB_ENDPOINT_KEY) != null ) {
            properties.put("sdbEndpoint", config.getServiceEndpoint(Configuration.SIMPLE_DB_ENDPOINT_KEY));
        }
        
        factory = new EntityManagerFactoryImpl("sc2boa"
                + StageUtils.getResourceSuffixForCurrentStage(), properties);
	}


	@Override
	public OnlineBuildOrder getOnlineBuildOrder(String id) {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select onlinebuildorder from com.ALC.SC2BOAserver.entities.OnlineBuildOrder u where u.id=:id");
            query.setParameter("id", id);
            //TODO check query
            return (OnlineBuildOrder)query.getSingleResult();
        }
        catch (NoResultException e) {
            //No matching result so return null
            return null;
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		
	}

	@Override
	public void addOnlineBuildOrder(OnlineBuildOrder buildorder) {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            em.persist(buildorder);
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		// TODO check this
		
	}

	@Override
	public void deleteOnlineBuildOrder(OnlineBuildOrder buildorder) {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            em.remove(buildorder);
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		// TODO check this
		
	}
	
	@Override
	public void deleteAllOnlineBuildOrders() {
		List<OnlineBuildOrder> list = this.getAllOnlineBuildOrders();
		for(int i =0;i<list.size();i++){
			this.deleteOnlineBuildOrder(list.get(i));
		}
		// TODO check this
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OnlineBuildOrder> getAllOnlineBuildOrders() {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select all from com.ALC.SC2BOAserver.entities.OnlineBuildOrder");
            //TODO check this query
            return (List<OnlineBuildOrder>)query.getResultList();
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
	}

	@Override
	public User getUser(String username) {
        EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.username=:username");
            query.setParameter("username", username);
            return (User)query.getSingleResult();
        }
        catch (NoResultException e) {
            //No matching result so return null
            return null;
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
    }
	
	@Override
	public User getUserByEmail(String email) {
		//TODO test this
        EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.email=:email");
            query.setParameter("email", email);
            return (User)query.getSingleResult();
        }
        catch (NoResultException e) {
            //No matching result so return null
            return null;
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
    }


    
	@Override
	public void saveUser(User user) {
        EntityManager em = null;

        try {
            em = factory.createEntityManager();
            em.persist(user);
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
    }


	@Override
	public void deleteUser(User user) {
        EntityManager em = null;

        try {
            em = factory.createEntityManager();
            em.remove(user);
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select j from com.ALC.SC2BOAserver.entities.User j");
            //TODO check this query
            return (List<User>)query.getResultList();
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
	}

	@Override
	public void deleteAllUsers() {
		List<User> list = this.getUsers();
		for(int i =0;i<list.size();i++){
			this.deleteUser(list.get(i));
		}
		
	}
	@Override
	public void setDefaultBuilds(List<OnlineBuildOrder> list) {
		//stores the default builds by storing the list with a user
		EntityManager em = null;
		User defaultBuildsUser;
		

        try {
        	em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.username=:username");
            query.setParameter("username", SC2BOADAOSimpleDBImpl.DefaultBuildsListUser);
            defaultBuildsUser = (User)query.getSingleResult();
            if(defaultBuildsUser==null){//test to see if no build exists
            	defaultBuildsUser=new User();
            	defaultBuildsUser.setUsername(SC2BOADAOSimpleDBImpl.DefaultBuildsListUser);
            }
            defaultBuildsUser.setBuilds(list);
            em = factory.createEntityManager();
            em.persist(defaultBuildsUser);
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		// TODO need to test this
		
	}
	@Override
	public List<OnlineBuildOrder> getDefaultBuilds() {
		EntityManager em = null;
		User user =null;
		try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.username=:username");
            query.setParameter("username", SC2BOADAOSimpleDBImpl.DefaultBuildsListUser);
            user = (User)query.getSingleResult();
        }
        catch (NoResultException e) {
            
            return null;
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		return user.getBuilds();
		
		
		// TODO check this
	}

	
    
}
