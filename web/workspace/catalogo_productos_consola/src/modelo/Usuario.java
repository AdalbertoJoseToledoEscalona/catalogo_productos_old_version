/**
 * 
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import modelo.utils.BaseDatos;

/**
 * @author adalberto
 * 
 */
public class Usuario implements HttpSessionBindingListener,
		HttpSessionAttributeListener, HttpSessionListener {

	private List<GrupoEquipo> grupoEquipo;
	private List<Permisologia> permisologia;
	private Ciudad ciudad;
	/**
	 * nombre de usuario para autenticarse en el sistema
	 */
	private String usuario;
	/**
	 * La clave para autenticarse en el sistema
	 */
	private String clave;
	/**
	 * nombre de la persona usuario del sistema
	 */
	private String nombre;
	/**
	 * apellido de la persona usuario del sistema
	 */
	private String apellido;
	/**
	 * email de la persona usuario del sistema
	 */
	private String email;
	/**
	 * El Telefono del usuario
	 */
	private char[] telefono;
	/**
	 * La direccion del Usuario
	 */
	private String direccion;
	/**
	 * El codigo postal donde se encuentra el usuario
	 */
	private int codigoPostal;
	/**
	 * El Idioma_Pais del usuario (separado por '_')
	 */
	private String idiomaPais;
	/**
	 * Indica si esta o no bloqueado
	 */
	private boolean bloqueado;
	/**
	 * Indica si esta o no eliminado
	 */
	private boolean eliminado;

	/**
	 * 
	 */
	public Usuario(Ciudad ciudad2, List<Permisologia> permisologia2,
			List<GrupoEquipo> grupoEquipo2) {
		ciudad = ciudad2;
		permisologia = permisologia2;
		grupoEquipo = grupoEquipo2;
	}

	public Usuario(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}

	public Usuario(String usuario, String clave, String nombre,
			String apellido, String email, char[] telefono, String direccion,
			int codigoPostal, String idiomaPais, boolean bloqueado,
			boolean eliminado) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idiomaPais = idiomaPais;
		this.bloqueado = bloqueado;
		this.eliminado = eliminado;
	}

	public Usuario(List<GrupoEquipo> grupoEquipo,
			List<Permisologia> permisologia, Ciudad ciudad, String usuario,
			String clave, String nombre, String apellido, String email,
			char[] telefono, String direccion, int codigoPostal,
			String idiomaPais, boolean bloqueado, boolean eliminado) {
		super();
		this.grupoEquipo = grupoEquipo;
		this.permisologia = permisologia;
		this.ciudad = ciudad;
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.idiomaPais = idiomaPais;
		this.bloqueado = bloqueado;
		this.eliminado = eliminado;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public char[] getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(char[] telefono) {
		this.telefono = telefono;
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
	public int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal
	 *            the codigoPostal to set
	 */
	public void setCodigoPostal(int codigoPostal) {
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
	 * @return the bloqueado
	 */
	public boolean isBloqueado() {
		return bloqueado;
	}

	/**
	 * @param bloqueado
	 *            the bloqueado to set
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	/**
	 * @return the eliminado
	 */
	public boolean isEliminado() {
		return eliminado;
	}

	/**
	 * @param eliminado
	 *            the eliminado to set
	 */
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	/**
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}


	/**
	 * @return the permisologia
	 */
	public List<Permisologia> getPermisologia() {
		return permisologia;
	}

	/**
	 * @return the grupoEquipo
	 * @throws SQLException
	 * @throws NamingException
	 */
	public List<GrupoEquipo> getGrupoEquipo() throws NamingException,
			SQLException {

		if (grupoEquipo == null) {
			BaseDatos bd = new BaseDatos();

			String[] campos = { "grupos_equipos.id_grupo_equipo",
					"grupos_equipos.nombre", "grupos_equipos.descripcion" };
			String[] tablas = { "grupos_equipos" };
			String[][] uniones = {
					{ "INNER", "usuarios_x_grupos_equipos",
							"grupos_equipos.id_grupo_equipo", "=",
							"usuarios_x_grupos_equipos.id_grupo_equipo" },
					{ "INNER", "usuarios", "usuarios_x_grupos_equipos.usuario",
							"=", "usuarios.usuario" } };
			String condicion = "usuarios.usuario = '" + usuario
					+ "' AND usuarios.clave = '" + clave + "'";
			boolean disctinct = false;
			String[] camposOrden = { "grupos_equipos.nombre" };
			Boolean[] asc = { true };
			String[] camposGroup = null;
			String condicionHaving = null;
			bd.generarSelect(campos, tablas, uniones, condicion, disctinct,
					camposOrden, asc, camposGroup, condicionHaving);

			try{
				bd.abrirConexionDataSource(null);
				bd.stmt = bd.con.createStatement();
				bd.rs = bd.stmt.executeQuery(bd.sql);
	
				grupoEquipo = new ArrayList<GrupoEquipo>();
				while (bd.rs.next()) {
					grupoEquipo.add(new GrupoEquipo(
							bd.rs.getInt("id_grupo_equipo"), bd.rs
									.getString("nombre"), bd.rs
									.getString("descripcion"), null));
				}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			} finally{
				bd.cerrarConexion();
			}

		}

		return grupoEquipo;
	}

	public static Usuario autenticarUsuario(String usuario, String clave,
			int idGrupoEquipo) throws NamingException, SQLException {
		Usuario objUsuario = null;

		BaseDatos bd = new BaseDatos();

		String[] campos = { "usuarios.usuario", "usuarios.clave",
				"usuarios.nombre", "usuarios.apellido", "usuarios.email",
				"usuarios.telefono", "usuarios.direccion",
				"usuarios.codigo_postal", "usuarios.idioma_pais",
				"usuarios.bloqueado", "usuarios.eliminado" };
		String[] tablas = { "usuarios" };
		String[][] uniones = { { "INNER", "usuarios_x_grupos_equipos",
				"usuarios.usuario", "=", "usuarios_x_grupos_equipos.usuario" } };
		String condicion = "usuarios.usuario = '" + usuario
				+ "' AND usuarios.clave = '" + clave
				+ "' AND usuarios_x_grupos_equipos.id_grupo_equipo = "
				+ idGrupoEquipo
				+ " AND usuarios.bloqueado = 0 AND usuarios.eliminado = 0";
		boolean disctinct = true;
		String[] camposOrden = null;
		Boolean[] asc = null;
		String[] camposGroup = null;
		String condicionHaving = null;
		bd.generarSelect(campos, tablas, uniones, condicion, disctinct,
				camposOrden, asc, camposGroup, condicionHaving);

		try{
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
			bd.rs = bd.stmt.executeQuery(bd.sql);
	
			if (bd.rs.next()) {
				objUsuario = new Usuario(bd.rs.getString("usuario"),
						bd.rs.getString("clave"), bd.rs.getString("nombre"),
						bd.rs.getString("apellido"), bd.rs.getString("email"),
						bd.rs.getString("telefono").toCharArray(),
						bd.rs.getString("direccion"),
						bd.rs.getInt("codigo_postal"),
						bd.rs.getString("idioma_pais"),
						bd.rs.getBoolean("bloqueado"),
						bd.rs.getBoolean("eliminado"));
			}

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			bd.cerrarConexion();
		}


		return objUsuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Se ha creado la sesion");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Se ha destruido la sesion");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.
	 * servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("Se ha agregado un atributo a la sesion");
		System.out.println(arg0.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax
	 * .servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("Se ha removido un atributo a la sesion");
		System.out.println(arg0.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax
	 * .servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("Se ha reemplazado un atributo a la sesion");
		System.out.println(arg0.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionBindingListener#valueBound(javax.servlet
	 * .http.HttpSessionBindingEvent)
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("Se ha enlazado un objeto a la Sesion...");
		System.out.println(arg0.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionBindingListener#valueUnbound(javax.servlet
	 * .http.HttpSessionBindingEvent)
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("Se ha Desenlazado un objeto a la Sesion...");
		System.out.println(arg0.getName());

		BaseDatos bd = new BaseDatos();

		String nombreTabla = "usuarios";
		Object[][] productosValores = { { "idioma_pais", idiomaPais } };
		String condicion = "usuario = '" + usuario + "'";
		bd.generarUpdate(nombreTabla, productosValores, condicion);

		try {
			bd.abrirConexionDataSource(null);
			bd.stmt = bd.con.createStatement();
			bd.stmt.executeUpdate(bd.sql);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
