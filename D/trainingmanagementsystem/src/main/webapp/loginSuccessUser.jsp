<center>
List Of Subjects: 
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
   <td>Subject Name<td>
   <td>Subject Description<td>
   <td> ADD Subject<td>
   <td> DELETE Subject<td>
   </tr> 

<c:forEach items="${subjectlist}" var="item"> 

<tr> 
   <td>${item.getId()}<td>
   <td>${item.getSubjectname()}<td>
   <td>${item.getSubjectdescription()}<td>
   <td><a href="addSubject?id=${item.getId()}" >ADD</a> <td>
   <td><a href="deleteSubject?id=${item.getId()}" >DELETE</a> <td>
   </tr> 
</c:forEach> 
</table>  
<center>
<br/>
<a href="/logout">Logout</a>
</body>  
</html>  