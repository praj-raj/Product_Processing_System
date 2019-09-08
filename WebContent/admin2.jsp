<%@page import="java.util.ArrayList"%>
<%@page import="com.rdec.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="style1.css">
		 <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700%7CPT+Serif:400,700,400italic' rel='stylesheet'>
		  <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans" rel="stylesheet">
</head>
<body>
	<%List<Product> list1=(List<Product>)request.getAttribute("list");%>
<%session.setAttribute("list",list1); %>
	<div class="bgimage">
		<div class="menu">
			
			<div class="leftmenu">
				<h4> ADMIN </h4>
			</div>

			<div class="rightmenu">
				<ul>
					<li id="fisrtlist"> HOME </li>
					<li> Users</li>
					<li> Add Product</li>
					
				</ul>
			</div>

		</div>
			<h1 style="text-align:center; color:white;">Catagery</h1>
		<div class="rightmenu" >
	
			<ul ><%List<String> s=new ArrayList<String>();%>
			<% for(Product u:list1){%>
<%
if(!s.contains(u.getPcatagery())){
s.add(u.getPcatagery());
 }}%>
			<% for(String u:s){%>
	
	
<li><h1 ><a href="Product1.jsp?action=<%=u%>"><%=u %></a></h1></li><%} %></ul>
</div>

		<div class="text" >
		

			<a href="Product.jsp"><button id="buttonone">Add Product</button></a>
			<a href="UserController?action=displayAll"><button id="buttontwo">User</button> </a>
		</div>

	</div>

</body>
</html>