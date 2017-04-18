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
<div class="container">
  <h2>Available Category</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Category Id</th>
        <th>Category Name</th>
        <th>Category Description</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${caList}" var="cList">
      <tr>
        <td><c:out value="${cList.catid}" /></td>
        <td><c:out value="${cList.catname}" /></td>
        <td><c:out value="${cList.catdesc}" /></td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
</div>
<form action="DeleteCategory">
		<h2>Enter Category Id</h2>
		<input type="text" name="catid" path="catid" id="catid" placeholder="Enter Category ID" />
		<input type="submit" value="Delete">
</form>
</body>
</html>