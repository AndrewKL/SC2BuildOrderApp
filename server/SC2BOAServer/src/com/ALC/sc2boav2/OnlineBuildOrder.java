package com.ALC.sc2boav2;

import com.google.appengine.api.datastore.Text;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey; 


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class OnlineBuildOrder {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	private String buildName;
	private Text buildOrderInstructions;
	private String race;
	private float rating;
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
	public Text getBuildOrderInstructions() {
		return buildOrderInstructions;
	}
	public void setBuildOrderInstructions(Text buildOrderInstructions) {
		this.buildOrderInstructions = buildOrderInstructions;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public Long getId() {
		return id;
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

