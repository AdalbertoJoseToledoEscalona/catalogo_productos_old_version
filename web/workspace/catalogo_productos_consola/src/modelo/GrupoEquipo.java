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
public class GrupoEquipo {

	private List<ArchivoGrupoEquipo> archivoGrupoEquipo;
	/**
	 * Identificador del GrupoEquipo
	 */
	private int id;
	/**
	 * El nombre a mostrar del GrupoEquipo
	 */
	private String nombre;
	/**
	 * Descripcion del GrupoEquipo
	 */
	private String descripcion;

	/**
	 * 
	 */
	public GrupoEquipo(List<ArchivoGrupoEquipo> archivoGrupoEquipo2) {
		archivoGrupoEquipo = archivoGrupoEquipo2;
	}

	public GrupoEquipo(int id, String nombre, String descripcion,
			List<ArchivoGrupoEquipo> archivoGrupoEquipo2) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		archivoGrupoEquipo = archivoGrupoEquipo2;
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

	public static GrupoEquipo getGrupoEquipo(int id) throws NamingException,
			SQLException {
		GrupoEquipo grupoEquipo = null;

		BaseDatos bd = new BaseDatos();

		String[] campos = { "grupos_equipos.id_grupo_equipo",
				"grupos_equipos.nombre", "grupos_equipos.descripcion" };
		String[] tablas = { "grupos_equipos" };
		String[][] uniones = null;
		String condicion = "grupos_equipos.id_grupo_equipo = " + id;
		boolean disctinct = true;
		String[] camposOrden = null;
		Boolean[] asc = null;
		String[] camposGroup = null;
		String condicionHaving = null;
		bd.generarSelect(campos, tablas, uniones, condicion, disctinct,
				camposOrden, asc, camposGroup, condicionHaving);

		try {
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
			bd.rs = bd.stmt.executeQuery(bd.sql);

			if (bd.rs.next()) {
				grupoEquipo = new GrupoEquipo(bd.rs.getInt("id_grupo_equipo"),
						bd.rs.getString("nombre"),
						bd.rs.getString("descripcion"), null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			bd.cerrarConexion();
		}

		return grupoEquipo;
	}

	/**
	 * @return the archivoGrupoEquipo
	 */
	public List<ArchivoGrupoEquipo> getArchivoGrupoEquipo() {
		return archivoGrupoEquipo;
	}

	/**
	 * @return the archivoGrupoEquipo
	 * @throws SQLException
	 * @throws NamingException
	 */
	public List<ArchivoGrupoEquipo> getArchivoGrupoEquipoPorTipoArchivo(
			String nombresTiposArchivos[]) throws NamingException, SQLException {
		List<ArchivoGrupoEquipo> archivoGrupoEquipo = null;

		BaseDatos bd = new BaseDatos();

		String[] campos = {
				"archivos_x_grupos_equipos.id_archivo_x_grupo_equipo",
				"archivos_x_grupos_equipos.nombre_original",
				"archivos_x_grupos_equipos.md5_archivo", "archivos.ruta",
				"archivos.id_tipo_archivo", "tipos_archivos.nombre",
				"tipos_archivos.descripcion" };
		String[] tablas = { "archivos_x_grupos_equipos" };
		String[][] uniones = {
				{ "INNER", "archivos", "archivos_x_grupos_equipos.md5_archivo",
						"=", "archivos.md5_archivo" },
				{ "INNER", "tipos_archivos", "archivos.id_tipo_archivo", "=",
						"tipos_archivos.id_tipo_archivo" } };
		String condicion = "archivos_x_grupos_equipos.id_grupo_equipo = " + id;

		if (nombresTiposArchivos != null && nombresTiposArchivos.length > 0) {
			condicion += " AND (tipos_archivos.nombre IN(";
			condicion += "'" + nombresTiposArchivos[0] + "'";
			for (int i = 1; i < nombresTiposArchivos.length; i++) {
				condicion += ", '" + nombresTiposArchivos[i] + "'";
			}
			condicion += "))";
		}

		boolean disctinct = false;
		String[] camposOrden = null;
		Boolean[] asc = null;
		String[] camposGroup = null;
		String condicionHaving = null;
		bd.generarSelect(campos, tablas, uniones, condicion, disctinct,
				camposOrden, asc, camposGroup, condicionHaving);

		// System.out.println(bd.sql);

		try {
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
			bd.rs = bd.stmt.executeQuery(bd.sql);

			archivoGrupoEquipo = new ArrayList<ArchivoGrupoEquipo>();
			while (bd.rs.next()) {

				TipoArchivo tipoArchivo = new TipoArchivo(null,
						bd.rs.getInt("id_tipo_archivo"),
						bd.rs.getString("nombre"),
						bd.rs.getString("descripcion"));

				Archivo archivo = new Archivo(tipoArchivo,
						bd.rs.getString("md5_archivo"), bd.rs.getString("ruta"));

				archivoGrupoEquipo.add(new ArchivoGrupoEquipo(archivo, bd.rs
						.getInt("id_archivo_x_grupo_equipo"), bd.rs
						.getString("nombre_original")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			bd.cerrarConexion();
		}

		if (nombresTiposArchivos == null || nombresTiposArchivos.length == 0) {
			this.archivoGrupoEquipo = archivoGrupoEquipo;
		}

		return archivoGrupoEquipo;
	}

	/**
	 * @return the archivoGrupoEquipo
	 * @throws SQLException
	 * @throws NamingException
	 */
	public BaseDatos retornarBaseDatosArchivoGrupoEquipoPorTipoArchivo(
			String nombresTiposArchivos[]) throws NamingException, SQLException {
		BaseDatos bd = new BaseDatos();

		String[] campos = {
				"archivos_x_grupos_equipos.id_archivo_x_grupo_equipo",
				"archivos_x_grupos_equipos.nombre_original",
				"archivos_x_grupos_equipos.md5_archivo", "archivos.ruta",
				"archivos_x_grupos_equipos.id_grupo_equipo" };
		String[] tablas = { "archivos_x_grupos_equipos" };
		String[][] uniones = {
				{ "INNER", "archivos", "archivos_x_grupos_equipos.md5_archivo",
						"=", "archivos.md5_archivo" },
				{ "INNER", "tipos_archivos", "archivos.id_tipo_archivo", "=",
						"tipos_archivos.id_tipo_archivo" } };
		String condicion = "archivos_x_grupos_equipos.id_grupo_equipo = " + id;

		if (nombresTiposArchivos != null && nombresTiposArchivos.length > 0) {
			condicion += " AND (tipos_archivos.nombre IN(";
			condicion += "'" + nombresTiposArchivos[0] + "'";
			for (int i = 1; i < nombresTiposArchivos.length; i++) {
				condicion += ", '" + nombresTiposArchivos[i] + "'";
			}
			condicion += "))";
		}

		boolean disctinct = false;
		String[] camposOrden = null;
		Boolean[] asc = null;
		String[] camposGroup = null;
		String condicionHaving = null;

		bd.usarJDBC = false;
		bd.campos = campos;
		bd.tablas = tablas;
		bd.uniones = uniones;
		bd.condicion = condicion;
		bd.disctinct = disctinct;
		bd.camposOrden = camposOrden;
		bd.asc = asc;
		bd.camposGroup = camposGroup;
		bd.condicionHaving = condicionHaving;

		// System.out.println(bd.sql);

		return bd;
	}

}
