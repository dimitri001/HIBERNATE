<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 3 MVC Series - Contact Manager</title>
<link href="css/maquetacion.css" rel="stylesheet" type="text/css" >
 </head>

<body>
<div id ="header">
<img src="images/Hibernate_logo_a.png"/>
</div> 

 <table class="FuenteTitulo2">
<h1><spring:message code="label.title"/></h1>
</table>
<form:form method="post" action="add.html" commandName="contact">
<table class="contentTablaConv">
 <tr>
 <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
   <td><form:input path="firstname" /></td> 
 </tr>
 <tr>
 <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
 <td><form:input path="lastname" /></td>
 </tr>
 <tr>
 <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
 <td><form:input path="email" class="fuentes" /></td>
 </tr>
 <tr>
 <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
 <td><form:input path="telephone" /></td>
 </tr>
 <tr>
 <td colspan="2" >
 <input class="fuentes" type="submit" value="<spring:message code="label.addcontact"/>"/>
 </td>
 </tr>
</table> 
</form:form>
 <table class="FuenteTitulo1">
<h3>Nuevo Contacto</h3>
</table>
<c:if test="${!empty contactList}">
<!--  <table class="data">-->
<table class="contentTabla2">
<tr>
 <th><spring:message code="label.firstname"/></th>
 <th><spring:message code="label.email"/></th>
 <th><spring:message code="label.telephone"/></th>
 <th>&nbsp;</th>
</tr>
<c:forEach items="${contactList}" var="contact">
 <tr>
 <td>${contact.lastname}, ${contact.firstname} </td>
 <td>${contact.email}</td>
 <td>${contact.telephone}</td>
 <td><a href="delete/${contact.id}">Eliminar</a></td>
 </tr>
</c:forEach>
</table>
</c:if>
<img src="images/nuevologosoprasteria.png" class="ImagesopraAcademy"/>
 <div id ="footer">
 <h5> Copyright © 2016 | SopraAcademy <h5></div>
 </body>
</html>