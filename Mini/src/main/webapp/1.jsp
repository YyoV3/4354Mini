<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>






<%
//Integer number = (Integer) request.getAttribute("ValueA");


//int   s   =(int)request.getAttribute( "ValueA ");	

%>
The value is: <%= request.getAttribute("value") %>


<form method="post" action="http://localhost:8080/Mini/Servlet">



 Enter OTP:<br>
<input type="text" name="otp" >
<br>


<br>
<input type="submit" value="Submit">


</form> 





</body>
</html>