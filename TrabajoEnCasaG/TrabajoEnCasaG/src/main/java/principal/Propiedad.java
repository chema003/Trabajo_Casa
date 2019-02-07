package principal;

public class Propiedad {

	private String nombrePropiedad;
	private String direccion;
	private int precio;
	
	public String getNombrePropiedad() {
		return nombrePropiedad;
	}
	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public Propiedad(String nombrePropiedad, String direccion, int precio) {
		this.nombrePropiedad = nombrePropiedad;
		this.direccion = direccion;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "La Propiedad " + nombrePropiedad + ", con direccion: " + direccion + 
				", tiene un precio de " + precio+".";
	}
	
	
	
}
