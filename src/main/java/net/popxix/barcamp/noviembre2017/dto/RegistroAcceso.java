/**
 * 
 */
package net.popxix.barcamp.noviembre2017.dto;

import java.util.Date;

/**
 * @author pjgonzalez
 *
 */
public class RegistroAcceso {

    private Date fecha;
    
    private String ip;
	
	private String peticion;
	
	private int estatus;
	
	private String clienteOrigen;
	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the peticion
	 */
	public String getPeticion() {
		return peticion;
	}

	/**
	 * @param peticion the peticion to set
	 */
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	/**
	 * @return the estatus
	 */
	public int getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the clienteOrigen
	 */
	public String getClienteOrigen() {
		return clienteOrigen;
	}

	/**
	 * @param clienteOrigen the clienteOrigen to set
	 */
	public void setClienteOrigen(String clienteOrigen) {
		this.clienteOrigen = clienteOrigen;
	}

}
