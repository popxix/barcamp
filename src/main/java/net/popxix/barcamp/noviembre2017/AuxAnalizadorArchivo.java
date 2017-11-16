/**
 * 
 */
package net.popxix.barcamp.noviembre2017;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.popxix.barcamp.noviembre2017.dto.RegistroAcceso;

/**
 * @author Owner
 *
 */
public class AuxAnalizadorArchivo {

	public static  List<RegistroAcceso> archivoALista(File archivo, Predicate<RegistroAcceso> filtro)  {
		if(esValido(archivo)) {
			try(Stream<String> streamArchivo = Files.lines(archivo.toPath())){
				return streamArchivo.map(AuxFunciones::analizadorLog)
						.filter(filtro).collect(Collectors.toList());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return Collections.emptyList();
	}
	
	private static boolean esValido(File archivo) {
		Objects.requireNonNull(archivo, "El Archivo no puede ser null");
		return archivo.isFile() && archivo.exists();
	}
	
   public static Predicate<RegistroAcceso> getFiltroIP(final String ip){
	   return  new Predicate<RegistroAcceso>() {

			@Override
			public boolean test(RegistroAcceso t) {
				return	t.getIp().equals(ip);
			}
		};
   }
	
}
