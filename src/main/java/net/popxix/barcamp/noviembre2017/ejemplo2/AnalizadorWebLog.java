/**
 * 
 */
package net.popxix.barcamp.noviembre2017.ejemplo2;

import static net.popxix.barcamp.noviembre2017.AuxAnalizadorArchivo.archivoALista;
import static net.popxix.barcamp.noviembre2017.AuxAnalizadorArchivo.getFiltroIP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.popxix.barcamp.noviembre2017.dto.RegistroAcceso;

/**
 * @author pjgonzalez
 *
 */
public class AnalizadorWebLog {

	private List<RegistroAcceso> registros = new ArrayList<>();
	
	public synchronized void analizaLog(File archivo) {
			System.out.println("Cargando Archivos de log..");
			this.registros = archivoALista(archivo,getFiltroIP("192.168.234.82"));
			System.out.println("Fueron Cargados.." + registros.size() + " Registros");
			notify();
	}
	
	public synchronized void insertaLogDB() {
		if(registros.isEmpty()) {
			System.out.println("No hay archivos procesados en este momento...");
			try {
				wait();
			} catch (Exception e) {
				System.out.println("Error al invocar el bloqueo en el Thread..");
			}
		}
		
		registros.stream().forEach(registro->{
			System.out.println(" Procesando el registro de la fecha: " + registro.getFecha());
		});
	}
	
}
