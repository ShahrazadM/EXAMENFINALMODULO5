package Controlador;


import java.io.IOException;
import java.util.List;
import Modelo.Contacto;
import Modelo.ContactoRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactoRepository repositorio = new ContactoRepository();
        List<Contacto> contactos = repositorio.obtenerTodosLosContactos();
        request.setAttribute("contactos", contactos);
        getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");

        // Imprimir los datos del contacto en la consola
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Mensaje: " + mensaje);

        // Crear un objeto Contacto con los datos obtenidos
        Contacto contacto = new Contacto(nombre, email, mensaje);

        // Agregar el contacto al repositorio
        ContactoRepository repositorio = new ContactoRepository();
        repositorio.agregarContacto(contacto);

        // Imprimir mensaje de registro
        System.out.println("Contacto guardado: " + contacto.getNombre());

        // Adjuntar la lista actualizada de contactos al objeto request
        List<Contacto> contactos = repositorio.obtenerTodosLosContactos();
        request.setAttribute("contactos", contactos);

        // Redireccionar nuevamente al formulario
        request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
    }
}