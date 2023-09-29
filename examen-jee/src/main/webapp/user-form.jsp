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
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			Edit User
            		</c:if>
            		<c:if test="${user == null}">
            			Agregar nuevo usuario
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        		</c:if>            
            <tr>
                <th>User Nombre: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.nombre}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>User Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${user.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Fecha Nacimiento (yyyy-MM-dd): </th>
                <td>
                	<input type="text" name="fecha" size="15"
                			value="<c:out value='${user.fechaNacimiento}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
