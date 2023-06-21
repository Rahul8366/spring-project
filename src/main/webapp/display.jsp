<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <!-- "isELIgnored="false"=> It is an atrribute which is used inside the directive tag in jsp file 
    in order to print /display the data in desired formet
    =>the default value is true  
    Note - we are surrounding the value with S{} in order to received the data in whatever state it is present-->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
     <!--  In this JSP Page we have created a  table to reprsent our data exactly how it is saved inside the database -->
   <table border="10px">
   <tr> 
   <th>Student_Id</th>
   <th>Student_Name</th>
   <th>Student_Email</th>
   <th>Student_Password</th>
   <th>Edit</th>
   <th>Delete</th>
     </tr>   
     <!-- we have declared a c:forEach loop inorder to iterate through the list of data we have recived from the displaystudent()
     method 
     var ="student "=>It is the refrence variable of the student type which will acepts the key we have set inside the displaystudent()
     method for the (list of students).
     NOTE - we are surrounding the values with S{} in order to receive the data in whatever state it is present.
      -->
   <c:forEach var="s" items="${stud}">
   <tr>
   <td>${s.getId()} </td>
   <td>${s.getName()}</td>
   <td>${s.getEmail()}</td>
   <td>${s.getPassword()}</td>
   <!-- Inside this<td>tag will we have used an anchor(<a>) tag where the value is(Edit) and the href is (updateStudent).
   So when we click on edit it go in search of a @requestMapping(/updateStudent)
   we have also taken the id of the particular student object for which request will given to the object know 
   (id) will be the primary key in the database with the help of which wu can fetch that student object from the database.
    -->
   <td><a href="updateStudent?id=${s.getId()}">Edit</a></td>
   <td><a href="deleteStudent?id=${s.getId()}">Delete</a> </td>
   </tr>
   </c:forEach>
      
      </table>
</body>
</html>

<!-- isELIgnored="true" -->