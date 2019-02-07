package serial;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;

import principal.Propiedad;



public class SerializadorPropiedad implements JsonSerializer<Propiedad> {

	
	
	@Override
	public Propiedad read(Json json, JsonValue valor, Class type) {
		
		String nombrePropiedad = valor.getString("nombrePropiedad");
		String direccion = valor.getString("direccion");
		int precio = valor.getInt("precio");
		Propiedad casa = new Propiedad(nombrePropiedad, direccion, precio);
		
		return casa;
	}

	@Override
	public void write(Json json, Propiedad valor, Class type) {
		json.writeObjectStart();
		json.writeValue("nombrePropiedad", valor.getNombrePropiedad());
		json.writeValue("direccion", valor.getDireccion());
		json.writeValue("precio", valor.getPrecio());
		json.writeObjectEnd();
	}

}
