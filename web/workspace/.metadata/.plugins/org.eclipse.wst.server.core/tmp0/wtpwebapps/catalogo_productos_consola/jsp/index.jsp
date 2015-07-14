<%@page import="modelo.utils.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelo.utils.Traductor"%>
<%@include file="plantillas/obj_idioma.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=traductor.traducir("title_index")%></title>
<link type="text/css" rel="StyleSheet"
	href="../css/plantillas/encabezado.css">
<link type="text/css" rel="StyleSheet" href="../css/utils/errores.css">
<link type="text/css" rel="StyleSheet" href="../css/index.css">

<script type="text/javascript" src="../js/utils/utils.js"></script>
<script type="text/javascript" src="../js/utils/validaciones.js"></script>
<script type="text/javascript" src="../js/utils/cookies.js"></script>
<script type="text/javascript" src="../js/plantillas/idioma_pais.js"></script>

<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript"
	src="../js/ajax/llenar_cmb_grupo_equipos_ajax.js"></script>

<%@include file="scripts/utils/validaciones.jsp"%>
</head>
<body>
	<%
		try {
	%>
	<%@include file="plantillas/encabezado.jsp"%>
	<div id="cuerpo">
		<div id="error" class="error"></div>
		<h2 class="titulo"><%=traductor.traducir("titulo_index")%></h2>
		<form method="post"
			action="<%=request.getContextPath() %>/AutenticarUsuarioServlet"
			class="form_autenticacion" onsubmit="return validarFormulario(this);">
			<div>
				<span class="lbl_usuario"><%=traductor.traducir("usuario")%>:</span>
				<input id="txtUsuario" type="text" maxlength="100"
					name="<%=Util.convertirANombreCampo(traductor
						.traducir("usuario"))%>"
					required="required" onchange="llenarGrupoEquipos();">
			</div>
			<div>
				<span class="lbl_usuario"><%=traductor.traducir("clave")%>:</span> <input
					id="pwdClave" type="password" maxlength="100"
					name="<%=Util.convertirANombreCampo(traductor
						.traducir("clave"))%>"
					required="required" onchange="llenarGrupoEquipos();">
			</div>
			<div>
				<span class="lbl_usuario"><%=traductor.traducir("grupo_de_equipos")%>:</span>
				<select id="cmbGrupoEquipos"
					name="<%=Util.convertirANombreCampo(traductor
						.traducir("grupo_de_equipos"))%>"
					disabled="disabled" required="required">
					<option value=""><%=traductor.traducir("seleccione_un_grupo_de_equipos")%></option>
				</select>
			</div>
			<br> <input type="hidden" name="idioma_pais"
				value="<%=strIdiomaPais%>">
			<div class="botones">
				<input type="submit" value="<%=traductor.traducir("entrar")%>">
				<input type="reset" value="<%=traductor.traducir("reset")%>">
			</div>
		</form>
		<br>
		<div class="recuperar_clave">
			<a
				onclick="window.open('recuperar_clave.jsp', '<%=traductor.traducir("recuperar_clave").replaceAll(" ",
						"_")%>', 'resizable=0,width=350,height=250,scrollbars=0,toolbar=0,status=0, position=absolute, top=50%, left=50%');"
				href="?"><%=traductor.traducir("olvide_mi_clave")%></a>
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
