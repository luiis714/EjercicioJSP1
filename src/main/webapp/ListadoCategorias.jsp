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
				ArrayList <Usuarios> lista = (ArrayList<Usuarios>)request.getAttribute("listaUsuarios");
			%>
		
		<h1>Listado Usuarios</h1>
			<table border="2">
					<tr>
				  	  	<th>Id</th>
				    	<th>Rol</th>
				    	<th>Email</th>
				    	<th>Contraseña</th>
				    	<th>Nombre</th>
				    	<th>Primer apellido</th>
				    	<th>Segundo apellido</th>
				    	<th>Dirección</th>
				    	<th>Localidad</th>
				    	<th>Provincia</th>
				    	<th>Teléfono</th>
				    	<th>DNI</th>
			   		 </tr>
					<%
					for(int i = 0; i < lista.size(); i++){
					%>	
						<tr>
							<td><%=lista.get(i).getId() %></td>
			                <td><%=lista.get(i).getIdRol() %></td>
			                <td><%=lista.get(i).getEmail() %></td>
			                <td><%=lista.get(i).getClave()%></td>
			                <td><%=lista.get(i).getNombre() %></td>
			                <td><%=lista.get(i).getApellido1() %></td>
			                <td><%=lista.get(i).getApellido2() %></td>
			                <td><%=lista.get(i).getDireccion() %></td>
			                <td><%=lista.get(i).getLocalidad() %></td>
			                <td><%=lista.get(i).getProvincia() %></td>
			                <td><%=lista.get(i).getTelefono() %></td>
			                <td><%=lista.get(i).getDni() %></td>
							
						</tr>
					<%
					}
					%>					
					
			  <!-- <c:forEach items="${pageScope.listaUsuarios}" var="usuario" varStatus="status" begin="0" end="${pageScope.listaUsuarios.size() - 1}">
			        <tr>
			        	<td><c:out value="${usuario.id}" /></td>
		                <td><c:out value="${usuario.idRol}" /></td>
		                <td><c:out value="${usuario.email}" /></td>
		                <td><c:out value="${usuario.clave}" /></td>
		                <td><c:out value="${usuario.nombre}" /></td>
		                <td><c:out value="${usuario.apellido1}" /></td>
		                <td><c:out value="${usuario.apellido2}" /></td>
		                <td><c:out value="${usuario.direccion}" /></td>
		                <td><c:out value="${usuario.localidad}" /></td>
		                <td><c:out value="${usuario.provincia}" /></td>
		                <td><c:out value="${usuario.telefono}" /></td>
		                <td><c:out value="${usuario.dni}" /></td>          
			        </tr>
			    </c:forEach>
			     -->  
			</table>
	</body>
</html>