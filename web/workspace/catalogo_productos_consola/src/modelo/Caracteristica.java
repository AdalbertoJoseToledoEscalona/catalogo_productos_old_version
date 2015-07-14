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
public class Caracteristica {

	/**
	 * Identificador de la Característica
	 */
	private int id;
	/**
	 * Nombre de la Característica
	 */
	private String nombre;
	/**
	 * Descripción de la Característica
	 */
	private String descripcion;

	/**
	 * 
	 */
	public Caracteristica() {
	}

	public Caracteristica(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public static List<Caracteristica> getCaracteristicas()
			throws NamingException, SQLException {
		ArrayList<Caracteristica> caracteristicas = null;

		BaseDatos bd = new BaseDatos();

		String[] campos = { "id_caracteristica", "nombre", "descripcion" };
		String[] tablas = { "caracteristicas" };
		String[][] uniones = null;
		String condicion = null;
		boolean disctinct = false;
		String[] camposOrden = { "nombre" };
		Boolean[] asc = { true };
		String[] camposGroup = null;
		String condicionHaving = null;

		bd.generarSelect(campos, tablas, uniones, condicion, disctinct,
				camposOrden, asc, camposGroup, condicionHaving);

		try{
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
	
			bd.rs = bd.stmt.executeQuery(bd.sql);
	
			caracteristicas = new ArrayList<Caracteristica>();
			while (bd.rs.next()) {
				caracteristicas.add(new Caracteristica(bd.rs
						.getInt("id_caracteristica"), bd.rs.getString("nombre"),
						bd.rs.getString("descripcion")));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			bd.cerrarConexion();
		}
		

		return caracteristicas;

	}

}
