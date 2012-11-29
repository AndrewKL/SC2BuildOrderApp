package com.ALC.SC2BOAserver.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements Serializable, UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2304587778749516353L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	String id;
	String username;
	String email;
	String password;//TODO this needs to get converted to a hashed pw
	Boolean isAdmin;
	List<OnlineBuildOrder> builds;
	
	//get setter functions
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String Email){
		this.email=Email;
	}
	public String getEmail(){
		return this.email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBuilds(List<OnlineBuildOrder> list){
		this.builds = list;
	}
	
	public List<OnlineBuildOrder> getBuilds(){
		return this.builds;
	}
	
	//========================
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}


