<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" flush="false"/>
		<h1>MENU PRINCIPAL</h1>
		
		<ul>
			<li><a method="post" href="<%=request.getContextPath()%>/AltaUsuario.jsp">Alta usuario</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/ListadoUsuarios">Visualizar usuarios</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/AltaRol.jsp">Alta rol</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/ListadoRoles">Visualizar rol</a></li>
			<li></li>
			<li></li>
		</ul>
		
	</body>
</html>