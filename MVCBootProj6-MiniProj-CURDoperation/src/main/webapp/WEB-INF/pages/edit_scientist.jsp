<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <style>
body{
background-image:url("images/image7.jpg");
background-size:100% 100%;
}

</style>
    <h1 style="color:magenta;text-align:center">Scientist Edit Form</h1>
    <body>
    <div align="center">
    <table border="1" style="color:navy;background:mistyrose">
    <form:form method="POST" modelAttribute="scCmd">
    <tr>
    <td>Scientist ID::</td>
    <td><form:input path="id" disabled="true"/></td>
    </tr>
    <tr>
    <td>Scientist Name::</td>
    <td><form:input path="name"/></td>
    </tr>
    <tr>
    <td>Scientist Domain::</td>
    <td><form:input path="domain"/></td>
    </tr>
    <tr>
    <td>Scientist Experience::</td>
    <td><form:input path="experience"/></td>
    </tr>
    <tr>
    <td>Scientist Patents Count::</td>
    <td><form:input path="patentsCount"/></td>
    </tr>
    <tr> 
    <td><input type="submit" value="Update"/></td>
    <td><input type="reset" value="cancel"/></td>
    </tr>
    
    </form:form>
    </table>
    </div>
    <p><a href="home.htm"><img width="70" heigth="70" src="images/home1.jpg"></a></p>
    </body>