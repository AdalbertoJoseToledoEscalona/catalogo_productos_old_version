/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2014-08-26 08:12:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.beans.FiltroReporte;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import modelo.GrupoEquipo;
import modelo.utils.Traductor;
import modelo.utils.Traductor;
import modelo.utils.Traductor;
import modelo.utils.Traductor;
import modelo.Usuario;
import modelo.utils.Traductor;
import java.util.HashMap;
import java.util.Map;
import modelo.beans.FiltroReporte;
import java.util.List;
import modelo.Producto;
import java.util.ArrayList;
import modelo.utils.Traductor;

public final class listado_005fproductos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/jsp/plantillas/encabezado.jsp", Long.valueOf(1397991058000L));
    _jspx_dependants.put("/jsp/scripts/utils/validaciones.jsp", Long.valueOf(1398973020000L));
    _jspx_dependants.put("/WEB-INF/tlds/reportes.tld", Long.valueOf(1409040557000L));
    _jspx_dependants.put("/jsp/plantillas/reporte_listado_producto.jsp", Long.valueOf(1407928321000L));
    _jspx_dependants.put("/jsp/plantillas/botonera_principal.jsp", Long.valueOf(1407594474000L));
    _jspx_dependants.put("/jsp/plantillas/obj_idioma.jsp", Long.valueOf(1397991058000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005freportes_005ffiltros_0026_005fusarAjax_005ftextoRestaurar_005ftextoFiltrar_005fordenarCampos_005fidTablaReporte_005ffiltrosReporte_005fcolumnas_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005freportes_005ffiltros_0026_005fusarAjax_005ftextoRestaurar_005ftextoFiltrar_005fordenarCampos_005fidTablaReporte_005ffiltrosReporte_005fcolumnas_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005freportes_005ffiltros_0026_005fusarAjax_005ftextoRestaurar_005ftextoFiltrar_005fordenarCampos_005fidTablaReporte_005ffiltrosReporte_005fcolumnas_005fnobody.release();
    _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('	');
      out.write('\n');

	Traductor traductor = (Traductor) session.getAttribute("traductor");
	String[] idioma_pais = new String[2];
	String strIdiomaPais = "";
	if(traductor == null){
		String cookieName = "cookie_idioma_pais";
		Cookie cookies[] = request.getCookies();
		Cookie myCookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					myCookie = cookies[i];
					break;
				}
			}
		}
	
	
		if (myCookie == null) {
			traductor = new Traductor();
			idioma_pais[0] = traductor.getIdioma();
			idioma_pais[1] = traductor.getPais();
			myCookie = new Cookie(cookieName, idioma_pais[0] + "_"
					+ idioma_pais[1]);
			myCookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(myCookie);
		} else {
			idioma_pais = myCookie.getValue().split("_");
			traductor = new Traductor(idioma_pais[0], idioma_pais[1]);
		}
		
		
		
	}else{
		idioma_pais[0] = traductor.getIdioma();
		idioma_pais[1] = traductor.getPais();
	}
	
		strIdiomaPais = idioma_pais[0] + "_" + idioma_pais[1];


	String[] idiomasDisponibles = traductor
			.getIdiomasPaisesDisponibles();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>");
      out.print(traductor.traducir("listado_productos"));
      out.write("</title>\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\"\n");
      out.write("\thref=\"../css/plantillas/encabezado.css\">\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\"\n");
      out.write("\thref=\"../css/plantillas/cuerpo.css\">\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\"\n");
      out.write("\thref=\"../css/plantillas/botonera_principal.css\">\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\"\n");
      out.write("\thref=\"../css/plantillas/ubicacion.css\">\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\" href=\"../css/utils/errores.css\">\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\" href=\"../css/utils/utils.css\">\n");
      out.write("\n");
      out.write("<link type=\"text/css\" rel=\"StyleSheet\" href=\"../css/utils/reportes.css\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"../js/utils/utils.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/utils/validaciones.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/utils/cookies.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/utils/contenido_dinamico.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../js/utils/reporte.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"../js/plantillas/idioma_pais.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"../js/ajax/set_idioma_pais_ajax.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"../js/ajax/reporte.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tvar cargando = \"");
      out.print(traductor.traducir("cargando"));
      out.write("\";\n");
      out.write("\tvar el_campo = \"");
      out.print(traductor.traducir("el_campo"));
      out.write("\";\n");
      out.write("\tvar es_requerido = \"");
      out.print(traductor.traducir("es_requerido"));
      out.write("\";\n");
      out.write("\tvar mensaje_email_invalido = \"");
      out.print(traductor.traducir("mensaje_email_invalido"));
      out.write("\";\n");
      out.write("\tvar titulo_errores_formulario = \"");
      out.print(traductor.traducir("titulo_errores_formulario"));
      out.write("\";\n");
      out.write("\tvar error_validar_imagen_parte1 = \"");
      out.print(traductor.traducir("error_validar_imagen_parte1"));
      out.write("\";\n");
      out.write("\tvar error_validar_video_parte1 = \"");
      out.print(traductor.traducir("error_validar_video_parte1"));
      out.write("\";\n");
      out.write("\tvar error_validar_archivo_parte1 = \"");
      out.print(traductor.traducir("error_validar_archivo_parte1"));
      out.write("\";\n");
      out.write("\tvar error_validar_archivo_parte2 = \"");
      out.print(traductor.traducir("error_validar_archivo_parte2"));
      out.write("\";\n");
      out.write("</script>");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");

		try {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			GrupoEquipo grupoEquipo = (GrupoEquipo) session
					.getAttribute("grupoEquipo");
	
      out.write('\n');
      out.write('	');
      out.write("\n");
      out.write("\t\n");
      out.write("<div class=\"encabezado\">\n");
      out.write("\t<div class=\"texto_encabezado\">\n");
      out.write("\t\t<div class=\"titulo_encabezado\">");
      out.print(traductor.traducir("nombre_sistema") );
      out.write("</div>\n");
      out.write("\t\t<div class=\"subtitulo_encabezado\">");
      out.print(traductor.traducir("consola_administrativa") );
      out.write("</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"select_idiomas\">\n");
      out.write("\t\t<select id=\"select_idioma\" onchange=\"setIdiomaPais(this);\">\n");
      out.write("\t\t\t");

				for (int i = 0; i < idiomasDisponibles.length; i++) {
			
      out.write("\n");
      out.write("\t\t\t<option value=\"");
      out.print(idiomasDisponibles[i]);
      out.write("\"\n");
      out.write("\t\t\t\t");
if (idiomasDisponibles[i].equals(strIdiomaPais)) {
      out.write("\n");
      out.write("\t\t\t\tselected=\"selected\" ");
}
      out.write(">\n");
      out.write("\t\t\t\t");

					if (idiomasDisponibles[i].trim().length() > 0) {
							String idioma_pais2[] = idiomasDisponibles[i].split("_");
							Traductor t = new Traductor(idioma_pais2[0], idioma_pais2[1]);
							out.print(t.traducir(idioma_pais2[0]) + ", "
									+ t.traducir(idioma_pais2[1]));
						} else {
							out.print(traductor.traducir("default"));
						}
				
      out.write("\n");
      out.write("\t\t\t</option>\n");
      out.write("\t\t\t");

				}
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t</select>\n");
      out.write("\t</div>\n");
      out.write("</div>");
      out.write('\n');
      out.write('	');
      out.write('\n');
      out.write('\n');
      out.write('\n');
 //Usuario usuario = (Usuario) session.getAttribute("usuario");
      out.write("\n");
      out.write("<div class=\"botonera_principal\">\n");
      out.write("\t<h3 class=\"usuario_botonera\">");
      out.print(usuario.getNombre() + " " + usuario.getApellido() );
      out.write(" </h3>\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li><a href=\"agregar_producto.jsp\">");
      out.print(traductor.traducir("agregar_producto"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a href=\"listado_productos.jsp\">");
      out.print(traductor.traducir("listado_productos"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a href=\"administrar_documentos_productos.jsp\">");
      out.print(traductor.traducir("administrar_documentos_productos"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a href=\"listado_categoria.jsp\">");
      out.print(traductor.traducir("listado_categoria"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a href=\"personalizar_pantallas.jsp\">");
      out.print(traductor.traducir("personalizar_pantallas_mt"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a href=\"agregar_administrador.jsp\">");
      out.print(traductor.traducir("agregar_administrador"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a href=\"listado_administradores.jsp\">");
      out.print(traductor.traducir("listado_administradores"));
      out.write("</a></li>\n");
      out.write("\t\t<li><a\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath() );
      out.write("/AutenticarUsuarioServlet\">");
      out.print(traductor.traducir("cerrar_sesion"));
      out.write("</a></li>\n");
      out.write("\t</ul>\n");
      out.write("</div>");
      out.write("\n");
      out.write("\t<div id=\"cuerpo\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<span class=\"ubicacion\"><a href=\"home.jsp\">");
      out.print(traductor.traducir("home"));
      out.write("</a>\n");
      out.write("\t\t\t\t&gt;&gt; <b>");
      out.print(traductor.traducir("listado_productos"));
      out.write("</b></span>\n");
      out.write("\t\t\t<div class=\"grupo_equipos\">\n");
      out.write("\t\t\t\t<b>");
      out.print(traductor.traducir("grupo_de_equipos"));
      out.write(":</b>\n");
      out.write("\t\t\t\t");
      out.print(grupoEquipo.getNombre());
      out.write("</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"error\" class=\"error\"></div>\n");
      out.write("\t\t<div id=\"filtro_listado_productos\">\n");
      out.write("\n");
      out.write("\t\t\t");

				List<FiltroReporte> filtros = new ArrayList<FiltroReporte>();
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.productos.nombre",
							traductor.traducir("nombre_producto"), "select",
							traductor.traducir("todos"), 3));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.productos.descripcion",
							traductor.traducir("descripcion_producto"), "select",
							traductor.traducir("todas"), 4));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.equipos.nombre", traductor
									.traducir("nombre_pantalla_mt"), "select",
							traductor.traducir("todos"), 7));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.caracteristicas.nombre",
							traductor.traducir("nombre_caracteristica"), "select",
							traductor.traducir("todas"), 10));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.productos_x_caracteristicas.valor",
							traductor.traducir("valor_caracteristica"), "select",
							traductor.traducir("todos"), 11));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.precios_productos.nombre",
							traductor.traducir("nombre_precio"), "select",
							traductor.traducir("todos"), 13));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.precios_productos.codigo_moneda",
							traductor.traducir("codigo_moneda"), "select",
							traductor.traducir("todos"), 14));
					filtros.add(new FiltroReporte(
							"catalogo_productos_servidor.precios_productos.valor",
							traductor.traducir("valor_precio"), "select", traductor
									.traducir("todos"), 15));

					request.setAttribute("filtros_reporte", filtros);
			
      out.write("\n");
      out.write("\t\t\t<center>\n");
      out.write("\t\t\t\t");
      //  reportes:filtros
      vista.tags.FiltrosTagHandler _jspx_th_reportes_005ffiltros_005f0 = (vista.tags.FiltrosTagHandler) _005fjspx_005ftagPool_005freportes_005ffiltros_0026_005fusarAjax_005ftextoRestaurar_005ftextoFiltrar_005fordenarCampos_005fidTablaReporte_005ffiltrosReporte_005fcolumnas_005fnobody.get(vista.tags.FiltrosTagHandler.class);
      _jspx_th_reportes_005ffiltros_005f0.setPageContext(_jspx_page_context);
      _jspx_th_reportes_005ffiltros_005f0.setParent(null);
      // /jsp/listado_productos.jsp(101,4) name = columnas type = java.lang.Integer reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setColumnas(new java.lang.Integer(4));
      // /jsp/listado_productos.jsp(101,4) name = filtrosReporte type = java.util.List reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setFiltrosReporte(filtros);
      // /jsp/listado_productos.jsp(101,4) name = ordenarCampos type = java.lang.Boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setOrdenarCampos(new java.lang.Boolean(true));
      // /jsp/listado_productos.jsp(101,4) name = usarAjax type = java.lang.Boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setUsarAjax(new java.lang.Boolean(true));
      // /jsp/listado_productos.jsp(101,4) name = idTablaReporte type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setIdTablaReporte("reporte_tabla");
      // /jsp/listado_productos.jsp(101,4) name = textoFiltrar type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setTextoFiltrar(traductor.traducir("filtrar"));
      // /jsp/listado_productos.jsp(101,4) name = textoRestaurar type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ffiltros_005f0.setTextoRestaurar(traductor.traducir("reset"));
      int _jspx_eval_reportes_005ffiltros_005f0 = _jspx_th_reportes_005ffiltros_005f0.doStartTag();
      if (_jspx_th_reportes_005ffiltros_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005freportes_005ffiltros_0026_005fusarAjax_005ftextoRestaurar_005ftextoFiltrar_005fordenarCampos_005fidTablaReporte_005ffiltrosReporte_005fcolumnas_005fnobody.reuse(_jspx_th_reportes_005ffiltros_005f0);
        return;
      }
      _005fjspx_005ftagPool_005freportes_005ffiltros_0026_005fusarAjax_005ftextoRestaurar_005ftextoFiltrar_005fordenarCampos_005fidTablaReporte_005ffiltrosReporte_005fcolumnas_005fnobody.reuse(_jspx_th_reportes_005ffiltros_005f0);
      out.write("\n");
      out.write("\t\t\t</center>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"listado_productos\">\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 if (session == null || session.getAttribute("usuario") == null
|| session.getAttribute("grupoEquipo") == null
|| session.getAttribute("traductor") == null) {
	out.println("<REDIRECCIONAR>" + request.getContextPath() + "/jsp/index.jsp?error=expira_sesion" + "</REDIRECCIONAR>");
	response.sendRedirect(request.getContextPath() + "/jsp/index.jsp?error=expira_sesion");
} else {
	Traductor traductor2 = null;
	traductor2 = Traductor.getTraductorSesion(request, response);
	
	ArrayList<String> encabezado = new ArrayList<String>();
	//encabezado.add("Id Producto");
	encabezado.add(traductor2.traducir("logotipo"));
	encabezado.add(traductor2.traducir("nombre_producto"));
	encabezado.add(traductor2.traducir("descripcion_producto"));
	encabezado.add(traductor2.traducir("nombre_pantalla_mt"));
	encabezado.add(traductor2.traducir("nombre_caracteristica"));
	encabezado.add(traductor2.traducir("valor_caracteristica"));
	encabezado.add(traductor2.traducir("nombre_precio"));
	encabezado.add(traductor2.traducir("codigo_moneda"));
	encabezado.add(traductor2.traducir("valor_precio"));

	ArrayList<Integer> columnaEncabezado = new ArrayList<Integer>();
	//columnaEncabezado.add(1);
	columnaEncabezado.add(2);
	columnaEncabezado.add(3);
	columnaEncabezado.add(4);
	columnaEncabezado.add(7);
	columnaEncabezado.add(10);
	columnaEncabezado.add(11);
	columnaEncabezado.add(13);
	columnaEncabezado.add(14);
	columnaEncabezado.add(15);

	List<FiltroReporte> filtros2 = (List<FiltroReporte>) request
			.getAttribute("filtros_reporte");

	Map<Integer, String> tipoColumna = new HashMap<Integer, String>();
	tipoColumna.put(2, "url_archivo");

      out.write('\n');
      out.write('\n');
      //  reportes:tabla
      vista.tags.TablaTagHandler _jspx_th_reportes_005ftabla_005f0 = (vista.tags.TablaTagHandler) _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody.get(vista.tags.TablaTagHandler.class);
      _jspx_th_reportes_005ftabla_005f0.setPageContext(_jspx_page_context);
      _jspx_th_reportes_005ftabla_005f0.setParent(null);
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = titulo type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setTitulo("<H2>" + traductor2.traducir("listado_productos")
					+ "</H2>");
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = bd type = modelo.utils.BaseDatos reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setBd(Producto.retornarBaseDatosListaProductos());
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = pk type = java.lang.Integer reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setPk(new java.lang.Integer(1));
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = encabezado type = java.util.List reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setEncabezado(encabezado);
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = columnaEncabezado type = java.util.List reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setColumnaEncabezado(columnaEncabezado);
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = filasPorPagina type = java.lang.Integer reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setFilasPorPagina(new java.lang.Integer(4));
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = paginacionJS type = java.lang.Boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setPaginacionJS(new java.lang.Boolean(true));
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = ordenarCampos type = java.lang.Boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setOrdenarCampos(new java.lang.Boolean(true));
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = usarAjax type = java.lang.Boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setUsarAjax(new java.lang.Boolean(true));
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = filtrosReporte type = java.util.List reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setFiltrosReporte(filtros2);
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = tipoColumna type = java.util.List reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setTipoColumna(tipoColumna);
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = editar type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setEditar("agregar_producto.jsp");
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = eliminar type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setEliminar(request.getContextPath() + "/EliminarProductoServlet" );
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = textoEditar type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setTextoEditar(traductor2.traducir("editar") );
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = textoEliminar type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setTextoEliminar(traductor2.traducir("eliminar") );
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = textoNoFilas type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setTextoNoFilas(traductor2.traducir("texto_no_filas") );
      // /jsp/plantillas/reporte_listado_producto.jsp(49,0) name = mensajeConfirmacionEliminar type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_reportes_005ftabla_005f0.setMensajeConfirmacionEliminar(traductor2.traducir("mensaje_confirmacion_eliminar_producto") );
      int _jspx_eval_reportes_005ftabla_005f0 = _jspx_th_reportes_005ftabla_005f0.doStartTag();
      if (_jspx_th_reportes_005ftabla_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody.reuse(_jspx_th_reportes_005ftabla_005f0);
        return;
      }
      _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody.reuse(_jspx_th_reportes_005ftabla_005f0);
      out.write('\n');
      out.write('	');
}
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t");
if (request.getParameter("error") != null) {
      out.write("\n");
      out.write("\t\t\tmostrarMensaje(\"");
      out.print(traductor.traducir(request.getParameter("error")));
      out.write("\", true);\n");
      out.write("\t\t");
} else if (request.getParameter("mensaje_error") != null) {
      out.write("\n");
      out.write("\t\t\tmostrarMensaje(\"");
      out.print(request.getParameter("mensaje_error"));
      out.write("\", true);\n");
      out.write("\t\t");
} else if (request.getParameter("exito") != null) {
      out.write("\n");
      out.write("\t\t\tmostrarMensaje(\"");
      out.print(traductor.traducir(request.getParameter("exito")));
      out.write("\", false);\n");
      out.write("\t\t");
} else if (request.getParameter("mensaje_exito") != null) {
      out.write("\n");
      out.write("\t\t\tmostrarMensaje(\"");
      out.print(request.getParameter("mensaje_exito"));
      out.write("\", false);\n");
      out.write("\t\t");
}
      out.write("\n");
      out.write("\t</script>\n");
      out.write("\t");

		} catch (Exception e) {
			e.printStackTrace();
	
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\tmostrarMensaje(\"");
      out.print(e.getMessage());
      out.write("\", true);\n");
      out.write("\t</script>\n");
      out.write("\t");

		}
	
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
