/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class MediaInactividad {

	private Archivo archivo;
	/**
	 * Identificador Media Inactividad
	 */
	private int id;
	/**
	 * Tiempo Duracion media Inactividad
	 */
	private Integer tiempo;

	/**
	 * 
	 */
	public MediaInactividad(Archivo archivo2) {
		archivo = archivo2;
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
	 * @return the tiempo
	 */
	public Integer getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}

}
