<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>
<div class="container">                                                                                     
  <div class="table-responsive">          
  <table class="table table-bordered">
    <thead >
      <tr >
        <th style="text-align: center">CART ID</th>
        <th> PRODUCT NAME</th>
        <th>COST</th>
        <th>STATUS</th>
       <th> DATE ADDED</th>
       <th> QUANTITY</th>
       <th> SUM</th>
      </tr>
    </thead>
  <c:forEach var="myCart" items="${showcartlist}">
  <tbody>
  <tr>
  	<td>${myCart.cartid }</td>
  	<td>${myCart.prodname}</td>
  	<td>${myCart.prodcost}</td>
  	<td>${myCart.status}</td>
  	<td>${myCart.dateadded}</td>
  	<td><a href="<c:url value='/increasequantity/${myCart.cartid}' />">
  	<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span>
  	</button></a>&nbsp;${myCart.prodquan}&nbsp;<a href="<c:url value='/decreasequantity/${myCart.cartid}' />">
  	<button type="submit" class="btn btn-default" style="color:#FF3349;">
  	<span class="glyphicon glyphicon-minus"></span></button></a></td>
  	<td>${myCart.sum}</td>
<%-- 	<td><a href="deletecart?id=${myCart.id}"><button type="submit" class="btn btn-default" style="color:#FF3349;"><span class="glyphicon glyphicon-remove"></span></button></a></td>
 --%>  	</tr>
  	</tbody>
  </c:forEach>
  <tr>
  	<td colspan="6" Style="text-align:right">Total</td>
  	<td>${carttotal}</td>
  	</tr>
  	
  </table>
  </div>
  </div>
  <jsp:include page="CommonFooter.jsp"></jsp:include>
  </body>
</html>