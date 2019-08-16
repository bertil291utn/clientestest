<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Art&iacute;culo</title>
</head>
<body>
	<h1>Actualizar Artículo</h1>
	<form action="adminArticulo?action=editar" method="post">
		<table>
			<input type="hidden" name="cod" value="<c:out value='${user.cod}' />" />

			<tr>
				<th>Cedula:</th>
				<td><input type="text" name="ci" size="45"
					value="<c:out value='${user.ci}' />" /></td>
			</tr>
			<tr>
				<th>Nombre:</th>
				<td><input type="text" name="nombre" size="45"
					value="<c:out value='${user.nombre}' />" /></td>
			</tr>
			<tr>
				<th>Apellido:</th>
				<td><input type="text" name="apellido" size="45"
					value="<c:out value='${user.apellido}' />" /></td>
			</tr>
			<tr>
				<th>Pass:</th>
				<td><input type="password" name="contrasena" size="15"
					value="<c:out value='${user.contrasena}' />" /></td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><input type="text" name="direccion" size="45"
					value="<c:out value='${user.direccion}' />" /></td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><input type="text" name="telefono" size="15"
					value="<c:out value='${user.telefono}' />" /></td>
			</tr>
			<tr>
				<th>Estado Civil:</th>
				<td><input type="text" name="estado" size="15"
					value="<c:out value='${user.estado}' />" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="mail" size="45"
					value="<c:out value='${user.mail}' />" /></td>
			</tr>
			
		</table>

		<input type="submit" name="registrar" value="Guardar">
	</form>

</body>
</html>