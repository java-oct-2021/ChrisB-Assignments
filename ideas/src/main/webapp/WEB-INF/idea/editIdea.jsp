<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ${idea.id }</title>
</head>
<body>
<h1>Edit ${idea.content }</h1>
<form:form method="POST" action="/edit/${idea.id}" modelAttribute="idea">
<div class="form-group">
	<form:label path="content">Content:</form:label>
	<form:errors path="content"/>
	<form:input type="text" class="form-control" path="content"/>
</div>
<p><button>Update Idea</button>
</form:form>
</body>
</html>