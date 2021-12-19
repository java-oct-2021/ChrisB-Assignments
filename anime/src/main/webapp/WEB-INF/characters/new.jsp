<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8">
<title>Add a character!</title>
</head>
<body>
<t:wrapper>
<h3>Add a new character!</h3>
<form:form method="POST" action="/character/newCharacter" modelAttribute="characters">
<div class="form-control">
	<form:label path="charName">Character name</form:label>
	<form:errors path="charName"/>
	<form:input type="text" path="charName"/>
</div>
<div class="form-control">
	<form:label path="ability">What is/are their power(s)?</form:label>
	<form:errors path="ability"/>
	<form:input type="text" path="ability"/>
</div>
<div class="form-control">
	<form:label path="affiliation">Who are they affiliated with? (i.e their crew, school, etc.)</form:label>
	<form:errors path="affiliation"/>
	<form:input type="text" path="affiliation"/>
</div>
	<form:select path="animeCharIsFrom">
		<c:forEach items="${anime}" var="anime">
		<option value="${anime.id}">${anime.animeTitle}</option>
		</c:forEach>
	</form:select>
	<button>Add Character</button>
</form:form>
</t:wrapper>


</body>
</html>