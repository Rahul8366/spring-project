<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<f:form action="saveUpdateStudent" modelAttribute="studentupdate">
	<!-- read only:you can't change/alter the present value here in input tag -->
		<f:input path="id" readonly="true"/>
		<br>
		<f:input path="name"  />
		<br>
		<f:input path="email" />
		<br>
		<f:input path="password"  />
		<br>
		<input type="submit" value="update">
	</f:form>

</body>
</html>