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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${product != null}">
            			Edit Product
            		</c:if>
						<c:if test="${product == null}">
            			Add New Product
            		</c:if>
					</h2>
				</caption>

				<c:if test="${product != null}">
					<input type="hidden" name="id"
						value="<c:out value='${product.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Product Name</label> <input type="text"
						value="<c:out value='${product.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product Price ($)</label> <input pattern="^\d*(\.\d{0,2})?$"
						value="<c:out value='${product.price}' />" class="form-control"
						name="price">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
