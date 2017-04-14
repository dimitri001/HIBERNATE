<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de Usuarios</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Lista de Usuarios </span></div>
		  	<div class="tablecontainer">
				<table class="table table-hover">
		    		<thead>
			      		<tr>
					        <th>Nombre</th>
					        <th>Apellido</th>
					        <th>Email</th>
					        <th>SSO ID</th>
					        <th width="100"></th>
					        <th width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<td>${user.ssoId}</td>
							<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">editar</a></td>
							<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">borrar</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newuser' />">Añadir nuevo usuario</a>
	 	</div>
   	</div>
</body>
</html>