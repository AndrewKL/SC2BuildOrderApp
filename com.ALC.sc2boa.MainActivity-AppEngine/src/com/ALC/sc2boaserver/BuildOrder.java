package com.ALC.sc2boaserver;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class BuildOrder {
	
	@Id
	private long id;
	private String buildName;
	private String buildOrderInstructions;
	private String race;
	private float rating;
	
	
	public final static String zerg = "zerg";
	public final static String protoss = "protoss";
	public final static String terran = "terran";
	public final String[] races = {"zerg","protoss","terran"};
	public BuildOrder()
	{
		race=null;
		buildName=null;
		buildOrderInstructions=null;
		
	 
	}
	public BuildOrder(String name, String order,String setrace,long setid)
	{
		this.id=setid;
		this.race = setrace;
		this.buildName=name;
		this.buildOrderInstructions=order;
		rating=0;
	}
	public void setBuildName(String name)
	{
		this.buildName=name;
	}
	public void setBuildOrderInstructions(String instructions)
	{
		this.buildOrderInstructions = instructions;
	}
	public void setRace(String raceon)
	{
		this.race = raceon;
	}
	public String GetName()
	{
		return buildName;
	}
	public String GetOrderInstructions()
	{
		return buildOrderInstructions;
	}
	public String GetRace()
	{
		return race;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String toString()
	{
		return buildName;//"B: "+this.buildName+" id: "+this.id+" R: "+this.races.toString()+" instr: "+this.buildOrderInstructions;
	}
	
	
	
	public int GetRaceInt() {
		//R.array.races_array
		//used for spinners
		if(race.matches("zerg")){
			return 2;
		}else if(race.matches("terran")){
			return 0;
		}else if(race.matches("protoss")){
			return 1;//green color
		}else{
			return 0;
		}
	}
	
	public void setRating(float float1) {
		this.rating=float1;
		
	}
	public float getRating(){
		return rating;
	}
	
	

}
