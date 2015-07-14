package controlador.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class VerificarLicenciaFiltro
 */
@WebFilter(description = "Filtro para verificar si este equipo tiene licencia trabajar con la aplicación", urlPatterns = { "/VerificarLicenciaFiltro" })
public class VerificarLicenciaFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public VerificarLicenciaFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// TODO: Crear el Web Service en tienda_aplicaciones que valide el equipo segun la mac local usan la clase MAC.java en utils
		System.out.println("Verifico Licencia");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession sesion = req.getSession(false);
		if (sesion != null && sesion.getAttribute("usuario") != null
				&& sesion.getAttribute("grupoEquipo") != null
						&& sesion.getAttribute("traductor") != null) {
			res.sendRedirect("/catalogo_productos_consola/jsp/home.jsp");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
