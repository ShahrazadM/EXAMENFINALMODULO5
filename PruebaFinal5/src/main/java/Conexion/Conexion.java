package Conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

	private static Connection conn = null;
	//constructor privado
	 private Conexion() {
	// Datos de conexión a la base de datos
    String url = "jdbc:mysql://localhost:3306/sprintf";
    String driver = "com.mysql.jdbc.Driver";
    String user = "Alumno";
    String password = "1234";

    // 
            try {
            	// Agrega un mensaje de registro para indicar que se está intentando establecer la conexión
                System.out.println("Intentando establecer la conexión a la base de datos...");

                // Cargar el driver de MySQL
                Class.forName(driver);
             // Agrega un mensaje de registro para indicar que la conexión se estableció correctamente
                
                try {
                	conn = DriverManager.getConnection(url, user, password);
                } catch (SQLException se) {
                	se.printStackTrace();
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
	 }
	 // METODOS
	 public static Connection getConnection() {
		 if( conn == null) {
			 new Conexion();
			 System.out.println("creando conexion");
			 System.out.println("metodo para get conection");
			 return conn;
		 }
            else {
            	System.out.println("retorno conexion");
            	return conn;
            }
	 }

		public static Connection abrirConeccion() {
			String url="jdbc:mysql://localhost:3306/sprintf";
			String driver = "com.mysql.jdbc.Driver";			
			String user = "Alumno";
			String password = "1234";
			
			try {
				Class.forName(driver);
	            try {
	                conn = DriverManager.getConnection(url, user, password);
	            } catch (SQLException se) {
	                //Handle errors for JDBC
	            	System.out.println("error conexion");
	                se.printStackTrace();
	            }
	        } catch (Exception ex) {
	            //Handle errors for Class.forName
	        	System.out.println("fallo algo");
	            ex.printStackTrace();
	        }
			return conn;
		}
		
}