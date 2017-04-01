<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Admin : Edit Category</title>
<jsp:include page="CommonHeader.jsp"></jsp:include>
</head>
<body>


<center>
<h1>Edit Category</h1>
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
<form action="findCategory">
<h2>Enter Category ID : </h2>
<input type="text" name="catid" /> 
<input type="submit" value="Edit">
</form>
</center>
</body>
</html>