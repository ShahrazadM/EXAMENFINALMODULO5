<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Crear Capacitación</title>
</head>
<body>
    <h2>Crear Capacitación</h2>
    <form action="CrearCapacitacionServlet" method="post">
        <label>Identificador:</label>
        <input type="text" name="identificador"><br>
        <label>Rut Cliente:</label>
        <input type="text" name="rutCliente"><br>
        <label>Día:</label>
        <input type="text" name="dia"><br>
        <label>Hora:</label>
        <input type="text" name="hora"><br>
        <label>Lugar:</label>
        <input type="text" name="lugar"><br>
        <label>Duración:</label>
        <input type="text" name="duracion"><br>
        <label>Cantidad de Asistentes:</label>
        <input type="text" name="cantidadAsistentes"><br>
        <input type="submit" value="Crear">
    </form>
</body>
</html>
<%@ include file="mimenu.jsp" %>