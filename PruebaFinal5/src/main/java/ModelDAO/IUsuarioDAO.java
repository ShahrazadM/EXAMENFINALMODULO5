package ModelDAO;




import Modelo.Usuario;

public interface IUsuarioDAO {
    void create(Usuario usuario);
    Usuario read(int id);
    void update(Usuario usuario);
    void delete(int id);
     void UsuarioCompleto();

}

