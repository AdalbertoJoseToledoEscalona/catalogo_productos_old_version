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
public class Moneda {

	/**
	 * Codigo Internacional de la moneda Ejemplo BsF. USD, etc
	 */
	private String codigo;
	/**
	 * Nombre de la Moneda, ejemplo Bolívares Fuertes, Dólares, etc
	 */
	private String nombre;
	/**
	 * Valor Internacional de la Moneda, ejemplo Bolívares Fuertes, Dólares, etc
	 */
	private float valor;
	/**
	 * Indica si está o no deshabilitado
	 */
	private boolean deshabilitado;

	/**
	 * 
	 */
	public Moneda() {
		// TODO Auto-generated constructor stub
	}

	public Moneda(String codigo, String nombre, float valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.deshabilitado = false;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * @return the deshabilitado
	 */
	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	/**
	 * @param deshabilitado
	 *            the deshabilitado to set
	 */
	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	public static List<Moneda> getMonedas() throws NamingException,
			SQLException {
		ArrayList<Moneda> monedas = null;

		BaseDatos bd = new BaseDatos();

		String[] campos = { "codigo_moneda", "nombre", "valor" };
		String[] tablas = { "monedas" };
		String[][] uniones = null;
		String condicion = "deshabilitado = 0";
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
	
			monedas = new ArrayList<Moneda>();
			while (bd.rs.next()) {
				monedas.add(new Moneda(bd.rs.getString("codigo_moneda"), bd.rs
						.getString("nombre"), bd.rs.getFloat("valor")));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			bd.cerrarConexion();
		}

		return monedas;
	}

}
