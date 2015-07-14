package controlador.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.utils.Traductor;

/**
 * Servlet implementation class EditarProductoServlet
 */
@WebServlet(description = "Servlet utilizado para Editar un Producto", urlPatterns = { "/EditarProductoServlet" }, initParams = { @WebInitParam(name = "ruta_contenido_archivos", value = "contenido", description = "ruta del contenido de archivos") })
public class EditarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Get the file location where it would be stored.
		filePath = config.getInitParameter("ruta_contenido_archivos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Traductor traductor = Traductor.getTraductorSesion(request, response);

		try {
			Producto.Agregar(request, filePath, traductor);
			response.sendRedirect("jsp/listado_productos.jsp?exito=producto_editado_exito");
		} catch (Exception e) {
			// e.printStackTrace();
			response.sendRedirect("jsp/listado_productos.jsp?mensaje_error="
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}

}
