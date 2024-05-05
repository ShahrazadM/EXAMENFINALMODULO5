package ModelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Administrativo;
import Modelo.Cliente;
import Modelo.Profesional;
import Modelo.Usuario;

public class ListaUsuarioDAOImpl implements IListaUsuarioDAO {
    
    // Métodos de conexión a la base de datos (pueden variar según el sistema de base de datos que estés utilizando)
    private Connection getConnection() throws SQLException {
        // Aquí configura los parámetros de conexión a tu base de datos
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sprintf", "Alumno", "1234");
    }

    // Método para cerrar la conexión a la base de datos
    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para cerrar los recursos de la base de datos (PreparedStatement y ResultSet)
    private void closeResources(PreparedStatement ps, ResultSet rs) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Usuario> todosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            // Consulta SQL para obtener todos los usuarios, incluyendo administrativos, clientes y profesionales
            String query = "SELECT * FROM Usuarios LEFT JOIN Cliente ON Usuarios.id = Cliente.usuarioId "
                         + "LEFT JOIN Profesional ON Usuarios.id = Profesional.usuarioId "
                         + "LEFT JOIN Administrativo ON Usuarios.id = Administrativo.usuarioId";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Dependiendo de los datos obtenidos de la base de datos, se crea un objeto Usuario, Cliente, Profesional o Administrativo
                Usuario usuario = null;
                int clienteId = rs.getInt("Cliente.id");
                int profesionalId = rs.getInt("Profesional.id");
                int administrativoId = rs.getInt("Administrativo.id");
                
                // Verificamos si el usuario es un cliente
                if (clienteId != 0) {
                    Cliente cliente = new Cliente();
                    cliente.setId(clienteId);
                    cliente.setRut(rs.getString("rut"));
                    cliente.setNombres(rs.getString("nombres"));
                    cliente.setApellidos(rs.getString("apellidos"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setAfp(rs.getString("afp"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setComuna(rs.getString("comuna"));
                    cliente.setEdad(rs.getInt("edad"));
                    usuario = cliente;
                }
                // Verificamos si el usuario es un profesional
                else if (profesionalId != 0) {
                    Profesional profesional = new Profesional();
                    profesional.setId(profesionalId);
                    profesional.setTitulo(rs.getString("titulo"));
                    profesional.setFechaIngreso(rs.getDate("fechaIngreso"));
                    usuario = profesional;
                }
                // Verificamos si el usuario es un administrativo
                else if (administrativoId != 0) {
                    Administrativo administrativo = new Administrativo();
                    administrativo.setId(administrativoId);
                    administrativo.setArea(rs.getString("area"));
                    administrativo.setExperiencia(rs.getInt("experiencia"));
                    usuario = administrativo;
                }

                if (usuario != null) {
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    usuario.setRun(rs.getInt("run"));
                    usuario.setClave(rs.getString("clave"));

                    // Agregamos el usuario a la lista
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, rs);
            closeConnection(conn);
        }

        return usuarios;
    }

    @Override
    public Usuario usuarioPorId(int id) {
        // Aquí iría la lógica para buscar un usuario por su ID en la base de datos
        // Por ahora, simplemente devolvemos un usuario ficticio
        return null; // Deberías implementar esta lógica según tu requerimiento
    }
}