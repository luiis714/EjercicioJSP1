<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Rol</title>
	</head>
	<body>
		<form method="post" action=AltaRol>
			<jsp:include page="Header.jsp" flush="false"/>
			<h1>Registrar Rol</h1>
			<div>
	            Rol: <input type="text" name="rol" />
	        </div>
	        </br>
	        <div>
	            <input type="submit" name="registro" value="Registrar"/>
	        </div>
	
		</form>
	</body>
</html>