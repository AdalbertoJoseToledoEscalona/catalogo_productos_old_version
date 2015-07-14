package controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import modelo.utils.Traductor;

/**
 * Servlet implementation class EliminarProductoServlet
 */
@WebServlet(
		description = "Servlet usado para Eliminar un Producto", 
		urlPatterns = { "/EliminarProductoServlet" }, 
		initParams = { 
				@WebInitParam(name = "ruta_contenido_archivos", value = "contenido", description = "ruta para donde esta el contenido")
		})
public class EliminarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Traductor traductor = Traductor.getTraductorSesion(request, response);
		if(request.getParameter("id_eliminar") != null){
			PrintWriter salida = response.getWriter();
			
			HttpSession sesion = request.getSession(false);
			if (sesion == null || sesion.getAttribute("usuario") == null
					|| sesion.getAttribute("grupoEquipo") == null
					|| sesion.getAttribute("traductor") == null) {
				salida.println("<REDIRECCIONAR>" + request.getContextPath() + "/jsp/index.jsp?error=expira_sesion" + "</REDIRECCIONAR>");
			} else {
				try {
					Producto.Eliminar(Integer.parseInt(request.getParameter("id_eliminar")));
					salida.println("<EXITO>" + traductor.traducir("producto_eliminado_exito") + "</EXITO>");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					salida.println("<ERROR>" + e.getMessage() + "</ERROR>");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					salida.println("<ERROR>" + e.getMessage() + "</ERROR>");
				}
				
				ServletContext contexto = request.getServletContext();
				RequestDispatcher rd = contexto.getRequestDispatcher("/jsp/plantillas/reporte_listado_producto.jsp");
				rd.include(request, response);
				//rd.forward(request, response);
			
			}
			
		}else if(request.getParameter("id") != null){
			HttpSession sesion = request.getSession(false);
			if (sesion == null || sesion.getAttribute("usuario") == null
					|| sesion.getAttribute("grupoEquipo") == null
					|| sesion.getAttribute("traductor") == null) {
				response.sendRedirect(request.getContextPath() + "/jsp/index.jsp?error=expira_sesion");
			} else {
				String mensaje = "";
				try {
					Producto.Eliminar(Integer.parseInt(request.getParameter("id")));
					mensaje = "exito=producto_eliminado_exito";
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mensaje = "mensaje_error=" + e.getMessage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mensaje = "mensaje_error=" + e.getMessage();
				}
				response.sendRedirect("jsp/listado_productos.jsp?" + mensaje);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
