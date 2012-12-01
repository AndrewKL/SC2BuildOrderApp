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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.ALC.SC2BOAserver.aws.S3StorageManager;
import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.Configuration;
import com.ALC.SC2BOAserver.util.DEBUG;
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
		
		//setup properties
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
        
        //setup persistance unit string
        String persistanceunit = "sc2boa"+ StageUtils.getResourceSuffixForCurrentStage();
        
        //setupfactory
        factory = new EntityManagerFactoryImpl(persistanceunit, properties);
	}


	@Override
	public OnlineBuildOrder getOnlineBuildOrder(String id) {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select onlinebuildorder from com.ALC.SC2BOAserver.entities.OnlineBuildOrder u where u.id=:id");
            query.setParameter("id", id);
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
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OnlineBuildOrder> getAllOnlineBuildOrders() {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select all from com.ALC.SC2BOAserver.entities.OnlineBuildOrder");
            return (List<OnlineBuildOrder>)query.getResultList();
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
	}
	
	@Override
	public User getUserByID(String id) {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.id=:id");
            query.setParameter("id", id);
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
	public User getUserByUsername(String username) {
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
		DEBUG.d("settingdefault builds list");

        try {
        	em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.username=:username");
            query.setParameter("username", SC2BOADAOSimpleDBImpl.DefaultBuildsListUser);
            defaultBuildsUser = (User)query.getSingleResult();
            
            defaultBuildsUser.setBuilds(OnlineBuildOrder.convertBuildsToIds(list));
            em = factory.createEntityManager();
            em.persist(defaultBuildsUser);
        }catch (NoResultException e) {
        	DEBUG.d("noResultsException creating a user to place the default list");
        	defaultBuildsUser=new User();
        	defaultBuildsUser.setUsername(SC2BOADAOSimpleDBImpl.DefaultBuildsListUser);
        	defaultBuildsUser.setBuilds(OnlineBuildOrder.convertBuildsToIds(list));
        	
        	em = factory.createEntityManager();
            em.persist(defaultBuildsUser);
        	
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
	}
	
	@Override
	public List<OnlineBuildOrder> getDefaultBuilds() {
		List<String> idsofbuildstoreturn = getIdsOfDefaultBuilds();
		DEBUG.d("idsofbuildstoreturn size: "+idsofbuildstoreturn.size());
		List<OnlineBuildOrder> list = new ArrayList<OnlineBuildOrder>();
		
		if(idsofbuildstoreturn==null)return null;
		
		for(int i = 0;i<idsofbuildstoreturn.size();i++){
			list.add(this.getOnlineBuildOrder(idsofbuildstoreturn.get(i)));
		}
		return list;
		
	}
		
	@Override
	public List<String> getIdsOfDefaultBuilds() {
		EntityManager em = null;
		User user =null;
		try {
            em = factory.createEntityManager();
            Query query = em.createQuery("select user from com.ALC.SC2BOAserver.entities.User u where u.username=:username");
            query.setParameter("username", SC2BOADAOSimpleDBImpl.DefaultBuildsListUser);
            user = (User)query.getSingleResult();
        }
        catch (NoResultException e) {
            DEBUG.d("no results exception");
            return new ArrayList<String>();
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		return user.getBuilds();
	}
	
	@Override
	public void deleteOnlineBuildOrder(String buildorderId) {
		EntityManager em = null;

        try {
            em = factory.createEntityManager();
            Query query = em.createQuery("delete onlinebuildorder from com.ALC.SC2BOAserver.entities.OnlineBuildOrder u where u.id=:id");
            query.setParameter("id", buildorderId);
            query.executeUpdate();
            //TODO check query
        }
        finally {
            if (em!=null) {
                em.close();
            }
        }
		
	}
}
