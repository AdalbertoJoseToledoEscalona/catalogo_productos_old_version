/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2014-08-26 08:32:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.plantillas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.Map;
import modelo.beans.FiltroReporte;
import java.util.List;
import modelo.Producto;
import java.util.ArrayList;
import modelo.utils.Traductor;

public final class reporte_005flistado_005fproducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/tlds/reportes.tld", Long.valueOf(1409040557000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005freportes_005ftabla_0026_005fusarAjax_005ftitulo_005ftipoColumna_005ftextoNoFilas_005ftextoEliminar_005ftextoEditar_005fpk_005fpaginacionJS_005fordenarCampos_005fmensajeConfirmacionEliminar_005ffiltrosReporte_005ffilasPorPagina_005fencabezado_005feliminar_005feditar_005fcolumnaEncabezado_005fbd_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
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