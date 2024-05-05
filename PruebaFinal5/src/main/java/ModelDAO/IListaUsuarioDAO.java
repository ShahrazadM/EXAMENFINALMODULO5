package ModelDAO;


import java.util.List;
import Modelo.Usuario;

public interface IListaUsuarioDAO {
    
    public Usuario usuarioPorId(int id);
    public List<Usuario> todosUsuarios();

}