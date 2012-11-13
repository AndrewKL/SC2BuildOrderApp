package com.ALC.sc2boa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServerBuildOrderDBManager {
	String serveraddress = "";
	String username = "bigljhkx_sc2boa";
	String password = "05410021";
	
	public ServerBuildOrderDBManager(){
	
	}
	
	public void exampleFunction() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailer",username,password);
		  //Find customer information where the customer ID is maximum
		  PreparedStatement statement =  con.prepareStatement("SELECT * FROM customers WHERE C_ID = (SELECT MAX(C_ID) FROM customers)");
		  ResultSet result = statement.executeQuery();
	}

}
