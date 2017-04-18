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
<style>
.active {
    background-color: #4CAF50;
}
</style>
</head>
<body>

<%--  <h3> <center style="color:Maroon"> ezone Shopping Cart</center></h3> --%>

<!-- <nav class="navbar navbar-light" style="background-color: #DB7093;"> -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  
  <div class="navbar-header">
<a class="navbar-brand" href="Home">ezone Shopping cart</a>
</div>
   <ul class="nav navbar-nav">
    <li class="active"><a href="Home">Home</a></li>
      <li><a href="Registration">Registration</a></li>
      <li><a href="AboutUs">About Us</a></li>
      <li><a href="ContactUs">Contact Us</a></li>
      <li><a href="ProductView">ProductView</a></li>
      
      <li><a href="Reg">Reg</a></li>
     <!-- <li class="fa fa-shopping-cart" aria-hidden="true"></li> -->
    
            
   <li> <c:if test="${not empty showAdmin }">
		<a href="Admin">Admin</a> 
		</li>
         </c:if>            
     </ul>

     <!-- <ul class="nav navbar-nav navbar-right">
        <li><a href="Login"><span class="glyphicon glyphicon-log-in">     -->    
<%--   <center>${UID}</center>
<c:if test="${not empty UID}">
 	<a href="Logout">Logout</a>
</c:if>
</span> Login</a>
 <c:if test="${empty UID}">
 <a href="Login">Login</a>
</c:if>  --%>
<!-- </li> -->
   </ul>   
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="ProductView"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    
     <ul class="nav navbar-nav navbar-right">
        <li><a href="Login"><span class="glyphicon glyphicon-log-in">
        </span>  Login</a></li></ul>
     
   </div>
   
<c:if test="${empty UID }"><li id="effect"><a href="Login" style="color:white"></a></li></c:if>
    	<c:if test="${empty SUCC }"><li id="effect"><a href="Registration" style="color:white"></a></li></c:if>
    	<c:if test="${not empty showAdmin }"><li id="effect"><a href="admin" style="color:white"></a></li></c:if>
    	<c:if test="${(not empty UID) and (not empty SUCC)}">
    	<%-- <c:if test="${not empty LogList }"><li id="effect"><a href="ulist" style="color:white">Account Settings</a></li></c:if>
    	<c:if test="${not empty RegList }"><li id="effect"><a href="ulist1" style="color:white">Account Settings</a></li></c:if> --%>
    	<li id="effect"><a href="Logout" style="color:white">Logout</a></li>
    	</c:if>

 </nav>


</body>
</html>