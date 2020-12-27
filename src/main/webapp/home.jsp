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
HII HOW ARE YOU 
<table border="1">
<tr>
	<th>Testid</th>
	<th>Tname</th>
	<th>Action</th>
</tr>
<c:forEach var="combo" items="${trlist}">
	<tr>
		<td>${combo.testid}</td>
		<td>${combo.name}</td>
		<td>
			<c:choose>
			<c:when test="${combo.attemped}">${combo.marks}
			<button><a href="http://localhost:8081/review${combo.testid}">Review</a></button>
			</c:when>
			<c:otherwise><button><a href="http://localhost:8081/attempt${combo.testid}">attempt</a></button></c:otherwise>
			</c:choose>
		</td>
	</tr>
	</c:forEach>
	
</table>
<br></br>

<button><a href="http://localhost:8081/logout">Logout</a></button>
</body>
</html>