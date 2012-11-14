package com.ALC.sc2boaserver;

import com.ALC.sc2boaserver.EMF;

import com.google.api.server.spi.config.Api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "buildorderendpoint")
public class BuildOrderEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method.
	 *
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	public List<BuildOrder> listBuildOrder() {
		EntityManager mgr = getEntityManager();
		List<BuildOrder> result = new ArrayList<BuildOrder>();
		try {
			Query query = mgr
					.createQuery("select from BuildOrder as BuildOrder");
			for (Object obj : (List<Object>) query.getResultList()) {
				result.add(((BuildOrder) obj));
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
	public BuildOrder getBuildOrder(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		BuildOrder buildorder = null;
		try {
			buildorder = mgr.find(BuildOrder.class, id);
		} finally {
			mgr.close();
		}
		return buildorder;
	}

	/**
	 * This inserts the entity into App Engine datastore.
	 * It uses HTTP POST method.
	 *
	 * @param buildorder the entity to be inserted.
	 * @return The inserted entity.
	 */
	public BuildOrder insertBuildOrder(BuildOrder buildorder) {
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(buildorder);
		} finally {
			mgr.close();
		}
		return buildorder;
	}

	/**
	 * This method is used for updating a entity.
	 * It uses HTTP PUT method.
	 *
	 * @param buildorder the entity to be updated.
	 * @return The updated entity.
	 */
	public BuildOrder updateBuildOrder(BuildOrder buildorder) {
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(buildorder);
		} finally {
			mgr.close();
		}
		return buildorder;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	public BuildOrder removeBuildOrder(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		BuildOrder buildorder = null;
		try {
			buildorder = mgr.find(BuildOrder.class, id);
			mgr.remove(buildorder);
		} finally {
			mgr.close();
		}
		return buildorder;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
