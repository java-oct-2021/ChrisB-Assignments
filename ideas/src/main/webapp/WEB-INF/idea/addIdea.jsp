<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add New</title>
</head>
<body>
<div class="container">
<h1>Create A New Idea</h1>
<a href="/dashboard">Dashboard | </a>
<a href="/logout">Logout</a>
<form:form method="POST" action="/new" modelAttribute="idea">
	<div class="form-control">
		<form:label path="content">Content:</form:label>
		<form:errors path="content"/>
		<form:input type="text" path="content"/>
	</div>
	<p><button>Submit</button></p>
</form:form>
</div>
</body>
</html>