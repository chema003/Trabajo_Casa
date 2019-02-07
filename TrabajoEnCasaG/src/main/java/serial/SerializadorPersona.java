package serial;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializable;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;

import principal.Persona;
import principal.Propiedad;

public class SerializadorPersona implements JsonSerializer<Persona> {


	

	@Override
	public Persona read(Json json, JsonValue valor, Class arg2) {
		json.setSerializer(Propiedad.class, new SerializadorPropiedad());
		String nombre = valor.getString("nombre");
		String apellido = valor.getString("apellido");
		int edad = valor.getInt("edad");
		System.out.println(valor.getChild("casa"));
		Propiedad casa = json.fromJson(Propiedad.class, valor.getChild("casa").toString());
		
		
		Persona persona = new Persona(nombre, apellido, edad, casa);
		
		return persona;
	}

	@Override
	public void write(Json json, Persona persona, Class arg2) {
		json.writeObjectStart();
		json.writeValue("nombre", persona.getNombre());
		json.writeValue("apellido", persona.getApellido());
		json.writeValue("edad", persona.getEdad());
		json.writeValue("casa", persona.getCasa());
		json.writeObjectEnd();
	
	}

}
