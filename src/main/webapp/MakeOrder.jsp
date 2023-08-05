<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="w-50 m-auto">
		<form action="createneworder" method="post">

			<div class="mb-3">
				<div class="row">
					<div class="col-6">

						<label class="form-label" for="order_id">Order ID:</label> <input
							class="form-control" id="order_id" name="order_id" />
					</div>
					<div class="col-6">
						<label class="form-label" for="order_date">Order Date:</label> <input
							class="form-control" id="order_date" name="order_date" value=""
							 />
					</div>
				</div>

				<label class="form-label" for="product_id">Product ID:</label> <select
					id="product_id" name="product_id">
					<c:forEach var="product" items="${productList}">
						<option value="${product.product_id}">${product.product_name}</option>
					</c:forEach>

				</select>

				<div class="mb-3">
					<label class="form-label" for="user_id">User ID:</label> <input
						class="form-control" id="user_id" name="user_id"
						placeholder="Enter valid Username" value="${user_id}"  />
				</div>

				<div class="mb-3">
					<label class="form-label" for="order_quantity">Quantity:</label> <input
						class="form-control" id="order_quantity" name="order_quantity" />
				</div>
				<button class="btn btn-primary" type="submit">Make Order</button>
		</form>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

	<script>
		const date = new Date();

		document.getElementById("order_date").value = date.toLocaleDateString();
	</script>
</body>
</html>