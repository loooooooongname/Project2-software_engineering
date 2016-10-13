<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Book Manager</title>

	<style type="text/css">	
	body{
		background-color:#E8E8E8;
 		text-align:center; 
 		top:40%;
	}
	h1{
		margin-top:100px;
		margin-bottom:50px;
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
	<h1>
		Welcome To Book Manager
	</h1>
	<p>
	<button name="new" onclick="location='addbook'" class="button orange" style="width:140px;">Add book</button><br><br><br>
	<button name="search" onclick="location='search'" class="button orange" style="width:140px;">Search book</button>
	</p>
</body>
</html>