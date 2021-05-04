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
		<h1>Listado Roles</h1>
		

		<form action="" method="post">
			<table border="2">
					<tr>
				  	  	<th>Id</th>
				    	<th>Nombre</th>
			   		 </tr>
				
			    <c:forEach items="${sessionScope.listaRoles}" var="rol" varStatus="status" begin="0" end="${sessionScope.rolesList.size() - 1}">
			        <tr>
			        	
			                      
			        </tr>
			    </c:forEach>
			</table>
		</form>
	</body>
</html>