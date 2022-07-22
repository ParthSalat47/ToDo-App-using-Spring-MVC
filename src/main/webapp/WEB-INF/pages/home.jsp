<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ToDo App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/Todo.css">
  
  </head>
  <body>
  	<%-- The following will be useful only if login functionality is present
    <h3 class="centerClass">Hello, ${name}!</h3> --%>
    
    <div class="container">
    	<h1 class="centerClass">Welcome to ToDo manager</h1>
    	    <br>
			<br>
    	
    	<form action="${pageContext.request.contextPath}/addTask" method="get">
    		<input type="submit" value="Add a task" class="homepageButtons">
    		<br>
			<br>
    	</form>
    	
    	<form action="${pageContext.request.contextPath}/updateTask" method="get">
    		<input type="submit" value="Update a task" class="homepageButtons">
    		<br>
			<br>
    	</form>
    	
    	<form action="${pageContext.request.contextPath}/deleteTask" method="get">
    		<input type="submit" value="Delete a task" class="homepageButtons">
    		<br>
			<br>
    	</form>
    	
    	<form action="${pageContext.request.contextPath}/viewTasks" method="get">
    		<input type="submit" value="View all tasks" class="homepageButtons">
    		<br>
			<br>
    	</form>
    	
    	<hr class="rounded">
    	
    	<form action="${pageContext.request.contextPath}/tagFilter" method="get">
    		<input id = "tagFilter" type="submit" value="Filter tasks using tags" class="homepageButtons">
    		<br>
			<br>
    	</form>
    	
    	<br>
    	<br>
    	
    	<div class="error">${message}</div>
    	
    </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>