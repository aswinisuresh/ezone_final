<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Product</title>
</head>
<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>
<center>
<h1>Edit Product</h1>
<div class="container">
  <h2>Available Products</h2>    
  <ul class="nav nav-pills" role="tablist"></ul>
  <c:forEach items="${categoryList}" var="category">
  <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#">$category.name <span>
  class="caret"</span></a>
  
  <ul class="dropdown-menu" role="menu">
  <c:forEach items="${category.product}" var="product">
  <li><a href="manage_product/get"{product.id}">${product.name}</a>
  </c:forEach>
  </ul></li>
  </c:forEach>        
 </div>
<hr color="blue" width="100">
${category.product}
</center>
</body>
</html>