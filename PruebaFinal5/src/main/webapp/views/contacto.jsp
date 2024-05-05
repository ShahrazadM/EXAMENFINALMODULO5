
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="mimenu.jsp" %> <!-- Incluye el menú -->
    <title>Formulario de Contacto</title>
</head>
<body>
    <h1>Formulario de Contacto</h1>
    <form method="post" action="ContactoServlet" onsubmit="return validarFormulario();">
        Nombre: <input type="text" id="nombre" name="nombre"><br>
        Email: <input type="email" name="email"><br>
        Mensaje: <textarea name="mensaje"></textarea><br>
        <input type="submit" value="Enviar">
    </form>

    <% String contactoGuardado = (String) request.getAttribute("contactoGuardado");
       if (contactoGuardado != null) { %>
        <p><%= contactoGuardado %></p>
    <% } %>

    <h2>Contactos Guardados</h2>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Email</th>
            <th>Mensaje</th>
        </tr>
        <%@ page import="Modelo.Contacto" %>
        <%@ page import="java.util.List" %>
        <% List<Contacto> contactos = (List<Contacto>) request.getAttribute("contactos");
           if (contactos != null) {
               for (Contacto contacto : contactos) { %>
            <tr>
                <td><%= contacto.getNombre() %></td>
                <td><%= contacto.getEmail() %></td>
                <td><%= contacto.getMensaje() %></td>
            </tr>
        <%     }
           } %>
    </table>

    <script>
        function validarFormulario() {
            var nombre = document.getElementById("nombre").value;
            var mensaje = document.getElementsByName("mensaje")[0].value;

            // Validación de campos
            if (nombre.trim() === "" || mensaje.trim() === "") {
                alert("Por favor, complete todos los campos.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>