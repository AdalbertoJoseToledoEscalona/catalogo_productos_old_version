<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.GrupoEquipo"%>
<%@page import="modelo.utils.Traductor"%>
<%@page import="modelo.Producto"%>
<%@page import="modelo.utils.BaseDatos"%>
<%@ taglib uri="/catalogo_productos_consola" prefix="reportes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if (session == null || session.getAttribute("usuario") == null
|| session.getAttribute("grupoEquipo") == null
|| session.getAttribute("traductor") == null) {
	out.println("<REDIRECCIONAR>" + request.getContextPath() + "/jsp/index.jsp?error=expira_sesion" + "</REDIRECCIONAR>");
	response.sendRedirect(request.getContextPath() + "/jsp/index.jsp?error=expira_sesion");
} else {%>
    
    <% Producto p = new Producto(null, null, null, Integer.parseInt(request.getParameter("id_producto")), null, null);
    
    Traductor traductor2 = Traductor.getTraductorSesion(request, response);
	
	GrupoEquipo grupoEquipo2 = (GrupoEquipo) session
			.getAttribute("grupoEquipo");
	
	ArrayList<String> encabezado = new ArrayList<String>();
	//encabezado.add("Id Producto");
	encabezado.add("nombre");
	encabezado.add("descripcion");
	encabezado.add("documento");
	encabezado.add("Tipo Documento");
	encabezado.add("Predeterminado");

	ArrayList<Integer> columnaEncabezado = new ArrayList<Integer>();
	//columnaEncabezado.add(1);
	columnaEncabezado.add(2);
	columnaEncabezado.add(3);
	columnaEncabezado.add(4);
	columnaEncabezado.add(5);
	columnaEncabezado.add(6);
	
	/*Map<Integer, String> tipoColumna = new HashMap<Integer, String>();
	tipoColumna.put(3, "checkbox");
	tipoColumna.put(4, "url_archivo");*/
    %>
    
    <reportes:tabla
			titulo='<%="<H3>" + p.getNombre()
							+ "</H3>"%>'
			bd="<%=p.getBDDocumentos()%>"
			encabezado="<%=encabezado%>" columnaEncabezado="<%=columnaEncabezado%>"
			filasPorPagina="4" paginacionJS="true"
			usarAjax="true"
			eliminar='<%=request.getContextPath() + "/EliminarArchivoServlet" %>'
			textoEliminar='<%=traductor2.traducir("eliminar") %>'
			textoNoFilas='<%=traductor2.traducir("texto_no_filas") %>'
			mensajeConfirmacionEliminar='<%=traductor2.traducir("mensaje_confirmacion_eliminar_producto") %>'
			pagActual='<%=request.getContextPath() + "/jsp/plantillas/tabla_documentos_producto.jsp" %>' 
			id="listado_documentos_producto_<%=p.getId() %>"  />
	<%}%>