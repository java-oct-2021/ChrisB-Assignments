<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Welcome to Records dot Com</title>
</head>
<body>
<div class="container">
<h1>Welcome to Records dot Com</h1>
<hr>
<table class="table table-striped table-dark">
<thead>
<tr>
<th>Id</th>
<th>Album Name</th>
<th>Band Name</th>
<th>Year</th>
<!-- <a href="/delete">Delete</a>
 --></tr>
<c:forEach items="${allAlbums}" var="album">
<tr>
<td>${album.id}</td>
<td>${album.albumName}</td>
<td>${album.bandName}</td>
<td>${album.year}</td>
<!-- <a href="/delete">delete</a>
 --></tr>
</c:forEach>

</thead>
</table>

</div>
</body>
</html>