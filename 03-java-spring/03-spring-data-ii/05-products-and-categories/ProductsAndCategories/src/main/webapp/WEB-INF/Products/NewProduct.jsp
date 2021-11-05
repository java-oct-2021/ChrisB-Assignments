<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>New Product</title>
</head>
<body>
<div class="container">
<h1>Create a New Product!</h1>
<hr>
<form action="/createProduct" METHOD="POST">
<p><label for="name">Product Name:</label>
<input type="text" name="name"></p>
<p><label for="description">Product Description:</label>
<textarea name="description"></textarea></p>
<p><label for="price">Product Price:</label>
<input type="number" name="price" step="0.01"></p>
<p><button>Create Product</button></p>
</form>
</div>
</body>
</html>