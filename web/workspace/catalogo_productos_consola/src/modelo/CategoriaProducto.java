/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class CategoriaProducto {

	private CategoriaProducto categoriaProductoPadre;
	private Categoria categoria;
	private Producto producto;
	private Archivo archivo;
	/**
	 * Identificador
	 */
	private int id;
	/**
	 * Valor de la Categoría
	 */
	private String valor;
	/**
	 * 
	 */
	public CategoriaProducto(Archivo archivo2, Producto producto2, Categoria categoria2, CategoriaProducto categoriaProductoPadre2) {
		archivo = archivo2;
		producto = producto2;
		categoria = categoria2;
		categoriaProductoPadre = categoriaProductoPadre2;
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
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @return the categoriaProductoPadre
	 */
	public CategoriaProducto getCategoriaProductoPadre() {
		return categoriaProductoPadre;
	}

}
