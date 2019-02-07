import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;

import principal.Persona;
import principal.Propiedad;
import serial.SerializadorPersona;
import serial.SerializadorPropiedad;

public class App_Casa {

	public static void main(String[] args) {
		
		//Ejemplo con Persona
		
		
		Persona p1 = new Persona("Juan", "Lopez", 33, null);
		Persona p2 = new Persona("Manuel", "Glez", 24, null);
		Persona p3 = new Persona("Maria", "Campos", 56, null);
		Propiedad casa1 = new Propiedad("CasaPepe", "Avda de la población", 240000);
		Propiedad casa2 = new Propiedad("VillaLaMasMaja", "miDireccion", 100000);
		p1.setCasa(casa1);
		p2.setCasa(casa2);
		p3.setCasa(casa1);
		
		
		Collection<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		String rutaJson = "datos/listaPersonas.json";
		
		crearYGuardarEnJson(listaPersonas, rutaJson);
		
		Collection<Persona> listaPersonasLeidas; 
		listaPersonasLeidas = leerYCrearColeccion(rutaJson);
		System.out.println(listaPersonasLeidas);
		
//		ProductoSer[] listadoProductos = new ProductoSer[3];
//		ProductoSer p1 = new ProductoSer(1, "producto1", "descripcion1");
//		ProductoSer p2 = new ProductoSer(2, "producto2", "descripcion2");
//		ProductoSer p3 = new ProductoSer(3, "producto3", "descripcion3");
//		
//		listadoProductos[0] = p1;
//		listadoProductos[1] = p2;
//		listadoProductos[2] = p3;
//		
//		CosasASerializar lista = new CosasASerializar(listadoProductos);
//		
//		Json json = new Json(OutputType.json);
//		String rutaJson = "datos/lista.json";
//	
//		crearYGuardarEnJson(lista, rutaJson);
//	}
//	
//	private static void crearYGuardarEnJson (CosasASerializar cosa, String ruta) {
//		Json jsonListado = new Json();
//			
//		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
//			new FileOutputStream(ruta),"UTF-8"))) {
//				
//				writer.write(jsonListado.toJson(cosa));
//				writer.newLine();
//			
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		
	}
	
	//Crear un json con el Collection de Personas:
	
		private static void crearYGuardarEnJson (Collection<Persona> listaPersonas, String ruta) {
			Json ListadoPersonasJson = new Json();
			ListadoPersonasJson.setSerializer(Propiedad.class, new SerializadorPropiedad());
			ListadoPersonasJson.setSerializer(Persona.class, new SerializadorPersona());
			
		try(BufferedWriter listadoJson = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream(ruta), "UTF-8"))) {
			for (Persona persona : listaPersonas) {
				listadoJson.write(ListadoPersonasJson.toJson(persona));
				listadoJson.newLine();
			}
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
		}
	
		
		public static Collection<Persona> leerYCrearColeccion(String ruta){
			
			Collection<Persona> listaPersonas = new ArrayList<>();
			Json json = new Json();
			json.setSerializer(Propiedad.class, new SerializadorPropiedad());
			json.setSerializer(Persona.class, new SerializadorPersona());
			
			try(BufferedReader br= new BufferedReader(new InputStreamReader
					(new FileInputStream(ruta), "UTF-8"))){
				String linealeida;
				linealeida = br.readLine();
				while(linealeida != null) {
					Persona p1 = json.fromJson(Persona.class, linealeida);
					listaPersonas.add(p1);					
					
					linealeida = br.readLine();
				}
				
				
			}catch (Exception e){
				e.printStackTrace();
				
			}
			
			return listaPersonas;
		}
}
