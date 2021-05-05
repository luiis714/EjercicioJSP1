<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, datamodel.dao.*, datamodel.entities.*, datamodel.util.*" %>
<%@ page import="org.hibernate.Session" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado Usuarios</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" flush="false"/>
			<%
				ArrayList <Productos> lista = (ArrayList<Productos>)request.getAttribute("listaProductos");
			%>
		
		<h1>Listado Usuarios</h1>
			<table border="2">
					<tr>
				  	  	<th>Id</th>
				    	<th>ID Categoria</th>
				    	<th>Nombre</th>
				    	<th>Descripción</th>
				    	<th>Precio</th>
				    	<th>Stock</th>
				    	<th>Fecha alta</th>
				    	<th>Fecha baja</th>
				    	<th>Impuesto</th>
			   		 </tr>
					<%
					for(int i = 0; i < lista.size(); i++){
					%>	
						<tr>
							<td><%=lista.get(i).getId() %></td>
			                <td><%=lista.get(i).getIdCategoria() %></td>
			                <td><%=lista.get(i).getNombre() %></td>
			                <td><%=lista.get(i).getDescripcion()%></td>
			                <td><%=lista.get(i).getPrecio() %></td>
			                <td><%=lista.get(i).getStock() %></td>
			                <td><%=lista.get(i).getFechaAlta() %></td>
			                <td><%=lista.get(i).getFechaBaja() %></td>
			                <td><%=lista.get(i).getImpuesto() %></td>
							
						</tr>
					<%
					}
					%>
			</table>
	</body>
</html>