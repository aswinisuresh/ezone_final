<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" src="Resources/Bootstrap/bootstrap.min.css">
<title>Admin : Edit Supplier</title>
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
<th>Supplier ID</th>
<th>Supplier Name</th>
<th>Supplier Address</th>
</tr>
      <tr>
        <td><c:out value="${suppFound.suppid}" /></td>
        <td><c:out value="${suppFound.suppname}" /></td>
        <td><c:out value="${suppFound.suppaddress}" /></td>
      </tr>
</table>
<br>
<br>
<form:form action="EditSupplier" method="post" modelattribute="supplier">
Supplier ID:<form:input path="suppid"/><br>
Supplier Name:<form:input path="suppname"/><br>
Supplier Description:<form:input path="suppaddress"/><br>
<input type="submit" value="Edit">
</center>
</form:form>

</body>
</html>