<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check it Out</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>${question.userQ}</h1>
<p><c:forEach items="${question.questionTags}" var="tag"> ${tag.subject} </c:forEach></p>
<hr>
<h2>Answers</h2>
<hr>
<ul class="list-group">
<c:forEach items="${question.answers}" var="answer"> 
<li class="list-group-item">${answer.userA}</li>
</c:forEach>
</ul>
<h3>Add Answer</h3>
<form:form method="POST" action="/addAnswer" modelAttribute="answer">
<p> <form:label path="userA">Answer: </form:label>
<form:errors path="userA"></form:errors>
<form:input path="userA"></form:input> 
<form:hidden path="questionAnswerIsOn" value="${question.id}"></form:hidden>
</p>
<button>Add Answer</button>
</form:form>
</body>
</html>