package principal;
import java.io.Serializable;

public class Persona implements Serializable{

	private String nombre;
	private String apellido;
	private int edad;
	Propiedad casa;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	public Propiedad getCasa() {
		return casa;
	}
	public void setCasa(Propiedad casa) {
		this.casa = casa;
	}
	
public Persona(String nombre, String apellido, int edad, Propiedad casa) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.casa = casa;
	}
	
	
}
