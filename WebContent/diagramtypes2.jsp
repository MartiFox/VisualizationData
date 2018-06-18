<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <% response.setContentType("text/html; charset=windows-1251"); %>
<%@ page import="java.util.*" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="https://d3js.org/d3.v5.min.js"></script>
<title>Диаграмма</title>

	<link rel="shortcut icon" href="images/icon.png" type="image/x-icon">
	<!-- Google Webfonts -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,100,500' rel='stylesheet' type='text/css'> 
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css"> 
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Simple Line Icons -->
	<link rel="stylesheet" href="css/simple-line-icons.css">
	<!-- Theme Style -->
	<link rel="stylesheet" href="css/style.css">
	
	<script src="js/d3.v3.min.js" charset="utf-8"></script>
    <script src="js/topojson.v1.min.js"></script>


</head>
<body>
<%Iterator itr;%>
				<% List data= (List)request.getAttribute("data");
				for (itr=data.iterator(); itr.hasNext(); )
				{
				%>
					<tr><td align="center"><%=itr.next()%></td></tr>
				<%}%>
		
</body>
</html>