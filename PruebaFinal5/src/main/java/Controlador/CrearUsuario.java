package Controlador;

import ModelDAO.UsuarioDAOImpl;
import Modelo.Administrativo;
import Modelo.Cliente;
import Modelo.Profesional;
import Modelo.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAOImpl usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoUsuario = request.getParameter("tipoUsuario");
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        int rut = Integer.parseInt(request.getParameter("rut"));
        String clave = request.getParameter("clave");

        Usuario usuario = null;
        switch (tipoUsuario) {
            case "cliente":
                int run = Integer.parseInt(request.getParameter("run"));
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String telefono = request.getParameter("telefono");
                String afp = request.getParameter("afp");
                int sistemaSalud = Integer.parseInt(request.getParameter("sistemaSalud"));
                String direccion = request.getParameter("direccion");
                String comuna = request.getParameter("comuna");
                int edad = Integer.parseInt(request.getParameter("edad"));

                usuario = new Cliente(nombre, fechaNacimiento, rut, clave, run, nombres, apellidos, telefono, afp, sistemaSalud, direccion, comuna, edad);
                break;
            case "administrativo":
                String area = request.getParameter("area");
                String experienciaPrevia = request.getParameter("experienciaPrevia");
                usuario = new Administrativo(nombre, fechaNacimiento, rut, clave, area, experienciaPrevia);
                break;
            case "profesional":
                String titulo = request.getParameter("titulo");
                String fechaIngreso = request.getParameter("fechaIngreso");
                usuario = new Profesional(nombre, fechaNacimiento, rut, clave, titulo, fechaIngreso);
                break;
            default:
                // Manejar caso no válido
                break;
        }

        // Llama al método create del DAO
        usuarioDAO.create(usuario);

        // Redirigir a una página de confirmación
        request.getRequestDispatcher("/views/mensajeconfirmacion.jsp").forward(request, response);
    
    }
}