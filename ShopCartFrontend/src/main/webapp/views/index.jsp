<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<title>Shop Cart</title>
</head>
<body>
${message}
	<form:form action="isValidUser" method="post">
   Enter User Id:<input type="text" name="name">
		<br />
   Enter Password:<input type="password" name="password" />
		<br />
		<input type="submit" value = "Login">

	</form:form>


</body>
</html>