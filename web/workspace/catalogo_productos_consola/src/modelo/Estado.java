/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Estado {

	private Pais pais;
	/**
	 * El Identificador del Estado
	 */
	private int id;
	/**
	 * El nombre del Estado
	 */
	private String nombre;
	/**
	 * Indica si está o no deshabilitado
	 */
	private boolean deshabilitado;

	/**
	 * 
	 */
	public Estado(Pais pais2) {
		pais = pais2;
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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

}
