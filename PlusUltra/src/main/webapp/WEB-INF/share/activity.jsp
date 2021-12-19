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
<title>Activity</title>
</head>
<body>
<t:wrapper>
<h1>${shareDetails.owner.firstName} shared:</h1>
<h3>${shareDetails.content}</h3>
<c:choose>
<c:when test="${shareDetails.owner.id == loggedInUser}">
<a href="/edit/${shareDetails.id}"> Edit</a> |
<a href="/delete/${shareDetails.id}">Delete</a> 
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<h3>Users who liked this:</h3>
<hr>
<table class="table table-striped table-dark table-bordered">
<thead>
<tr>
<th>Name</th>
</tr>
<tr>
<th><c:forEach items="${shareDetails.likers}" var="user">
<li>${user.firstName}</li>
</c:forEach></th>
</tr>
</thead>
</table>

</t:wrapper>
</body>
</html>