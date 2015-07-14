package controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GrupoEquipo;
import modelo.Usuario;

/**
 * Servlet implementation class LlenarCmbGrupoEquipoServlet
 */
@WebServlet(description = "Servlet utilizado para llenar el combo de Grupo de Equipos", urlPatterns = { "/LlenarCmbGrupoEquipoServlet" })
public class LlenarCmbGrupoEquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LlenarCmbGrupoEquipoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		
		Usuario usuario = new Usuario(request.getParameter("usuario"), request.getParameter("clave"));
		
		try {
			List<GrupoEquipo> gruposEquipos = usuario.getGrupoEquipo();
		
			salida.println("<SELECT>");
			for (GrupoEquipo grupoEquipo : gruposEquipos) {
				salida.println("<OPTION value='" + grupoEquipo.getId() + "'>" + grupoEquipo.getNombre() +"</OPTION>");
			}
			salida.println("</SELECT>");
		
		} catch (NamingException e) {
			e.printStackTrace();
			salida.println("<ERROR>" + e.getClass().getSimpleName() + ": "+ e.getMessage() + "</ERROR>");
		} catch (SQLException e) {
			e.printStackTrace();
			salida.println("<ERROR>" + e.getClass().getSimpleName() + ": "+ e.getMessage() + "</ERROR>");
		}
	}
}
