/**
 * 
 */
package net.popxix.barcamp.noviembre2017;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

import net.popxix.barcamp.noviembre2017.dto.RegistroAcceso;

/**
 * @author pjgonzalez
 *
 */
public class AuxFunciones {

	public static RegistroAcceso analizadorLog(final String registro){
		Function<String[], RegistroAcceso> transformador = convertidorARegistroAcceso();
		return transformador.apply(registro.split("\\|"));
	}
	
	public static Function<String[], RegistroAcceso> convertidorARegistroAcceso(){
		return new  Function<String[], RegistroAcceso>() {

			@Override
			public RegistroAcceso apply(String[] t) {
				RegistroAcceso registroAcceso = new RegistroAcceso();
				registroAcceso.setClienteOrigen(t[4]);
				registroAcceso.setEstatus(Integer.valueOf(t[3]));
				registroAcceso.setFecha(cadenaAFecha(t[0]));
				registroAcceso.setIp(t[1]);
				registroAcceso.setPeticion(t[2]);
				return registroAcceso;
			}
		};
	}
	
	public static Date cadenaAFecha(String dateString){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date formatedDate = null;
		try {
			formatedDate = format.parse(dateString);
		} catch (ParseException e) {			
			throw new IllegalArgumentException("error realizando el formato", e);
		}
		return formatedDate;
	}
}
