package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Modelo.Capacitaciones;
import Conexion.Conexion;

public class CapacitacionDAOImpl implements ICapacitacionDAO {
    private Connection conn = null;
    
    @Override
    public void create(Capacitaciones capacitacion) {
        String sql = "INSERT INTO capacitaciones (rutCliente, dia, hora, lugar, duracion, cantidadAsistentes) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, capacitacion.getRutCliente());
            ps.setString(2, capacitacion.getDia());
            ps.setString(3, capacitacion.getHora());
            ps.setString(4, capacitacion.getLugar());
            ps.setString(5, capacitacion.getDuracion());
            ps.setInt(6, capacitacion.getCantidadAsistentes());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Capacitaciones capacitacion) {
        String sql = "UPDATE Capacitaciones SET rutCliente = ?, dia = ?, hora = ?, lugar = ?, duracion = ?, cantidadAsistentes = ? WHERE id = ?";
        try {
            conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, capacitacion.getRutCliente());
            ps.setString(2, capacitacion.getDia());
            ps.setString(3, capacitacion.getHora());
            ps.setString(4, capacitacion.getLugar());
            ps.setString(5, capacitacion.getDuracion());
            ps.setInt(6, capacitacion.getCantidadAsistentes());
            ps.setInt(7, capacitacion.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Capacitaciones WHERE id = ?";
        try {
            conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Capacitaciones readOne(int id) {
        String sql = "SELECT id, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes FROM Capacitaciones WHERE Identificador = ?";
        Capacitaciones capacitacion = null;
        try {
            conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                capacitacion = new Capacitaciones();
                capacitacion.setId(rs.getInt("id"));
                capacitacion.setRutCliente(rs.getInt("rutCliente"));
                capacitacion.setDia(rs.getString("dia"));
                capacitacion.setHora(rs.getString("hora"));
                capacitacion.setLugar(rs.getString("lugar"));
                capacitacion.setDuracion(rs.getString("duracion"));
                capacitacion.setCantidadAsistentes(rs.getInt("cantidadAsistentes"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return capacitacion;
    }

    @Override
    public List<Capacitaciones> readAll() {
        String sql = "SELECT id, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes FROM Capacitaciones";
        List<Capacitaciones> capacitaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                capacitaciones.add(new Capacitaciones(
                    rs.getInt("id"),
                    rs.getInt("rutCliente"),
                    rs.getString("dia"),
                    rs.getString("hora"),
                    rs.getString("lugar"),
                    rs.getString("duracion"),
                    rs.getInt("cantidadAsistentes")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return capacitaciones;
    }

	@Override
	public void delete(Capacitaciones c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatde(Capacitaciones c) {
		// TODO Auto-generated method stub
		
	}

}