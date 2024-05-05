package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelDAO.IListaUsuarioDAO;
import ModelDAO.ListaUsuarioDAOImpl;
import Modelo.Usuario;

@WebServlet("/ListaUsuariosServlet")
public class ListaUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private IListaUsuarioDAO usuarioDAO;

    public ListaUsuariosServlet() {
        super();
        usuarioDAO = new ListaUsuarioDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioDAO.todosUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/views/listarusuarios.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}