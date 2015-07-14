package controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ArchivoGrupoEquipo;
import modelo.utils.Traductor;

/**
 * Servlet implementation class EliminarArchivoServlet
 */
@WebServlet(
		description = "Servlet usado para Eliminar un Archivo tanto de la Base de Datos como del Sistema de Archivos", 
		urlPatterns = { "/EliminarArchivoServlet" }, 
		initParams = { 
				@WebInitParam(name = "ruta_contenido_archivos", value = "contenido", description = "ruta del contenido de los archivos")
		})
public class EliminarArchivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private String filePath;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarArchivoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Get the file location where it would be stored.
	      //filePath = 
	    //		  config.getInitParameter("ruta_contenido_archivos"); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Traductor traductor = Traductor.getTraductorSesion(request, response);
		if(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.md5_archivo_eliminar") != null){
			PrintWriter salida = response.getWriter();
			
			HttpSession sesion = request.getSession(false);
			if (sesion == null || sesion.getAttribute("usuario") == null
					|| sesion.getAttribute("grupoEquipo") == null
					|| sesion.getAttribute("traductor") == null) {
				salida.println("<REDIRECCIONAR>" + request.getContextPath() + "/jsp/index.jsp?error=expira_sesion" + "</REDIRECCIONAR>");
			} else {
				try {
					ArchivoGrupoEquipo.eliminar(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.md5_archivo_eliminar"), Integer.parseInt(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.id_archivo_x_grupo_equipo_eliminar")), Integer.parseInt(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.id_grupo_equipo_eliminar")), request.getParameter("catalogo_productos_servidor.archivos.ruta_eliminar"), request);
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
				RequestDispatcher rd = contexto.getRequestDispatcher("/jsp/plantillas/reporte_listado_archivos.jsp");
				rd.include(request, response);
				//rd.forward(request, response);
			
			}
			
		}else if(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.md5_archivo") != null){
			HttpSession sesion = request.getSession(false);
			if (sesion == null || sesion.getAttribute("usuario") == null
					|| sesion.getAttribute("grupoEquipo") == null
					|| sesion.getAttribute("traductor") == null) {
				response.sendRedirect(request.getContextPath() + "/jsp/index.jsp?error=expira_sesion");
			} else {
				String mensaje = "";
				try {
					ArchivoGrupoEquipo.eliminar(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.md5_archivo"), Integer.parseInt(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.id_archivo_x_grupo_equipo")), Integer.parseInt(request.getParameter("catalogo_productos_servidor.archivos_x_grupos_equipos.id_grupo_equipo")), request.getParameter("catalogo_productos_servidor.archivos.ruta"), request);
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
				response.sendRedirect("jsp/administrar_documentos_productos.jsp?" + mensaje);
			}
		}
	}

}
