package com.ALC.sc2boa;

public class BuildOrder {
	private String buildName;
	private String buildOrderInstructions;
	private String race;
	private long id;
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
	public String GetRaceHTML(){
		if(race.matches("zerg")){
			return "<font color=\"red\">Zerg</font>";
		}else if(race.matches("terran")){
			return "<font color=\"blue\">Terran</font>";
		}else if(race.matches("protoss")){
			return "<font color=\"#00FF00\">Protoss</font>";//green color
		}else{
			return "<font color=\"#00FF00\">"+this.race+"</font>";//green color
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
	
	public int getIcon() {
		if(race.matches("zerg")){
			return R.drawable.mini_zerg_icon;
		}else if(race.matches("terran")){
			return R.drawable.mini_terran_icon;
		}else if(race.matches("protoss")){
			return R.drawable.mini_protoss_icon;//green color
		}else{
			return R.drawable.mini_random_icon;
		}
	}
	
	

}
