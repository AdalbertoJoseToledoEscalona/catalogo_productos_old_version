<%@page import="modelo.beans.FiltroReporte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
<%@page import="modelo.GrupoEquipo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelo.utils.Traductor"%>
<%@include file="plantillas/obj_idioma.jsp"%>
<%@ taglib uri="/catalogo_productos_consola" prefix="reportes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=traductor.traducir("listado_productos")%></title>
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/encabezado.css">
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/cuerpo.css">
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/botonera_principal.css">
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/ubicacion.css">
<link type="text/css" rel="StyleSheet" href="../css/utils/errores.css">
<link type="text/css" rel="StyleSheet" href="../css/utils/utils.css">

<link type="text/css" rel="StyleSheet" href="../css/utils/reportes.css">

<script type="text/javascript" src="../js/utils/utils.js"></script>
<script type="text/javascript" src="../js/utils/validaciones.js"></script>
<script type="text/javascript" src="../js/utils/cookies.js"></script>
<script type="text/javascript" src="../js/utils/contenido_dinamico.js"></script>
<script type="text/javascript" src="../js/utils/reporte.js"></script>

<script type="text/javascript" src="../js/plantillas/idioma_pais.js"></script>

<script type="text/javascript" src="../js/ajax/set_idioma_pais_ajax.js"></script>

<script type="text/javascript" src="../js/ajax/reporte.js"></script>

<%@include file="scripts/utils/validaciones.jsp"%>
</head>
<body>
	<%
		try {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			GrupoEquipo grupoEquipo = (GrupoEquipo) session
					.getAttribute("grupoEquipo");
	%>
	<%@include file="plantillas/encabezado.jsp"%>
	<%@include file="plantillas/botonera_principal.jsp"%>
	<div id="cuerpo">
		<div>
			<span class="ubicacion"><a href="home.jsp"><%=traductor.traducir("home")%></a>
				&gt;&gt; <b><%=traductor.traducir("listado_productos")%></b></span>
			<div class="grupo_equipos">
				<b><%=traductor.traducir("grupo_de_equipos")%>:</b>
				<%=grupoEquipo.getNombre()%></div>
		</div>
		<div id="error" class="error"></div>
		<div id="filtro_listado_productos">

			<%
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
			%>
			<center>
				<reportes:filtros columnas="4" filtrosReporte="<%=filtros%>"
					ordenarCampos="true" usarAjax="true" idTablaReporte="reporte_tabla"
					textoFiltrar='<%=traductor.traducir("filtrar")%>'
					textoRestaurar='<%=traductor.traducir("reset")%>' />
			</center>
		</div>

		<div id="listado_productos">
			<%@include file="plantillas/reporte_listado_producto.jsp"%>
		</div>
	</div>
	<script type="text/javascript">
		<%if (request.getParameter("error") != null) {%>
			mostrarMensaje("<%=traductor.traducir(request.getParameter("error"))%>", true);
		<%} else if (request.getParameter("mensaje_error") != null) {%>
			mostrarMensaje("<%=request.getParameter("mensaje_error")%>", true);
		<%} else if (request.getParameter("exito") != null) {%>
			mostrarMensaje("<%=traductor.traducir(request.getParameter("exito"))%>", false);
		<%} else if (request.getParameter("mensaje_exito") != null) {%>
			mostrarMensaje("<%=request.getParameter("mensaje_exito")%>", false);
		<%}%>
	</script>
	<%
		} catch (Exception e) {
			e.printStackTrace();
	%>
	<script type="text/javascript">
	mostrarMensaje("<%=e.getMessage()%>", true);
	</script>
	<%
		}
	%>
</body>
</html>