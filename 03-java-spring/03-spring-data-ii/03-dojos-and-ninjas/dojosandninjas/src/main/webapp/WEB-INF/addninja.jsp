<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add Ninja</title>
</head>
<body>
<div class="container">
<h1>New Ninja</h1>
	<form:form action="/createNinja" method="POST" modelAttribute="ninja">
	<p>
	<form:label path="dojo">Dojo:</form:label>
	<form:errors path="dojo"/>
	<form:select path="dojo">
	<c:forEach items="${allDojos}" var="dojo">
	<option value="${dojo.id}">${dojo.location}</option>
	</c:forEach>
	</form:select>
	</p>
	<p>
	<form:label path="firstName">First Name:</form:label>
	<form:errors path="firstName"/>
	<form:input path="firstName"/>
	</p>
	<p>
	<form:label path="lastName">Last Name:</form:label>
	<form:errors path="lastName"/>
	<form:input path="lastName"/>
	</p>
	<p>
	<form:label path="age">Age:</form:label>
	<form:errors path="age"/>
	<form:input path="age"/>
	</p>
	<button>Create Ninja</button>
	</form:form>

</div>
</body>
</html>