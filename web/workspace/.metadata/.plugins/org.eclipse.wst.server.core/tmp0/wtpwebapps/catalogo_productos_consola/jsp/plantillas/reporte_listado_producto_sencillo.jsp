<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="modelo.beans.FiltroReporte"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.utils.Traductor"%>
<%@ taglib uri="/catalogo_productos_consola" prefix="reportes"%>
<% if (session == null || session.getAttribute("usuario") == null
|| session.getAttribute("grupoEquipo") == null
|| session.getAttribute("traductor") == null) {
	out.println("<REDIRECCIONAR>" + request.getContextPath() + "/jsp/index.jsp?error=expira_sesion" + "</REDIRECCIONAR>");
	response.sendRedirect(request.getContextPath() + "/jsp/index.jsp?error=expira_sesion");
} else {
	Traductor traductor2 = null;
	traductor2 = Traductor.getTraductorSesion(request, response);
	
	ArrayList<String> encabezado = new ArrayList<String>();
	encabezado.add("Seleccion");
	encabezado.add(traductor2.traducir("logotipo"));
	encabezado.add(traductor2.traducir("nombre_producto"));

	ArrayList<Integer> columnaEncabezado = new ArrayList<Integer>();
	columnaEncabezado.add(1);
	columnaEncabezado.add(2);
	columnaEncabezado.add(3);
	
	Map<Integer, String> tipoColumna = new HashMap<Integer, String>();
	tipoColumna.put(1, "checkbox");
	tipoColumna.put(2, "url_archivo");
%>

<reportes:tabla
	titulo='<%="<H3>" + traductor2.traducir("listado_productos")
					+ "</H3>"%>'
	bd="<%=Producto.retornarBaseDatosListaProductos()%>" pk="1"
	encabezado="<%=encabezado%>" columnaEncabezado="<%=columnaEncabezado%>"
	filasPorPagina="4" paginacionJS="true" ordenarCampos="true"
	usarAjax="true"
	tipoColumna="<%=tipoColumna%>"
	textoNoFilas='<%=traductor2.traducir("texto_no_filas") %>'
	pagActual='<%=request.getContextPath() + "/jsp/plantillas/reporte_listado_producto_sencillo.jsp" %>' id="listado_productos"/>
	<%}%>