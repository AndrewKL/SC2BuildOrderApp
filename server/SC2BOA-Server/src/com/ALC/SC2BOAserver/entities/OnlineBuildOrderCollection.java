package com.ALC.SC2BOAserver.entities;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class OnlineBuildOrderCollection {
	@JsonProperty("builds")
	private List<OnlineBuildOrder> onlineBuildOrderCollection;
	
	public List<OnlineBuildOrder> getBuilds(){
		return onlineBuildOrderCollection;
	}
	
	public void setBuilds(List<OnlineBuildOrder> list){
		this.onlineBuildOrderCollection=list;
	}

}