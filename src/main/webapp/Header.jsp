<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*, java.time.format.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div>
			Usuario: ${sessionScope.usuario.getNombre()} 
			${sessionScope.usuario.getApellido1()} 
			${sessionScope.usuario.getApellido1()}      
			<div>Inicio de sesión: ${sessionScope.fechaLog}<div>
		</div>
	</body>
</html>