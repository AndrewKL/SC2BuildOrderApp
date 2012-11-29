/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.ALC.SC2BOAserver.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.Configuration;
import com.ALC.SC2BOAserver.util.DataExtractor;
import com.ALC.SC2BOAserver.util.DataLoader;

/**
 * This is the core of the TravelLog functionality.  It's a Spring controller implemented
 * using annotations.  Most methods for loading and storing journals, entries, comments and photos
 * are initiated in this class.
 */
@Controller
public class SC2BOAserverController {

    private SC2BOADAO dao;
    private static final Logger logger=Logger.getLogger(SC2BOAserverController.class.getName());


    /**
     * AWS Elastic Beanstalk checks your application's health by periodically
     * sending an HTTP HEAD request to a resource in your application. By
     * default, this is the root or default resource in your application,
     * but can be configured for each environment.
     *
     * Here, we report success as long as the app server is up, but skip
     * generating the whole page since this is a HEAD request only. You
     * can employ more sophisticated health checks in your application.
     *
     * @param model the spring model for the request
     */
    @RequestMapping(value="/home.do", method=RequestMethod.HEAD)
    public void doHealthCheck(HttpServletResponse response) {
        response.setContentLength(0);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * The main request handler that builds out the home page for the journal
     * @param model the spring model for the request
     */
    @RequestMapping(value="/home.do", method={RequestMethod.GET, RequestMethod.POST})
    public void doHome (ModelMap model) {
    	//TODO create home page or redesign what this is supposed todo
        
        
    }

    



    //===========================onlinebuildorderfunctions========================
    
    @RequestMapping("/deleteOnlineBuildOrder.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView doDeleteOnlineBuildOrder (@RequestParam("entryId") String buildorderId, ModelMap map) {
        OnlineBuildOrder buildorder = dao.getOnlineBuildOrder(buildorderId);
        dao.deleteOnlineBuildOrder(buildorder);
        doHome(map);
        return new ModelAndView("redirect:home.do");
        //TODO check this
    }
    
    @RequestMapping("/addOnlineBuildOrder.do")
    //@Secured("ROLE_ADMIN")
    public ModelAndView addOnlineBuildOrder (@RequestParam("buildname") String buildname,
    		@RequestParam("buildinstructions") String buildinstructions,
    		@RequestParam("race") String race,
    		ModelMap map) {
        OnlineBuildOrder buildorder = new OnlineBuildOrder();
        buildorder.setBuildName(buildname);
        buildorder.setBuildOrderInstructions(buildinstructions);
        buildorder.setRace(race);
        
        dao.addOnlineBuildOrder(buildorder);
    	
        doHome(map);
        return new ModelAndView("redirect:home.do");
        //TODO check this
    }
    
    
    //=====================UserFunctions=====================
    
    /**
     * If we have a login failure this request mapping flags the error to be shown
     * in the UI.
     * @param model the spring model for the request
     */
    @RequestMapping ("/loginFailure.do")
    public ModelAndView doLoginFailure (ModelMap map) {
        map.addAttribute("popupScreen","login_div");
        doHome(map);
        return new ModelAndView("home", map);
    }

    
    @RequestMapping("/createAccount.do")
    public ModelAndView doCreateAccount (User user,  BindingResult result, ModelMap map,
      @RequestParam("password2") String password2) {

        //Verify user info submission
    	
        if (user.getUsername().equals("")) {
            result.reject("username", "Username cannot be blank");
        }
        if (user.getPassword().equals("")) {
            result.reject("password", "Password cannot be blank");
        }
        if (!user.getPassword().equals(password2)) {
            result.reject("password", "Passwords do not match");
        }

        if (result.hasErrors()) {
            doHome(map);
            return new ModelAndView("home", map);
        }

        // check to make sure we don't have a user account already
        //TODO this looks very slow
        List<User> users = dao.getUsers();
        if (users.size() > 0) {
            result.reject("username", "The admin user already exists");
            return new ModelAndView("home", map);
        } else {
            dao.saveUser(user);
            map.addAttribute("usercreated", true);
        }

        doHome(map);
        return new ModelAndView("redirect:home.do");
        //TODO test this

    }

    @RequestMapping("/logout.do")
    public void doLogout (HttpServletResponse response) throws IOException {
        response.sendRedirect("home.do");
    }
    
    //================================AdminFunctions===================

    @RequestMapping("/backupRestore.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView doBackupRestore (ModelMap map, @RequestParam("backupBucket") String bucketName,
        @RequestParam("backupPath") String storagePath, @RequestParam("backupRestoreFlag") String flag) {

        final Thread thread;
        if (flag.equals("backup")) {
            DataExtractor extractor = new DataExtractor(bucketName,storagePath,dao);
            thread = new Thread(extractor);
        }
        else {
            DataLoader loader = new DataLoader(bucketName, storagePath, dao);
            thread = new Thread(loader);
        }

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        doHome(map);
        return new ModelAndView("redirect:home.do");
    }


    @Autowired
    public void setSC2BOADAO (SC2BOADAO dao) {
        this.dao = dao;
    }

    /**
     * Method establishes the transformation of incoming date strings into Date objects
     * @param binder the spring databinder object that we connect to the date editor
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


}
