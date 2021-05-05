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
			<li><a method="post" href="<%=request.getContextPath()%>/ListadoUsuarios">Visualizar usuarios</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/ListadoRoles">Visualizar roles</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/AltaCategoria.jsp">Alta categoría</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/ListadoCategorias">Visualizar categorías</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/AltaProducto.jsp">Alta producto</a></li>
			<li><a method="post" href="<%=request.getContextPath()%>/ListadoProductos">Visualizar productos</a></li>
		</ul>
		
	</body>
</html>