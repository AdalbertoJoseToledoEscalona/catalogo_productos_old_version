/**
 * 
 */
package modelo;

/**
 * @author adalberto
 *
 */
public class Permisologia {

	private ElementoHTML elementoHTML;
	/**
	 * Identificador del Permiso
	 */
	private int id;
	/**
	 * Indica si está visible
	 */
	private boolean visible;
	/**
	 * Indica si esta Enable
	 */
	private boolean enable;
	/**
	 * Indica si esta readonly
	 */
	private boolean readonly;
	/**
	 * Indica si requiere solicitar permiso o no
	 */
	private boolean solicitar_permiso;

	/**
	 * 
	 */
	public Permisologia(ElementoHTML elementoHTML2) {
		elementoHTML = elementoHTML2;
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
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the readonly
	 */
	public boolean isReadonly() {
		return readonly;
	}

	/**
	 * @param readonly the readonly to set
	 */
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	/**
	 * @return the solicitar_permiso
	 */
	public boolean isSolicitar_permiso() {
		return solicitar_permiso;
	}

	/**
	 * @param solicitar_permiso the solicitar_permiso to set
	 */
	public void setSolicitar_permiso(boolean solicitar_permiso) {
		this.solicitar_permiso = solicitar_permiso;
	}

	/**
	 * @return the elementoHTML
	 */
	public ElementoHTML getElementoHTML() {
		return elementoHTML;
	}

}
