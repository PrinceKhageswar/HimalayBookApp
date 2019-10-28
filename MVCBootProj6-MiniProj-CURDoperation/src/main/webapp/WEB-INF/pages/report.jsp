<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<h1 style="color:fuchsia;text-align:center"><u>All Scientist Details</u></h1>
<style>
body{
background-image:url("images/image4.jpg");
background-size:100% 100%;
}

</style>


<body>
<div align="center">
<c:choose>
<c:when test="${!empty listDTO}">
<table border="2" style="color:navy;background:mistyrose">
<tr bgcolor="mintcream" style="color:red"><th>SRNO</th><th>ID</th><th>Name</th><th>Domain</th><th>Experience</th><th>PatentsCount</th><th>Operation</th></tr>
<c:forEach var="dto" items="${listDTO}">
<tr>
<td>${dto.srno}</td>
<td>${dto.id}</td>
<td>${dto.name}</td>
<td>${dto.domain}</td>
<td>${dto.experience}</td>
<td>${dto.patentsCount}</td>
<td>
<a href="edit.htm?id=${dto.id}"><img src="images/edit.png" width="30" height="30"></a>
&nbsp;
<a href="delete.htm?id=${dto.id}" onclick = "if (! confirm('Do you want to delete the Scientist?'+${dto.id})) { return false; }"><img src="images/delete.png" width="30" height="30"></a>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Records not found</h1>
</c:otherwise>


</c:choose>
</div>
 <p style="text-align:center"> <a href="add.htm"><img src="images/add.png" width="70" height="70"></a> 
    <a href="home.htm"><img width="70" heigth="70" src="images/home1.jpg"></a>
     </p>
    </body>
    