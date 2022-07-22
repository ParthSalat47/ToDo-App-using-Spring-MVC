<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page isELIgnored="false" %>

<%@ include file="../../resources/IncludeInEveryPage.jsp" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="content">
<H2>All tasks</H2>

<c:forEach var="item" items="${taskList}" varStatus="counter">
	${counter.count}. ${item.taskName} - <i>tags: ${item.tags}</i>  
	<br>
</c:forEach>

</div>

</body>
</html>