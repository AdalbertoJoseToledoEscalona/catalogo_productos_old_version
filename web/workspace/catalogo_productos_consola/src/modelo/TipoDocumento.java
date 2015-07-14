/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class TipoDocumento {

	private Archivo archivo;
	/**
	 * Identificador de tipo de documento
	 */
	private int id;
	/**
	 * Nombre del Tipo de Documento
	 */
	private String nombre;
	/**
	 * Descripcion del Tipo de Documento
	 */
	private String descripcion;

	/**
	 * 
	 */
	public TipoDocumento(Archivo archivo2) {
		archivo = archivo2;
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

	/**
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}

}
