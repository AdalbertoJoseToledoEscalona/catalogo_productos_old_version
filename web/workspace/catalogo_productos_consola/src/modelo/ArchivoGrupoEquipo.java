/**
 * 
 */
package modelo;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import modelo.utils.BaseDatos;

/**
 * @author adalberto
 * 
 */
public class ArchivoGrupoEquipo {

	private Archivo archivo;
	/**
	 * Identificador del Archivo-GrupoEquipo
	 */
	private int id;
	/**
	 * Nombre del archivo original (el nombre dado por el usuario al cargarlo en
	 * el sistema)
	 */
	private String nombreOriginal;

	/**
	 * 
	 */
	public ArchivoGrupoEquipo(Archivo archivo2) {
		archivo = archivo2;
	}

	public ArchivoGrupoEquipo(Archivo archivo, int id, String nombreOriginal) {
		super();
		this.archivo = archivo;
		this.id = id;
		this.nombreOriginal = nombreOriginal;
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
	 * @return the nombreOriginal
	 */
	public String getNombreOriginal() {
		return nombreOriginal;
	}

	/**
	 * @param nombreOriginal
	 *            the nombreOriginal to set
	 */
	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	/**
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}

	public static void eliminar(String md5, int idArchivoGrupoEquipo,
			int idGrupoEquipo, String rutaArchivo, HttpServletRequest request)
			throws Exception {
		boolean eliminarArchivo = false;

		BaseDatos bd = new BaseDatos();

		String[] campos = { "id_grupo_equipo" };
		String[] tablas = { "archivos_x_grupos_equipos" };
		String[][] uniones = null;
		String condicion = "id_archivo_x_grupo_equipo != "
				+ idArchivoGrupoEquipo + " AND id_grupo_equipo != "
				+ idGrupoEquipo + " AND md5_archivo = '" + md5 + "'";
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

			if (bd.rs.next()) {
				eliminarArchivo = false;
			} else {
				eliminarArchivo = true;
			}

			bd.con.setAutoCommit(false);

			String nombreTabla = "archivos_x_grupos_equipos";
			condicion = "id_archivo_x_grupo_equipo = " + idArchivoGrupoEquipo
					+ " AND id_grupo_equipo = " + idGrupoEquipo
					+ " AND md5_archivo = '" + md5 + "'";
			bd.generarDelete(nombreTabla, condicion);
			if (bd.stmt.executeUpdate(bd.sql) > 0) {

			} else {
				throw new Exception("No elimino de la tabla " + nombreTabla);
			}

			if (eliminarArchivo) {
				nombreTabla = "archivos";
				condicion = "md5_archivo = '" + md5 + "'";
				bd.generarDelete(nombreTabla, condicion);
				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No elimino de la tabla " + nombreTabla);
				}

				File archivo = new File(request.getServletContext()
						.getRealPath(rutaArchivo));

				File directorio = archivo.getParentFile();

				if (!archivo.delete()) {
					throw new Exception("No eliminó el archivo "
							+ archivo.getAbsolutePath());
				}

				File archivosExtras[] = directorio.listFiles();

				for (File file : archivosExtras) {
					file.delete();
				}

				directorio.delete();

			}

			bd.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (!bd.con.getAutoCommit()) {
					bd.con.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try {
				bd.cerrarConexion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}

	}

}
