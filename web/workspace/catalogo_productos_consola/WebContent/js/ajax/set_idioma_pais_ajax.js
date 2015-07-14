// Cambia estos parametros
//var seconds = 10; // el tiempo en que se refresca
var dividSetIdiomaPais = "select_idioma"; // el div que quieres!
var urlSetIdiomaPais = "/catalogo_productos_consola/SetIdiomaPaisServlet"; // el
// archivo
// que ira en el
// div
// var secondsSetIdiomaPais = 1800;
// //////////////////////////////
//
// Refreshing the DIV
//
// //////////////////////////////
function ajaxSetIdiomaPais(cmbIdiomas) {
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
	var nocacheurl = urlSetIdiomaPais + "?t=" + timestamp + "&idioma_pais="
			+ cmbIdiomas.options[cmbIdiomas.selectedIndex].value;

	var textoActualPrimeraPosicion = cmbIdiomas.options[0].text;
	var valorActualSeleccionado = cmbIdiomas.options[cmbIdiomas.selectedIndex].value;
	cmbIdiomas.options[0].selected = true;

	// The code...
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var strRespuesta = xmlHttp.responseText; // OBTENGO LO QUE
														// IMPRIMIO MI JSP

			cmbIdiomas.options[0].text = textoActualPrimeraPosicion;

			if (strRespuesta.length > 0) {
				var inicioRESPUESTA = "<RESPUESTA>";
				var finRESPUESTA = "</RESPUESTA>";

				var inicioError = "<ERROR>";
				var finError = "</ERROR>";
				if (strRespuesta.indexOf(inicioError) >= 0) {
					var mensajeError = strRespuesta.substring(strRespuesta
							.indexOf(inicioError)
							+ inicioError.length, strRespuesta.length);

					mensajeError = mensajeError.substring(0, mensajeError
							.indexOf(finError));

					if(mensajeError == "expira_sesion"){
						location.href = "/catalogo_productos_consola/jsp/index.jsp?error=expira_sesion";
					}else {
						mostrarMensaje(mensajeError, true);
					}
				} else if (strRespuesta.indexOf(inicioRESPUESTA) >= 0) {
					var strOpciones = strRespuesta.substring(strRespuesta
							.indexOf(inicioRESPUESTA)
							+ inicioRESPUESTA.length, strRespuesta.length);

					strOpciones = strOpciones.substring(0, strOpciones
							.indexOf(finRESPUESTA));

					if(strOpciones == "exito"){
						for ( var i = 0; i < cmbIdiomas.options.length; i++) {
							if(cmbIdiomas.options[i].value == valorActualSeleccionado){
								cmbIdiomas.options[i].selected = true;
								break;
							}
						}
						location.reload();
					}
				}
			}

			// setTimeout('refreshdiv()',secondsSetIdiomaPais*1000);
		} else {
			// document.getElementById(dividSetIdiomaPais).innerHTML="Cargando...";
			cmbIdiomas.options[0].text = cargando + "...";
		}
	};
	xmlHttp.open("GET", nocacheurl, true);
	xmlHttp.send(null);
}
// Start the refreshing process
/*
 * window.onload = function startrefresh(){
 * setTimeout('refreshdivCartelera()',secondsSetIdiomaPais*1000); }
 */
