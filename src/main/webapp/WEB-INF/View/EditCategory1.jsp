<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" src="Resources/Bootstrap/bootstrap.min.css">
<title>Admin : Edit Category</title>
<style>
table, th, td {
   border: 1px solid black;
}
</style>
</head>
<body>

<center>
<table>
<tr>
<th>Category ID</th>
<th>Category Name</th>
<th>Category Description</th>
</tr>
      <tr>
        <td><c:out value="${caFound.catid}" /></td>
        <td><c:out value="${caFound.catname}" /></td>
        <td><c:out value="${caFound.catdesc}" /></td>
      </tr>
</table>

<form:form action="EditCategory" method="post" modelattribute="category">
Category ID:<form:input path="catid"/><br>
Category Name:<form:input path="catname"/><br>
Category Description:<form:input path="catdesc"/><br>
<input type="submit" value="Edit">
</center>
</form:form>

</body>
</html>