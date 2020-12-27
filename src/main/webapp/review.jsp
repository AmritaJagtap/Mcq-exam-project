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
<table border="1">
<tr>
	<th>Question</th>
	<th>1</th>
	<th>2</th>
	<th>3</th>
	<th>4</th>
	<th>correct ans</th>
	<th>userchoice</th>
	
</tr>
<c:forEach var="review" items="${rlist}">
<tr>
	<td>${review.question.qname}</td>
	<td>${review.question.qa}</td>
	<td>${review.question.qb}</td>
	<td>${review.question.qc}</td>
	<td>${review.question.qd}</td>
	<td>${review.question.ans}</td>
	<td>${review.userchoice}</td>
</tr>

</c:forEach>


</table>

<button><a href="http://localhost:8081/home">Home</a></button>
</body>
</html>