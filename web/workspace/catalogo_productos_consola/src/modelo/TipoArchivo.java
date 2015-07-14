/**
 * 
 */
package modelo;

import java.util.List;

/**
 * @author adalberto
 *
 */
public class TipoArchivo {

	private List<Extension> extension;
	/**
	 * Identificador del Tipo de Archivo
	 */
	private int id;
	/**
	 * Nombre del Tipo de Archivo
	 */
	private String nombre;
	/**
	 * Descripción del Tipo de Archivo
	 */
	private String descripcion;

	/**
	 * 
	 */
	public TipoArchivo(List<Extension> extension2) {
		extension = extension2;
	}

	public TipoArchivo(List<Extension> extension, int id, String nombre,
			String descripcion) {
		super();
		this.extension = extension;
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the extension
	 */
	public List<Extension> getExtension() {
		return extension;
	}

}
