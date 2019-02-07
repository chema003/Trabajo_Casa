package principal;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;

public class Serializador implements JsonSerializer<Persona>{

	
	public Collection<Persona> getPersona (String rutaJson){
		Collection<Persona> listadoPersonas = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(rutaJson),"UTF-8"))){
			String linea = reader.readLine();
			while((linea = reader.readLine()) != null) {
				listadoPersonas.add(deserializarColecion());
			}				
		}catch (Exception e){
			e.printStackTrace();
		}
		return listadoPersonas;
	}

	public Persona deserializarColecion() {
		
		return null;
	}

	@Override
	public Persona read(Json json, JsonValue valores, Class type) {
	

		return null;
	}

	@Override
	public void write(Json json, Persona persona, Class type) {
		Json json2 = new Json();
		
		
	}
	
}
