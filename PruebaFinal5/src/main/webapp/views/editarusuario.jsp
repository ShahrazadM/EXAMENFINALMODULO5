<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
</head>
<body>
    <h2>Editar Usuario</h2>
    <form action="EditarUsuarioServlet" method="post">
        <!-- Resto del formulario... -->

        <div class="mb-3">
            <label for="id">ID del Usuario:</label>
            <input type="text" id="id" name="id">
        </div>
        <div class="mb-3">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre">
        </div>
        <div class="mb-3">
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" id="fechaNacimiento" name="fechaNacimiento">
        </div>
        <div class="mb-3">
            <label for="acceso">Acceso:</label>
            <input type="text" id="acceso" name="acceso">
        </div>
        <div class="mb-3">
            <label for="clave">Clave:</label>
            <input type="password" id="clave" name="clave">
        </div>
        <!-- Agrega más campos del formulario según sea necesario -->

        <button type="submit">Editar Usuario</button>
    </form>

    <script>
        document.getElementById('tipoUsuario').addEventListener('change', function() {
            var selectedValue = this.value;
            var tipoUsuarios = document.querySelectorAll('.tipo-usuario');
            tipoUsuarios.forEach(function(element) {
                if (element.id === selectedValue) {
                    element.style.display = 'block';
                } else {
                    element.style.display = 'none';
                }
            });
        });
    </script>
    
    <%@ include file="mimenu.jsp" %> <!-- Enlace para regresar a la página principal -->
</body>
</html>