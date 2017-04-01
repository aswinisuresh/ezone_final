<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>ezone</title>
</head>
<body>
<center>
<c:if test="${not empty SUCC }">
<jsp:include page="CommonHeader.jsp"></jsp:include>

${success }
${SUCC }
<jsp:include page="CommonFooter.jsp"></jsp:include>
</c:if>
<c:if test="${empty SUCC}">
<jsp:include page="Registration.jsp"></jsp:include>
</c:if>

</center>
</body>
</html>