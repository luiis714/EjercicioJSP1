<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, datamodel.dao.*, datamodel.entities.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado Roles</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" flush="false"/>
		<%
				ArrayList<Roles> lista = (ArrayList<Roles>)request.getAttribute("listaRoles");
		%>
		
		<h1>Listado Roles</h1>
		

		<form action="" method="post">
			<table border="2">
					<tr>
				  	  	<th>Id</th>
				    	<th>Nombre</th>
			   		 </tr>
				
			    <%
					for(int i = 0; i < lista.size(); i++){
					%>	
						<tr>
							<td><%=lista.get(i).getId() %></td>
			                <td><%=lista.get(i).getRol() %></td>
						</tr>
					<%
					}
					%>	
			</table>
		</form>
	</body>
</html>