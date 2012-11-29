package com.ALC.sc2boav2;

import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class SC2BOAUser {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long userID;
	String email;
	String nickname;
	Boolean isAdmin;
	
	@Persistent
	Set<OnlineBuildOrder> userBuildOrderList;//used to store the IDs of the Build Orders
	
	public void setUserID(Long id){
		this.userID=id;
	}
	public Long getID(){
		return userID;
	}
	
	public void setEmail(String useremail){
		this.email=useremail;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setAdmin(Boolean setadmin){
		this.isAdmin=setadmin;
	}
	public Boolean getIsAdmin(){
		return isAdmin;
	}
	public void setNickname(String nick){
		this.nickname=nick;
	}
	
}
