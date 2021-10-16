<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Date Template</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>

</head>
<body>
<script>dateAlert()</script>
<p class= "date"> <fmt:formatDate pattern="EEEE, 'the' dd'th' 'of' MMMM, Y" value="${datetime}"/></p>

</body>
</html>