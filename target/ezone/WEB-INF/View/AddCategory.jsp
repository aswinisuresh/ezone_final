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
<div class="panel-heading">ADD CATEGORY</div>
<div class="panel-body">
  <div class="row">
  	  	
  	<form:form action="validateAddCategory" method ="post">
  	
  	<div class="col-xs-6">
    <div class="input-group">
   
	<span class="input-group-addon">Category Id </span>
      <form:input type="text" class="form-control" path="catid" id="catid" placeholder="Enter Category ID"/>
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Category Name </span>
      <form:input type="text" class="form-control" path="catname" id="catname" placeholder="Enter Category Name"/>
    </div>
    <br>
    
    <div class="input-group">
     <span class="input-group-addon">Category Desc </span>
      <form:input type="text" class="form-control" path="catdesc" id="catdesc" placeholder="Enter Category Description"/>
    </div>
    <br>
           
    <br>
    
    <form:button type="submit" class="btn btn-default"> Add </form:button>
    
    </div>
</form:form>
  
 
</body>
</html>