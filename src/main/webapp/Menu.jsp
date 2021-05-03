<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu</title>
	</head>
	<body>
		<h1>MENU PRINCIPAL</h1>
		
		<form method="post" action="AltaUsuario.jsp">
			<input type="submit" name="alta_usuario" value="Alta usuario"/>
		</form>
		<form method="post" action="AltaRol.jsp">
			<input type="submit" name="alta_rol" value="Alta rol"/>
		</form>
		<form method="post" action="ListadoUsuarios.jsp">
			<input type="submit" name="listado_usuarios" value="Listado usuarios"/>
		</form>
		<form method="post" action="ListadoRoles.jsp">
			<input type="submit" name="listado_roles" value="Listado roles"/>
		</form>
		
	</body>
</html>