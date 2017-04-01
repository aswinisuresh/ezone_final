<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<style>
a.list-group-item {
    height:auto;
    min-height:220px;
}
a.list-group-item.active small {
    color:#fff;
}
</style>
</head>
<body>


<div class="container">
    <div class="row">
		<div class="well">
        <h1 class="text-center">Add to Cart</h1>
        <div class="list-group">
          <a href="#" class="list-group-item active">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive"  src="resources/shuffle.png" alt="placehold.it/resources/shuffle.png" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading">Product Description</h4>
                    <p class="list-group-item-text"> This is samsung curve TV</p>
                </div>
                <div class="col-md-3 text-center">
                    <!-- <h2> 14240 <small> votes </small></h2> -->
                    <button type="button" class="btn btn-default btn-lg btn-block"> Add to Card </button>
                 </div></div></div></div></div></a>
</body>
</html>