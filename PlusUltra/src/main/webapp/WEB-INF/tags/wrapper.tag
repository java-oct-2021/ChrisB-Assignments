<%@ tag language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<div class="p-3 mb-2 bg-secondary text-white">
<div class = "container">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
 <span class="navbar-brand mb-0 h1">P.V.O</span>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <div class="navbar-nav">
		<a class="nav-item nav-link active" href="/dashboard">Home</a>
		<a class="nav-item nav-link active" href="/profile/${user.id}">Profile</a>
		<a class="nav-item nav-link active" href="/logout">Logout</a>
    </div>
  </div>
</nav>
<div class="p-3 mb-2 bg-light text-dark"><jsp:doBody></jsp:doBody></div>
</div>
</div>
</body>
</html>