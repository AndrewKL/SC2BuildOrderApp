package com.ALC.SC2BOAserver.entities;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class BuildOrderCollection {
	
	@JsonProperty("builds")
	private List<OnlineBuildOrder> builds;
	
	public List<OnlineBuildOrder> getBuilds(){
		return builds;
	}
	
	public void setBuilds(List<OnlineBuildOrder> list){
		this.builds=list;
	}

}