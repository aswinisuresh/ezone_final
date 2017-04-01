<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Admin : Edit Product</title>
</head>
<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>
<center>
<h1>Edit Product</h1>
<div class="container">
  <h2>Available Products</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Supplier Id</th>
        <th>Category Id</th>
        <th>Product Quantity</th>
        <th>Product Cost</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${prList}" var="pList">
      <tr>
        <td><c:out value="${pList.prodid}" /></td>
        <td><c:out value="${pList.prodname}" /></td>
        <td><c:out value="${pList.proddesc}" /></td>
        <td><c:out value="${pList.suppid}" /></td>
        <td><c:out value="${pList.catid}" /></td>
        <td><c:out value="${pList.prodquan}" /></td>
        <td><c:out value="${pList.prodcost}" /></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
</div>
<form action="findProduct">
<h2>Enter Product ID : </h2>
<input type="text" name="prodid" /> 
<!-- <input type="submit" value="Edit"> -->

<button type="submit" class="btn btn-primary">Edit</button>
</form>
</center>
</body>
</html>