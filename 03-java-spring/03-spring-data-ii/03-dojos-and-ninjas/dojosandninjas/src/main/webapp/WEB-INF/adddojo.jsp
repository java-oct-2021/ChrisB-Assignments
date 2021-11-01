<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add Dojo</title>
</head>
<body>
<div class="container">
<h1>New Dojo</h1>
<form:form action="/createDojo" method="POST" modelAttribute="dojo">
	<p>
	<form:label path="location">Name:</form:label>
	<form:errors path="location"/>
	<form:input path="location"/>
	</p>
	<button>Create</button>
</form:form>

</div>
</body>
</html>