<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Jack's MiniMart</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<div style="background-color: paleturquoise" class="headingSize">
			<h1 class="h1 text-center">
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
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Product</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Price ($)</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${listProduct}">

						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.name}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
