<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <style>
body{
background-image:url("images/image6.jpg");
background-size:100% 100%;
}

</style>
    <h1 style="color:red;text-align:center">Scientist ADD Form</h1>
    <body >
    <div align="center">
    <table border="1" style="color:navy;background:mistyrose">
    <form:form method="POST" modelAttribute="scCmd">
    <tr>
    <td>Scientist ID::</td>
    <td><form:input path="id"/></td>
    </tr>
    <tr>
    <td>Scientist Name::</td>
    <td><form:input path="name"/><form:errors path="name"></form:errors></td>
    </tr>
    <tr>
    <td>Scientist Domain::</td>
    <td><form:input path="domain"/><form:errors path="domain"></form:errors></td>
    </tr>
    <tr>
    <td>Scientist Experience::</td>
    <td><form:input path="experience"/><form:errors path="experience"></form:errors></td>
    </tr>
    <tr>
    <td>Scientist Patents Count::</td>
    <td><form:input path="patentsCount"/><form:errors path="patentsCount"></form:errors></td>
    </tr>
    <tr>
    <input type="hidden" name="cToken" value="${sToken}"/>
    <td><input type="submit" value="Register"/></td>
    <td><input type="reset" value="cancel"/></td>
    </tr>
    
    </form:form>
    </table>
    </div>
    <p><a href="home.htm"><img width="70" heigth="70" src="images/home1.jpg"></a></p>
    </body>
