<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
   <table border="10px">
   <tr> 
   <th>Student_Id</th>
   <th>Student_Name</th>
   <th>Student_Email</th>
   <th>Student_Password</th>
   <th>Edit</th>
   <th>Delete</th>
     </tr>   
   <c:forEach var="s" items="${stud}">
   <tr>
   <td>${s.getId()} </td>
   <td>${s.getName()}</td>
   <td>${s.getEmail()}</td>
   <td>${s.getPassword()}</td>
   <td><a href="updateStudent?id=${s.getId()}">Edit</a></td>
   <td><a href="deleteStudent?id=${s.getId()}">Delete</a> </td>
   </tr>
   </c:forEach>
      
      </table>
</body>
</html>

<!-- isELIgnored="true" -->