package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import Modelo.Administrativo;
import Modelo.Cliente;
import Conexion.Conexion;
import Modelo.Profesional;
import Modelo.Usuario;

public class UsuarioDAOImpl<UsuarioCompleto> implements IUsuarioDAO {

    protected Connection connection;

    public UsuarioDAOImpl() {
        // Inicializa la conexión a la base de datos
        this.connection = Conexion.getConnection();
    }


    @Override
    public void create(Usuario usuario) {
        String sql = "";
        if (usuario instanceof Cliente) {
            sql = "INSERT INTO cliente (nombre, fechaNacimiento, rut, clave, run, nombres, apellidos, telefono, afp, sistema_salud, direccion, comuna, edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Cliente cliente = (Cliente) usuario;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, cliente.getNombre());
                pstmt.setString(2, cliente.getFechaNacimiento());
                pstmt.setInt(3, cliente.getRun());
                
                pstmt.setString(4, cliente.getClave());
                pstmt.setInt(5, cliente.getRun());
                pstmt.setString(6, cliente.getNombres());
                pstmt.setString(7, cliente.getApellidos());
                pstmt.setString(8, cliente.getTelefono());
                pstmt.setString(9, cliente.getAfp());
                pstmt.setInt(10, cliente.getSistemaSalud());
                pstmt.setString(11, cliente.getDireccion());
                pstmt.setString(12, cliente.getComuna());
                pstmt.setInt(13, cliente.getEdad());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (usuario instanceof Administrativo) {
            sql = "INSERT INTO administrativo (nombre, fecha_nacimiento, rut, clave, area, experiencia_previa) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Administrativo administrativo = (Administrativo) usuario;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, administrativo.getNombre());
                pstmt.setString(2, administrativo.getFechaNacimiento());
                pstmt.setInt(3, administrativo.getRun());
                pstmt.setString(4, administrativo.getClave());
                pstmt.setString(5, administrativo.getArea());
                pstmt.setString(6, administrativo.getExperienciaPrevia());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (usuario instanceof Profesional) {
            sql = "INSERT INTO profesionales (nombre, fecha_nacimiento, rut, acceso, clave, titulo, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Profesional profesional = (Profesional) usuario;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, profesional.getNombre());
                pstmt.setString(2, profesional.getFechaNacimiento());
                pstmt.setInt(3, profesional.getRun());
                pstmt.setString(4, profesional.getAcceso());
                pstmt.setString(5, profesional.getClave());
                pstmt.setString(6, profesional.getTitulo());
                pstmt.setString(7, profesional.getFechaIngreso());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tipo de usuario no válido");
        }
    }
    @Override
    public void update(Usuario usuario) {
        String sql = "";
        if (usuario instanceof Cliente) {
            sql = "UPDATE clientes SET nombre=?, fecha_nacimiento=?, clave=?, run=?, nombres=?, apellidos=?, telefono=?, afp=?, sistema_salud=?, direccion=?, comuna=?, edad=? WHERE id=?";
            Cliente cliente = (Cliente) usuario;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, cliente.getNombre());
                pstmt.setString(2, cliente.getFechaNacimiento());
                pstmt.setString(3, cliente.getAcceso());
                pstmt.setString(4, cliente.getClave());
                pstmt.setInt(5, cliente.getRun());
                pstmt.setString(6, cliente.getNombres());
                pstmt.setString(7, cliente.getApellidos());
                pstmt.setString(8, cliente.getTelefono());
                pstmt.setString(9, cliente.getAfp());
                pstmt.setInt(10, cliente.getSistemaSalud());
                pstmt.setString(11, cliente.getDireccion());
                pstmt.setString(12, cliente.getComuna());
                pstmt.setInt(13, cliente.getEdad());
                pstmt.setInt(14, cliente.getId()); // Aquí deberías tener un método getId() en la clase Cliente
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (usuario instanceof Administrativo) {
            sql = "UPDATE administrativos SET nombre=?, fecha_nacimiento=?, acceso=?, clave=?, area=?, experiencia_previa=? WHERE id=?";
            Administrativo administrativo = (Administrativo) usuario;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, administrativo.getNombre());
                pstmt.setString(2, administrativo.getFechaNacimiento());
                pstmt.setString(3, administrativo.getAcceso());
                pstmt.setString(4, administrativo.getClave());
                pstmt.setString(5, administrativo.getArea());
                pstmt.setString(6, administrativo.getExperienciaPrevia());
                pstmt.setInt(7, administrativo.getId()); // Aquí deberías tener un método getId() en la clase Administrativo
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (usuario instanceof Profesional) {
            sql = "UPDATE profesionales SET nombre=?, fecha_nacimiento=?, acceso=?, clave=?, titulo=?, fecha_ingreso=? WHERE id=?";
            Profesional profesional = (Profesional) usuario;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, profesional.getNombre());
                pstmt.setString(2, profesional.getFechaNacimiento());
                pstmt.setString(3, profesional.getAcceso());
                pstmt.setString(4, profesional.getClave());
                pstmt.setString(5, profesional.getTitulo());
                pstmt.setString(6, profesional.getFechaIngreso());
                pstmt.setInt(7, profesional.getId()); // Aquí deberías tener un método getId() en la clase Profesional
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tipo de usuario no válido");
        }
    }

    @Override
    public void delete(int id) {
        // Primero, eliminamos el registro de la tabla 'usuarios'
        String sqlUsuarios = "DELETE FROM usuarios WHERE id=?";
        try {
            PreparedStatement pstmtUsuarios = connection.prepareStatement(sqlUsuarios);
            pstmtUsuarios.setInt(1, id);
            pstmtUsuarios.executeUpdate();
            pstmtUsuarios.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Luego, eliminamos el registro correspondiente en la tabla específica de cada tipo de usuario
        String sqlCliente = "DELETE FROM cliente WHERE id=?";
        String sqlAdministrativo = "DELETE FROM administrativo WHERE id=?";
        String sqlProfesional = "DELETE FROM profesional WHERE id=?";

        try {
            PreparedStatement pstmtCliente = connection.prepareStatement(sqlCliente);
            pstmtCliente.setInt(1, id);
            pstmtCliente.executeUpdate();
            pstmtCliente.close();
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        try {
            PreparedStatement pstmtAdministrativo = connection.prepareStatement(sqlAdministrativo);
            pstmtAdministrativo.setInt(1, id);
            pstmtAdministrativo.executeUpdate();
            pstmtAdministrativo.close();
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        try {
            PreparedStatement pstmtProfesional = connection.prepareStatement(sqlProfesional);
            pstmtProfesional.setInt(1, id);
            pstmtProfesional.executeUpdate();
            pstmtProfesional.close();
        } catch (SQLException e) {
            // Manejo de excepciones
        }
    }

	@Override
	public Usuario read(int id) {
		
		return null;
	}


	@Override
	public void UsuarioCompleto() {
		// TODO Auto-generated method stub
		
	}
}

    