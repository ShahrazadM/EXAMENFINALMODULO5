<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


  <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <label for="run">RUT:</label>
        <input type="text" id="run" name="run" required><br><br>
        
        <label for="clave">Clave:</label>
        <input type="password" id="clave" name="clave" required><br><br>
        
        <input type="submit" value="Iniciar sesión">
    </form>

    <!-- Si hay un parámetro de error en la URL, mostrar un mensaje de error -->
    <% String error = request.getParameter("error"); %>
    <% if (error != null && error.equals("1")) { %>
        <p style="color: red;">¡Credenciales incorrectas! Inténtelo de nuevo.</p>
    <% } %>
</body>
</html>