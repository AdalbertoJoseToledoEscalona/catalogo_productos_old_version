/**
 * 
 */
var pagina = 1;
var filasPorPagina = 10;
var volverPagina = false;
var campoOrdenar = null;
var ascOrdenar = null;
function colocarPagina(pag, id) {
	pagina = parseInt(pag);
	var obj_reporte = document.getElementById(id);
	var filas = obj_reporte.getElementsByTagName("TR");
	var ultima_fila = pag * filasPorPagina;
	var primera_fila = ultima_fila - (filasPorPagina - 1);

	var prefijoFila = id + "_tr_";
	var numTotalFilas = 0;
	for ( var i = 1; i < filas.length; i++) {
		// reporte_tabla_tr_1_1
		var num = filas[i].id.substring(prefijoFila.length);
		num = num.substring(0, num.indexOf("_"));
		if (num < primera_fila || num > ultima_fila) {
			// if(i < primera_fila || i > ultima_fila){
			filas[i].style.visibility = "hidden";
			filas[i].style.width = "0px";
			filas[i].style.height = "0px";
			filas[i].style.display = "none";
		} else {
			filas[i].style.visibility = "visible";
			filas[i].style.width = "";
			filas[i].style.height = "";
			filas[i].style.display = "";
		}
		numTotalFilas = num;
	}

	// var fila = filas.length - 1;
	var fila = numTotalFilas - 1;
	var cont = parseInt(fila / filasPorPagina, 10);
	if (fila % 10 != 0) {
		cont++;
	}
	if (pag <= cont) {
		var strPaginas = "";
		if (cont > 1) {
			var inicio = pag - filasPorPagina;
			var fin = pag + filasPorPagina;

			var quite = 0;
			if (inicio < 1) {
				quite = inicio - 1;
				inicio = 1;
				fin -= quite;
			}

			if (fin > cont) {
				quite = fin - cont;
				fin = cont;
				inicio -= quite;
				if (inicio < 1) {
					inicio = 1;
				}
			}

			if (inicio > 1) {
				strPaginas += "<a href=\"javascript: colocarPagina(1, '" + id + "');\" >1</a>...&nbsp;&nbsp;&nbsp;";
			}

			var i = inicio;
			for (i = inicio; i <= cont && i <= fin; i++) {
				if (i == pag) {
					strPaginas += "<b style='color: blue;'>" + i
							+ "</b>&nbsp;&nbsp;&nbsp;";
				} else {
					strPaginas += "<a href=\"javascript: colocarPagina(" + i
							+ ", '" + id + "');\" >" + i + "</a>&nbsp;&nbsp;&nbsp;";
				}
			}
			strPaginas = strPaginas.substring(0, strPaginas
					.lastIndexOf("&nbsp;&nbsp;&nbsp;"));
			if (i < cont + 1) {
				strPaginas += "&nbsp;&nbsp;&nbsp;...<a href=\"javascript: colocarPagina("
						+ cont + ", '" + id + "');\" >" + cont + "</a>";
			}
			document.getElementById(id + "_paginas").innerHTML = strPaginas;
		}
	} else {
		return false;
	}

}

function ordenarTablaReporte(campo, asc, usarAjax, pagActual, id, objLink) {
	
	campoOrdenar = campo;
	ascOrdenar = asc;

	var objHiddenOrdenar = document.getElementById("campo_ordenar_" + id + "_hidden");
	if(objHiddenOrdenar != null){
		objHiddenOrdenar.name = campo
				+ "_ordenar_" + id;
		objHiddenOrdenar.value = (asc == null) ? "null"
				: asc;
	}
	var qs = "";

	var f = document.getElementsByName("form_filtro_" + id)[0];

	if (f != null) {

		for ( var i = 0; i < f.length; i++) {
			if (f[i].name != null && f[i].name != "") {
				if (f[i].tagName.toLowerCase() == "select") {
					qs += f[i].name + "="
							+ f[i].options[f[i].selectedIndex].value + "&";
				} else {
					qs += f[i].name + "=" + f[i].value + "&";
				}
			}
		}

		qs = qs.substring(0, qs.length - 1);

	} else {

		qs = "ordenar_" + id + "=true&" + campo + "_ordenar_" + id + "="
				+ asc + "&pagina_js_" + id + "=" + pagina
				+ "&" + id + "_refrescando=true";

	}

	if (usarAjax) {
		var objDiv = objLink;
		do {
			objDiv = objDiv.parentNode;
		} while (objDiv.nodeName.toLowerCase() != "table");

		objDiv = objDiv.parentNode;

		ajaxTablaReporte(qs, objDiv, pagina, pagActual, id);

	} else {
		location.href = location.href.split("?")[0] + "?" + qs;
	}

}

