package controlador.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.utils.Traductor;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class AgregarProductoServlet
 */
@WebServlet(
		description = "Servlet usado para Agregar un Producto", 
		urlPatterns = { "/AgregarProductoServlet" }, 
		initParams = { 
				@WebInitParam(name = "ruta_contenido_archivos", value = "contenido", description = "Aquí se crearan las carpetas y se colocan los archivos subidos por los clientes")
		})
public class AgregarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 50 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Get the file location where it would be stored.
	      filePath = 
	    		  config.getInitParameter("ruta_contenido_archivos"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Traductor traductor = Traductor.getTraductorSesion(request, response);
		
		try {
			Producto.Agregar(request, filePath, traductor);
			response.sendRedirect("jsp/agregar_producto.jsp?exito=producto_agregado_exito");
		} catch (Exception e) {
			//e.printStackTrace();
			response.sendRedirect("jsp/agregar_producto.jsp?mensaje_error="
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}

	}

}
