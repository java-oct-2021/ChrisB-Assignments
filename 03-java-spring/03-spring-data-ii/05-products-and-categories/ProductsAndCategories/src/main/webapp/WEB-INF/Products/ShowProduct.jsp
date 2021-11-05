<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>See product</title>
</head>
<body>
<div class="container">
<h1>Check Out This Product!</h1>
<hr>
<h3>Product Details</h3>
<p>Product Name: <c:out value="${product.name}"></c:out></p>
<p>Product Description: <c:out value="${product.description}"></c:out></p>
<p>Product Price: <c:out value="${product.price}"></c:out></p>

<hr>
<h3>Categories</h3>
<ul>
<c:forEach items="${product.categories}" var="category">
<li>${category.name}</li>
</c:forEach>
</ul>
<form method="POST" action="/addCategoryToProduct/${product.id}">
<select name="categories">
<c:forEach items="${notInProd}" var="category">
<option value="${category.id}">${category.name}</option>
</c:forEach>
</select>
<button>Add Category</button>
</form>
</div>
</body>
</html>