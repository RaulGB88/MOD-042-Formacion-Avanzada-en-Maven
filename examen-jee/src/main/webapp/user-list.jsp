<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<title>Sistema de adivinacion</title>
</head>
<body>
	<center>
		<h1>Gestor de Usuarios</h1>
        <h2>
        	<a href="new">Agregar nuevo usuario</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Listar todos los usuarios</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de usuarios</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Fecha de Nacimiento</th>
                <th>Acciones</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.nombre}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.fechaNacimiento}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${user.id}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${user.id}' />">Borrar</a>  
                  	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
