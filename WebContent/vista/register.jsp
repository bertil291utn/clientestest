<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Artículo</title>
</head>
<body>
	<h1>Registrar Artículo</h1>
	<h4>
		<c:out value='${errmsg}' />
	</h4>
	<form action="adminArticulo?action=register" method="post">
		<table border="1" align="center">
			<tr>
				<th>Cedula:</th>
				<td><input type="text" name="ci" size="45" /></td>
			</tr>
			<tr>
				<th>Nombre:</th>
				<td><input type="text" name="nombre" size="45" /></td>
			</tr>
			<tr>
				<th>Apellido:</th>
				<td><input type="text" name="apellido" size="45" /></td>
			</tr>
			<tr>
				<th>Pass:</th>
				<td><input type="password" name="contrasena" size="15" /></td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><input type="text" name="direccion" size="45" /></td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><input type="text" name="telefono" size="15" /></td>
			</tr>
			<tr>
				<th>Estado Civil:</th>
				<td><input type="text" name="estado" size="15" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="mail" size="45" /></td>
			</tr>

		</table>
		<br>
		<table border="0" align="center">
			<tr>
				<td><input type="submit" value="Agregar"></td>
			</tr>

			</form>
</body>
</html>