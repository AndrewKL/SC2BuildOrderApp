package com.ALC.SC2BOAserver.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrderCollection;


@Controller
@RequestMapping(value = "/buildorder")
public class OnlineBuildOrderController {
	private SC2BOADAO dao;
	
	@RequestMapping(value="/getall", method=RequestMethod.GET)
	public OnlineBuildOrderCollection getAllBuildOrders(){
		OnlineBuildOrderCollection collection = new OnlineBuildOrderCollection();
		collection.setBuilds(dao.getAllOnlineBuildOrders());
		return collection;
	}
	
	@Autowired
    public void setSC2BOADAO (SC2BOADAO dao) {
        this.dao = dao;
    }
	
	

}
