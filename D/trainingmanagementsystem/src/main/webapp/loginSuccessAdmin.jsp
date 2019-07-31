Hello to all from Admin

<center>
List Of Registered Student-Subject: 
</center>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>  
<head>  
<title>Subject </title>  
</head>  
<body> 
<br/>
<br/>
<center>
<table border="1">
<tr> 
   <td>ID<td>
   <td>Subject ID<td>
   <td>Name<td>
   <td> DELETE User<td>
   </tr> 

<c:forEach items="${subjects}" var="item"> 

<tr> 
   <td>${item.getId()}<td>
   <td>${item.getSubjectId()}<td>
   <td>${item.getUserName()}<td>
   <td><a href="deleteUserSubject?id=${item.getId()}" >DELETE</a> <td>
   </tr> 
</c:forEach> 
</table>  
<center>
<br/>
<a href="/logout">Logout</a>
</body>  
</html>  

