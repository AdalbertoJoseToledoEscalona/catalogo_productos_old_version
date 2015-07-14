<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="modelo.utils.Traductor"%>
<div class="encabezado">
	<div class="texto_encabezado">
		<div class="titulo_encabezado"><%=traductor.traducir("nombre_sistema") %></div>
		<div class="subtitulo_encabezado"><%=traductor.traducir("consola_administrativa") %></div>
	</div>
	<div class="select_idiomas">
		<select id="select_idioma" onchange="setIdiomaPais(this);">
			<%
				for (int i = 0; i < idiomasDisponibles.length; i++) {
			%>
			<option value="<%=idiomasDisponibles[i]%>"
				<%if (idiomasDisponibles[i].equals(strIdiomaPais)) {%>
				selected="selected" <%}%>>
				<%
					if (idiomasDisponibles[i].trim().length() > 0) {
							String idioma_pais2[] = idiomasDisponibles[i].split("_");
							Traductor t = new Traductor(idioma_pais2[0], idioma_pais2[1]);
							out.print(t.traducir(idioma_pais2[0]) + ", "
									+ t.traducir(idioma_pais2[1]));
						} else {
							out.print(traductor.traducir("default"));
						}
				%>
			</option>
			<%
				}
			%>

		</select>
	</div>
</div>