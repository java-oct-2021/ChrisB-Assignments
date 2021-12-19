<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add New</title>
</head>
<body>
<t:wrapper>
<h3>Add a new anime to the list! </h3>
<form:form method="POST" action="/new" modelAttribute="anime">
	<div class="form-control">
		<form:label path="animeTitle">Anime Name:</form:label>
		<form:errors path="animeTitle"/>
		<form:input type="text" path="animeTitle"/>
	</div>
	<div class="form-control">
		<form:label path="animeDescr">Description:</form:label>
		<form:errors path="animeDescr"/>
		<form:input type="text" path="animeDescr"/>
	</div>
	<div class="form-control">
		<form:label path="numberOfEpis">How many episodes?</form:label>
		<form:errors path="numberOfEpis"/>
		<form:input type="text" path="numberOfEpis"/>
	</div>
	<p><button>Add Anime</button></p>
</form:form>
</t:wrapper>
</body>
</html>