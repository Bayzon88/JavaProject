<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="addnewproduct" method="post">

			<div class="mb-3">
				<div class="row">
					<div class="col-6">

						<label class="form-label" for="product_id">Product ID:</label> <input
							class="form-control" id="product_id" name="product_id" />
					</div>
					<div class="col-6">
					 <label
							class="form-label" for="product_price">Product Price:</label> <input
							class="form-control" id="product_price" name="product_price" /></div>

				</div>



				<div class="mb-3">
					<div class="col-12">
						<label class="form-label" for="product_name">Product Name:</label>
						<input class="form-control" id="product_name" name="product_name"
							value=""  />
					</div>

				</div>


				<button class="btn btn-primary" type="submit">Add New
					Product</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>