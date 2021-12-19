<%@ tag language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add New</title>
</head>
<body>
<div class="container">
<h1>Hello! Welcome to Fav-A-Anime!</h1>
<nav>
<a href="/dashboard">Dashboard</a> |
<%-- <a href="/profile/${user.id}">Profile</a> | --%>
<a href="/new">Add an Anime</a> |
<a href="/character/new">Add a New Character</a> | 
<a href="/logout">Logout</a> 
</nav>
<hr>
<jsp:doBody></jsp:doBody>
</div>
</body>
</html>