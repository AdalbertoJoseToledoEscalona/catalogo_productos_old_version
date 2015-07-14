/**
 * 
 */
package modelo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.utils.BaseDatos;
import modelo.utils.Traductor;
import modelo.utils.Util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

/**
 * @author adalberto
 * 
 */
public class Producto {

	private List<Precio> precio;
	private List<Documento> documento;
	private Archivo archivoLogo;
	/**
	 * Identificador del Producto
	 */
	private int id;
	/**
	 * El nombre del producto
	 */
	private String nombre;
	/**
	 * Descripción del Producto
	 */
	private String descripcion;

	/**
	 * 
	 */
	
	
	
	public Producto(Archivo archivoLogo2, List<Documento> documento2,
			List<Precio> precio2) {
		archivoLogo = archivoLogo2;
		documento = documento2;
		precio = precio2;
	}

	/**
	 * @param precio
	 * @param documento
	 * @param archivoLogo
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public Producto(List<Precio> precio, List<Documento> documento,
			Archivo archivoLogo, int id, String nombre, String descripcion) {
		super();
		this.precio = precio;
		this.documento = documento;
		this.archivoLogo = archivoLogo;
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
	 * @throws NamingException 
	 * @throws SQLException 
	 */
	public String getNombre() throws NamingException, SQLException {
		if(nombre == null){
			BaseDatos bd = new BaseDatos();
			
			String[] campos = {"productos.nombre"};
			String[] tablas = {"productos"};
			String[][] uniones = null;
			String condicion = "productos.id_producto = " + getId();
			boolean disctinct = false;
			String[] camposOrden = {"productos.nombre"};
			Boolean[] asc  = {true};
			String[] camposGroup = null;
			String condicionHaving = null;
			bd.generarSelect(campos, tablas, uniones, condicion, disctinct, camposOrden, asc, camposGroup, condicionHaving);
			
			try {
				bd.abrirConexionDataSource(null);
				bd.stmt = bd.con.createStatement();
				
				bd.rs = bd.stmt.executeQuery(bd.sql);
				
				while(bd.rs.next()){
					setNombre(bd.rs.getString(1));
				}
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}finally{
				try {
					bd.cerrarConexion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
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
	 * @return the documento
	 */
	public List<Documento> getDocumento() {
		return documento;
	}

	/**
	 * @return the precio
	 */
	public List<Precio> getPrecio() {
		return precio;
	}

	/**
	 * @return the archivoLogo
	 */
	public Archivo getArchivoLogo() {
		return archivoLogo;
	}

	public static void Agregar(HttpServletRequest request, String filePath,
			Traductor traductor) throws Exception {
		// response.setContentType("text/html");
		// PrintWriter System.out = response.getWriter();
		BaseDatos bd = new BaseDatos();

		try {
			HttpSession sesion = request.getSession();

			Usuario usuarioActual = (Usuario) sesion.getAttribute("usuario");

			GrupoEquipo grupoEquipoActual = (GrupoEquipo) sesion
					.getAttribute("grupoEquipo");

			Map<String, Object> campos_valores = new HashMap<String, Object>();
			List<FileItem> fileItemList = new ArrayList<FileItem>();
			List<File> ficheroList = new ArrayList<File>();
			List<File> carpetaCrearList = new ArrayList<File>();
			List<String> md5List = new ArrayList<String>();
			List<String> nombreOriginalList = new ArrayList<String>();

			System.out.println("Hello<br/>");

			boolean isMultipartContent = ServletFileUpload
					.isMultipartContent(request);
			if (!isMultipartContent) {
				// System.out.println("You are not trying to upload<br/>");
				return;
			}
			System.out.println("You are trying to upload<br/>");

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			// try {
			List<FileItem> fields = upload.parseRequest(request);
			System.out.println("Number of fields: " + fields.size()
					+ "<br/><br/>");
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				System.out.println("No fields found");
				return;
			}
			System.out.println("<table border=\"1\">");
			while (it.hasNext()) {
				System.out.println("<tr>");
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					System.out
							.println("<td>regular form field</td><td>FIELD NAME: "
									+ fileItem.getFieldName()
									+ "<br/>STRING: "
									+ fileItem.getString());
					System.out.println("</td>");

					if (campos_valores.containsKey(fileItem.getFieldName())) {
						if (campos_valores.get(fileItem.getFieldName()) instanceof String) {
							String arr[] = {
									(String) campos_valores.get(fileItem
											.getFieldName()),
									fileItem.getString() };
							campos_valores.put(fileItem.getFieldName(), arr);
						} else if (campos_valores.get(fileItem.getFieldName()) instanceof String[]) {
							String arr1[] = (String[]) campos_valores
									.get(fileItem.getFieldName());
							String arr2[] = new String[arr1.length + 1];
							for (int i = 0; i < arr1.length; i++) {
								arr2[i] = arr1[i];
							}

							arr2[arr1.length] = fileItem.getString();
							campos_valores.put(fileItem.getFieldName(), arr2);
						}
					} else {
						campos_valores.put(fileItem.getFieldName(),
								fileItem.getString());
					}

				} else {
					System.out
							.println("<td>file form field</td><td>FIELD NAME: "
									+ fileItem.getFieldName() + "<br/>STRING: "
									+ fileItem.getString() + "<br/>NAME: "
									+ fileItem.getName()
									+ "<br/>CONTENT TYPE: "
									+ fileItem.getContentType()
									+ "<br/>SIZE (BYTES): "
									+ fileItem.getSize() + "<br/>TO STRING: "
									+ fileItem.toString());
					System.out.println("</td>");

					System.out.println();

					String fileName = fileItem.getName();

					if (fileName.isEmpty() && fileItem.getSize() == 0) {
						System.out.println("EL CAMPO FILE ESTA VACIO");
					} else {

						// System.System.out.println("Nos han subido el fichero"
						// +
						// fileName);

						// construimos un objeto file para recuperar el trayecto
						// completo
						File fichero = new File(fileName);
						// depura("El nombre del fichero es " +
						// fichero.getName());

						MessageDigest md = MessageDigest.getInstance("MD5");
						// FileInputStream fis = new
						// FileInputStream("c:\\loging.log");
						InputStream fis = fileItem.getInputStream();

						byte[] dataBytes = new byte[1024];

						int nread = 0;
						while ((nread = fis.read(dataBytes)) != -1) {
							md.update(dataBytes, 0, nread);
						}
						
						byte[] mdbytes = md.digest();

						// convert the byte to hex format method 1
						StringBuffer sb = new StringBuffer();
						for (int i = 0; i < mdbytes.length; i++) {
							sb.append(Integer.toString(
									(mdbytes[i] & 0xff) + 0x100, 16).substring(
									1));
						}

						String md5 = sb.toString();

						// Verifico si la carpeta md5 ya existe
						File f = new File(request.getServletContext()
								.getRealPath(filePath + File.separator + md5));

						md5List.add(md5);
						nombreOriginalList.add(fileName);

						if (!f.isDirectory()) {
							fileItemList.add(fileItem);
							ficheroList.add(fichero);
							carpetaCrearList.add(f);
							/*
							 * if(f.mkdir()){ // nos quedamos solo con el nombre
							 * y descartamos el path fichero = new
							 * File(request.getServletContext
							 * ().getRealPath(filePath + File.separator + md5 +
							 * File.separator + fileName));
							 * 
							 * System.out.println(fichero.getAbsolutePath());
							 * 
							 * System.out.println(new
							 * File(Thread.currentThread()
							 * .getContextClassLoader()
							 * .getResource("modelo").getFile
							 * ()).getAbsolutePath());
							 * 
							 * // escribimos el fichero colgando del nuevo path
							 * fileItem.write(fichero); }else{ throw new
							 * Exception("Could not make Directory " +
							 * f.getAbsolutePath()); }
							 */

						} else {
							System.out.println("ya existia el archivo");
							fileItemList.add(null);
							ficheroList.add(null);
							carpetaCrearList.add(null);
						}
					}
				}
				System.out.println("</tr>");
			}
			System.out.println("</table>");
			// } catch (FileUploadException e) {
			// e.printStackTrace();
			// } catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			System.out.println(new File(Thread.currentThread()
					.getContextClassLoader().getResource("modelo").getFile())
					.getAbsolutePath());

			bd.abrirConexionDataSource(null);

			DatabaseMetaData metaData = bd.con.getMetaData();

			bd.con.setAutoCommit(false);

			bd.stmt = bd.con.createStatement();

			// AGREGO EL LOGO EN BASE DE DATOS
			for (int i = 0; i < fileItemList.size(); i++) {
				if (fileItemList.get(i) != null) {
					/*
					 * if (nombreOriginalList.get(i).lastIndexOf(".") >= 0 &&
					 * nombreOriginalList.get(i).lastIndexOf(".") <
					 * nombreOriginalList .get(i).length() - 1) { String ext =
					 * nombreOriginalList .get(i) .substring(
					 * nombreOriginalList.get(i).lastIndexOf(".") + 1)
					 * .toLowerCase();
					 * 
					 * System.out.println("Extension = " + ext); }
					 */

					int idTipoArchivo = -1;

					String[] campos = { "id_tipo_archivo" };
					String[] tablas = { "tipos_archivos" };
					String[][] uniones = null;
					String condicion = "nombre = 'img'";
					boolean disctinct = false;
					String[] camposOrden = null;
					Boolean[] asc = null;
					String[] camposGroup = null;
					String condicionHaving = null;
					bd.generarSelect(campos, tablas, uniones, condicion,
							disctinct, camposOrden, asc, camposGroup,
							condicionHaving);

					// bd.stmt = bd.con.createStatement();

					bd.rs = bd.stmt.executeQuery(bd.sql);

					if (bd.rs.next()) {
						idTipoArchivo = bd.rs.getInt("id_tipo_archivo");
					} else {

						String nombreTabla = "tipos_archivos";
						String[] columnas = { "nombre", "descripcion",
								"fecha_hora_creacion", "usuario_creador",
								"usuario_bd_creador" };
						Object[][] valores = { { "img",
								"Las imagenes son jpg, png o gif",
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(),
								metaData.getUserName() } };
						bd.generarInsert(nombreTabla, columnas, valores);

						// bd.stmt = bd.con.createStatement();

						if (bd.stmt.executeUpdate(bd.sql,
								Statement.RETURN_GENERATED_KEYS) > 0) {
							bd.rs = bd.stmt.getGeneratedKeys();
							if (bd.rs.next()) {
								idTipoArchivo = bd.rs.getInt(1);
							} else {
								throw new Exception(
										"No retornó el key generado "
												+ nombreTabla);
							}
						} else {
							throw new Exception("No insertó en la tabla "
									+ nombreTabla);
						}

					}

					String nombreTabla = "archivos";
					String[] columnas = { "md5_archivo", "ruta",
							"id_tipo_archivo", "fecha_hora_creacion",
							"usuario_creador", "usuario_bd_creador" };
					Object[][] valores = { {
							md5List.get(i),
							filePath + File.separator + md5List.get(i)
									+ File.separator
									+ nombreOriginalList.get(i), idTipoArchivo,
							new Timestamp(new Date().getTime()),
							usuarioActual.getUsuario(), metaData.getUserName() } };
					bd.generarInsert(nombreTabla, columnas, valores);

					// bd.stmt = bd.con.createStatement();

					if (bd.stmt.executeUpdate(bd.sql) > 0) {
						nombreTabla = "archivos_x_grupos_equipos";
						String[] columnas2 = { "nombre_original",
								"md5_archivo", "id_grupo_equipo",
								"fecha_hora_creacion", "usuario_creador",
								"usuario_bd_creador" };
						Object[][] valores2 = { { nombreOriginalList.get(i),
								md5List.get(i), grupoEquipoActual.getId(),
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(),
								metaData.getUserName() } };
						bd.generarInsert(nombreTabla, columnas2, valores2);

						if (bd.stmt.executeUpdate(bd.sql) > 0) {

						} else {
							throw new Exception("No insertó en la tabla "
									+ nombreTabla);
						}
					} else {
						throw new Exception("No insertó en la tabla "
								+ nombreTabla);
					}

				} else {
					String[] campos = { "id_archivo_x_grupo_equipo" };
					String[] tablas = { "archivos_x_grupos_equipos" };
					String[][] uniones = null;
					String condicion = "md5_archivo = '" + md5List.get(i)
							+ "' AND id_grupo_equipo = '"
							+ grupoEquipoActual.getId() + "'";
					boolean disctinct = false;
					String[] camposOrden = null;
					Boolean[] asc = null;
					String[] camposGroup = null;
					String condicionHaving = null;
					bd.generarSelect(campos, tablas, uniones, condicion,
							disctinct, camposOrden, asc, camposGroup,
							condicionHaving);

					bd.rs = bd.stmt.executeQuery(bd.sql);

					if (!bd.rs.next()) {

						String nombreTabla = "archivos_x_grupos_equipos";
						String[] columnas = { "nombre_original", "md5_archivo",
								"id_grupo_equipo", "fecha_hora_creacion",
								"usuario_creador", "usuario_bd_creador" };
						Object[][] valores = { { nombreOriginalList.get(i),
								md5List.get(i), grupoEquipoActual.getId(),
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(),
								metaData.getUserName() } };
						bd.generarInsert(nombreTabla, columnas, valores);

						if (bd.stmt.executeUpdate(bd.sql) > 0) {

						} else {
							throw new Exception("No insertó en la tabla "
									+ nombreTabla);
						}
					}
				}
			}

			// FIN AGREGO EL LOGO EN BASE DE DATOS

			// AGREGO EL PRODUCTO
			String md5Producto = "";
			if (md5List.size() == 0) {
				md5Producto = (String) campos_valores.get("checkbox_logo");
			} else {
				md5Producto = md5List.get(0);
			}

			int idProducto = -1;
			String nombreTabla = "productos";
			if (campos_valores.containsKey("id_producto")) {
				idProducto = Integer.parseInt((String) campos_valores
						.get("id_producto"));

				Object[][] productosValores = {
						{
								"nombre",
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("nombre"))) },
						{
								"descripcion",
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("descripcion"))) },
						{ "md5_archivo", md5Producto },
						{ "fecha_hora_actualizacion",
								new Timestamp(new Date().getTime()) },
						{ "usuario_actualizacion", usuarioActual.getUsuario() },
						{ "usuario_bd_actualizacion", metaData.getUserName() } };
				String condicion = "id_producto = " + idProducto;
				bd.generarUpdate(nombreTabla, productosValores, condicion);

				if (bd.stmt.executeUpdate(bd.sql) > 0) {
					// EXITO
				} else {
					throw new Exception("No actualizo la tabla " + nombreTabla);
				}
			} else {

				String[] columnas = { "nombre", "descripcion", "md5_archivo",
						"fecha_hora_creacion", "usuario_creador",
						"usuario_bd_creador" };
				Object[][] valores = { {
						campos_valores.get(Util.convertirANombreCampo(traductor
								.traducir("nombre"))),
						campos_valores.get(Util.convertirANombreCampo(traductor
								.traducir("descripcion"))), md5Producto,
						new Timestamp(new Date().getTime()),
						usuarioActual.getUsuario(), metaData.getUserName() } };
				bd.generarInsert(nombreTabla, columnas, valores);

				if (bd.stmt.executeUpdate(bd.sql,
						Statement.RETURN_GENERATED_KEYS) > 0) {
					bd.rs = bd.stmt.getGeneratedKeys();
					if (bd.rs.next()) {
						idProducto = bd.rs.getInt(1);
					} else {
						throw new Exception("No retornó el key generado "
								+ nombreTabla);
					}
				} else {
					throw new Exception("No insertó en la tabla " + nombreTabla);
				}
			}
			// FIN AGREGO EL PRODUCTO

			// AGREGO LAS PANTALLAS AL PRODUCTO
			List<String> listaIdProductoXEquipos = new ArrayList<String>();
			if (campos_valores.containsKey("id_producto_x_equipos")) {
				listaIdProductoXEquipos = Arrays
						.asList(((String) campos_valores
								.get("id_producto_x_equipos")).split(","));
			}

			List<String> listaIdEquipos = new ArrayList<String>();
			if (campos_valores.get(Util.convertirANombreCampo(traductor
					.traducir("equipo"))) instanceof String) {
				listaIdEquipos.add((String) campos_valores.get(Util
						.convertirANombreCampo(traductor.traducir("equipo"))));
			} else if (campos_valores.get(Util.convertirANombreCampo(traductor
					.traducir("equipo"))) instanceof String[]) {
				listaIdEquipos = Arrays.asList((String[]) campos_valores
						.get(Util.convertirANombreCampo(traductor
								.traducir("equipo"))));
			}

			List<String> listaIdProductosXEquiposEliminar = new ArrayList<String>();
			List<Object[]> listaValoresInsertar = new ArrayList<Object[]>();
			nombreTabla = "productos_x_equipos";

			Object[][] productosValores = { { "id_producto", idProducto },
					{ "id_equipo", bd.new Incognita() },
					{ "fecha_hora_actualizacion", bd.new Incognita() },
					{ "usuario_actualizacion", usuarioActual.getUsuario() },
					{ "usuario_bd_actualizacion", metaData.getUserName() } };
			String condicion = "id_producto_x_equipo = ?";
			bd.generarUpdate(nombreTabla, productosValores, condicion);
			System.out.println(bd.sql);
			bd.prstmt = bd.con.prepareStatement(bd.sql);
			for (int i = 0; i < listaIdProductoXEquipos.size()
					|| i < listaIdEquipos.size(); i++) {
				if (i < listaIdProductoXEquipos.size()
						&& i < listaIdEquipos.size()) {
					bd.prstmt.setInt(1, Integer.parseInt(listaIdEquipos.get(i)));
					bd.prstmt.setTimestamp(2, new Timestamp(new Date().getTime()));
					bd.prstmt.setInt(3, Integer.parseInt(listaIdProductoXEquipos.get(i)));
					if(bd.prstmt.executeUpdate() > 0){
						
					}else{
						throw new Exception("No actualizo la tabla " + nombreTabla);
					}
				}else if (i < listaIdProductoXEquipos.size()){
					listaIdProductosXEquiposEliminar.add(listaIdProductoXEquipos.get(i));
				}else if (i < listaIdEquipos.size()){
					Object[] o =  { idProducto, listaIdEquipos.get(i),
						new Timestamp(new Date().getTime()),
						usuarioActual.getUsuario(), metaData.getUserName() } ;
					listaValoresInsertar.add(o);
				}

			}
			bd.prstmt.close();
			
			if(listaIdProductosXEquiposEliminar.size() > 0){
				String lista[] = new String[listaIdProductosXEquiposEliminar.size()];
				lista = listaIdProductosXEquiposEliminar.toArray(lista);
				condicion = "id_producto_x_equipo IN( " + StringUtils.join(lista, ',') + ")";
				bd.generarDelete(nombreTabla, condicion);
				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No elimino de la tabla " + nombreTabla);
				}
			}
			
			if(listaValoresInsertar.size() > 0){
				String[] columnas = { "id_producto", "id_equipo",
						"fecha_hora_creacion", "usuario_creador",
						"usuario_bd_creador" };
				Object[][] valores = new Object[listaValoresInsertar.size()][columnas.length];
				valores = listaIdProductosXEquiposEliminar.toArray(valores);
				bd.generarInsert(nombreTabla, columnas, valores);
				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No inserto en la tabla " + nombreTabla);
				}
			}
			// FIN AGREGO LAS PANTALLAS AL PRODUCTO

			// AGREGO LAS CARACTERISTICAS
			List<String> listaidProductoXCaracteristicas = new ArrayList<String>();
			if (campos_valores.containsKey("id_producto_x_caracteristicas")) {
				listaidProductoXCaracteristicas = Arrays
						.asList(((String) campos_valores
								.get("id_producto_x_caracteristicas")).split(","));
			}

			
			int num = 1;
			ArrayList<Object[]> listInsertar = new ArrayList<Object[]>();
			ArrayList<String> listEliminar = new ArrayList<String>();
				
			nombreTabla = "productos_x_caracteristicas";
			Object[][] productosValores2 = { { "id_producto", idProducto },
					{ "id_caracteristica", bd.new Incognita() },
					{ "valor", bd.new Incognita() },
					{ "fecha_hora_actualizacion", bd.new Incognita() },
					{ "usuario_actualizacion", usuarioActual.getUsuario() },
					{ "usuario_bd_actualizacion", metaData.getUserName() } };
			condicion = "id_producto_x_caracteristica = ?";
			bd.generarUpdate(nombreTabla, productosValores2, condicion);
			bd.prstmt = bd.con.prepareStatement(bd.sql);
			
			while (campos_valores
					.containsKey(Util.convertirANombreCampo(traductor
							.traducir("caracteristica")) + "_" + num) || num <= listaidProductoXCaracteristicas.size()) {
				
				if(campos_valores
					.containsKey(Util.convertirANombreCampo(traductor
							.traducir("caracteristica")) + "_" + num)){
					int idCaracteristica = -1;
	
					if (campos_valores.get(Util.convertirANombreCampo(traductor
							.traducir("es_nueva_caracteristica")) + "_" + num) != null) {
						nombreTabla = "caracteristicas";
						String[] columnas3 = { "nombre", "descripcion",
								"fecha_hora_creacion", "usuario_creador",
								"usuario_bd_creador" };
						Object[][] valores3 = { {
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("nueva_caracteristica"))
										+ "_" + num), "",
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(), metaData.getUserName() } };
						bd.generarInsert(nombreTabla, columnas3, valores3);
	
						if (bd.stmt.executeUpdate(bd.sql,
								Statement.RETURN_GENERATED_KEYS) > 0) {
							bd.rs = bd.stmt.getGeneratedKeys();
							if (bd.rs.next()) {
								idCaracteristica = bd.rs.getInt(1);
							} else {
								throw new Exception("No retornó el key generado "
										+ nombreTabla);
							}
	
						} else {
							throw new Exception("No insertó en la tabla "
									+ nombreTabla);
						}
	
					} else {
						idCaracteristica = Integer.parseInt((String) campos_valores
								.get(Util.convertirANombreCampo(traductor
										.traducir("caracteristica")) + "_" + num));
					}
					
					if(num <= listaidProductoXCaracteristicas.size()){
						bd.prstmt.setInt(1, idCaracteristica);
						bd.prstmt.setString(2, (String) campos_valores.get(Util.convertirANombreCampo(traductor
								.traducir("valor_caracteristica")) + "_" + num));
						bd.prstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
						bd.prstmt.setInt(4, Integer.parseInt(listaidProductoXCaracteristicas.get(num-1)));
						if(bd.prstmt.executeUpdate() > 0){
							
						}else{
							throw new Exception("No actualizo la tabla " + nombreTabla);
						}
					}else{
	
						Object vs[] = {
								idProducto,
								idCaracteristica,
								campos_valores.get(Util.convertirANombreCampo(traductor
										.traducir("valor_caracteristica")) + "_" + num),
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(), metaData.getUserName() };
						listInsertar.add(vs);
					}
				}else{
					listEliminar.add(listaidProductoXCaracteristicas.get(num-1));
				}
				num++;
			}
			bd.prstmt.close();

			if(listEliminar.size() > 0){ 
				nombreTabla = "productos_x_caracteristicas";
				String lista[] = new String[listEliminar.size()];
				lista = listEliminar.toArray(lista);
				condicion = "id_producto_x_caracteristica IN( " + StringUtils.join(lista, ',') + ")";
				bd.generarDelete(nombreTabla, condicion);
				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No elimino de la tabla " + nombreTabla);
				}
			}
			
			if (listInsertar.size() > 0) {
				nombreTabla = "productos_x_caracteristicas";
				String[] columnas = { "id_producto", "id_caracteristica",
						"valor", "fecha_hora_creacion", "usuario_creador",
						"usuario_bd_creador" };
				Object[][] valores = new Object[listInsertar.size()][columnas.length];
				valores = listInsertar.toArray(valores);
				bd.generarInsert(nombreTabla, columnas, valores);

				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No insertó en la tabla " + nombreTabla);
				}
			}
			// FIN AGREGO LAS CARACTERISTICAS

			// AGREGO LOS PRECIOS
			List<String> listaidProductoXPrecios = new ArrayList<String>();
			if (campos_valores.containsKey("id_precios_producto")) {
				listaidProductoXPrecios = Arrays
						.asList(((String) campos_valores
								.get("id_precios_producto")).split(","));
			}

			
			num = 1;
			listInsertar = new ArrayList<Object[]>();
			listEliminar = new ArrayList<String>();
				
			nombreTabla = "precios_productos";
			Object[][] productosValores3 = {
					{ "nombre", bd.new Incognita() },
					{ "descripcion", bd.new Incognita() },
					{ "id_producto", idProducto },
					{ "codigo_moneda", bd.new Incognita() },
					{ "valor", bd.new Incognita() },
					{ "fecha_hora_actualizacion", bd.new Incognita() },
					{ "usuario_actualizacion", usuarioActual.getUsuario() },
					{ "usuario_bd_actualizacion", metaData.getUserName() } };
			condicion = "id_precio_producto = ?";
			bd.generarUpdate(nombreTabla, productosValores3, condicion);
			bd.prstmt = bd.con.prepareStatement(bd.sql);
			
			while (campos_valores.containsKey(Util
					.convertirANombreCampo(traductor.traducir("nombre_precio"))
					+ "_" + num) || num <= listaidProductoXPrecios.size()) {

				if(campos_valores.containsKey(Util
						.convertirANombreCampo(traductor.traducir("nombre_precio"))
						+ "_" + num)){
				
					String codigoMoneda = "";
	
					if (campos_valores.get(Util.convertirANombreCampo(traductor
							.traducir("es_nueva_moneda")) + "_" + num) != null) {
						nombreTabla = "monedas";
						String[] columnas3 = { "codigo_moneda", "nombre",
								"simbolo", "valor", "deshabilitado",
								"fecha_hora_creacion", "usuario_creador",
								"usuario_bd_creador" };
						Object[][] valores3 = { {
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("codigo_nueva_moneda"))
										+ "_" + num),
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("nombre_nueva_moneda"))
										+ "_" + num),
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("simbolo_nueva_moneda"))
										+ "_" + num),
								campos_valores.get(Util
										.convertirANombreCampo(traductor
												.traducir("valor_nueva_moneda"))
										+ "_" + num), 0,
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(), metaData.getUserName() } };
						bd.generarInsert(nombreTabla, columnas3, valores3);
	
						if (bd.stmt.executeUpdate(bd.sql) > 0) {
							codigoMoneda = (String) campos_valores.get(Util
									.convertirANombreCampo(traductor
											.traducir("codigo_nueva_moneda"))
									+ "_" + num);
						} else {
							throw new Exception("No insertó en la tabla "
									+ nombreTabla);
						}
	
					} else {
						codigoMoneda = (String) campos_valores
								.get(Util.convertirANombreCampo(traductor
										.traducir("moneda")) + "_" + num);
					}
	
					if(num <= listaidProductoXPrecios.size()){
						bd.prstmt.setString(1, (String) campos_valores.get(Util.convertirANombreCampo(traductor
								.traducir("nombre_precio")) + "_" + num));
						bd.prstmt.setString(2, "");
						bd.prstmt.setString(3, codigoMoneda);
						bd.prstmt.setString(4, (String) campos_valores.get(Util.convertirANombreCampo(traductor
								.traducir("valor_precio")) + "_" + num));
						bd.prstmt.setTimestamp(5, new Timestamp(new Date().getTime()));
						bd.prstmt.setInt(6, Integer.parseInt(listaidProductoXPrecios.get(num-1)));
						if(bd.prstmt.executeUpdate() > 0){
							
						}else{
							throw new Exception("No actualizo la tabla " + nombreTabla);
						}
					}else{
						Object vs[] = {
								campos_valores.get(Util.convertirANombreCampo(traductor
										.traducir("nombre_precio")) + "_" + num),
								"",
								idProducto,
								codigoMoneda,
								campos_valores.get(Util.convertirANombreCampo(traductor
										.traducir("valor_precio")) + "_" + num),
								new Timestamp(new Date().getTime()),
								usuarioActual.getUsuario(), metaData.getUserName() };
						listInsertar.add(vs);
					}
				}else{
					listEliminar.add(listaidProductoXPrecios.get(num-1));
				}
				num++;
			}
			
			if(listEliminar.size() > 0){ 
				nombreTabla = "precios_productos";
				String lista[] = new String[listEliminar.size()];
				lista = listEliminar.toArray(lista);
				condicion = "id_precio_producto IN( " + StringUtils.join(lista, ',') + ")";
				bd.generarDelete(nombreTabla, condicion);
				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No elimino de la tabla " + nombreTabla);
				}
			}

			if (listInsertar.size() > 0) {
				nombreTabla = "precios_productos";
				String[] columnas = { "nombre", "descripcion", "id_producto",
						"codigo_moneda", "valor", "fecha_hora_creacion",
						"usuario_creador", "usuario_bd_creador" };
				Object[][] valores = new Object[listInsertar.size()][columnas.length];
				valores = listInsertar.toArray(valores);

				bd.generarInsert(nombreTabla, columnas, valores);
				if (bd.stmt.executeUpdate(bd.sql) > 0) {

				} else {
					throw new Exception("No insertó en la tabla " + nombreTabla);
				}
			}
			// FIN AGREGO LOS PRECIOS

			// SUBO EL LOGO
			for (int i = 0; i < ficheroList.size(); i++) {
				if (ficheroList.get(i) != null) {
					if (carpetaCrearList.get(i).mkdir()) { // nos quedamos solo
															// con el nombre y
															// descartamos el
															// path
						File fichero = ficheroList.get(i);
						fichero = new File(request.getServletContext()
								.getRealPath(
										filePath + File.separator
												+ md5List.get(i)
												+ File.separator
												+ nombreOriginalList.get(i)));

						System.out.println(fichero.getAbsolutePath());

						System.out.println(new File(Thread.currentThread()
								.getContextClassLoader().getResource("modelo")
								.getFile()).getAbsolutePath());

						// escribimos el fichero colgando del nuevo path
						fileItemList.get(i).write(fichero);
					} else {
						throw new Exception("Could not make Directory "
								+ ficheroList.get(i).getAbsolutePath());
					}
				}
			}
			// FIN SUBO EL LOGO

			bd.con.commit();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				bd.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// throw e1;
			}
			throw e;
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				bd.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// throw e1;
			}
			throw e;
		} finally {
			bd.cerrarConexion();
		}
	}

	public static BaseDatos retornarBaseDatosListaProductos() {
		BaseDatos bd = new BaseDatos();

		bd.usarJDBC = false;

		String[] campos = { "productos.id_producto", "archivos.ruta",
				"productos.nombre", "productos.descripcion",
				"productos_x_equipos.id_producto_x_equipo",
				"equipos.id_equipo", "equipos.nombre",
				"productos_x_caracteristicas.id_producto_x_caracteristica",
				"caracteristicas.id_caracteristica", "caracteristicas.nombre",
				"productos_x_caracteristicas.valor",
				"precios_productos.id_precio_producto",
				"precios_productos.nombre", "precios_productos.codigo_moneda",
				"precios_productos.valor" };
		String[] tablas = { "productos" };
		String[][] uniones = {
				{ "INNER", "archivos", "productos.md5_archivo", "=",
						"archivos.md5_archivo" },
				{ "INNER", "productos_x_equipos", "productos.id_producto", "=",
						"productos_x_equipos.id_producto" },
				{ "INNER", "equipos", "productos_x_equipos.id_equipo", "=",
						"equipos.id_equipo" },
				{ "LEFT", "productos_x_caracteristicas",
						"productos.id_producto", "=",
						"productos_x_caracteristicas.id_producto" },
				{ "LEFT", "caracteristicas",
						"productos_x_caracteristicas.id_caracteristica", "=",
						"caracteristicas.id_caracteristica" },
				{ "LEFT", "precios_productos", "productos.id_producto", "=",
						"precios_productos.id_producto" } };
		String condicion = null;
		boolean disctinct = false;
		String[] camposOrden = null;
		Boolean[] asc = null;
		String[] camposGroup = null;
		String condicionHaving = null;

		bd.campos = campos;
		bd.tablas = tablas;
		bd.uniones = uniones;
		bd.condicion = condicion;
		bd.disctinct = disctinct;
		bd.camposOrden = camposOrden;
		bd.asc = asc;
		bd.camposGroup = camposGroup;
		bd.condicionHaving = condicionHaving;

		return bd;
	}
	
	public static void Eliminar(int idProducto) throws Exception {
		BaseDatos bd = new BaseDatos();
		
		try {
			String nombreTabla = "productos_x_equipos";
			String condicion = "id_producto = " + idProducto;
			bd.generarDelete(nombreTabla, condicion);
			
			bd.abrirConexionDataSource(null);
			bd.con.setAutoCommit(false);	
			bd.stmt = bd.con.createStatement();
			
			if (bd.stmt.executeUpdate(bd.sql) > 0) {

			} else {
				throw new Exception("No eliminó de la tabla " + nombreTabla);
			}
			
			nombreTabla = "productos_x_caracteristicas";
			bd.generarDelete(nombreTabla, condicion);
			
			if (bd.stmt.executeUpdate(bd.sql) > 0) {

			} else {
				//throw new Exception("No eliminó de la tabla " + nombreTabla);
			}
			
			nombreTabla = "precios_productos";
			bd.generarDelete(nombreTabla, condicion);
			
			if (bd.stmt.executeUpdate(bd.sql) > 0) {

			} else {
				//throw new Exception("No eliminó de la tabla " + nombreTabla);
			}
			
			nombreTabla = "productos_x_documentos";
			bd.generarDelete(nombreTabla, condicion);
			
			if (bd.stmt.executeUpdate(bd.sql) > 0) {

			} else {
				//throw new Exception("No eliminó de la tabla " + nombreTabla);
			}
			
			nombreTabla = "productos";
			bd.generarDelete(nombreTabla, condicion);
			
			if (bd.stmt.executeUpdate(bd.sql) > 0) {

			} else {
				throw new Exception("No eliminó de la tabla " + nombreTabla);
			}
			
			bd.con.commit();
		} catch (NamingException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			bd.con.rollback();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			bd.con.rollback();
			throw e;
		}
	}
	
	public static Producto[] getListaProductos(int idGrupoEquipo) throws NamingException, SQLException {
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		BaseDatos bd = new BaseDatos();
		
		String[] campos = {"productos.id_producto", "productos.nombre"};
		String[] tablas = {"productos"};
		String[][] uniones = {{"INNER", "productos_x_equipos", "productos.id_producto", "=", "productos_x_equipos.id_producto"},
				{"INNER", "equipos", "productos_x_equipos.id_equipo", "=", "equipos.id_equipo"}};
		String condicion = "equipos.id_grupo_equipo = " + idGrupoEquipo;
		boolean disctinct = false;
		String[] camposOrden = {"productos.nombre"};
		Boolean[] asc  = {true};
		String[] camposGroup = null;
		String condicionHaving = null;
		bd.generarSelect(campos, tablas, uniones, condicion, disctinct, camposOrden, asc, camposGroup, condicionHaving);
		
		try {
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
			
			bd.rs = bd.stmt.executeQuery(bd.sql);
			
			while(bd.rs.next()){
				listaProductos.add(new Producto(null, null, null, bd.rs.getInt(1), bd.rs.getString(2), null));
			}
			
			Producto[] Productos = new Producto[listaProductos.size()];
			
			Productos = listaProductos.toArray(Productos);
			
			return Productos;
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			try {
				bd.cerrarConexion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//return null;
	}
	
	public BaseDatos getBDDocumentos() {
		BaseDatos bd = new BaseDatos();
		
		bd.usarJDBC = false;
		
		String[] campos = {"documentos.id_documento", "documentos.nombre", "documentos.descripcion", 
				"CASE WHEN documentos.enlace_pagina_web IS NOT NULL THEN documentos.enlace_pagina_web ELSE "+
				"CASE WHEN documentos.texto_plano IS NOT NULL THEN documentos.texto_plano ELSE "+
				"CASE WHEN documentos.texto_html IS NOT NULL THEN documentos.texto_html ELSE " +
				"CASE WHEN documentos.md5_archivo IS NOT NULL THEN "+
				 "(CONCAT(\"<A href=\\\"\", (SELECT a.ruta FROM archivos a WHERE a.md5_archivo = documentos.md5_archivo), \"\\\">\", (SELECT a.nombre_original FROM archivos_x_grupos_equipos a WHERE a.md5_archivo = md5_archivo AND id_grupo_equipo = equipos.id_grupo_equipo), \"</A>\")) "+
				 "END "+
				 "END "+
				 "END "+
				 "END AS documento",
				"tipos_documentos.nombre", "predeterminado"};
		String[] tablas = {"documentos"};
		String[][] uniones = {{"INNER", "tipos_documentos", "documentos.id_tipo_documento", "=", "tipos_documentos.id_tipo_documento"},
				{"INNER", "productos_x_equipos	", "documentos.id_producto", "=", "productos_x_equipos.id_producto"},
				{"INNER", "equipos	", "productos_x_equipos.id_equipo", "=", "equipos.id_equipo"}};
		String condicion = "documentos.id_producto = " + getId();
		boolean disctinct = false;
		String[] camposOrden = {"documentos.orden"};
		Boolean[] asc  = {true};
		String[] camposGroup = null;
		String condicionHaving = null;
		
		bd.campos = campos;
		bd.tablas = tablas;
		bd.uniones = uniones;
		bd.condicion = condicion;
		bd.disctinct = disctinct;
		bd.camposOrden = camposOrden;
		bd.asc = asc;
		bd.camposGroup = camposGroup;
		bd.condicionHaving = condicionHaving;
		
		return bd;
	}
}
