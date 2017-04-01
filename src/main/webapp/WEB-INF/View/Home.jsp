
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/valid.js"></script>
<title>Insert title here</title>
</head>

<!-- <style>


 .carousel-inner >.item >img,
.carousel-inner >.item >a>img
{width:50%;height:40%;
margin:auto;
}  

/* .bs-example {
	margin-left:40px;
	margin-right:40px;
}
.carousel {
	margin : 0 Auto;
	background:white;
}
.carousel-inner > .item > img, 
.carousel-inner > .item > a > img{
margin: auto;
} 

 </style>
  -->
<!--  <style>  
  .carousel-inner > .item > img,  
  .carousel-inner > .item > a > img {  
      width: 80%;  
      margin: auto;  
  }  
</style>  --> 
<body>
<hr>
<jsp:include page="CommonHeader.jsp"></jsp:include>
     
 <div id="myCarousel" class="carousel slide" data-ride="carousel">

  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
  </ol>

  <div class="carousel-inner" role="listbox">
  
  <div class="item active">
  <img src="resources/E1.jpg" class="img-responsive" alt="E1" style="width:80"; height:80vh">
  </div>
      <div class="item">
      <img src="resources/E2.jpg" class="img-responsive" alt="E2" style="width:80%; height:80vh">
    </div>

    <div class="item">
      <img src="resources/E3.jpg" class="img-responsive" alt="E3" style="width:80%; height:80vh">
    </div>

    <div class="item">
      <img src="resources/E6.jpg" class="img-responsive" alt="E6" style="width:80%; height:80vh">
    </div>
    
     <div class="item">
      <img src="resources/E7.jpg" class="img-responsive" alt="E7" style="width:80%; height:80vh">
    </div>
  </div>
  
<!--   
  <div id="myCarousel" class="carousel slide" data-ride="carousel">  
    Indicators  
    <ol class="carousel-indicators">  
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>  
      <li data-target="#myCarousel" data-slide-to="1"></li>  
      <li data-target="#myCarousel" data-slide-to="2"></li>  
    </ol>  
  
    Wrapper for slides  
    <div class="carousel-inner" role="listbox">  
      <div class="item active">  
        <img src="resources/E1.jpg" alt="E1" >  
      </div>  
  
      <div class="item">  
        <img src="resources/E3.jpg" alt="E3" >  
      </div>  
      
      <div class="item">  
        <img src="resources/w4.jpg" alt="w4" >  
      </div>  
      <div class="item">  
        <img src="images/w8.jpg" alt="w8" >  
      </div>  
      <div class="item">  
        <img src="images/w9.jpg" alt="w9" >  
      </div>  
    </div>  
  
    Left and right controls  
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">  
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>  
      <span class="sr-only">Previous</span>  
    </a>  
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">  
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>  
      <span class="sr-only">Next</span>  
    </a>  
</div>corousel end  
  
</div>   -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
 

 <jsp:include page="CommonFooter.jsp"></jsp:include> 
</body>
</html>