// Cambia estos parametros
//var seconds = 10; // el tiempo en que se refresca
var dividLlenarCmbGrupoEquipos = "cmbGrupoEquipo"; // el div que quieres!
var urlLlenarCmbGrupoEquipos = "/catalogo_productos_consola/LlenarCmbGrupoEquipoServlet"; // el
// archivo
// que ira en el
// div
// var secondsLlenarCmbGrupoEquipos = 1800;
// //////////////////////////////
//
// Refreshing the DIV
//
// //////////////////////////////
function ajaxLlenarGrupoEquipos(strUsuario, strClave, objCmbGrupoEquipos) {
	// The XMLHttpRequest object
	var xmlHttp;
	try {
		xmlHttp = new XMLHttpRequest(); // Firefox, Opera 8.0+, Safari
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // Internet Explorer
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Tu explorador no soporta AJAX.");
				return false;
			}
		}
	}
	// Timestamp for preventing IE caching the GET request
	fetch_unix_timestamp = function() {
		return parseInt(new Date().getTime().toString().substring(0, 10));
	};
	var timestamp = fetch_unix_timestamp();
	var nocacheurl = urlLlenarCmbGrupoEquipos + "?t=" + timestamp + "&usuario="
			+ strUsuario + "&clave=" + strClave;

	var textoActualPrimeraPosicion = objCmbGrupoEquipos.options[0].text;
	var valorActualSeleccionado = objCmbGrupoEquipos.options[objCmbGrupoEquipos.selectedIndex].value;
	objCmbGrupoEquipos.options[0].selected = true;

	// The code...
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var strRespuesta = xmlHttp.responseText; // OBTENGO LO QUE
														// IMPRIMIO MI JSP

			objCmbGrupoEquipos.options[0].text = textoActualPrimeraPosicion;

			if (strRespuesta.length > 0) {
				var inicioSELECT = "<SELECT>";
				var finSELECT = "</SELECT>";

				var inicioError = "<ERROR>";
				var finError = "</ERROR>";
				if (strRespuesta.indexOf(inicioError) >= 0) {
					var mensajeError = strRespuesta.substring(strRespuesta
							.indexOf(inicioError)
							+ inicioError.length, strRespuesta.length);

					mensajeError = mensajeError.substring(0, mensajeError
							.indexOf(finError));

					mostrarMensaje(mensajeError, true);
				} else if (strRespuesta.indexOf(inicioSELECT) >= 0) {
					var strOpciones = strRespuesta.substring(strRespuesta
							.indexOf(inicioSELECT)
							+ inicioSELECT.length, strRespuesta.length);

					strOpciones = strOpciones.substring(0, strOpciones
							.indexOf(finSELECT));

					var inicioValue = "<OPTION value='";
					var inicioText = "'>";
					var finText = "</OPTION>";

					objCmbGrupoEquipos.length = 1;

					while (strOpciones.indexOf(inicioValue) >= 0) {
						strOpciones = strOpciones.substring(strOpciones
								.indexOf(inicioValue)
								+ inicioValue.length, strOpciones.length);

						var valor = strOpciones.substring(0, strOpciones
								.indexOf(inicioText));

						strOpciones = strOpciones.substring(strOpciones
								.indexOf(inicioText)
								+ inicioText.length, strOpciones.length);

						var texto = strOpciones.substring(0, strOpciones
								.indexOf(finText));

						var seleccionado = false;
						if (valor == valorActualSeleccionado) {
							seleccionado = true;
						}
						objCmbGrupoEquipos[objCmbGrupoEquipos.length] = new Option(
								texto, valor, false, seleccionado);
					}

					if (objCmbGrupoEquipos.length > 1) {
						objCmbGrupoEquipos.removeAttribute("disabled");
					}
				}
			}

			// setTimeout('refreshdiv()',secondsLlenarCmbGrupoEquipos*1000);
		} else {
			// document.getElementById(dividLlenarCmbGrupoEquipos).innerHTML="Cargando...";
			objCmbGrupoEquipos.options[0].text = cargando + "...";
		}
	};
	xmlHttp.open("GET", nocacheurl, true);
	xmlHttp.send(null);
}
// Start the refreshing process
/*
 * window.onload = function startrefresh(){
 * setTimeout('refreshdivCartelera()',secondsLlenarCmbGrupoEquipos*1000); }
 */
