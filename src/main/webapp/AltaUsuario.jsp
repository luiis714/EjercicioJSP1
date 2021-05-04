<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" >
		<title>Alta Usuario</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" flush="false"/>
	    <form method="post" action="AltaUsuario">
	        <h1>Registrar Usuario</h1>
			<div>
	            ID Rol: <input type="text" name="id_rol" id="id_rol" />
	        </div>
	        </br>
	        </br>
	        <div>
	            Email: <input type="text" name="email" id="email"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Clave: <input type="text" name="clave" id="clave"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Nombre: <input type="text" name="nombre" id="nombre"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Primer Apellido: <input type="text" name="apellido1" id="apellido1"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Segundo Apellido: <input type="text" name="apellido2" id="apellido2"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Dirección: <input type="text" name="direccion" id="direccion"/>
	        </div>
	        </br></br>
	        <div>
	            Localidad: <input type="text" name="localidad" id="localidad"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Provincia: <input type="text" name="provincia" id="provincia"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            Teléfono: <input type="text" name="telefono" id="telefono"/>
	        </div>
	        </br>
	        </br>
	        <div>
	            DNI: <input type="text" name="dni" id="dni"/>
	        </div>
	        </br>
	        </br>
	        </br>
	        <div>
	            <input type="submit" name="registro" value="Registrar"/>
	        </div>
	    </form>
	</body>
</html>