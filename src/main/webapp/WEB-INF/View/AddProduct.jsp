<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/valid.js"></script>
<title>Insert title here</title>
<jsp:include page="CommonHeader.jsp"></jsp:include> 
<script>
function validateForm()
{
    if(document.frm.prodid.value=="")
    {
      alert("Product id should not be left blank");
      document.frm.prodid.focus();
      return false;
    }
    else if(document.frm.prodname.value=="")
    {
      alert("Product prodname should not be left blank");
      document.frm.prodname.focus();
      return false;
    }
    else if(document.frm.suppid.value=="")
    {
      alert("Supplier id should not be left blank");
      document.frm.suppid.focus();
      return false;
    }
    else if(document.frm.catid.value=="")
    {
      alert("Category id should not be left blank");
      document.frm.catid.focus();
      return false;
    }
    else if(document.frm.prodquan.value=="")
    {
      alert("Product quantity should not be left blank");
      document.frm.prodquan.focus();
      return false;
    }
    else if(document.frm.prodcost.value=="")
    {
      alert("Product cost should not be left blank");
      document.frm.prodcost.focus();
      return false;
    }
}
</script>
</head>

<body>
<div class="container">
 <div class="panel panel-primary" style="width:750px;margin:0px auto">
<div class="panel-heading">ADD PRODUCT</div>
<div class="panel-body">
  <div class="row">
  
  	<%-- <form:form action="validateAddProduct" method ="post"> --%>
  	  	
  	<form:form name="frm" action="validateAddProduct" modelattribute="Product" enctype="multipart/form-data" onSubmit="return validateForm()">
  	 
  	<div class="col-xs-6">
    <div class="input-group">
   
	<span class="input-group-addon"> Product Id </span>
      <form:input type="text" class="form-control" path="prodid" id="prodid" placeholder="Enter Product ID" />
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Product Name </span>
      <form:input type="text" class="form-control" path="prodname" id="prodname" placeholder="Enter Product Name"/>
    </div>
    <br>
    
    <div class="input-group">
     <span class="input-group-addon"> Supplier ID </span>
      <form:input type="text" class="form-control" path="suppid" id="suppid" placeholder="Enter Supplier ID"/>
    </div>
    <br>
        <div class="input-group">
     <span class="input-group-addon"> Category ID </span>
      <form:input type="text" class="form-control" path="catid" id="catid" placeholder="Enter Category ID"/>
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Product Desc </span>
      <form:input type="text" class="form-control" path="proddesc" id="proddesc" placeholder="Enter Product Desc"/>
    </div>
    <br>
   <div class="input-group">
	<span class="input-group-addon"> Product Quantity </span>
      <form:input type="text" class="form-control" path="prodquan" id="prodquan" placeholder="Enter Product Quantity"/>
    </div>
    <br>
    <div class="input-group">
      <span class="input-group-addon"> Product Cost </span>
      <form:input type="text" class="form-control" path="prodcost" id="prodcost" placeholder="Enter Product cost"/>
    </div>
    
    <br>
    
     <div class="input-group">
      <span class="input-group-addon"> Product image </span>
      <form:input type="file" class="form-control" path="pimage" id="pimage" placeholder="Upload Product image"/>
    </div>
    
<br>
    
    <form:button type="submit" class="btn btn-default"> Add </form:button>
    
    </div>
</form:form>
  
 
</body>
</html>