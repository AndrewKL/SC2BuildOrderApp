package com.alc.sc2boa;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuildOrder {
	
	@Id
	private long id;
	private String buildName;
	private String buildOrderInstructions;
	private int race;
	private float rating;
	
	public final static String zerg = "zerg";
	public final static String protoss = "protoss";
	public final static String terran = "terran";
	public final static String[] races = {"zerg","protoss","terran","other"};
	
	
	public BuildOrder()
	{
		race=3;//other
		buildName=null;
		buildOrderInstructions=null;
	}
	public BuildOrder(String name, String order,int setrace,long setid)
	{
		this.id=setid;
		this.race = setrace;
		this.buildName=name;
		this.buildOrderInstructions=order;
		this.rating=0;
	}
	public void setBuildName(String name)
	{
		this.buildName=name;
	}
	public void setBuildOrderInstructions(String instructions)
	{
		this.buildOrderInstructions = instructions;
	}
	public void setRace(int raceon)
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
	public int GetRace()
	{
		return race;
	}
	public String GetRaceHTML(){
		if(race==0){
			return "<font color=\"red\">Zerg</font>";
		}else if(race==2){
			return "<font color=\"blue\">Terran</font>";
		}else if(race==1){
			return "<font color=\"#00FF00\">Protoss</font>";//green color
		}else{
			return "<font color=\"#00FF00\">other</font>";//green color
		}
	}
	
	public int compareTo(BuildOrder another) {
        if (another == null) return 1;
        // sort descending, most recent first
        return another.GetName().compareTo(buildName);
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
	
	
	
	
	
	public void setRating(float float1) {
		this.rating=float1;
		
	}
	public float getRating(){
		return rating;
	}
	
	

}

