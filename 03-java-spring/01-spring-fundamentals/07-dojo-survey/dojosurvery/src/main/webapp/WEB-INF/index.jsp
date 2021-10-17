<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css"/>
<title>Survey</title>
</head>
<body>
<div class="container">
<div class="building">
<h1>Dojo Survey</h1>
<form action="/result" method="POST" class="form"> 
<p><label>Your Name:</label>
<input type="text" name="firstName"></p>
<p><label>Dojo Location:</label>
<select name="location">
<c:forEach items="${locations}" var="location">
<option value="${location}">${location}</option>
</c:forEach>
</select>
</p>
<p><label>Favorite Language:</label>
<select name="language">
<c:forEach items="${languages}" var="language">
<option value="${language}">${language}</option>
</c:forEach>
</select>
</p>
<p><label>Comment(optional): </label>
<textarea name="comment"></textarea>
		
</p>
<button>Submit</button>
</form>
</div>
</div>

</body>
</html>