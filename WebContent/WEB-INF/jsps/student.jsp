<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<label>First Name:</label>
	<input type="text" id="firstName" name="firstName"><br>
	
	<label>Last Name:</label>
	<input type="text" id="lastName" name="lastName"><br>
	
	<label>Address:</label>
	<input type="text" id="address" name="address"><br>
	
	<label>Contact:</label>
	<input type="text" id="contact" name="contact"><br>
	
	<label>Gender</label>
	<input type="radio" name="gender">Male
	<input type="radio" name="gender">Female<br>
	
	<input type="button" value="Submit" name="submit" id="submit">
</form>
</body>
</html>