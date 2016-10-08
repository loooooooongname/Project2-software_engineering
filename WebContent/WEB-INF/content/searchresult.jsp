<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>

<style type="text/css">
	body{
		background-color:#E8E8E8;
 		text-align:center; 
 		top:40%;
	}
	
	table.imagetable {
		font-family: verdana,arial,sans-serif;
		font-size:11px;
		color:#333333;
		border-width: 1px;
		border-color: #999999;
		border-collapse: collapse;
	}
	table.imagetable th {
		background:#b5cfd2 url('image/cell-blue.jpg');
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #999999;
	}
	table.imagetable td {
		background:#dcddc0 url('image/cell-grey.jpg');
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #999999;
	}
	
	.button { 
		display: inline-block; 
		zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */ 
		*display: inline; 
		vertical-align: baseline; 
		margin: 0 2px; 
		outline: none; 
		cursor: pointer; 
		text-align: center; 
		text-decoration: none; 
		font: 14px/100% Arial, Helvetica, sans-serif; 
		padding: .5em 2em .55em; 
		text-shadow: 0 1px 1px rgba(0,0,0,.3); 
		-webkit-border-radius: .5em; 
		-moz-border-radius: .5em; 
		border-radius: .5em; 
		-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2); 
		-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2); 
		box-shadow: 0 1px 2px rgba(0,0,0,.2); 
	} 
	.button:hover { 
		text-decoration: none; 
	}	 
	.button:active { 
		position: relative; 
		top: 1px; 
	} 
	.orange { 
		color: #fef4e9; 
		border: solid 1px #da7c0c; 
		background: #f78d1d; 
		background: -webkit-gradient(linear, left top, left bottom, from(#faa51a), to(#f47a20)); 
		background: -moz-linear-gradient(top, #faa51a, #f47a20); 
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#faa51a', endColorstr='#f47a20'); 
	} 
	.orange:hover { 
		background: #f47c20; 
		background: -webkit-gradient(linear, left top, left bottom, from(#f88e11), to(#f06015)); 
		background: -moz-linear-gradient(top, #f88e11, #f06015); 
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f88e11', endColorstr='#f06015'); 
	} 
</style>

</head>
<body>
	<h3>author</h3>
	<center>
	<table class="imagetable">
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
	</center>
	<h3>books</h3>
	<center>
	<table class="imagetable">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>Publisher</th>
			<th>PublishDate</th>
			<th>Price</th>
			<th>Operation</th>
		</tr>
		<s:iterator value="books" var="b">
			
			<tr>
				<td>${b.ISBN}</td>
				<td>${b.title}</td>
				<td>${b.publisher}</td>
				<td>${b.publishdate}</td>
				<td>${b.price}</td>
				<td>
					<form action="DelBook" method="post">
						<button name="del_book" type="submit" value="${b.ISBN}" class="button orange" style="width:80px">del</button>
					</form>
					<form action="ShowBook" method="post">
						<button name="show_book" type="submit" value="${b.ISBN}" class="button orange" style="width:80px">update</button>
					</form>
				</td>
			</tr>
		</s:iterator>
	</table>
	</center>
	<button onclick="location='welcome'" class="button orange" style="margin-top:50px">Back to main</button>
</body>
</html>