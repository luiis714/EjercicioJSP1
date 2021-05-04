<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*, java.time.format.*" %>
<%@page import="datamodel.entities.*, datamodel.dao.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div id="info-usuario">
			<div>Fecha y hora inicio: ${sessionScope.fechaLog}
				<div id="btns" align="right"> 
					<button href=""> << Volver</button>
					<button href="Login"> X Cerrar sesión</button>
				</div>
			<div>
			<div>Rol: ${sessionScope.rol.getRol()}</div>
			<div>Usuario: ${sessionScope.usuario.getNombre()} 
			${sessionScope.usuario.getApellido1()} 
			${sessionScope.usuario.getApellido2()}</div>      
			
		</div>
		

	</body>
</html>