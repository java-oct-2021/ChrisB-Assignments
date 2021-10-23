<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/languages">Dashboard</a>

<p> <c:out value="${language.langName}"/></p>
<p> <c:out value="${language.creator}"/></p>
<p> <c:out value="${language.version}"/></p>
<a href="/edit/${language.id}">Edit</a> |
<form action="/delete/${language.id}" method="POST">
<input type ="hidden" name="_method" value="delete">
 <a href="/delete/${language.id}">Delete</a>
 </form>
</body>
</html>