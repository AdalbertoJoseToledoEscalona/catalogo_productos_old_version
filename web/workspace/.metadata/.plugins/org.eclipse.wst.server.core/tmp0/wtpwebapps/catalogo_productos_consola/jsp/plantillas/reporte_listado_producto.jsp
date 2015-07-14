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
%>

<reportes:tabla
	titulo='<%="<H2>" + traductor2.traducir("listado_productos")
					+ "</H2>"%>'
	bd="<%=Producto.retornarBaseDatosListaProductos()%>" pk="1"
	encabezado="<%=encabezado%>" columnaEncabezado="<%=columnaEncabezado%>"
	filasPorPagina="4" paginacionJS="true" ordenarCampos="true"
	usarAjax="true" filtrosReporte="<%=filtros2%>"
	tipoColumna="<%=tipoColumna%>" editar="agregar_producto.jsp"
	eliminar='<%=request.getContextPath() + "/EliminarProductoServlet" %>' textoEditar='<%=traductor2.traducir("editar") %>'
	textoEliminar='<%=traductor2.traducir("eliminar") %>'
	textoNoFilas='<%=traductor2.traducir("texto_no_filas") %>'
	mensajeConfirmacionEliminar='<%=traductor2.traducir("mensaje_confirmacion_eliminar_producto") %>' />
	<%}%>