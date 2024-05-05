package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModelDAO.CapacitacionDAOImpl;

import Modelo.Capacitaciones;
/**
 * Servlet implementation class CapacitacionServlet
 */
@WebServlet("/CapacitacionServlet")
public class CapacitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapacitacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CapacitacionDAOImpl pDAO = new CapacitacionDAOImpl();
		
		//ArrayList<Producto> productos = new ArrayList<Producto>();
		
		List<Capacitaciones> capacitaciones = pDAO.readAll();
		

		request.setAttribute("capacitaciones", capacitaciones);
		
		getServletContext().getRequestDispatcher("/views/listacapacitacion.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
