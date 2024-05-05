package ModelDAO;
import java.util.List;
import Modelo.Capacitaciones;
public interface ICapacitacionDAO {
public void create(Capacitaciones c);
public List<Capacitaciones>readAll();
public Capacitaciones readOne(int id);

public void delete(int id);
public void delete (Capacitaciones c);
public void update (Capacitaciones c);
void updatde(Capacitaciones c);

	

}
