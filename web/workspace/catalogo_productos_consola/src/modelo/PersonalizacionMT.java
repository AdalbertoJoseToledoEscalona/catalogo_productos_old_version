/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class PersonalizacionMT {

	private ElementoMT elementoMT;
	private Archivo archivoFondo;
	/**
	 * Identificador Personalizacion MultiTouch
	 */
	private int id;
	/**
	 * Indica si se debe colocar en Vertical o no
	 */
	private Boolean vertical;
	/**
	 * Posición en el eje Horizontal del Elemento MT
	 */
	private float posicionXPorcentaje;
	/**
	 * posicion en el eje Y de la pantalla en Porcentaje
	 */
	private float posicionYPorcentaje;
	/**
	 * El ancho del Elemento MT en Porcentaje
	 */
	private float anchoPorcentaje;
	/**
	 * Alto del elemento MT en porcentaje
	 */
	private float altoPorcentaje;

	/**
	 * 
	 */
	public PersonalizacionMT(Archivo archivoFondo2, ElementoMT elementoMT2) {
		archivoFondo = archivoFondo2;
		elementoMT = elementoMT2;
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
	 * @return the vertical
	 */
	public Boolean getVertical() {
		return vertical;
	}

	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(Boolean vertical) {
		this.vertical = vertical;
	}

	/**
	 * @return the posicionXPorcentaje
	 */
	public float getPosicionXPorcentaje() {
		return posicionXPorcentaje;
	}

	/**
	 * @param posicionXPorcentaje the posicionXPorcentaje to set
	 */
	public void setPosicionXPorcentaje(float posicionXPorcentaje) {
		this.posicionXPorcentaje = posicionXPorcentaje;
	}

	/**
	 * @return the posicionYPorcentaje
	 */
	public float getPosicionYPorcentaje() {
		return posicionYPorcentaje;
	}

	/**
	 * @param posicionYPorcentaje the posicionYPorcentaje to set
	 */
	public void setPosicionYPorcentaje(float posicionYPorcentaje) {
		this.posicionYPorcentaje = posicionYPorcentaje;
	}

	/**
	 * @return the anchoPorcentaje
	 */
	public float getAnchoPorcentaje() {
		return anchoPorcentaje;
	}

	/**
	 * @param anchoPorcentaje the anchoPorcentaje to set
	 */
	public void setAnchoPorcentaje(float anchoPorcentaje) {
		this.anchoPorcentaje = anchoPorcentaje;
	}

	/**
	 * @return the altoPorcentaje
	 */
	public float getAltoPorcentaje() {
		return altoPorcentaje;
	}

	/**
	 * @param altoPorcentaje the altoPorcentaje to set
	 */
	public void setAltoPorcentaje(float altoPorcentaje) {
		this.altoPorcentaje = altoPorcentaje;
	}

	/**
	 * @return the archivoFondo
	 */
	public Archivo getArchivoFondo() {
		return archivoFondo;
	}

	/**
	 * @return the elementoMT
	 */
	public ElementoMT getElementoMT() {
		return elementoMT;
	}

}
