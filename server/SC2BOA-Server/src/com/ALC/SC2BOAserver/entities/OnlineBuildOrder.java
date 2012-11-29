package com.ALC.SC2BOAserver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineBuildOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String buildName;
	private String buildOrderInstructions;
	private String race;
	private float rating;
	
	//=========================================
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getBuildOrderInstructions() {
		return buildOrderInstructions;
	}
	public void setBuildOrderInstructions(String buildOrderInstructions) {
		this.buildOrderInstructions = buildOrderInstructions;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		this.id=Id;
	}
	
	//======================================================
	
	
	public static OnlineBuildOrder merge(OnlineBuildOrder old,OnlineBuildOrder newbuild){
		if (newbuild.getBuildName() != null)
			 old.setBuildName(newbuild.getBuildName());
		 if (newbuild.getBuildOrderInstructions() != null)
			 old.setBuildOrderInstructions(newbuild.getBuildOrderInstructions());
		 return old;
		
	}
}