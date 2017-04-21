<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>

<div class="container">
<div class="wrapper">


  <form:form  action="./finalcheckout" method="post" commandName="ckout">
  
    <div class="form-group">
    
      <label>NAME:</label>
      <form:input path="name" placeholder="Enter Name" class="form-control" /><br><br>
     
      <label>CONTACT NO:</label>
      <form:input path="contact" placeholder="Enter your contactno" class="form-control" /><br><br>
     
      <label>ADDRESS:</label>
      <form:textarea path="address" placeholder="Enter your Address" rows="8"class="form-control" / ></form:textarea>
      
      <label>STATE:</label>
      <form:input path="state" placeholder="Enter your state name" class="form-control" /><br><br>
     
     <label>CITY:</label>
      <form:input path="city" placeholder="Enter your city name " class="form-control" /><br><br>
     
     <label>PINCODE:</label>
      <form:input path="pincode" placeholder="Enter your pincode" class="form-control" /><br><br>
     
      <br><br><center><button type="submit" class="btn btn-success">SUBMIT</button></center>
      </div>
    </form:form>
    </div>
    </div>
 <jsp:include page="CommonFooter.jsp"></jsp:include>
</body>
</html>