<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.formtable {
	width: 400px;
	padding: 10px;
	border: 1px solid blue;
}

input[type=text] {
	width: 250px;
	
}

textarea {
	width: 250px;
	height: 300px;
}

.label {
	text-align: right;
	vertical-align: top;
}

.control {
	margin-left: 10px;
}

</style>
</head>
<body>
Add Offer

<form method=post action="${pageContext.request.contextPath}/doCreate">

	<label>First Name:</label>
	<input type="text" id="firstName" name="firstName"><br>
	
	<label>Last Name:</label>
	<input type="text" id="lastName" name="lastName"><br>
	
	<label>Email:</label>
	<input type="text" id="email" name="email"><br>
	
	<label>Text:</label>
	<input type="text" id="text" name="text"><br>
	
	<input type="submit" value="Add"> 
</form>
</body>
</html>