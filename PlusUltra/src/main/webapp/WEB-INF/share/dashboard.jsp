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
<title>Home / P.V.O</title>
</head>
<body>
<t:wrapper>
<div class = "container">
	<div class="col">
	<div class="row">
		<div class="jumbotron jumbotron-fluid">
  		<div class="container-fluid" class="border">
   			<h1 class="display-4" align="center">Hey ${user.firstName}!</h1>
    		<p class="lead" align="center">Spread some positivity today</p>
 		</div>
		</div>
	</div>
	</div>
	<div class="form-control form-control-lg">
	<div class="row">
	<div class="col offset-2">
		<form:form method="POST" action="/new" modelAttribute="share">
			<h3><form:label path="content">Share a thought!</form:label></h3>
			<form:errors path="content"/>
			<form:input type="text" path="content" value="What's on your mind?"/> 
			<button>Submit</button>
		</form:form>
	</div>
	<div class="col-6 offset-1">
	<h3>Share a photo!</h3>
		<form method="POST" action="/upload" enctype="multipart/form-data">
			<div class="form-data">Select File: <input type="file" name="pic"></div>
			<div class="form-data"><textarea name="description">Please enter a description</textarea> <button>Upload Pic</button></div>
		</form>
	</div>
	</div>
	</div>
	

<%-- <p>Following: <c:out value="${currentUser.getFollowing().size()}"/> | Followers: <c:out value="${currentUser.getFollower().size()}"/></p>
 --%>
 <div class = "container">
 	<div class = "row w-50">
 	<c:forEach items="${allShares}" var="share">
      <h5 class="mb-1"><a href="/profile/${share.owner.id}">${share.owner.firstName}</a> shared:</h5>
		<p class="mb-1 border">
		<small>${share.content}</small>
		<small>${picture.image_url}</small>
    	<c:choose>
      	<c:when test="${share.likers.contains(user)}">
      	|<a href="/unlike/${share.id}"> Unlike</a>
      	</c:when>
      	<c:otherwise>
      	|<a href="/like/${share.id}"> Like</a> </c:otherwise>
      	</c:choose>
      	<td>${share.likers.size()}</td> 
 			</c:forEach>
 	</div>
 </div>
 </div> 
</t:wrapper>
</body>
</html>