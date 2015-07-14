<%@page import="modelo.GrupoEquipo"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelo.utils.Traductor"%>
<%@include file="plantillas/obj_idioma.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=traductor.traducir("home")%></title>
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/encabezado.css">
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/cuerpo.css">
<link type="text/css" rel="StyleSheet" href="../css/home.css">
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/botonera_principal.css">
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/ubicacion.css">
<link type="text/css" rel="StyleSheet" href="../css/utils/errores.css">

<script type="text/javascript" src="../js/utils/utils.js"></script>
<script type="text/javascript" src="../js/utils/validaciones.js"></script>
<script type="text/javascript" src="../js/utils/cookies.js"></script>
<script type="text/javascript" src="../js/plantillas/idioma_pais.js"></script>

<script type="text/javascript" src="../js/ajax/set_idioma_pais_ajax.js"></script>

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
			<span class="ubicacion"><b><%=traductor.traducir("home")%></b></span>
			<div class="grupo_equipos">
				<b><%=traductor.traducir("grupo_de_equipos")%>:</b>
				<%=grupoEquipo.getNombre()%></div>
		</div>
		<div id="error" class="error"></div>
		<h1 class="bienvenida_home"><%=traductor.traducir("bienvenido") + " "
						+ usuario.getNombre() + " " + usuario.getApellido()%>
		</h1>
	</div>
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