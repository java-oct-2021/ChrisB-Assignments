<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Dojo Details</title>
</head>
<body>
<div class="container">
<h1><c:out value="${dojo.location}"/> Location Ninjas</h1>
<table>
<tr>
<th>First Name:</th>
<th>Last Name:</th>
<th>Age:</th>
</tr>
<c:forEach items="${dojo.ninjas}" var="ninja">
<tr>
<td><c:out value="${ninja.firstName}"/></td>
<td><c:out value="${ninja.lastName}"/></td>
<td><c:out value="${ninja.age}"/></td>
</tr>
</c:forEach>

</table>


</div>

</body>
</html>