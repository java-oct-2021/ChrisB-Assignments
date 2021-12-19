<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Anime</title>
</head>
<body>
<t:wrapper>
<h4>Welcome ${user.firstName}!</h4>
<table class="table table-striped table-dark table-bordered">
  <thead>
    <tr>
      <th>Anime Name</th>
      <th>Description</th>
      <th>Number Of Episodes</th>
      <th>Likes</th>
      <th>Like</th>
    </tr>
    <c:forEach items="${allAnimes}" var="anime">
    <tr>
      <td><a href="/details/${anime.id}">${anime.animeTitle}</a></td>
      <td>${anime.animeDescr}</td>
      <td>${anime.numberOfEpis}</td>
      <td>${anime.likers.size()}</td>
      <td>
      <c:choose>
      <c:when test="${anime.likers.contains(user)}">
      <a href="/unlike/${anime.id}">Unlike</a>
      </c:when>
      <c:otherwise><a href="/like/${anime.id}">Like</a> </c:otherwise>
      </c:choose> </td>
    </tr>
    </c:forEach>
  </thead>
</table>
</t:wrapper>
</body>
</html>