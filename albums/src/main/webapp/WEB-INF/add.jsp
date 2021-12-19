<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add an Album</title>
</head>
<body>
<h1>Create a new Album</h1>
<hr>
<h3>HTML Forms Way</h3>
<form action="/new" METHOD="POST">
<p>Album Name: </p>
<input name="albumName" type="text">
<p>Band Name: </p>
<input name="bandName" type="text">
<p>Release Year: </p>
<input name="year" type="text">



</form>
</body>
</html>