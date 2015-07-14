<%@page import="modelo.GrupoEquipo"%>
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
	
	GrupoEquipo grupoEquipo2 = (GrupoEquipo) session
			.getAttribute("grupoEquipo");
	
	ArrayList<String> encabezado = new ArrayList<String>();
	//encabezado.add("Id Producto");
	encabezado.add("seleccion");
	encabezado.add("archivo");
	encabezado.add("nombre");

	ArrayList<Integer> columnaEncabezado = new ArrayList<Integer>();
	//columnaEncabezado.add(1);
	columnaEncabezado.add(3);
	columnaEncabezado.add(4);
	columnaEncabezado.add(2);
	
	Map<Integer, String> tipoColumna = new HashMap<Integer, String>();
	tipoColumna.put(3, "checkbox");
	tipoColumna.put(4, "url_archivo");
%>

<reportes:tabla
			titulo='<%="<H3>" + "Listado de Archivos"
							+ "</H3>"%>'
			bd="<%=grupoEquipo2
					.retornarBaseDatosArchivoGrupoEquipoPorTipoArchivo(null)%>"
			encabezado="<%=encabezado%>" columnaEncabezado="<%=columnaEncabezado%>"
			filasPorPagina="4" paginacionJS="true" ordenarCampos="true"
			usarAjax="true"
			tipoColumna="<%=tipoColumna%>"
			eliminar='<%=request.getContextPath() + "/EliminarArchivoServlet" %>'
			textoEliminar='<%=traductor2.traducir("eliminar") %>'
			textoNoFilas='<%=traductor2.traducir("texto_no_filas") %>'
			mensajeConfirmacionEliminar='<%=traductor2.traducir("mensaje_confirmacion_eliminar_producto") %>'
			pagActual='<%=request.getContextPath() + "/jsp/plantillas/reporte_listado_archivos.jsp" %>' 
			id="listado_archivos" />
	<%}%>