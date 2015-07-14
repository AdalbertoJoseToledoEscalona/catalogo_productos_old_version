/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Precio {

	private Moneda moneda;
	/**
	 * Identificador del Precio
	 */
	private int id;
	/**
	 * Nombre del Precio
	 */
	private String nombre;
	/**
	 * Descripcion del Precio
	 */
	private String descripcion;
	/**
	 * El valor del Precio
	 */
	private float valor;
	/**
	 * 
	 */
	public Precio() {
		moneda = new Moneda();
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
	 * @return the moneda
	 */
	public Moneda getMoneda() {
		return moneda;
	}
	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

}
