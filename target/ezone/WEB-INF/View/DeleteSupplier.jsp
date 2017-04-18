<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" src="Resources/Bootstrap/bootstrap.min.css">
<title>Admin : Delete Supplier</title>
<style>
table, th, td {
   border: 1px solid black;
}
</style>
</head>
<body>

<jsp:include page="CommonHeader.jsp"></jsp:include>

<h1>Delete Supplier</h1>
<div class="container">
  <h2>Available Supplier</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Supplier Id</th>
        <th>Supplier Name</th>
        <th>Supplier Address</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${supList}" var="sList">
      <tr>
        <td><c:out value="${sList.suppid}" /></td>
        <td><c:out value="${sList.suppname}" /></td>
        <td><c:out value="${sList.suppaddress}" /></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
</div>
<form action="DeleteSupplier">
<h2>Enter Supplier ID : </h2>
<input type="text" name="suppid" path="suppid" id="suppid" placeholder="Enter Supplier ID" /> 
<!-- <button type="submit" class="btn btn-warning">Delete</button>  -->
<input type="submit" value="Delete">
</form>


</body>
</html>