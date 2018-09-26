<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<sql:query var="rs" dataSource="jdbc/TestDB">
select id, email, first_name, last_name, text from offers
</sql:query>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>

<a href="class/">Class</a>
<a href="session/">SessionTest</a>
<a href="model/">ModelTest</a>
<a href="modelandview/">ModelAndViewTest</a>
<a href="student/">Student</a></br>
hello world</br>

<c:forEach var="row" items="${rs.rows}">
    Id: ${row.id}<br/>
    Email: ${row.email}<br/>
    First Name: ${row.first_name}<br/>
    Last Name: ${row.last_name}<br/>
    Text: ${row.text}<br/> </br>
</c:forEach>
</body>
</html>