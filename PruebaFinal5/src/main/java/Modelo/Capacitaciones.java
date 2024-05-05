package Modelo;

public class Capacitaciones {
	// Atributos

	private int id;
	private int rutCliente;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;
	

	
	public Capacitaciones() {
		super();		
	}
	
	// Constructor con parametros
	public Capacitaciones(int id, int rutCliente, String dia, String hora, String lugar, String duracion,
			int cantidadAsistentes) {
		super();	
		this.id = id;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	// Constructor sin parámetros
	
	// Método para mostrar el detalle de la capacitación
	public void mostrarDetalle() {
		System.out.println(
				"La capacitación será en " + lugar + " a las " + hora + " del día " + dia + ", y durará " + duracion);
	}

	// Método toString para representar la capacitación como cadena
	

	// Métodos de acceso (getters y setters) para los atributos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	// Método toString para representar la capacitación como cadena
    @Override
    public String toString() {
        return "Capacitacion [identificador=" + id + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora="
                + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes=" + cantidadAsistentes + "]";
    }
}