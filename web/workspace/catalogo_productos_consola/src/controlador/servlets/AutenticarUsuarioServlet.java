package controlador.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.GrupoEquipo;
import modelo.Usuario;
import modelo.utils.Traductor;
import modelo.utils.Util;

/**
 * Servlet implementation class AutenticarUsuarioServlet
 */
@WebServlet(description = "Servlet usado para autenticar el usuario en la consola", urlPatterns = { "/AutenticarUsuarioServlet" })
public class AutenticarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutenticarUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		/*
		 * sesion.removeAttribute("usuario");
		 * sesion.removeAttribute("grupoEquipo");
		 * sesion.removeAttribute("traductor");
		 */
		if (sesion != null) {
			sesion.invalidate();
		}

		response.sendRedirect(request.getContextPath() + "/jsp/index.jsp?exito=sesion_cerrada");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idioma_pais[] = request.getParameter("idioma_pais").split("_");
		Traductor traductor = new Traductor(idioma_pais[0], idioma_pais[1]);

		try {
			Usuario usuario = Usuario.autenticarUsuario(request
					.getParameter(Util.convertirANombreCampo(traductor
							.traducir("usuario"))), request
					.getParameter(traductor.traducir("clave").replaceAll(" ",
							"_")), Integer.parseInt(request.getParameter(Util
					.convertirANombreCampo(traductor
							.traducir("grupo_de_equipos")))));

			if (usuario != null) {
				GrupoEquipo grupoEquipo = GrupoEquipo.getGrupoEquipo(Integer
						.parseInt(request.getParameter(Util
								.convertirANombreCampo(traductor
										.traducir("grupo_de_equipos")))));

				String idiomaPais = request.getParameter("idioma_pais");
				if (usuario.getIdiomaPais() != null) {
					idiomaPais = usuario.getIdiomaPais();
				}
				String idioma = "";
				String pais = "";
				if (!idiomaPais.isEmpty()) {
					idioma = idiomaPais.split("_")[0];
					pais = idiomaPais.split("_")[1];
				}

				traductor.setIdiomaPais(idioma, pais);

				usuario.setIdiomaPais(traductor.getIdioma() + "_"
						+ traductor.getPais());

				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("usuario", usuario);
				sesion.setAttribute("grupoEquipo", grupoEquipo);
				sesion.setAttribute("traductor", traductor);
				response.sendRedirect("jsp/home.jsp");
			} else {
				// request.getRequestDispatcher("jsp/index.jsp?error=credenciales_invalidos").forward(request,
				// response);
				response.sendRedirect("jsp/index.jsp?error=credenciales_invalidos");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendRedirect("jsp/index.jsp?mensaje_error="
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NamingException e) {
			e.printStackTrace();
			response.sendRedirect("jsp/index.jsp?mensaje_error="
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("jsp/index.jsp?mensaje_error="
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}

}
