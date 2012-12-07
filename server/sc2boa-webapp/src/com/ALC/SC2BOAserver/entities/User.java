package com.ALC.SC2BOAserver.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.ALC.SC2BOAserver.util.DEBUG;


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
	List<String> builds = new ArrayList<String>();//strings representing the IDs of this users currently selected builds
	//Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	List<String> authorities= new ArrayList<String>();
	
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
	public void setBuilds(List<String> list){
		this.builds = list;
	}
	
	public List<String> getBuilds(){
		return this.builds;
	}
	public void setAuths(List<String> auths){
		this.authorities = auths;
	}
	
	public List<String> getAuths(){
		return this.authorities;
	}
	
	@Override
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(String authority: authorities){
			auths.add(new GrantedAuthorityImpl(authority) );
		}
		return auths;
	}
	
	
	
	public void addAuthority(GrantedAuthority auth){
		this.authorities.add(auth.toString());
	}
	
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;//hardwire to true  for now
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;//hardwire to true  for now
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;//hardwire to true  for now
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;//hardwire to true  for now
	}
	
	public String toString(){
		return "user: "+this.username+"  email: "+this.email+" pw: "+this.password;
	}
	public void clearPassword() {
		this.password=null;
	}
}


