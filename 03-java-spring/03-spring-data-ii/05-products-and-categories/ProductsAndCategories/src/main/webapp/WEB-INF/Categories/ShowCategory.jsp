<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>See Category</title>
</head>
<body>
<div class="container">
<h1>Check Out This Category!</h1>
<hr>
<h2><c:out value="${category.name}"></c:out></h2>
<hr>
<h3>Products</h3>
<ul>
<c:forEach items="${category.products}" var="product">
<li>${product.name} | ${product.description} | ${product.price}</li>
</c:forEach>
</ul>
<form method="POST" action="/addProductToCategory/${category.id}">
<select name="product">
<c:forEach items="${categoryDetails}" var="product">
<option value="${product.id}">${product.name}</option>
</c:forEach>
</select>
<button>Add Product</button>
</form>
</div>
</body>
</html>