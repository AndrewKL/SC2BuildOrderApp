package com.ALC.SC2BOAserver.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;


public class SpringAuthenticator implements UserDetailsService {


	public SpringAuthenticator() throws Exception {
		super();
	}

	private SC2BOADAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserDetails details = dao.getUser(username);
		if (details == null) {
			throw new UsernameNotFoundException("Unknown user: "+username);
		}
		return details;
	}
	
	
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException, DataAccessException {
		UserDetails details = dao.getUserByEmail(email);
		if (details == null) {
			throw new UsernameNotFoundException("Unknown user: "+email);
		}
		return details;
	}

    @Autowired
    public void setSC2BOADAO (SC2BOADAO dao) {
    	this.dao = dao;
    }

	

}
