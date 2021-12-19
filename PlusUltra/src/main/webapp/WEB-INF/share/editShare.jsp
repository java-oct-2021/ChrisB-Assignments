<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ${share.id }</title>
</head>
<body>
<t:wrapper>
<h1>Edit ${share.content }</h1>
<form:form method="POST" action="/edit/${share.id}" modelAttribute="share">
<div class="form-group">
	<form:label path="content">Content:</form:label>
	<form:errors path="content"/>
	<form:input type="text" class="form-control" path="content"/>
</div>
<p><button>Update Share</button>
</form:form>
</t:wrapper>
</body>
</html>