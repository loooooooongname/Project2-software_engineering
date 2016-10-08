<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
	<p>The original data</p>
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
	<p>New data</p>
	
		<form action="updatebook" method="post">
			ISBN : <input type="text" name="book.ISBN"/><br>
			Title : <input type="text" name="book.title"/><br>
			Publisher : <input type="text" name="book.publisher"/><br>	
			PublishDate : <input type="text" name="book.publishdate"/><br>
			Price : <input type="text" name="book.price"/><br>
			<s:iterator value="books" var="b">
				<button type="submit" name="ori_ISBN" value="${b.ISBN}">OK</button>
			</s:iterator>
		</form>
		<button onclick="location='welcome'">Back to main</button>

</body>
</html>