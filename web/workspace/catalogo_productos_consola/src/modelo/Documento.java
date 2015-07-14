/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Documento {

	private TipoDocumento tipoDocumento;
	/**
	 * Identificador del Documento
	 */
	private int id;
	/**
	 * Nombre del Documento
	 */
	private String nombre;
	/**
	 * Descripcion del Documento
	 */
	private String descripcion;
	/**
	 * Este atributo se llena solo si es una pagina web
	 */
	private String enlacePaginaWeb;
	/**
	 * Este  atributo se llena solo si es un texto plano
	 */
	private String textoPlano;
	/**
	 * Este atributo se llena solo si es texto en HTML
	 */
	private String textoHTML;

	/**
	 * 
	 */
	public Documento(TipoDocumento tipoDocumento2) {
		tipoDocumento = tipoDocumento2;
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
	 * @return the enlacePaginaWeb
	 */
	public String getEnlacePaginaWeb() {
		return enlacePaginaWeb;
	}

	/**
	 * @param enlacePaginaWeb the enlacePaginaWeb to set
	 */
	public void setEnlacePaginaWeb(String enlacePaginaWeb) {
		this.enlacePaginaWeb = enlacePaginaWeb;
	}

	/**
	 * @return the textoPlano
	 */
	public String getTextoPlano() {
		return textoPlano;
	}

	/**
	 * @param textoPlano the textoPlano to set
	 */
	public void setTextoPlano(String textoPlano) {
		this.textoPlano = textoPlano;
	}

	/**
	 * @return the textoHTML
	 */
	public String getTextoHTML() {
		return textoHTML;
	}

	/**
	 * @param textoHTML the textoHTML to set
	 */
	public void setTextoHTML(String textoHTML) {
		this.textoHTML = textoHTML;
	}

	/**
	 * @return the tipoDocumento
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

}
