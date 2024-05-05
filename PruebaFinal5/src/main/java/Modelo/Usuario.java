package Modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public abstract class Usuario implements Asesoria {

	// Atributos
	private String nombre;
    private String fechaNacimiento;
    private int run;
    private String acceso;
    private String clave;

    public Usuario() {
        // Constructor sin argumentos
    }

    public Usuario(String nombre, String fechaNacimiento, int run, String clave) {
		this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
        this.setClave(clave);
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    


	
//Metodos Obligatorios para usuario...del proyecto
//1)Metodo Mostrar EdadCalcular la edad a partir de la fecha de nacimiento y mostrar un mensaje
	public void mostrarEdad() {
		// Obtener la fecha actual
		LocalDate ahora = LocalDate.now();

		// Parsear la fecha de nacimiento a LocalDate
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento);

		// Calcular la diferencia de años entre la fecha actual y la fecha de nacimiento
		Period periodo = Period.between(fechaNac, ahora);
		int edad = periodo.getYears();

		// Mostrar un mensaje con la edad del usuario
		System.out.println("El usuario tiene " + edad + " años.");
	}
// 2)Metodo Analizar Usuario..
	public void analizarUsuario() {
		System.out.println("Nombre: " + nombre);
		System.out.println("RUN: " + getRun());
	}
//Metodo complemtario para hacer uso del metodo Mostrar Edad junto al de analizar usuario
	// Método para mostrar los datos del usuario
    public void mostrarDatosUsuario() {
        System.out.println("Datos del Usuario:");
        analizarUsuario(); // Llama al método analizarUsuario() para mostrar nombre y RUN
        mostrarEdad(); // Llama al método mostrarEdad() para mostrar la edad del usuario
    }
	
	
	@Override
	public String toString() {
		return "Usuario{" + "nombre='" + nombre + '\'' + ", fechaNacimiento='" + fechaNacimiento + '\'' + ", run=" + getRun()
				+ '}';
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	public void setFechaNacimiento(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public void setAdministrativo(Administrativo administrativo) {
		// TODO Auto-generated method stub
		
	}

	public void setProfesional(Profesional profesional) {
		// TODO Auto-generated method stub
		
	}

	
}
