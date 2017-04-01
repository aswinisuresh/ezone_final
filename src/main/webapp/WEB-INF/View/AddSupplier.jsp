<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/valid.js"></script>
<title>Insert title here</title>
<jsp:include page="CommonHeader.jsp"></jsp:include> 
</head>
<body>
<div class="container">
 <div class="panel panel-primary" style="width:750px;margin:0px auto">
<div class="panel-heading">ADD Supplier</div>
<div class="panel-body">
  <div class="row">
  	  	
  	<form:form action="validateAddSupplier" method ="post">
  	
  	<div class="col-xs-6">
    <div class="input-group">
   
	<span class="input-group-addon">Supplier Id </span>
      <form:input type="text" class="form-control" path="suppid" id="suppid" placeholder="Enter Supplier ID"/>
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Supplier Name </span>
      <form:input type="text" class="form-control" path="suppname" id="suppname" placeholder="Enter Supplier Name"/>
    </div>
    <br>
    
    <div class="input-group">
     <span class="input-group-addon">Supplier Address </span>
      <form:input type="text" class="form-control" path="suppaddress" id="suppaddress" placeholder="Enter Supplier Address"/>
    </div>
    <br>
           
    <br>
    
    <form:button type="submit" class="btn btn-default"> Add </form:button>
    
    </div>
</form:form>
  
 
</body>
</html>