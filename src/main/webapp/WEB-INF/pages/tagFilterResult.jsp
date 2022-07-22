<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ include file="../../resources/IncludeInEveryPage.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tags filter result</title>
</head>
<body>

<div class="content"> 

	<h3>Tasks with the tag "${tagName}"</h3>

	<c:forEach var="item" items="${tasksList}" varStatus="counter">
	${counter.count}. ${item}  
	<br>
	</c:forEach>

</div>

</body>
</html>