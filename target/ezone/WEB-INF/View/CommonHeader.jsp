<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<h3> <center> Shopping Cart</center></h3>

<!-- <nav class="navbar navbar-light" style="background-color: #DB7093;"> -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   <ul class="nav navbar-nav">

   <li class="active"><a href="Home">Home</a></li>
  <!--    <li><a href="#">Home</a></li>  -->
<!--       <li><a href="Login">Login</a></li> -->
      <li><a href="Registration">Registration</a></li>
      <li><a href="AboutUs">About Us</a></li>
      <li><a href="ContactUs">Contact Us</a></li>
      <li><a href="Admin">Admin</a></li>
      <li><a href="ProductView">ProductView</a></li>
      <i class="fa fa-shopping-cart" aria-hidden="true"></i>
       <li><a href="ProductDescription">ProductDescription</a></li>
   <!--   <li><a href="AddProduct">AddProduct</a></li> -->
     </ul>

     <ul class="nav navbar-nav navbar-right">
        <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        
         <a href="Home">
          <span class="glyphicon glyphicon-log-out"></span>Logout
        </a>
        <center>${UID}</center><c:if test="${not empty UID}">
 <a href="Logout"></a>
</c:if>

 <c:if test="${empty UID}">
 <a href="Login"></a>
</c:if>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href=""><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    
     
   </div>

 </nav>


</body>
</html>