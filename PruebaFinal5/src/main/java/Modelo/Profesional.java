package Modelo;

import java.sql.Date;

public class Profesional extends Usuario {
	private String titulo;
	private String fechaIngreso;

	public Profesional(String nombre, String fechaNacimiento, int run, String clave, String titulo, String fechaIngreso) {
        super(nombre, fechaNacimiento, run, clave);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }
		
	public Profesional() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
	    return titulo;
	}

	public void setTitulo(String titulo) {
	    this.titulo = titulo;
	}

	public String getFechaIngreso() {
	    return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
	    this.fechaIngreso = fechaIngreso;
	}
	
	@Override
	public String toString() {
	    return "Profesional{" +
	            "nombre='" + getNombre() + '\'' +
	            ", fechaNacimiento='" + getFechaNacimiento() + '\'' +
	            ", run=" + getRun() +
	            ", acceso='" + getAcceso() + '\'' +
	            ", clave='" + getClave() + '\'' +
	            ", titulo='" + titulo + '\'' +
	            ", fechaIngreso='" + fechaIngreso + '\'' +
	            '}';
	}

	public static Profesional[] getProfesionales() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setFechaIngreso(Date date) {
		// TODO Auto-generated method stub
		
	}
}

	

