<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Anime's characters</title>
</head>
<body>
<t:wrapper>
<h1>Anime Details</h1>
<p>Anime Name: ${animeDetails.animeTitle}</p>
<p>This is what it's about: ${animeDetails.animeDescr}</p>
<p>Number of episodes: ${animeDetails.numberOfEpis}</p>
<p>Added By: <i><a href="/profile/${animeDetails.owner.id}">${animeDetails.owner.firstName}</a></i></p>
<hr>
<h3>Liked By: </h3>
<hr>
<c:forEach items="${animeDetails.likers}" var="user">
<li>${user.firstName}</li>
</c:forEach>
<hr>
<h3>Character List:</h3>
<c:forEach items="${animeDetails.characters}" var="character">
<ul>
<li>${character.charName} - ${character.ability} - ${character.affiliation}</li>
</ul>
</c:forEach>
<c:choose>
<c:when test="${animeDetails.owner.id == loggedInUser}">
<a href="/edit/${animeDetails.id}">Edit</a>
<a href="/delete/${animeDetails.id}">Delete</a>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</t:wrapper>
</body>
</html>