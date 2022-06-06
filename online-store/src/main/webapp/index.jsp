<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.h1 {
	font-family: Jazz LET, fantasy;
}

.headingSize {
	padding: 50px;
}

.navbar .navbar-nav .nav-link {
	padding: 5px;
}

.navbar .navbar-nav .nav-item:not(:last-child) .nav-link {
	border-right: 2px solid #000;
}
</style>
<meta charset="UTF-8">
<title>Jack's MiniMart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div style="background-color: paleturquoise" class="headingSize">
		<h1 class="h1 text-center ">
			<a href="<%=request.getContextPath()%>/home">Jack's MiniMart</a>
		</h1>
		<hr>
		<nav class="navbar navbar-expand-md navbar-light">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/list" class="nav-link">List
						Products</a></li>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/new" class="nav-link">Add
						New Product</a></li>
			</ul>
		</nav>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>