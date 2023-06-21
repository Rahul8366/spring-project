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

<!-- ModelAttribute ->It is keyboard / an attribute for the f:form tag which we accepts the "key"
 of the object sent from the java application.
 PATH- IT is an attribute inside your f:input tag which will take the variable name of the null classes object 
 passed inside modelAttribute. And it must be excatly same as the variable name in the DTO classes -->
 <!-- in this JSP page we are reciving the null object sent from the registerstudent() method and trking input 
 for all the variables required for the objecct from the browser
 
 and after adding the values and clicking on the register button we have given an action for(/save) in the from tag
 So it will go in search of an @requestMapping(/save) inside our Controller classes -->
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