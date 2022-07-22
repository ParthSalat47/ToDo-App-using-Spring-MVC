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

<h2>Update a task</h2>

	<form action="/processUpdateTask" name="updateForm">
	<h4>Select the task you wish to update:</h4>
	
	<c:forEach var="item" items="${taskList}">
		<input type="radio" id="${item}" name="taskList" value="${item.taskName}" required>
	    <label for="${item.taskName}">${item.taskName} - <i>tags: ${item.tags}</i>
	  </label>
	  <br>
	</c:forEach>
	  
	<br>
	
	<label for="taskName">Enter the updated task:</label> 
	<input type="text" id="taskName" name="taskName" required> 
	<br>
	<br>
	<label for="taskName">Enter tags for the selected task:</label> 
	<input type="text"  name="tags" required > 
	<br>
	<input type="submit" 	value="Update task" class="homepageButtons">
	
	</form>
	
	<br>
	<br>
	
	<h5> ${result} </h5>

</div>

</body>
</html>