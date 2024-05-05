<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="mimenu.jsp" %>
    <title>Listar Usuarios</title>
</head>
<body>
    <h2>Listar Usuarios</h2>
    <form action="ListarUsuarioServlet" method="post">
        <label>Seleccione el tipo de usuario:</label>
        <select name="tipoUsuario">
            <option value="cliente">Cliente</option>
            <option value="profesional">Profesional</option>
            <option value="administrativo">Administrativo</option>
        </select>
        <input type="submit" value="Listar">
    </form>

    <c:if test="${not empty usuarios}">
        <h3>Usuarios Listados:</h3>
        <c:forEach var="usuario" items="${usuarios}">
            <c:choose>
                <c:when test="${usuario.getClass().getName() == 'Modelo.Cliente'}">
                    <p>Cliente: ${usuario.obtenerNombre()}</p>
                    <!-- Agrega aquí más campos específicos de Cliente si es necesario -->
                </c:when>
				<c:when test="${usuario.getClass().getName() eq 'Modelo.Profesional'}" >
                    <!-- Agrega aquí más campos específicos de Profesional si es necesario -->
                </c:when>
                <c:when test="${usuario.getClass().getName() eq 'Modelo.Administrativo'}" >
                    <p>Administrativo: ${usuario.obtenerNombre()}</p>
                    <!-- Agrega aquí más campos específicos de Administrativo si es necesario -->
                </c:when>
            </c:choose>
        </c:forEach>
    </c:if>

    <form action="editarusuario.jsp" method="post">
        <input type="submit" value="Editar Usuario">
    </form>
</body>
</html>