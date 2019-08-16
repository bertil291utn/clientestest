<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Artículos</title>
</head>
<body>
	<h1>Lista Artículos</h1>
	<table>
		<tr>
			<td><a href="adminArticulo?action=index">Ir al menú</a></td>
		</tr>
	</table>

	<table border="1" width="100%">
		<tr>
			<th>CI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Password</th>
			<th>Direccion</th>
			<th>Telefono</th>
			<th>Estado</th>
			<th>Mail</th>
			<td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="user" items="${lista}">
			<tr>
				<td><c:out value="${user.ci}" /></td>
				<td><c:out value="${user.nombre}" /></td>
				<td><c:out value="${user.apellido}" /></td>
				<td>*********</td>
				<td><c:out value="${user.direccion}" /></td>
				<td><c:out value="${user.telefono}" /></td>
				<td><c:out value="${user.estado}" /></td>
				<td><c:out value="${user.mail}" /></td>
				<td><a
					href="adminArticulo?action=showedit&cod=<c:out value="${user.cod}" />">Editar</a></td>
				<td><a
					href="adminArticulo?action=eliminar&cod=<c:out value="${user.cod}"/>">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>