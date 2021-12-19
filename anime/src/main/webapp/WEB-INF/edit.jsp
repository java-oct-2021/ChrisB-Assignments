<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ${anime.id}</title>
</head>
<body>
<t:wrapper>
<h1>Edit Anime</h1>
<form:form method="POST" action="/edit/${anime.id}" modelAttribute="anime">
<div class="form-group">
	<form:label path="animeTitle">Anime Name:</form:label>
	<form:errors path="animeTitle"/>
	<form:input type="text" class="form-control" path="animeTitle"/>
</div>
<div class="form-group">
	<form:label path="animeDescr">Description:</form:label>
	<form:errors path="animeDescr"/>
	<form:input type="text" class="form-control" path="animeDescr"/>
</div>
<div class="form-group">
	<form:label path="numberOfEpis">How many episodes?</form:label>
	<form:errors path="numberOfEpis"/>
	<form:input type="text" class="form-control" path="numberOfEpis"/>
	<p><button>Edit Anime</button></p>
</div>
</form:form>
</t:wrapper>
</body>
</html>