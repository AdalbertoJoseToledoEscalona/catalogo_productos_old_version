package controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.utils.Traductor;

/**
 * Servlet implementation class SetIdiomaPaisServlet
 */
@WebServlet(description = "Coloca el idioma pais en la sesion", urlPatterns = { "/SetIdiomaPaisServlet" })
public class SetIdiomaPaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetIdiomaPaisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		PrintWriter salida = response.getWriter();
		if (sesion == null || sesion.getAttribute("usuario") == null
				|| sesion.getAttribute("grupoEquipo") == null
				|| sesion.getAttribute("traductor") == null) {
			salida.println("<ERROR>expira_sesion</ERROR>");
		}else {
			Traductor traductor = (Traductor) sesion.getAttribute("traductor");
			Usuario usuario = (Usuario) sesion.getAttribute("usuario");
			
			String idiomaPais = request.getParameter("idioma_pais");
			String idioma = "";
			String pais = "";
			if(!idiomaPais.isEmpty()){
				idioma = idiomaPais.split("_")[0];
				pais = idiomaPais.split("_")[1];
			}
			
			traductor.setIdiomaPais(idioma, pais);
			usuario.setIdiomaPais(traductor.getIdioma() + "_" + traductor.getPais());
			sesion.setAttribute("traductor", traductor);
			
			salida.println("<RESPUESTA>exito</RESPUESTA>");
		}
	}

}
