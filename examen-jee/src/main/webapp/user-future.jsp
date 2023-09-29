<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<title>Sistema de adivinacion</title>
</head>
<body>
	<center>
		<h1>Horoscopo</h1>
        <h2>
        	<a href="new">Agregar nuevo usuario</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Listar todos los usuarios</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Nombre</th>
                <th>Signo</th>
                <th>Horoscopo</th>
                <th>Acciones</th>
            </tr>

                <tr>
                    <td><c:out value="${user.nombre}" /></td>
                    <td><c:out value="${signo}" /></td>
                    <td><c:out value="${presagio}" /></td>
                    <td>
                    	<a href="again?id=<c:out value='${user.id}' />">Consultar de nuevo</a>                  	
                    </td>
                </tr>

        </table>
    </div>	
</body>
</html>
