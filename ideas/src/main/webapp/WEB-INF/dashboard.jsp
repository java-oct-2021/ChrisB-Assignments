<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ideas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Welcome ${user.name}!</h1>
<div class="container">
<h2>Ideas</h2>
<table class="table table-striped table-dark table-bordered">
  <thead>
    <tr>
      <th>Idea</th>
      <th>Created By:</th>
      <th>Likes</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${allIdeas}" var="idea">
    <tr>
      <td><a href="/details/${idea.id}">${idea.content}</a></td>
      <td>${idea.owner.name}</td>
      <td>${idea.likers.size()}</td>
      <td>
      <c:choose>
      <c:when test="${idea.likers.contains(user)}">
      <a href="/unlike/${idea.id}">Unlike</a>
      </c:when>
      <c:otherwise><a href="/like/${idea.id}">Like</a> </c:otherwise>
      </c:choose> </td>
    </tr>
    </c:forEach>
  </thead>
</table>
<p><a href="/new">Create an Idea</a> </p> <a href="/logout">Logout</a>
</div>
</body>
</html>