<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
</head>
<body>
    <h1>Crear Usuario</h1>
    <form action="CrearUsuarioServlet" method="post">
        <input type="hidden" name="operacion" value="crear">
        
        <label for="tipoUsuario">Tipo de Usuario:</label>
        <select name="tipoUsuario" id="tipoUsuario">
            <option value="cliente">Cliente</option>
            <option value="administrativo">Administrativo</option>
            <option value="profesional">Profesional</option>
        </select>
        <br><br>
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <br><br>

        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>
        <br><br>

        <label for="rut">RUT:</label>
        <input type="text" id="rut" name="rut" required>
        <br><br>

        <!-- Campos específicos para cada tipo de usuario -->
        <div id="clienteFields" style="display: none;">
            <label for="run">Run:</label>
            <input type="text" id="run" name="run">
            <br><br>
            
            <label for="nombres">Nombres:</label>
            <input type="text" id="nombres" name="nombres">
            <br><br>
            
            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos">
            <br><br>
            
            <label for="telefono">Teléfono:</label>
            <input type="text" id="telefono" name="telefono">
            <br><br>
            
            <label for="afp">AFP:</label>
            <input type="text" id="afp" name="afp">
            <br><br>
            
            <label for="sistemaSalud">Sistema de Salud:</label>
            <input type="text" id="sistemaSalud" name="sistemaSalud">
            <br><br>
            
            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion">
            <br><br>
            
            <label for="comuna">Comuna:</label>
            <input type="text" id="comuna" name="comuna">
            <br><br>
            
            <label for="edad">Edad:</label>
            <input type="text" id="edad" name="edad">
            <br><br>
        </div>

        <div id="administrativoFields" style="display: none;">
            <label for="area">Área:</label>
            <input type="text" id="area" name="area">
            <br><br>
            
            <label for="experienciaPrevia">Experiencia Previa:</label>
            <input type="text" id="experienciaPrevia" name="experienciaPrevia">
            <br><br>
        </div>

        <div id="profesionalFields" style="display: none;">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo">
            <br><br>
            
            <label for="fechaIngreso">Fecha de Ingreso:</label>
            <input type="date" id="fechaIngreso" name="fechaIngreso">
            <br><br>
        </div>

        <input type="submit" value="Crear Usuario">
    </form>

    <script>
        document.getElementById('tipoUsuario').addEventListener('change', function() {
            var selectedValue = this.value;
            var clienteFields = document.getElementById('clienteFields');
            var administrativoFields = document.getElementById('administrativoFields');
            var profesionalFields = document.getElementById('profesionalFields');
            
            if (selectedValue === 'cliente') {
                clienteFields.style.display = 'block';
                administrativoFields.style.display = 'none';
                profesionalFields.style.display = 'none';
            } else if (selectedValue === 'administrativo') {
                clienteFields.style.display = 'none';
                administrativoFields.style.display = 'block';
                profesionalFields.style.display = 'none';
            } else if (selectedValue === 'profesional') {
                clienteFields.style.display = 'none';
                administrativoFields.style.display = 'none';
                profesionalFields.style.display = 'block';
            } else {
                clienteFields.style.display = 'none';
                administrativoFields.style.display = 'none';
                profesionalFields.style.display = 'none';
            }
        });
    </script>
</body>
</html>
<%@ include file="mimenu.jsp" %> <!-- Incluye el menú -->