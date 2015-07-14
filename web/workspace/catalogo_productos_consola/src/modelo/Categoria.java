/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Categoria {

	/**
	 * Identificador de la Categoria
	 */
	private int id;
	/**
	 * El nombre de la Categoría
	 */
	private String nombre;
	/**
	 * Descripción de la Categoría
	 */
	private String descripcion;

	/**
	 * 
	 */
	public Categoria() {
		// TODO Auto-generated constructor stub
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

}
