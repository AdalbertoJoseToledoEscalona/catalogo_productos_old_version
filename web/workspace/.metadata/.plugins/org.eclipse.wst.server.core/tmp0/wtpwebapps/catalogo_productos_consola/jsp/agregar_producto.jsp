<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="modelo.Equipo"%>
<%@page import="modelo.utils.Util"%>
<%@page import="modelo.Moneda"%>
<%@page import="modelo.Precio"%>
<%@page import="modelo.Caracteristica"%>
<%@page import="modelo.ArchivoGrupoEquipo"%>
<%@page import="java.util.List"%>
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
<title><%=traductor.traducir("agregar_producto")%></title>
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

<link type="text/css" rel="StyleSheet"
	href="../css/agregar_producto.css">

<script type="text/javascript" src="../js/utils/utils.js"></script>
<script type="text/javascript" src="../js/utils/validaciones.js"></script>
<script type="text/javascript" src="../js/utils/cookies.js"></script>
<script type="text/javascript" src="../js/utils/contenido_dinamico.js"></script>
<script type="text/javascript" src="../js/plantillas/idioma_pais.js"></script>

<script type="text/javascript" src="../js/agregar_producto.js"></script>

<script type="text/javascript" src="../js/ajax/set_idioma_pais_ajax.js"></script>

