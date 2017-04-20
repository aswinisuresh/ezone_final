<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>

<nav class="navbar navbar-default" style="background-color: black;">
 <div class="container-fluid">
  
<div class="navbar-header">
<a class="navbar-brand" href="Home">eZone Shopping cart</a>
</div>
<ul class="nav navbar-nav">
<!-- <li class="active"><a href="Home">Home</a></li> -->
<li><a href="Home" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-home"></span> Home</a></li>
          <c:if test="${empty UID }"><li id="effect"><a href="Login" style="color:white">Login</a></li></c:if>
    	<c:if test="${empty SUCC }"><li id="effect"><a href="Registration" style="color:white">Register</a></li></c:if>
    	<c:if test="${not empty showAdmin }"><li id="effect"><a href="Admin" style="color:white">Admin</a></li></c:if>
    	<c:if test="${(not empty UID) and (not empty SUCC)}">
    	<li id="effect"><a href="Logout" style="color:white">Logout</a></li>
    	</c:if>
       <li><a href="AboutUs">Aboutus</a></li>
       <li><a href="ContactUs">Contactus</a></li>
       <c:if test="${(not empty UID) and (empty showAdmin) }"><li> <a href="ProductView" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-shopping-cart"></span> Cart</a> </li></c:if>
           
</ul>
</div>
</nav>

</body>
</html>