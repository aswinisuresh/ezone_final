<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Admin</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  
  function cFunc()
  {
  	var form_value=document.getElementById('product').value;
  	if(form_value=="AddProduct")
  	{
  	window.location="selAddProduct";
  	}
  	if(form_value=="EditProduct")
  	{
  	window.location="selEditProduct";
  	}
  	if(form_value=="DeleteProduct")
  	{
  	window.location="selDeleteProduct";
  	}
  	if(form_value=="Product")
	{
	window.location="selProduct";
	}
  	
  } 
   
  
  function dFunc()
  {
  	var form_value=document.getElementById('category').value;
  	if(form_value=="AddCategory")
  	{
  	window.location="selAddCategory";
  	}
  	if(form_value=="EditCategory")
  	{
  	window.location="selEditCategory";
  	}
  	if(form_value=="DelCategory")
  	{
  	window.location="selDeleteCategory";
  	}
  	
  
  }
     function sFunc()
    {
    	var form_value=document.getElementById('supplier').value;
    	if(form_value=="AddSupplier")
    	{
    	window.location="selAddSupplier";
    	}
    	if(form_value=="EditSupplier")
    	{
    	window.location="selEditSupplier";
    	}
    	if(form_value=="DelSupplier")
    	{
    	window.location="selDeleteSupplier";
    	}
  } 
  </script>

</head>

<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>
<div class="container">
 <div class="panel panel-primary" style="width:750px;margin:0px auto">

              <div class="panel-heading">ADMIN</div>
              <div class="panel-body">
  <div class="row">
  	<div class="col-md-6">



<form>
<div class="form-group">        

  <label>Product</label>
  <div class="row">  
  <div class="col-xs-12">

        <select class="form-control" id="product" onchange="cFunc()">
        <br><option>-----SELECT OPTION----------</option>
        <option value="AddProduct">Add</option>
        <option value="EditProduct">Edit</option>
        <option value="DeleteProduct">Delete</option>
 </select>
        </div></div>
        </div>
<label>Category</label>

      <select class="form-control" id="category" onchange="dFunc()">
<option>-------------SELECT OPTION---------------</option>        
        <option value="AddCategory">Add</option>
        <option value="EditCategory">Edit</option>
        <option value="DelCategory">Delete</option>
      </select>

  <br>  <label>Supplier</label></br>
      <select class="form-control" id="supplier"  onchange="sFunc()">
      
      <option>--------SELECT OPTION-----------------</option>
        <option value="AddSupplier">Add</option>
        <option value="EditSupplier">Edit</option>
        <option value="DelSupplier">Delete</option>
       </select> 
  
      </form>
<jsp:include page="CommonFooter.jsp"></jsp:include>      
</body>
</html>