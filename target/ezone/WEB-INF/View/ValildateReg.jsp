<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>ezone</title>
<style>
.table{
	text-align:center;
}
</style>
</head>
<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>
<c:if test="${not empty updateUser }">
<div class="container">
  <h2>Register Here <p class="lead">With Proper Details</p></h2>
  <form:form role="form" class="form-horizontal" action="validateUserEdit" method="post">
  <div class="form-group">
      <label class="col-sm-12">User</label>
      <div class="col-sm-6"><form:input type="text" path="id" id="id" name="id" class="form-control" placeholder="ID" required="" readonly="true" value="${UID }"/><div class="help">ID</div></div>
      <div class="col-sm-6"><form:input type="text" path="fname" id="fname" name="fname" class="form-control" placeholder="First Name" required="" value="${FNAME }"/><div class="help">First Name</div></div>
    </div>
     <div class="form-group">
     <label class="col-sm-12">User</label>
    	 <div class="col-sm-6"><form:input type="text" path="lname" id="lname" name="lname" class="form-control" placeholder="Name" required="" value="${LNAME }"/><div class="help">Last Name</div></div>
    	  <div class="col-sm-6"><form:input type="email" path="email" id="email" name="email" class="form-control" placeholder="Mail" value="${UMAIL }" required=""/><div class="help">Email</div></div>
   </div>
   <div class="form-group">
     <label class="col-sm-12">User</label>
    	 <div class="col-sm-6"><form:input type="password" path="password" id="password" name="password" class="form-control" placeholder="Password" value="${PASS }" required=""/><div class="help">Password</div></div>
    	  <div class="col-sm-6"><form:input type="password" path="confirmpassword" id="confirmpassword" name="confirmpassword" class="form-control" value="${CPASS }" placeholder="Confirm Password" required=""/><div class="help">Confirm Password</div></div>
   </div>
    <div class="form-group">
      <div class="col-sm-6">
        <form:button type="submit" class="btn btn-info pull-right">Update Product</form:button>
      </div>
    </div>
  </form:form>
  <hr>
</div>
</c:if>
<table class="table table-bordered" style="width:90%;margin:auto">
    <thead>
      <tr>
        <th style="text-align:center">First Name</th>
        <th style="text-align:center">Last Name</th>
        <th style="text-align:center">ID</th>
        <th style="text-align:center">Mail</th>
        <th style="text-align:center">Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${L.fname }</td>
        <td>${L.lname}</td>
        <td>${L.id}</td>
        <td>${L.email}</td>
        <td><a href="editUser?editrow=${L.id}" class="btn btn-success">Edit</a>
        <a href="deleteUser?deleterow=${L.id}" class="btn btn-danger">Delete</a></td>
      </tr>
    </tbody>
  </table>
  ${RCPSW }
 <jsp:include page="CommonFooter.jsp"></jsp:include>
</body>
</html>