<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<div class = "container">
<a href="/logout">Logout</a>
<h1>Welcome <c:out value="${currentUser.userName}"/>!</h1>
<h3>Share a photo!</h3>
		<form method="POST" action="/upload" enctype="multipart/form-data">
			<div class="form-data">Select File: <input type="file" name="pic"></div>
			<div class="form-data"><textarea name="description">Please enter a description</textarea> <button>Upload Pic</button></div>
		</form>
</div>
</body>
</html>