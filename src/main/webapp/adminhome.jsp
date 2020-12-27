<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button><a href="http://localhost:8081/addtest">addtest</a></button>
<br>
</br>
<table border="1">
<tr>
	<th>testid</th>
	<th>testName</th>
	<th>Quemgn</th>
	<th>delete</th>
</tr>
<c:forEach var="test" items="${tlist}">
<tr>
<td>${test.id}</td>
<td>${test.tname}</td>
<td><button><a href="http://localhost:8081/questionmang${test.id}">Questionmang</a></button></td>
<td><button><a href="http://localhost:8081/deletetest${test.id}">delete</a></button></td>
</tr>
</c:forEach>
</table>
</body>
</html>