function filtrarTablaReporte(f, usarAjax, idTablaReporte) {
	var qs = "";

	for ( var i = 0; i < f.length; i++) {
		if (f[i].name != null && f[i].name != "") {
			if (f[i].tagName.toLowerCase() == "select") {
				qs += f[i].name + "=" + f[i].options[f[i].selectedIndex].value
						+ "&";
			} else {
				qs += f[i].name + "=" + f[i].value + "&";
			}
		}
	}

	qs = qs.substring(0, qs.length - 1);

	if (usarAjax) {
		objDiv = document.getElementById(idTablaReporte).parentNode;

		ajaxTablaReporte(qs, objDiv, 1, null, idTablaReporte);

		return false;

	} else {
		return true;
	}

}

function eliminarFilaTablaReporte(qsEliminar, pagEliminar, usarAjax,
		mensajeConfirmacionEliminar, idTablaReporte, objLink) {

	if (mensajeConfirmacionEliminar == null
			|| mensajeConfirmacionEliminar == "null"
			|| confirm(mensajeConfirmacionEliminar)) {
		if (usarAjax) {

			do {
				qsEliminar = qsEliminar.replace("=", "_eliminar_igual_tag_");
			} while (qsEliminar != qsEliminar.replace("=",
					"_eliminar_igual_tag_"));

			do {
				qsEliminar = qsEliminar.replace("_igual_tag_", "=");
			} while (qsEliminar != qsEliminar.replace("_igual_tag_", "="));

			var qs = "";

			var f = document.getElementsByName("form_filtro_" +  idTablaReporte)[0];

			if (f != null) {

				for ( var i = 0; i < f.length; i++) {
					if (f[i].name != null && f[i].name != "") {
						if (f[i].tagName.toLowerCase() == "select") {
							qs += f[i].name + "="
									+ f[i].options[f[i].selectedIndex].value
									+ "&";
						} else {
							qs += f[i].name + "=" + f[i].value + "&";
						}
					}
				}

				qs = qs.substring(0, qs.length - 1);

			} else {
				if(campoOrdenar != null){
				qs = "ordenar_" + idTablaReporte + "=true&" + campoOrdenar
						+ "_ordenar_" + idTablaReporte + "=" + ascOrdenar
						+ "&pagina_js_" + idTablaReporte + "=" + pagina
						+ "&" + idTablaReporte + "_refrescando=true";
				}else{
					qs = "pagina_js_" + idTablaReporte + "=" + pagina
					+ "&" + idTablaReporte + "_refrescando=true";
				}
			}

			if (qs == "") {
				qs = qsEliminar;
			} else if (qsEliminar != "") {
				qs = qs + "&" + qsEliminar;
			}

			if (usarAjax) {
				var objDiv = objLink;
				do {
					objDiv = objDiv.parentNode;
				} while (objDiv.nodeName.toLowerCase() != "table");

				objDiv = objDiv.parentNode;

				ajaxTablaReporte(qs, objDiv, pagina, pagEliminar);

			} else {
				location.href = location.href.split("?")[0] + "?" + qs;
			}

		} else {
			location.href = location.href.split("?")[0] + "?" + qsEliminar;
		}
	}

}

