<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmation</title>
<style>
/*
 * Base structure
 */
/* Move down content because we have a fixed navbar that is 50px tall */
body {
	padding-top: 50px;
}
/*
 * Global add-ons
 */
.sub-header {
	padding-bottom: 10px;
	border-bottom: 1px solid #eee;
}
/*
 * Top navigation
 * Hide default border to remove 1px line.
 */
.navbar-fixed-top {
	border: 0;
}
/*
 * Sidebar
 */
/* Hide for mobile, show later */
.sidebar {
	display: none;
}
@media ( min-width : 768px) {
	.sidebar {
		position: fixed;
		top: 51px;
		bottom: 0;
		left: 0;
		z-index: 1000;
		display: block;
		padding: 20px;
		overflow-x: hidden;
		overflow-y: auto;
		/* Scrollable contents if viewport is shorter than content. */
		background-color: #f5f5f5;
		border-right: 1px solid #eee;
	}
}
/* Sidebar navigation */
.nav-sidebar {
	margin-right: -21px; /* 20px padding + 1px border */
	margin-bottom: 20px;
	margin-left: -20px;
}
.nav-sidebar>li>a {
	padding-right: 20px;
	padding-left: 20px;
}
.nav-sidebar>.active>a, .nav-sidebar>.active>a:hover, .nav-sidebar>.active>a:focus
	{
	color: #fff;
	background-color: #428bca;
}
/*
 * Main content
 */
.main {
	padding: 20px;
}
@media ( min-width : 768px) {
	.main {
		padding-right: 40px;
		padding-left: 40px;
	}
}
.main .page-header {
	margin-top: 0;
}
/*
 * Placeholder dashboard ideas
 */
.placeholders {
	margin-bottom: 30px;
	text-align: center;
}
.placeholders h4 {
	margin-bottom: 0;
}
.placeholder {
	margin-bottom: 20px;
}
.placeholder img {
	display: inline-block;
	border-radius: 50%;
}
.container-fluid{padding-right:15px;padding-left:15px;margin-right:auto;margin-left:auto}
.navbar {
	padding-top: 7px;
	padding-bottom: 15px;
	border: 0;
	border-radius: 0;
	margin-bottom: 0;
	font-size: 12px;
	letter-spacing: 2px;
}
</style>
</head>
<body>
     <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >Home Decor</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index">Home</a></li>
      <li><a href="aboutus">About Us</a></li>
      <li><a href="contact">Contact Us</a></li>
     </ul>
   </div>
</nav>

<h3>My Final Order</h3>
			
				<div class="table-responsive">
					<table class="table table-striped">
						<tr>

							<th width="80">Item</th>
							<th width="120">Quantity</th>
							<th width="80">Price</th>
							<th width="80">Total</th>
					   </tr>
						<c:forEach items="${cartList}" var="cart">
							<tr>
								<td>${cart.item.name}</td>
								<td>${cart.item.quantity}</td>
								<td>${cart.item.price}</td>
								<td>${cart.total}</td>
			                </tr>
						</c:forEach>
					</table>
				</div>
				<input class="btn btn-primary" type="submit" value="Submit">
</body>
</html>