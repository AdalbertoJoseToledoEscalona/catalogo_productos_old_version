/**
 * 
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.utils.BaseDatos;

/**
 * @author adalberto
 * 
 */
public class Equipo {

	private List<PersonalizacionMT> personalizacionMT;
	private List<MediaInactividad> mediaInactividad;
	private List<Producto> producto;
	private GrupoEquipo grupoEquipo;
	private Ciudad ciudad;
	/**
	 * Identificador del Equipo
	 */
	private int id;
	/**
	 * El nombre dado del equipo por el usuario
	 */
	private String nombre;
	/**
	 * Descripcion del Equipo
	 */
	private String descripcion;
	/**
	 * Dirección de donde se encuentra el equipo
	 */
	private String direccion;
	/**
	 * Codigo Postal del lugar donde se encuentra el equipo
	 */
	private String codigoPostal;
	/**
	 * El idioma_pais del equipo (separado por '_')
	 */
	private String idiomaPais;
	/**
	 * El numero de Pantallas MultiTouch en mostrar en este equipo
	 */
	private int numeroPantallas;
	/**
	 * Tiempo de Inactividad en Segundos
	 */
	private int tiempo_inactividad;
	/**
	 * Tiempo de espera para actualizar los datos
	 */
	private int tiempo_actualizacion;

	/**
	 * 
	 */
	public Equipo(Ciudad ciudad2, List<Producto> producto2,
			List<MediaInactividad> mediaInactividad2,
			List<PersonalizacionMT> personalizacionMT2) {
		ciudad = ciudad2;
		grupoEquipo = new GrupoEquipo(null);
		producto = producto2;
		mediaInactividad = mediaInactividad2;
		personalizacionMT = personalizacionMT2;
	}

	public Equipo(int id, String nombre, String descripcion, String direccion,
			String codigoPostal, String idiomaPais, int numeroPantallas,
			int tiempo_inactividad, int tiempo_actualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idiomaPais = idiomaPais;
		this.numeroPantallas = numeroPantallas;
		this.tiempo_inactividad = tiempo_inactividad;
		this.tiempo_actualizacion = tiempo_actualizacion;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param nombre
	 *            the nombre to set
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
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal
	 *            the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the idiomaPais
	 */
	public String getIdiomaPais() {
		return idiomaPais;
	}

	/**
	 * @param idiomaPais
	 *            the idiomaPais to set
	 */
	public void setIdiomaPais(String idiomaPais) {
		this.idiomaPais = idiomaPais;
	}

	/**
	 * @return the numeroPantallas
	 */
	public int getNumeroPantallas() {
		return numeroPantallas;
	}

	/**
	 * @param numeroPantallas
	 *            the numeroPantallas to set
	 */
	public void setNumeroPantallas(int numeroPantallas) {
		this.numeroPantallas = numeroPantallas;
	}

	/**
	 * @return the tiempo_inactividad
	 */
	public int getTiempo_inactividad() {
		return tiempo_inactividad;
	}

	/**
	 * @param tiempo_inactividad
	 *            the tiempo_inactividad to set
	 */
	public void setTiempo_inactividad(int tiempo_inactividad) {
		this.tiempo_inactividad = tiempo_inactividad;
	}

	/**
	 * @return the tiempo_actualizacion
	 */
	public int getTiempo_actualizacion() {
		return tiempo_actualizacion;
	}

	/**
	 * @param tiempo_actualizacion
	 *            the tiempo_actualizacion to set
	 */
	public void setTiempo_actualizacion(int tiempo_actualizacion) {
		this.tiempo_actualizacion = tiempo_actualizacion;
	}

	/**
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * @return the grupoEquipo
	 */
	public GrupoEquipo getGrupoEquipo() {
		return grupoEquipo;
	}

	/**
	 * @return the producto
	 */
	public List<Producto> getProducto() {
		return producto;
	}

	/**
	 * @return the mediaInactividad
	 */
	public List<MediaInactividad> getMediaInactividad() {
		return mediaInactividad;
	}

	/**
	 * @return the personalizacionMT
	 */
	public List<PersonalizacionMT> getPersonalizacionMT() {
		return personalizacionMT;
	}

	public static List<Equipo> getEquiposPertenecenAGrupoEquipo(
			int idGrupoEquipo) throws NamingException, SQLException {
		List<Equipo> equipos = null;

		BaseDatos bd = new BaseDatos();

		String[] campos = { "equipos.id_equipo", "equipos.nombre",
				"equipos.descripcion", "equipos.direccion",
				"equipos.codigo_postal", "equipos.idioma_pais",
				"equipos.numero_pantallas", "equipos.tiempo_inactitividad",
				"equipos.tiempo_actualizacion" };
		String[] tablas = { "equipos" };
		String[][] uniones = { { "INNER", "grupos_equipos",
				"equipos.id_grupo_equipo", "=", "grupos_equipos.id_grupo_equipo" } };
		String condicion = "equipos.id_grupo_equipo = " + idGrupoEquipo;
		boolean disctinct = false;
		String[] camposOrden = { "equipos.nombre" };
		Boolean[] asc = { true };
		String[] camposGroup = null;
		String condicionHaving = null;
		bd.generarSelect(campos, tablas, uniones, condicion, disctinct,
				camposOrden, asc, camposGroup, condicionHaving);
		
		try{
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
	
			bd.rs = bd.stmt.executeQuery(bd.sql);
	
			equipos = new ArrayList<Equipo>();
			while (bd.rs.next()) {
				equipos.add(new Equipo(bd.rs.getInt("id_equipo"), bd.rs
						.getString("nombre"), bd.rs.getString("descripcion"), bd.rs
						.getString("direccion"), bd.rs.getString("codigo_postal"),
						bd.rs.getString("idioma_pais"), bd.rs
								.getInt("numero_pantallas"), bd.rs
								.getInt("tiempo_inactitividad"), bd.rs
								.getInt("tiempo_actualizacion")));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			bd.cerrarConexion();
		}
		
		

		return equipos;
	}

}
