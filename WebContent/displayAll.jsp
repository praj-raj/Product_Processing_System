<%@page import="com.rdec.models.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style1.css" />
</head>
<body style="color:white; background-color:orange">
	<div class="menu">
			
			<div class="leftmenu">
				<a href="admin.jsp"><h4> Back </h4></a>
			</div>
			

			<div class="rightmenu">
				<ul>
					<a><li id="fisrtlist"> HOME </li>
					<a href="UserController?action=login&name=default&password=default"><li>Product</li></a>
					<a href="Login.jsp"><li>Admin</li></a>
					<a href="UserController?action=logout"><li>Logout</li></a>
					<a href="Registration.jsp"><li>Register </li></a>
					<li>contact</li>
				</ul>
			</div>

		</div>
<h1>LIST OF ALL USERS</h1>
<%
List<User> list=(List<User>)request.getAttribute("list");
%>
<table border="3" width="70%">
		<tr>
			<th>ID</th>
			<th>Email</th>
			<th>Password</th>
			<th>UserType</th>
		    <th>Login Status</th>
			<th>UPDATE</th>
			<th>DELETE</th>
	
			
		</tr>
		<% for(User u:list){%>
		<tr>
		<td><%=u.getId() %></td>
		<td><%=u.getEmail() %></td>
		
		<td><%=u.getPass() %></td>
		<td><%=u.getUserType() %></td>
		<td><%=u.getLoginStatus() %></td>
		
		<td><a style="color:white;" href="UserController?action=searchByIdForUpdate&id=<%=u.getId()%>">update</a></td>
		<td><a style="color:white;" href="UserController?action=searchByIdFordelete&id=<%=u.getId()%>" >delete</a></td>
		</tr>
		<%} %>
		
	</table>
</body>
</html>
