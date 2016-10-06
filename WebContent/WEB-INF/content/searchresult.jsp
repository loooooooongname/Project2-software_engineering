<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
	<p>author</p>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Country</th>
		</tr>
		<s:iterator value="authors" var="a">
			<tr>
				<td>${a.name}</td>
				<td>${a.age}</td>
				<td>${a.country}</td>
			</tr>
		</s:iterator>
	</table>
	<p>books</p>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>Publisher</th>
			<th>PublishDate</th>
			<th>Price</th>
		</tr>
		<s:iterator value="books" var="b">
			<tr>
				<td>${b.ISBN}</td>
				<td>${b.title}</td>
				<td>${b.publisher}</td>
				<td>${b.publishdate}</td>
				<td>${b.price}</td>
			</tr>
		</s:iterator>
	</table>
	<button onclick="location='welcome'">Back to main</button>
</body>
</html>