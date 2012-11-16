package com.ALC.sc2boav2;

import com.ALC.sc2boav2.PMF;

import com.google.api.server.spi.config.Api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "onlinebuildorderendpoint")
public class OnlineBuildOrderEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method.
	 *
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	public List<OnlineBuildOrder> listOnlineBuildOrder() {
		PersistenceManager mgr = getPersistenceManager();
		List<OnlineBuildOrder> result = new ArrayList<OnlineBuildOrder>();
		try {
			Query query = mgr.newQuery(OnlineBuildOrder.class);
			for (Object obj : (List<Object>) query.execute()) {
				result.add(((OnlineBuildOrder) obj));
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
	public OnlineBuildOrder getOnlineBuildOrder(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		OnlineBuildOrder onlinebuildorder = null;
		try {
			onlinebuildorder = mgr.getObjectById(OnlineBuildOrder.class, id);
		} finally {
			mgr.close();
		}
		return onlinebuildorder;
	}

	/**
	 * This inserts the entity into App Engine datastore.
	 * It uses HTTP POST method.
	 *
	 * @param onlinebuildorder the entity to be inserted.
	 * @return The inserted entity.
	 */
	public OnlineBuildOrder insertOnlineBuildOrder(
			OnlineBuildOrder onlinebuildorder) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(onlinebuildorder);
		} finally {
			mgr.close();
		}
		return onlinebuildorder;
	}

	/**
	 * This method is used for updating a entity.
	 * It uses HTTP PUT method.
	 *
	 * @param onlinebuildorder the entity to be updated.
	 * @return The updated entity.
	 */
	public OnlineBuildOrder updateOnlineBuildOrder(
			OnlineBuildOrder onlinebuildorder) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(onlinebuildorder);
		} finally {
			mgr.close();
		}
		return onlinebuildorder;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	public OnlineBuildOrder removeOnlineBuildOrder(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		OnlineBuildOrder onlinebuildorder = null;
		try {
			onlinebuildorder = mgr.getObjectById(OnlineBuildOrder.class, id);
			mgr.deletePersistent(onlinebuildorder);
		} finally {
			mgr.close();
		}
		return onlinebuildorder;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}