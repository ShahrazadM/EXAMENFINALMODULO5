package Modelo;
import java.util.ArrayList;
import java.util.List;

public class ContactoRepository {
    // Lista para almacenar los contactos
    private List<Contacto> listaContactos;

    // Constructor
    public ContactoRepository() {
        this.listaContactos = new ArrayList<>();
    }

    // Método para agregar un nuevo contacto a la lista
    public void agregarContacto(Contacto contacto) {
        listaContactos.add(contacto);
    }

    // Método para obtener todos los contactos
    public List<Contacto> obtenerTodosLosContactos() {
        return listaContactos;
    }
}