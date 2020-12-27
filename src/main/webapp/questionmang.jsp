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
${testname}

questions in test
<br>
</br>
<table border="1">
<tr>
	<th>QId</th>
	<th>Question</th>
	<th>1</th>
	<th>2</th>
	<th>3</th>
	<th>4</th>
	<th>Correct ans</th>
	<th>Action</th>
</tr>
<c:forEach var="q" items="${qlist}">
<tr>
	<td>${q.id}</td>
	<td>${q.qname}</td>
	<td>${q.qa}</td>
	<td>${q.qb}</td>
	<td>${q.qc}</td>
	<td>${q.qd}</td>
	<td>${q.ans}</td>
	<td><button><a href="http://localhost:8081/removequestion${q.id}">remove</a></button></td>
	</tr>
</c:forEach>

</table>
<br>
database questions
</br>
<table border="1">
<tr>
	<th>QId</th>
	<th>Question</th>
	<th>1</th>
	<th>2</th>
	<th>3</th>
	<th>4</th>
	<th>Correct ans</th>
	<th>Action</th>
</tr>
<c:forEach var="q" items="${qlistdb}">
<tr>
	<td>${q.id}</td>
	<td>${q.qname}</td>
	<td>${q.qa}</td>
	<td>${q.qb}</td>
	<td>${q.qc}</td>
	<td>${q.qd}</td>
	<td>${q.ans}</td>
	<td><button><a href="http://localhost:8081/addquestion${q.id}">add</a></button></td>
</tr>
</c:forEach>
</table>
</body>
</html>