<%@include file="scripts/utils/validaciones.jsp"%>
<%@include file="scripts/agregar_producto.jsp"%>
</head>
<body onload="verificarEstadoCampos();">
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
			<span class="ubicacion"> <%if(request.getParameter("catalogo_productos_servidor.productos.id_producto") == null){ %>
				<a href="home.jsp"><%=traductor.traducir("home")%></a> &gt;&gt; <b><%=traductor.traducir("agregar_producto")%></b>
				<%}else{ %> <a href="listado_productos.jsp"><%=traductor.traducir("listado_productos")%></a>
				&gt;&gt; <b><%=traductor.traducir("editar_producto")%></b> <%} %>
			</span>
			<div class="grupo_equipos">
				<b><%=traductor.traducir("grupo_de_equipos")%>:</b>
				<%=grupoEquipo.getNombre()%></div>
		</div>
		<!-- <center>  -->
		<div style="text-align: center; margin: auto;">
			<div id="error" class="error"></div>
			<h2>
				<%if(request.getParameter("catalogo_productos_servidor.productos.id_producto") == null){ %>
				<%=traductor.traducir("mensaje_agregar_producto")%>
				<%}else{ %>
				<%=traductor.traducir("mensaje_editar_producto")%>
				<%} %>
			</h2>
			<form method="post" onsubmit="return validarAgregarProducto(this);"
				action="<%=request.getContextPath() %>/<%=(request.getParameter("catalogo_productos_servidor.productos.id_producto") == null)?"AgregarProductoServlet":"EditarProductoServlet" %>"
				enctype="multipart/form-data">
				<%if(request.getParameter("catalogo_productos_servidor.productos.id_producto") != null){ %>
				<input type="hidden" name="id_producto"
					value="<%=request.getParameter("catalogo_productos_servidor.productos.id_producto")%>">
				<%} %>
				<table style="margin: auto;">
					<tr>
						<th class="lbl_usuario"><%=traductor.traducir("logotipo") %>:</th>
						<td align="left"><input required="required" type="file"
							id="logotipo"
							name="<%=Util.convertirANombreCampo(traductor.traducir("logotipo")) %>_norequerido"
							onchange="llenoArchivoLogo(this);">
							<div class="list_img">
								<table>
									<%
										List<ArchivoGrupoEquipo> archivoGrupoEquipos = grupoEquipo
												.getArchivoGrupoEquipoPorTipoArchivo(new String[] { "img" });
										for (int i = 0; i < archivoGrupoEquipos.size(); i++) {
									%>
									<tr>
										<th><input type="checkbox" name="checkbox_logo"
											value="<%=archivoGrupoEquipos.get(i).getArchivo().getMd5()%>"
											onchange="seleccionoCheckBoxLogo(this);"
											<%=(archivoGrupoEquipos.get(i).getArchivo().getRuta().equals(request.getParameter("catalogo_productos_servidor.archivos.ruta")))?" checked=\"checked\"":"" %>>
										</th>
										<th><a target="_blank"
											href="../<%=archivoGrupoEquipos.get(i).getArchivo().getRuta() %>"><img
												alt="logo_<%=(i+1) %>"
												src="../<%=archivoGrupoEquipos.get(i).getArchivo().getRuta() %>"
												class="logo"></a></th>
										<td><%=archivoGrupoEquipos.get(i).getNombreOriginal()%></td>
									</tr>
									<%
										}
									%>
								</table>
							</div></td>
					</tr>
					<tr>
						<th class="lbl_usuario"><%=traductor.traducir("nombre") %>:</th>
						<td align="left"><input type="text" required="required"
							name="<%=Util.convertirANombreCampo(traductor.traducir("nombre")) %>"
							value="<%=(request.getParameter("catalogo_productos_servidor.productos.nombre") == null)?"":request.getParameter("catalogo_productos_servidor.productos.nombre") %>"></td>
					</tr>
					<tr>
						<th class="lbl_usuario"><%=traductor.traducir("descripcion") %>:</th>
						<td align="left"><textarea required="required"
								name="<%=Util.convertirANombreCampo(traductor.traducir("descripcion")) %>"><%=(request.getParameter("catalogo_productos_servidor.productos.descripcion") == null)?"":request.getParameter("catalogo_productos_servidor.productos.descripcion") %></textarea></td>
					</tr>
					<tr>
						<% String arregloIdProductoXEquipos[] = request.getParameterValues("catalogo_productos_servidor.productos_x_equipos.id_producto_x_equipo");
						String arregloIdEquipos[] = request.getParameterValues("catalogo_productos_servidor.equipos.id_equipo"); 
						Set<String> setIdProductoXEquipos = null;
						if(arregloIdProductoXEquipos != null){
							setIdProductoXEquipos =  new HashSet<String>(Arrays.asList(arregloIdProductoXEquipos));
						}
						Set<String> setIdEquipos = null;
						if(arregloIdEquipos != null){
							setIdEquipos = new HashSet<String>(Arrays.asList(arregloIdEquipos));
						}
						%>
						<th class="lbl_usuario"><%=traductor.traducir("equipo") %>:</th>
						<td align="left"><select required="required"
							multiple="multiple"
							name="<%=Util.convertirANombreCampo(traductor.traducir("equipo")) %>">
								<% List<Equipo> equipos = Equipo.getEquiposPertenecenAGrupoEquipo(grupoEquipo.getId());
									for(int i = 0; i < equipos.size(); i++){%>
								<option value="<%=equipos.get(i).getId()%>"
									<%=(setIdEquipos != null && setIdEquipos.contains(Integer.toString(equipos.get(i).getId())))?" selected=\"selected\"":"" %>><%=equipos.get(i).getNombre() %></option>
								<%}%>
						</select> <%if(arregloIdProductoXEquipos != null){
								Object obj[] = setIdProductoXEquipos.toArray();
								Arrays.sort(obj);%> <input type="hidden"
							name="id_producto_x_equipos"
							value="<%=StringUtils.join(obj, ',') %>"> <%}%></td>
					</tr>
					<tr>
						<% String arregloIdProductoXCaracteristicas[] = request.getParameterValues("catalogo_productos_servidor.productos_x_caracteristicas.id_producto_x_caracteristica");
						String arregloIdCaracteristicas[] = request.getParameterValues("catalogo_productos_servidor.caracteristicas.id_caracteristica");
						String arregloValores[] = request.getParameterValues("catalogo_productos_servidor.productos_x_caracteristicas.valor"); 
						Set<String> setIdProductoXCaracteristicas = new HashSet<String>(); 
						
						 List<Caracteristica> caracteristicas = Caracteristica
										.getCaracteristicas(); %>
						<th class="lbl_usuario"><%=traductor.traducir("caracteristicas") %>:</th>
						<td align="left"><a
							href="javascript:agregarContenidoDinamico(0);"
							class="tipo_titulo"><%=traductor.traducir("agregar") %></a> <a
							href="javascript:quitarContenidoDinamico(0);" class="tipo_titulo"><%=traductor.traducir("quitar") %></a>
							<div id="campos_caracteristicas">
								<%if(arregloIdProductoXCaracteristicas != null){
								for(int i = 0; i < arregloIdProductoXCaracteristicas.length; i++){ 
									if(setIdProductoXCaracteristicas.add(arregloIdProductoXCaracteristicas[i])){ %>
								<!--inicio_<%=setIdProductoXCaracteristicas.size() %>-->
								<div class="contenido_caracteristicas">
									<div>
										<select
											name="<%=Util.convertirANombreCampo(traductor.traducir("caracteristica")) %>_<%=setIdProductoXCaracteristicas.size() %>"
											id="caracteristica_<%=setIdProductoXCaracteristicas.size() %>"
											required="required">
											<option value=""><%=traductor.traducir("seleccione_una_caracteristica") %></option>
											<%for (int j = 0; j < caracteristicas.size(); j++) {%>
											<option value="<%=caracteristicas.get(j).getId() %>"
												<%=(Integer.parseInt(arregloIdCaracteristicas[i]) == caracteristicas.get(j).getId())?" selected=\"selected\"":"" %>><%=caracteristicas.get(j).getNombre() %></option>
											<%} %>
										</select> <input type="text"
											style="visibility: hidden; display: none; width: 0px; height: 0px;"
											name="<%=Util.convertirANombreCampo(traductor.traducir("nueva_caracteristica")) %>_<%=setIdProductoXCaracteristicas.size() %>"
											id="nueva_caracteristica_<%=setIdProductoXCaracteristicas.size() %>">
										<input type="checkbox"
											onchange="ocultarMostrar(this, new Array('caracteristica_<%=setIdProductoXCaracteristicas.size() %>'), new Array('nueva_caracteristica_<%=setIdProductoXCaracteristicas.size() %>'));"
											value="true"
											name="<%=Util.convertirANombreCampo(traductor.traducir("es_nueva_caracteristica")) %>_<%=setIdProductoXCaracteristicas.size() %>">
										<%=traductor.traducir("nueva_preguntando") %>
									</div>
									<div class="tipo_titulo"><%=traductor.traducir("valor") %>:
										<input type="text"
											name="<%=Util.convertirANombreCampo(traductor.traducir("valor_caracteristica")) %>_<%=setIdProductoXCaracteristicas.size() %>"
											required="required" value="<%=arregloValores[i] %>">
									</div>
								</div>
								<!--fin_<%=setIdProductoXCaracteristicas.size() %>-->
								<% }
									}
								} %>
							</div> <%if(arregloIdProductoXCaracteristicas != null){
								Object obj[] = setIdProductoXCaracteristicas.toArray();
								Arrays.sort(obj);%> <input type="hidden"
							name="id_producto_x_caracteristicas"
							value="<%=StringUtils.join(obj, ',') %>"> <%}%></td>
					</tr>
					<tr>
						<% String arregloIdPreciosProducto[] = request.getParameterValues("catalogo_productos_servidor.precios_productos.id_precio_producto");
						String arregloNombresPrecios[] = request.getParameterValues("catalogo_productos_servidor.precios_productos.nombre");
						String arregloCodigoMonedas[] = request.getParameterValues("catalogo_productos_servidor.precios_productos.codigo_moneda");
						String arregloValoresPrecios[] = request.getParameterValues("catalogo_productos_servidor.precios_productos.valor");
						Set<String> setIdPrecioProductos = new HashSet<String>(); 
						
						 List<Moneda> monedas = Moneda.getMonedas(); %>
						<th class="lbl_usuario"><%=traductor.traducir("precios") %>:</th>
						<td align="left"><a
							href="javascript:agregarContenidoDinamico(1);"
							class="tipo_titulo"><%=traductor.traducir("agregar") %></a> <a
							href="javascript:quitarContenidoDinamico(1);" class="tipo_titulo"><%=traductor.traducir("quitar") %></a>
							<div id="campos_precios">
								<%if(arregloIdPreciosProducto != null){
									for(int i = 0; i < arregloIdPreciosProducto.length; i++){ 
										if(setIdPrecioProductos.add(arregloIdPreciosProducto[i])){ %>
								<!--inicio_<%=setIdPrecioProductos.size() %>-->
								<div class="contenido_precios">
									<div class="tipo_titulo">
										<%=traductor.traducir("nombre") %>: <input type="text"
											name="<%=Util.convertirANombreCampo(traductor.traducir("nombre_precio")) %>_<%=setIdPrecioProductos.size() %>"
											required="required" value="<%=arregloNombresPrecios[i] %>">
									</div>
									<div class="tipo_titulo">
										<%=traductor.traducir("valor") %>: <input type="number"
											onkeypress="return soloNumerosConDecimales(event);"
											name="<%=Util.convertirANombreCampo(traductor.traducir("valor_precio")) %>_<%=setIdPrecioProductos.size() %>"
											step="any" required="required"
											value="<%=arregloValoresPrecios[i] %>">
									</div>
									<div class="tipo_titulo">
										moneda: <select
											name="<%=traductor.traducir("moneda") %>_<%=setIdPrecioProductos.size() %>"
											id="moneda_<%=setIdPrecioProductos.size() %>"
											required="required">
											<option value=""><%=traductor.traducir("seleccione_una_moneda")%></option>
											<%for(int j = 0; j < monedas.size(); j++){ %>
											<option value="<%=monedas.get(j).getCodigo() %>"
												<%=arregloCodigoMonedas[i].equals(monedas.get(j).getCodigo())?" selected=\"selected\"":"" %>><%=monedas.get(j).getNombre() %></option>
											<%} %>
										</select>
										<div
											style="visibility: hidden; display: none; width: 0px; height: 0px;"
											id="div_nueva_moneda_<%=setIdPrecioProductos.size() %>">
											<div class="tipo_titulo">
												<%=traductor.traducir("codigo_moneda")%>: <input type="text"
													maxlength="10" size="6"
													name="<%=Util.convertirANombreCampo(traductor.traducir("codigo_nueva_moneda")) %>_<%=setIdPrecioProductos.size() %>">
											</div>
											<div class="tipo_titulo">
												<%=traductor.traducir("nombre_moneda")%>: <input type="text"
													name="<%=Util.convertirANombreCampo(traductor.traducir("nombre_nueva_moneda")) %>_<%=setIdPrecioProductos.size() %>">
											</div>
											<div class="tipo_titulo">
												<%=traductor.traducir("simbolo_moneda")%>: <input
													type="text" maxlength="10" size="6"
													name="<%=Util.convertirANombreCampo(traductor.traducir("simbolo_nueva_moneda")) %>_<%=setIdPrecioProductos.size() %>">
											</div>
											<div class="tipo_titulo">
												<%=traductor.traducir("valor_moneda")%>: <input
													type="number"
													onkeypress="return soloNumerosConDecimales(event);"
													step="any"
													name="<%=Util.convertirANombreCampo(traductor.traducir("valor_nueva_moneda")) %>_<%=setIdPrecioProductos.size() %>">
											</div>
										</div>
										<input type="checkbox"
											onchange="ocultarMostrar(this, Array('moneda_<%=setIdPrecioProductos.size() %>'), Array('div_nueva_moneda_<%=setIdPrecioProductos.size() %>'));"
											value="true"
											name="<%=Util.convertirANombreCampo(traductor.traducir("es_nueva_moneda")) %>_<%=setIdPrecioProductos.size() %>">
										<%=traductor.traducir("nueva_preguntando")%>
									</div>
								</div>
								<!--fin_<%=setIdPrecioProductos.size() %>-->
								<% }
									}
								} %>
							</div> <%if(arregloIdPreciosProducto != null){
								Object obj[] = setIdPrecioProductos.toArray();
								Arrays.sort(obj);%> <input type="hidden"
							name="id_precios_producto"
							value="<%=StringUtils.join(obj, ',') %>"> <%}%></td>
					</tr>
				</table>
				<br> <input type="submit"
					value="<%=(request.getParameter("catalogo_productos_servidor.productos.id_producto") == null)?traductor.traducir("agregar_producto"):traductor.traducir("editar_producto") %>">
				<input type="reset" value="<%=traductor.traducir("reset") %>">
			</form>
		</div>
		<!-- </center> -->
	</div>

	<script type="text/javascript">
		minContenido[0] = 0;
		numContenido[0] = <%=setIdProductoXCaracteristicas.size() %>;
		idDivContenedor[0] = "campos_caracteristicas";
		htmlContenido[0] = "<div class=\"contenido_caracteristicas\">" + 
		"<div>"+
		"<select required=\"required\" id=\"caracteristica_numContenido\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("caracteristica")) %>_numContenido\">"
				+ "<option value=\"\"><%=traductor.traducir("seleccione_una_caracteristica") %></option>" +
				
			<%
				for (int i = 0; i < caracteristicas.size(); i++) {
			%>
				"<option value=\"<%=caracteristicas.get(i).getId()%>\"><%=caracteristicas.get(i).getNombre()%>"+
		"</option>"+
	<%}%>
		"</select>"+
		"<input id=\"nueva_caracteristica_numContenido\" type=\"text\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("nueva_caracteristica")) %>_numContenido\" style=\"visibility: hidden; display: none; width: 0px; height: 0px;\">"+
		
		"<input type=\"checkbox\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("es_nueva_caracteristica")) %>_numContenido\" value=\"true\" onchange=\"ocultarMostrar(this, new Array('caracteristica_numContenido'), new Array('nueva_caracteristica_numContenido'));\"> <%=traductor.traducir("nueva_preguntando") %>"+
		"</div>"
		+"<div class=\"tipo_titulo\"><%=traductor.traducir("valor") %>: <input required=\"required\" type=\"text\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("valor_caracteristica")) %>_numContenido\">"
				+ "</div></div>";
				
				
		minContenido[1] = 0;
		numContenido[1] = <%=setIdPrecioProductos.size() %>;
		idDivContenedor[1] = "campos_precios";	
		htmlContenido[1] = "<div class=\"contenido_precios\">"+
			"<div class=\"tipo_titulo\">"+
		"<%=traductor.traducir("nombre") %>: <input required=\"required\" type=\"text\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("nombre_precio")) %>_numContenido\">"+
	"</div>"+
	"<div class=\"tipo_titulo\">"+
		"<%=traductor.traducir("valor") %>: <input required=\"required\" type=\"number\" step=\"any\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("valor_precio")) %>_numContenido\""+
			"onkeypress=\"return soloNumerosConDecimales(event);\">"+
	"</div>"+
	"<div class=\"tipo_titulo\">"+
		"<%=traductor.traducir("moneda") %>: <select required=\"required\" id=\"moneda_numContenido\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("moneda")) %>_numContenido\">"+
			"<option value=\"\"><%=traductor.traducir("seleccione_una_moneda")%></option>"+
		<%for(int i = 0; i < monedas.size(); i++){ %>
			"<option value=\"<%=monedas.get(i).getCodigo()%>\"><%=monedas.get(i).getNombre()%>"
				+ "</option>" +
	<%}%>
		"</select>"
				+ "<div id=\"div_nueva_moneda_numContenido\" style=\"visibility: hidden; display: none; width: 0px; height: 0px;\">"
				+ "<div class=\"tipo_titulo\"><%=traductor.traducir("codigo_moneda")%>: <input type=\"text\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("codigo_nueva_moneda")) %>_numContenido\" size=\"6\" maxlength=\"10\"></div>"
				+ "<div class=\"tipo_titulo\"><%=traductor.traducir("nombre_moneda")%>: <input type=\"text\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("nombre_nueva_moneda")) %>_numContenido\"></div>"
				+ "<div class=\"tipo_titulo\"><%=traductor.traducir("simbolo_moneda")%>: <input type=\"text\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("simbolo_nueva_moneda")) %>_numContenido\" size=\"6\" maxlength=\"10\"></div>"
				+ "<div class=\"tipo_titulo\"><%=traductor.traducir("valor_moneda")%>: <input type=\"number\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("valor_nueva_moneda")) %>_numContenido\" step=\"any\" onkeypress=\"return soloNumerosConDecimales(event);\"></div></div>"

				+ "<input type=\"checkbox\" name=\"<%=Util.convertirANombreCampo(traductor.traducir("es_nueva_moneda")) %>_numContenido\" value=\"true\" onchange=\"ocultarMostrar(this, Array('moneda_numContenido'), Array('div_nueva_moneda_numContenido'));\"> <%=traductor.traducir("nueva_preguntando")%>"
				+ "</div>" + "</div>";
				
				
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
	mostrarMensaje("<%=e.getMessage()%>
		", true);
	</script>
	<%
		}
	%>
</body>
</html>