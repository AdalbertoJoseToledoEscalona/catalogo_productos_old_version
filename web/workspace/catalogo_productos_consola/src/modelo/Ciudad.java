/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Ciudad {

	private Estado estado;
	/**
	 * Identificador de la Ciudad
	 */
	private int id;
	/**
	 * Nombre de la Ciudad
	 */
	private String nombre;
	/**
	 * Indica si está o no deshabilitado
	 */
	private boolean deshabilitado;

	/**
	 * 
	 */
	public Ciudad(Estado estado2) {
		estado = estado2;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the deshabilitado
	 */
	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	/**
	 * @param deshabilitado the deshabilitado to set
	 */
	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

}
