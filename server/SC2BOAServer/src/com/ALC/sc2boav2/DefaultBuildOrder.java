package com.ALC.sc2boav2;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DefaultBuildOrder {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long userID;
	
	@Persistent
	OnlineBuildOrder onlinebuildorder;
	
	public void setBuildOrder(OnlineBuildOrder buildorder){
		onlinebuildorder = buildorder;
	}
	
	public OnlineBuildOrder getBuildOrder(){
		return onlinebuildorder;
	}

}
