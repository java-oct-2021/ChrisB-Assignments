<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css"/>
<title>Results</title>
</head>
<body>
<div class="container">
<div class="building">
<h1>Submitted Info:</h1>
<p> Name: <c:out value="${firstName}"/></p>
<p> Dojo Location: <c:out value="${location}"/></p>
<p> Favorite Language: <c:out value="${language}"/></p>
<p> Comment(optional):<c:out value="${comment}"/></p>
<a href="/info"> Additional Info </a>

</div>
</div>


</body>
</html>