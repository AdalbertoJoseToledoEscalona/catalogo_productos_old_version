/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Pais {

	/**
	 * Identificador del Pais
	 */
	private int id;
	/**
	 * Nombre del Pais
	 */
	private String nombre;
	/**
	 * El codigo ISO2 del pais
	 */
	private char[] codigo;
	/**
	 * Indica si esta o no deshabilitado
	 */
	private boolean deshabilitado;

	/**
	 * 
	 */
	public Pais() {
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
	 * @return the codigo
	 */
	public char[] getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(char[] codigo) {
		this.codigo = codigo;
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

}
