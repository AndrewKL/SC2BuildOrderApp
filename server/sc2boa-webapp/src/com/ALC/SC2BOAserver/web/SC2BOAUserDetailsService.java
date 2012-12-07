package com.ALC.SC2BOAserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.DEBUG;

@Service("userDetailsService")
public class SC2BOAUserDetailsService implements UserDetailsService {
	private SC2BOADAO dao;
	
	public SC2BOAUserDetailsService() throws Exception {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		DEBUG.d("userservicedetails validating: "+username);
		User user  = dao.getUserByUsername(username);
		if(user==null)throw new UsernameNotFoundException(username);
		DEBUG.d("userservicedetails user found: "+user);
		return user;
		// TODO check this
	}
	
	@Autowired
    public void setSC2BOADAO (SC2BOADAO dao) {
        this.dao = dao;
        //TODO check this
    }

}
