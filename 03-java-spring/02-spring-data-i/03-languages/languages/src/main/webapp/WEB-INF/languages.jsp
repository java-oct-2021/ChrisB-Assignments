<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
<div class = "containter">
<h1>Languages</h1>
<hr>
<table class="table table-dark">
<thead>
<tr>
<th>Language Name</th>
<th>Creator</th>
<th>Version</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${allLanguages}" var="language">
<tr>
<td><a href="/show/${language.id}">${language.langName}</a> </td>
<td>${language.creator}</td>
<td>${language.version}</td>
<td><a href="/edit/${language.id}">Edit</a> |
<form id="delete-form" action="/delete/${language.id}" method="post">
<input type="hidden" name="_method" value="delete">
<input class="btn btn-danger" type="submit" value="Delete">
</form>
</tr>
</c:forEach>
</tbody>
</table>

<h3>Create New Language</h3>
<form:form action ="/languages/add" method="POST" modelAttribute="language">
<p>
<form:label path="langName">Name:</form:label>
<form:errors path="langName"/>
<form:input path="langName"/>
</p>
<p>
<form:label path="creator">Creator:</form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>
<p>
<form:label path="version">Current Version:</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>
<button>Submit New Language</button>
</form:form>
<a href="/languages">Dash board</a>

</div>
</body>
</html>