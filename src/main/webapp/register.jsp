<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<f:form action="save" modelAttribute="student">
		<f:input path="id" placeholder="enter id" />
		<br>
		<f:input path="name" placeholder="enter name" />
		<br>
		<f:input path="email" placeholder="enter email" />
		<br>
		<f:input path="password" placeholder="enter password" />
		<br>
		<input type="submit" value="register">
	</f:form>

</body>
</html>

<!-- modelAttribute - It is a keyword/ an attribute for the f:form tag which we accept the "key"
 of the obeject sent from the java application-->