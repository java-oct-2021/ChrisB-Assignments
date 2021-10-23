<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Edit Languages</title>
</head>
<body>
<div class="container">
<h1>Edit Language</h1>
<hr>
<h3>Submit a Form</h3>
<form:form action ="/edit/${language.id}" method="POST" modelAttribute="language">
<p>
<form:label path="langName">Name:</form:label>
<form:errors path="langName"/>
<form:input path="langName"/>
</p>
<p>
<form:label path="creator">Creator:</form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>
<p>
<form:label path="version">Current Version:</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>
<input type ="hidden" name="_method" value="put">
<button>Edit Language</button>
</form:form>
<a href="/languages">Dash board</a>
</div>
</body>
</html>