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
package com.ALC.SC2BOAserver.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.ALC.SC2BOAserver.entities.BuildOrderCollection;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;
import com.ALC.SC2BOAserver.entities.User;


public interface SC2BOADAO {
	//dao = data access object
	
	
	
	//build order related methods
	public OnlineBuildOrder getOnlineBuildOrder(String id);
	public void addOnlineBuildOrder(OnlineBuildOrder buildorder);
	public void deleteOnlineBuildOrder(OnlineBuildOrder buildorder);
	public void deleteOnlineBuildOrder(String buildorderId);
	public void deleteAllOnlineBuildOrders();
	public List<OnlineBuildOrder> getAllOnlineBuildOrders();
	public List<OnlineBuildOrder> searchOnlineBuildOrderByName(String name);
	
	//User related methods
	public User getUserByID(String id);
	public User getUserByUsername (String username);
	public User getUserByEmail(String email);
	public List<User> getUsers ();
	public void saveUser (User user);
	public void deleteUser (User user);
	public void deleteAllUsers();
	
	//default builds
	public void setDefaultBuilds(List<OnlineBuildOrder> list);
	public List<String> getIdsOfDefaultBuilds();
	public List<OnlineBuildOrder> getDefaultBuilds();
	
	
	
	
	
	
	
	
	
	/*
	//Journal related methods
	public Journal getJournal (String journalId);
	
	//Get first journal (convenience method since we only ever have one in this release)
	public Journal getJournal ();
	public void saveJournal (Journal journal);
	public void deleteJournal (Journal journal);
	public List<Journal> getJournals ();
	
	//Entry related methods
	public Entry getEntry (String entryId);
	public void saveEntry (Entry entry);
	public void deleteEntry (Entry entry) ;
	public List<Entry> getEntries(Journal journal);
	
	//Comment releated methods
	public List<Comment> getComments (Entry entry);
	public Comment getComment (String commentId);
	public void saveComment(Comment comment);
	public void saveCommenter(Commenter commenter);
	public void deleteComment(Comment comment);
	public void deleteCommenter(Commenter commenter);
	
	
	//Photo related methods
	public void savePhoto(Photo photo);
	public Photo getPhoto(String photoId);
	public List<Photo> getPhotos(Entry entry);
	public void deletePhoto(Photo photo);
	
	//User related methods
	public User getUser (String username);
	public List<User> getUsers ();
	public void saveUser (User user);
	public void deleteUser (User user);
	
	*/

}