function colocarPaginaOtraVez(id) {
	var pag = pagina;
	var obj_reporte = document.getElementById("reporte");
	var filas = obj_reporte.getElementsByTagName("TR");
	var ultima_fila = pag * filasPorPagina;
	var primera_fila = ultima_fila - (filasPorPagina - 1);

	var prefijoFila = id +"_tr_";
	var numTotalFilas = 0;
	for ( var i = 1; i < filas.length; i++) {
		// reporte_tabla_tr_1_1
		var num = filas[i].id.substring(prefijoFila.length);
		num = num.substring(0, num.indexOf("_"));
		if (num < primera_fila || num > ultima_fila) {
			// if(i < primera_fila || i > ultima_fila){
			filas[i].style.visibility = "hidden";
			filas[i].style.width = "0px";
			filas[i].style.height = "0px";
			filas[i].style.display = "none";
		} else {
			filas[i].style.visibility = "visible";
			filas[i].style.width = "";
			filas[i].style.height = "";
			filas[i].style.display = "";
		}
	}

	// var fila = filas.length - 1;
	var fila = numTotalFilas - 1;
	var cont = parseInt(fila / filasPorPagina, 10);
	if (fila % 10 != 0) {
		cont++;
	}
	var strPaginas = "";
	if (cont > 0) {
		var inicio = pag - filasPorPagina;
		var fin = pag + filasPorPagina;

		var quite = 0;
		if (inicio < 1) {
			quite = inicio - 1;
			inicio = 1;
			fin -= quite;
		}

		if (fin > cont) {
			quite = fin - cont;
			fin = cont;
			inicio -= quite;
			if (inicio < 1) {
				inicio = 1;
			}
		}

		if (inicio > 1) {
			strPaginas += "<a href='javascript: colocarPagina(1);' >1</a>...&nbsp;&nbsp;&nbsp;";
		}

		var i = inicio;
		for (i = inicio; i <= cont && i <= fin; i++) {
			if (i == pag) {
				strPaginas += "<b style='color: blue;'>" + i
						+ "</b>&nbsp;&nbsp;&nbsp;";
			} else {
				strPaginas += "<a href='javascript: colocarPagina(" + i
						+ ");' >" + i + "</a>&nbsp;&nbsp;&nbsp;";
			}
		}
		strPaginas = strPaginas.substring(0, strPaginas
				.lastIndexOf("&nbsp;&nbsp;&nbsp;"));
		if (i < cont + 1) {
			strPaginas += "&nbsp;&nbsp;&nbsp;...<a href='javascript: colocarPagina("
					+ cont + ");' >" + cont + "</a>";
		}
		document.getElementById(id + "_paginas").innerHTML = strPaginas;
	}
}

function ordenarCampos(campo, ascendente) {
	document.getElementById("campo_ordenar").value = campo;
	document.getElementById("ascendente").value = ascendente;
	document.getElementById("f").onsubmit();
}

function eliminarFila(campos, valores) {
	for ( var i = 0; i < campos.length; i++) {
		document.getElementById(campos[i]).value = valores[i];
	}

	volverPagina = true;

	// document.getElementById("fila_eliminar").value=fila;
	// document.getElementById("correo_eliminar").value=correo;
	document.getElementById("f").onsubmit();
}

function chequearSiVolverPagina() {

	if (volverPagina == true) {
		var resultado = false;
		do {
			resultado = colocarPagina(pagina);
			pagina--;
		} while (resultado == false);
		pagina++;
	}

	volverPagina = false;
}

function cargarSelects(datos) {
	// alert(datos.length);
	var num_select = -1;
	if (arguments[1] != null) {
		num_select = arguments[1];
	}

	var separador = "<sepa>";
	var obj_select = document.getElementById("f");
	// var obj_select = document.getElementsByName("filtro");
	// alert(obj_select.length);
	for ( var i = 0; i < datos.length; i++) {
		// if(obj_select[i].tagName.toLowerCase() == "select"){
		if (i != num_select) {
			var valor_colocar = obj_select[i].options[obj_select[i].selectedIndex].value
					.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
			// alert("valor_colocar = "+valor_colocar);
			obj_select[i].options.length = 1;
			var valores = datos[i].substring(0,
					datos[i].length - separador.length).split(separador);
			// obj_select[i].options[obj_select[i].options.length]= new
			// Option("Todos", "");
			for ( var j = 0; j < valores.length; j++) {
				if (valores[j].indexOf("=") != -1) {
					var valor = valores[j].split("=");
					// var opcion = new Option(valor[1], valor[0]);
					var opcion = null;
					if (valor[0].replace(/^\s\s*/, '').replace(/\s\s*$/, '') == valor_colocar) {
						// opcion.setAttribute("selected", "selected");
						opcion = new Option(valor[1].replace(/^\s\s*/, '')
								.replace(/\s\s*$/, ''), valor[0].replace(
								/^\s\s*/, '').replace(/\s\s*$/, ''), true);
					} else {
						opcion = new Option(valor[1].replace(/^\s\s*/, '')
								.replace(/\s\s*$/, ''), valor[0].replace(
								/^\s\s*/, '').replace(/\s\s*$/, ''));
					}
					obj_select[i].options[obj_select[i].options.length] = opcion;
				}
			}
		}
		// }
	}
}