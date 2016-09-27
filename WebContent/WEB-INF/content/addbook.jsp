<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new book</title>
</head>
<body>
	
	<form action="AddBook" method="post">
		<p>
			Information of author<br>
			Name    : <input type="text" name="author.name"/><br>
			Age     : <input type="text" name="author.age"/><br>
			Country : <input type="text" name="author.country"/><br>
			
			Information of book<br>
			ISBN          : <input type="text" name="book.ISBN"/><br>
			Title         : <input type="text" name="book.title"/><br>
			Publisher     : <input type="text" name="book.publisher"/><br>
			PublishDate : <input type="text" name="book.publishdate"/><br>
			Price         : <input type="text" name="book.price"/><br>
			
			<input type="submit" value="ok"><br>
		</p>
		
	</form>
	<button onclick="location='welcome'">Back</button> 

</body>
</html>