<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>

	<h2>ADD Product</h2>

	<form:form action="/addProduct" method="post">
		<table>
			<tr>
				<td>Product ID:</td>
				<td><input type="text" name="id"></td>
				<td><form:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="name"></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Product Description:</td>
				<td><input type="text" name="description"></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Product Category:</td>
				<td><input type="text" name="category"></td>
				<td><form:errors path="category" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Product Supplier:</td>
				<td><input type="text" name="supplier"></td>
				<td><form:errors path="supplier" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add">
				<td><input type="reset" value="Reset">
			</tr>
			
		</table>

	</form:form>

</body>
</html>