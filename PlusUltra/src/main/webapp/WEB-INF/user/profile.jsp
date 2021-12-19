<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<t:wrapper>
<h1> ${user.firstName}'s profile!</h1>
<hr>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col"><h3>Share's</h3></th>
    </tr>
    <c:forEach items="${pictures}" var="pic">
    <tr>
    <td><img src="${pic.image_url}" height="250" width="300">
    <p>${pic.description}</p></td>
    </tr>
    </c:forEach>
  <c:forEach items="${user.myShare}" var="share">
  <tr>
<td><a href="/activity/${share.id}">${share.content}</a></td>
</tr>
</c:forEach>
  </thead>
  </table>
</t:wrapper>
</body>
</html>