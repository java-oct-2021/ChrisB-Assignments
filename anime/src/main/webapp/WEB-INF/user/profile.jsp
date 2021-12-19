<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<t:wrapper>
<h2>Details For ${user.firstName} ${user.lastName}</h2>
<hr>
<h3>Anime added</h3>
<ul>
<c:forEach items="${user.myAnime}" var="anime">
<li><a href="/details/${anime.id}">${anime.animeTitle}</a> </li>
</c:forEach>
</ul>
</t:wrapper>
</body>
</html>