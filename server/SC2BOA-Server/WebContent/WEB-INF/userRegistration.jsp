<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
	<title>User Registration</title>
	</head>
<body>

		<label>Add User</label><br>
		<form:form method="POST" commandName="user">
		<table>
		    <tr>
		        <td>User Name :</td>
		        <td><form:input path="username" /></td>
		    </tr>
		    <tr>
		        <td>email :</td>
		        <td><form:password path="email" /></td>
		    </tr>
		    <tr>
		        <td>Password :</td>
		        <td><form:password path="password" /></td>
		    </tr>
		    
		    <tr>
		        <td colspan="2"><input type="submit" value="Register"></td>
		    </tr>
		</table>
		</form:form>

</body>
</html>