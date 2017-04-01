<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Delete the Product</title>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css">
<script src="Bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/valid.js"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <style>
table, th, td {
   border: 1px solid black;
}
</style>
  </head>
  
<body>

<h1>Delete Product</h1>
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


  
 <form action="deleteProduct">
<h2>Enter Product ID : </h2>
<input type="text" name="prodid" path="prodid" id="prodid" placeholder="Enter Product ID" /> 
<input type="submit" value="Delete">


</form>
</body>
</html>