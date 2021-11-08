<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>What is your Question?</h1>
<hr>
<form:form method="POST" action="/newQuestion" modelAttribute="question">
<div class="form-group"> <form:label path="userQ">Question</form:label>
<form:errors path="userQ"></form:errors>
<form:textarea path="userQ" class="form-control"></form:textarea> </div>

<div class="form-group">
 <form:label path="userTags">Tags (separate by comma)</form:label>
<form:errors path="userTags"></form:errors>
<form:input path="userTags"></form:input> </div>

<button>Submit Question</button>


</form:form>

</body>
</html>