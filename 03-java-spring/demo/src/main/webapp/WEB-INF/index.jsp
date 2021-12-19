<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>This is my first JSP file! :)</h1>


<%! int count=10; %>
<%= count %>

Created By : <c:out value="${firstName}"/>
During <c:out value="${stack}"/> Stack!
</body>
</html>