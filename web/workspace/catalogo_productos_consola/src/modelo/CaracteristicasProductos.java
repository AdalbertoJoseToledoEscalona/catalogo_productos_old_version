/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class CaracteristicasProductos {

	private Caracteristica caracteristica;
	private Producto producto;
	/**
	 * Identificador
	 */
	private int id;
	/**
	 * El valor de la caracteristica
	 */
	private String valor;

	/**
	 * 
	 */
	public CaracteristicasProductos(Producto producto2, Caracteristica caracteristica2) {
		producto = producto2;
		caracteristica = caracteristica2;
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
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @return the caracteristica
	 */
	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

}
