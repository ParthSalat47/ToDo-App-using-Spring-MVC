<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ include file="../../resources/IncludeInEveryPage.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="content"> 

<h2>Add a task</h2>

	<form action="processAddTask" method="get">
		<label for="taskName">Enter the task to do:</label> 
		<input type="text" id="taskName" name="taskName" required> 
		<br>
		<br>
		<label for="taskName">Enter the tags for this task:</label> 
		<input type="text" id="tags" name="tags" required> 
		<br>
		<input type="submit" 	value="Add task" class="homepageButtons"> 
		<br>
	</form>
	
	<br>
	
	<h5> ${result} </h5>

</div>

</body>
</html>