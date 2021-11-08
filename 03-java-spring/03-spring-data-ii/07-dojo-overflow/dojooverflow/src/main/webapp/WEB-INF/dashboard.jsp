<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Question Dashboard</h1>
<hr>
<table class="table">
<tr>
<th>Question</th>
<th>Tags</th>
</tr>
<c:forEach items="${questions}" var="q">
<tr>
<td><a href="/show/${q.id}">${q.userQ}</a></td>
<td>
<p><c:forEach items="${q.questionTags}" var="t"> ${t.subject}, </c:forEach></p>
</td>
</tr>
</c:forEach>
</table>
<a href="/new">New Question</a>

</body>
</html>