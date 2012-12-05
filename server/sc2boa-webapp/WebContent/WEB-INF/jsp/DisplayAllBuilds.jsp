<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.ALC.SC2BOAserver.dao.SC2BOADAO"%>
<%@page import="com.ALC.SC2BOAserver.entities.OnlineBuildOrder"%>

<jsp:useBean id="dao" type="com.ALC.SC2BOAserver.dao.SC2BOADAO" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
TEST ! @ #
<br>

<ol> 
<% for (OnlineBuildOrder build : dao.getAllOnlineBuildOrders()) { %>
	<li> <%= build %> </li>
<% } %>
</ol>

</body>
</html>