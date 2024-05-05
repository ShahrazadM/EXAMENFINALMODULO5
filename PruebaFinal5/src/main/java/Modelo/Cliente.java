package Modelo;

import java.io.PrintWriter;

public class Cliente extends Usuario {

	// Atributos

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int rut;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String afp;
	private int sistemaSalud;
	private String direccion;
	private String comuna;
	private int edad;

	
	// // Constructor sin parámetros
	public Cliente(String nombre, String fechaNacimiento, int run, String clave, int rut, String nombres, String apellidos, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, run, clave);
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

	

	public int getRut() {
	    return rut;
	}

	public void setRut(int clienteRut) {
	    this.rut = clienteRut;
	}

	public String getNombres() {
	    return nombres;
	}

	public void setNombres(String nombres) {
	    this.nombres = nombres;
	}

	public String getApellidos() {
	    return apellidos;
	}

	public void setApellidos(String apellidos) {
	    this.apellidos = apellidos;
	}

	public String getTelefono() {
	    return telefono;
	}

	public void setTelefono(String telefono) {
	    this.telefono = telefono;
	}

	public String getAfp() {
	    return afp;
	}

	public void setAfp(String afp) {
	    this.afp = afp;
	}

	public int getSistemaSalud() {
	    return sistemaSalud;
	}

	

	public String getDireccion() {
	    return direccion;
	}

	public void setDireccion(String direccion) {
	    this.direccion = direccion;
	}

	public String getComuna() {
	    return comuna;
	}

	public void setComuna(String comuna) {
	    this.comuna = comuna;
	}

	public int getEdad() {
	    return edad;
	}

	public void setEdad(int edad) {
	    this.edad = edad;
	}
	// Metodos obligatorios

	public String obtenerNombre() {
		return nombres + " " + apellidos;
	}

	public String obtenerSistemaSalud() {
		return (sistemaSalud == 1) ? "Fonasa" : "Isapre";
	}

	
	//Metodos Complementario para mostrar los datos del cliente 
	//haciendo uso de los metodos: obtenerNombre y obtenerSistemaSalud
	
    
	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("Dirección: " + direccion);
		System.out.println("Comuna: " + comuna);
		
	}

	public void mostrarClientes(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
	    return "Cliente [Nombre: " + nombres+ apellidos +
	    		", RUT: " + rut +
	            ", AFP: " + afp +
	            ", Sistema de Salud: " + obtenerSistemaSalud() +
	            ", Dirección: " + direccion +
	            ", Comuna: " + comuna +
	            ", Edad: " + edad + "]";
	}

	public static Cliente[] getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getrut() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void setRut(String string) {
		// TODO Auto-generated method stub
		
	}

}
	

	