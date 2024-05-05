package Controlador;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/sprintf";
    private static final String USERNAME = "Alumno";
    private static final String PASSWORD = "1234";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirigir a la página de inicio de sesión (login.jsp)
        getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros de la solicitud (rut y clave)
        String run = request.getParameter("run");
        String clave = request.getParameter("clave");

        // Verificar las credenciales del usuario utilizando la base de datos
        String tipoUsuario = verificarCredenciales(run, clave);

        // Redirigir según el tipo de usuario
        if (tipoUsuario != null) {
            switch (tipoUsuario) {
                case "cliente":
                case "administrativo":
                case "profesional":
                    response.sendRedirect("/views/home.jsp");
                    break;
            }
        } else {
            // Si las credenciales son incorrectas, redirigir a la página de login con un mensaje de error
            response.sendRedirect("/views/login.jsp?error=1");
        }
    }

    private String verificarCredenciales(String run, String clave) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT 'cliente' AS tipo_usuario FROM Cliente WHERE rut = ? AND usuarioId IN (SELECT id FROM Usuarios WHERE clave = ?) " +
                         "UNION " +
                         "SELECT 'profesional' AS tipo_usuario FROM Profesional WHERE usuarioId IN (SELECT id FROM Usuarios WHERE run = ? AND clave = ?) " +
                         "UNION " +
                         "SELECT 'administrativo' AS tipo_usuario FROM Administrativo WHERE usuarioId IN (SELECT id FROM Usuarios WHERE run = ? AND clave = ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, run);
                statement.setString(2, clave);
                statement.setString(3, run);
                statement.setString(4, clave);
                statement.setString(5, run);
                statement.setString(6, clave);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("tipo_usuario");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }}