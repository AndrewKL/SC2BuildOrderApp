package com.ALC.sc2boav2;

import com.ALC.sc2boav2.PMF;

import com.google.api.server.spi.config.Api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "defaultbuildorderendpoint")
public class DefaultBuildOrderEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method.
	 *
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	public List<DefaultBuildOrder> listDefaultBuildOrder() {
		PersistenceManager mgr = getPersistenceManager();
		List<DefaultBuildOrder> result = new ArrayList<DefaultBuildOrder>();
		try {
			Query query = mgr.newQuery(DefaultBuildOrder.class);
			for (Object obj : (List<Object>) query.execute()) {
				result.add(((DefaultBuildOrder) obj));
			}
		} finally {
			mgr.close();
		}
		return result;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	public DefaultBuildOrder getDefaultBuildOrder(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		DefaultBuildOrder defaultbuildorder = null;
		try {
			defaultbuildorder = mgr.getObjectById(DefaultBuildOrder.class, id);
		} finally {
			mgr.close();
		}
		return defaultbuildorder;
	}

	/**
	 * This inserts the entity into App Engine datastore.
	 * It uses HTTP POST method.
	 *
	 * @param defaultbuildorder the entity to be inserted.
	 * @return The inserted entity.
	 */
	public DefaultBuildOrder insertDefaultBuildOrder(
			DefaultBuildOrder defaultbuildorder) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(defaultbuildorder);
		} finally {
			mgr.close();
		}
		return defaultbuildorder;
	}
	
	/**
	 * This inserts the entity into App Engine datastore.
	 * It uses HTTP POST method.
	 * 
	 * takes in the key of the online build order to insert in the to default database.
	 *
	 * @param defaultbuildorder the entity to be inserted.
	 * @return The inserted entity.
	 */
	public DefaultBuildOrder insertOnlineBuildOrder(@Named("id")Long onlineBuildOrderID) {
		PersistenceManager mgr = getPersistenceManager();
		OnlineBuildOrder onlinebuildorder =null;
		DefaultBuildOrder defaultbuildorder =null;
		try {
			onlinebuildorder = mgr.getObjectById(OnlineBuildOrder.class, onlineBuildOrderID);
			defaultbuildorder = new DefaultBuildOrder();
			defaultbuildorder.setBuildOrder(onlinebuildorder);
			mgr.makePersistent(defaultbuildorder);
		} finally {
			mgr.close();
		}

		return defaultbuildorder;
	}

	/**
	 * This method is used for updating a entity.
	 * It uses HTTP PUT method.
	 *
	 * @param defaultbuildorder the entity to be updated.
	 * @return The updated entity.
	 */
	public DefaultBuildOrder updateDefaultBuildOrder(
			DefaultBuildOrder defaultbuildorder) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(defaultbuildorder);
		} finally {
			mgr.close();
		}
		return defaultbuildorder;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	public DefaultBuildOrder removeDefaultBuildOrder(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		DefaultBuildOrder defaultbuildorder = null;
		try {
			defaultbuildorder = mgr.getObjectById(DefaultBuildOrder.class, id);
			mgr.deletePersistent(defaultbuildorder);
		} finally {
			mgr.close();
		}
		return defaultbuildorder;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
