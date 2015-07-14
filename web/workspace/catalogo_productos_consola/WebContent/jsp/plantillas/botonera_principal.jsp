<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelo.utils.Traductor"%>
<% //Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<div class="botonera_principal">
	<h3 class="usuario_botonera"><%=usuario.getNombre() + " " + usuario.getApellido() %> </h3>
	<ul>
		<li><a href="agregar_producto.jsp"><%=traductor.traducir("agregar_producto")%></a></li>
		<li><a href="listado_productos.jsp"><%=traductor.traducir("listado_productos")%></a></li>
		<li><a href="administrar_documentos_productos.jsp"><%=traductor.traducir("administrar_documentos_productos")%></a></li>
		<li><a href="listado_categoria.jsp"><%=traductor.traducir("listado_categoria")%></a></li>
		<li><a href="personalizar_pantallas.jsp"><%=traductor.traducir("personalizar_pantallas_mt")%></a></li>
		<li><a href="agregar_administrador.jsp"><%=traductor.traducir("agregar_administrador")%></a></li>
		<li><a href="listado_administradores.jsp"><%=traductor.traducir("listado_administradores")%></a></li>
		<li><a
			href="<%=request.getContextPath() %>/AutenticarUsuarioServlet"><%=traductor.traducir("cerrar_sesion")%></a></li>
	</ul>
</div>