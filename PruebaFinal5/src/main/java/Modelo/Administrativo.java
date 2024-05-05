package Modelo;

import java.io.PrintWriter;

public class Administrativo extends Usuario implements Asesoria {

	// Atributos

	private String area;
	private String experienciaPrevia;
	
	// cpntrsuctor sin parametros
	public Administrativo(){
        super();
    }

	public Administrativo(String nombre, String fechaNacimiento, int run, String clave, String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, run, clave);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }
	
	
	// Métodos accesores para area
	public String getarea() {
		return area;
	}

	public void setarea(String area) {
		this.area = area;
	}

	// Métodos accesores para experienciaPrevia

	public String experienciaPrevia() {
		return experienciaPrevia;
	}

	public void setexperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	public void mostrarAdministrativos(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
	    return "Administrativo [Nombre: " + getNombre() +
	            ", Fecha de nacimiento: " + getFechaNacimiento() +
	            ", RUN: " + getRun() +
	            ", Área: " + area +
	            ", Experiencia previa: " + experienciaPrevia + "]";
	}



	public static Administrativo[] getAdministrativos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExperienciaPrevia() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setArea(String administrativoArea) {
		// TODO Auto-generated method stub
		
	}

	public void setExperiencia(int int1) {
		// TODO Auto-generated method stub
		
	}

}


