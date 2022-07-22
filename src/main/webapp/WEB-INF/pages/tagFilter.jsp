<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ include file="../../resources/IncludeInEveryPage.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter to save time!</title>
</head>
<body>

<div class="content"> 

	<H3>Which type of tasks do you want to view?</H3>

	<form action="/processFilterTag" name="filterTagForm">

	<c:forEach var="item" items="${tagsList}">
		<input type="radio" id="${item}" name="tagsList" value="${item}" required> 
	    <label for="${item}">${item} </label>
		  <br>
	</c:forEach>
	
	<input type="submit" 	value="Search tasks" class="homepageButtons">

</form>

</div>

</body>
</html>