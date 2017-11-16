package net.popxix.barcamp.noviembre2017;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import net.popxix.barcamp.noviembre2017.dto.RegistroAcceso;

/**
 * 
 * @author pjgonzalez
 *
 */
public class AnalizadorWebLogThread extends Thread {

	private File archivo;
	
	private Predicate<RegistroAcceso> filtro;
	
	//private Logger logger = Logger.getLogger(AnalizadorWebLogThread.class.getName());

	
	/**
	 * 
	 */
	public AnalizadorWebLogThread(final File archivo, Predicate<RegistroAcceso> filtro) {
		this.archivo = archivo;
		this.filtro = filtro;
	}
	
	private boolean esValido() {
		Objects.requireNonNull(archivo, "El Archivo no puede ser null");
		return archivo.isFile() && archivo.exists();
	}
	
	@Override
	public void run() {
		if(esValido()) {
			try {
				analizaArchivo(Files.lines(archivo.toPath()));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	protected  void analizaArchivo(Stream<String> streamArchivo) {
		long total = streamArchivo.map(AuxFunciones::analizadorLog)
		.filter(filtro).count();
		System.out.println(total + " Registros encontrados..");
	}
	
}
