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
<script type="text/javascript" src="js/valid.js"></script>
<title>Insert title here</title>
<jsp:include page="CommonHeader.jsp"></jsp:include> 
</head>
<style>
table, th, td {
   border: 1px solid black;
}
</style>
</head>
<body>
<div class="container">
 <div class="panel panel-primary" style="width:750px;margin:0px auto">
<div class="panel-heading">EDIT PRODUCT</div>
<div class="panel-body">
  <div class="row">
  
  
<center>
<br>
<br>

<form:form action="EditProduct" method="post" modelattribute="product">
<div class="col-xs-4">
    <div class="input-group">
<span class="input-group-addon"> Product Id </span>
<input type="text" value="${prFound.prodid}" disabled="disabled">
<input type="hidden" id="prodid" name="prodid" value="${prFound.prodid}">
</div>
    <br>
 <div class="input-group">
<span class="input-group-addon"> Product Name </span>
<input type="text" value="${prFound.prodname}" disabled="disabled">
<input type="hidden" id="prodname" name="prodname" value="${prFound.prodname}">
</div>
<br>

<div class="input-group">
<span class="input-group-addon"> Product Description </span>
<input type="text" value="${prFound.proddesc}" disabled="disabled">
<input type="hidden" id="proddesc" name="proddesc" value="${prFound.proddesc}">
</div>
<br>


<div class="input-group">
<span class="input-group-addon">Supplier ID </span>
<input type="text" value="${prFound.suppid}" disabled="disabled">
<input type="hidden" id="suppid" name="suppid" value="${prFound.suppid}">
</div>
<br>

<div class="input-group">
<span class="input-group-addon">Category ID</span>
<input type="text" value="${prFound.catid}" disabled="disabled">
<input type="hidden" id="catid" name="catid" value="${prFound.catid}">
</div>
<br>

<div class="input-group">
<span class="input-group-addon">Product Quantity </span>
<form:input path="prodquan"/><br>
</div>
<br>

<div class="input-group">
<span class="input-group-addon">Product Cost </span>
<form:input path="prodcost"/><br>
</div>
<br>

 <form:button type="submit" class="btn btn-success">Update</form:button>

</form:form>
</center>

</body>
</html>