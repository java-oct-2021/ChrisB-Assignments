<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<h1>Details For ${user.name}</h1>
<a href="/dashboard">Dashboard | </a>
<a href="/logout">Logout</a>
<hr>
<h2>Ideas</h2>
<ul>
<c:forEach items="${user.myIdea}" var="idea">
<li><a href="/details/${idea.id}">${idea.content}</a></li>
</c:forEach>
</ul>
</body>
</html>