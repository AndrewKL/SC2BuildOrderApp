package com.ALC.sc2boav2;

import com.ALC.sc2boav2.PMF;

import com.google.api.server.spi.config.Api;
import com.google.appengine.api.users.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "sc2boauserendpoint")
public class SC2BOAUserEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method.
	 *
	 * @return List of all entities persisted.
	 */
	@SuppressWarnings({ "cast", "unchecked" })
	public List<SC2BOAUser> listSC2BOAUser() {
		PersistenceManager mgr = getPersistenceManager();
		List<SC2BOAUser> result = new ArrayList<SC2BOAUser>();
		try {
			Query query = mgr.newQuery(SC2BOAUser.class);
			for (Object obj : (List<Object>) query.execute()) {
				result.add(((SC2BOAUser) obj));
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
	public SC2BOAUser getSC2BOAUser(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		SC2BOAUser sc2boauser = null;
		try {
			sc2boauser = mgr.getObjectById(SC2BOAUser.class, id);
		} finally {
			mgr.close();
		}
		return sc2boauser;
	}

	/**
	 * This inserts the entity into App Engine datastore.
	 * It uses HTTP POST method.
	 *
	 * @param sc2boauser the entity to be inserted.
	 * @return The inserted entity.
	 */
	/*public SC2BOAUser insertSC2BOAUser(SC2BOAUser sc2boauser) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(sc2boauser);
		} finally {
			mgr.close();
		}
		return sc2boauser;
	}*/
	
	/**
	 * This inserts the entity into App Engine datastore.
	 * It uses HTTP POST method.
	 * 
	 * lets a user create an account.
	 *
	 * 
	 * @return The inserted entity.
	 */
	public SC2BOAUser createSC2BOAUser(User user) {
		SC2BOAUser localuser = new SC2BOAUser();
		localuser.setAdmin(false);
		localuser.setEmail(user.getEmail());
		localuser.setNickname(user.getNickname());
		
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(localuser);
		} finally {
			mgr.close();
		}
		return localuser;
	}

	/**
	 * This method is used for updating a entity.
	 * It uses HTTP PUT method.
	 *
	 * @param sc2boauser the entity to be updated.
	 * @return The updated entity.
	 */
	public SC2BOAUser updateSC2BOAUser(SC2BOAUser sc2boauser) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			mgr.makePersistent(sc2boauser);
		} finally {
			mgr.close();
		}
		return sc2boauser;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 */
	public SC2BOAUser removeSC2BOAUser(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		SC2BOAUser sc2boauser = null;
		try {
			sc2boauser = mgr.getObjectById(SC2BOAUser.class, id);
			mgr.deletePersistent(sc2boauser);
		} finally {
			mgr.close();
		}
		return sc2boauser;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
