package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class InicioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioControlador() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprintf");
            if (conn != null) {
            	System.out.println("conexion correcta");
            } else {
            	System.out.println("conexion fallida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/views/home.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}// 