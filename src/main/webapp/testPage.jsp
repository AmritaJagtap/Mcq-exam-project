<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

welcome in test
</br></br>
${question.qname }
</br></br>
${question.qa }<input type="radio" name="ans" value="1"></br></br>
${question.qb }<input type="radio" name="ans" value="2"></br></br>
${question.qc }<input type="radio" name="ans" value="3"></br></br>
${question.qd }<input type="radio" name="ans" value="4"></br></br>

<c:forEach var="count" begin="1" end="${size}">
<button onclick="myFunction(${count})">${count}</button>
</c:forEach>


</br></br>
<button onclick="myFunction(1000)">Submit</button>

<script>
function myFunction(newquid)
{
	var ans=0;
	 ans=document.querySelector('input[name="ans"]:checked').value;

	window.location='http://localhost:8081/'+ans+'testLoop'+newquid;
}


</script>
</body>
</html>