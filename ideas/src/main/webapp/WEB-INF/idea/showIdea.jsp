<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Ideas</title>
</head>
<body>
<h1>${ideaDetails.content}</h1>
<p>Added By: <i><a href="/profile/${ideaDetails.owner.id}">${ideaDetails.owner.name}</a></i></p>
<h3>Users who like your idea:</h3>
<hr>
<table class="table table-striped table-dark table-bordered">
<thead>
<tr>
<th>Name</th>
</tr>
<tr>
<th><c:forEach items="${ideaDetails.likers}" var="user">
<li>${user.name}</li>
</c:forEach></th>
</tr>
</thead>
</table>
<a href="/dashboard">Dashboard | </a>
<a href="/logout">Logout</a>
<c:choose>
<c:when test="${ideaDetails.owner.id == loggedInUser}">
<a href="/edit/${ideaDetails.id}">| Edit</a> |
<a href="/delete/${ideaDetails.id}">Delete</a> 
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</body>
</html>