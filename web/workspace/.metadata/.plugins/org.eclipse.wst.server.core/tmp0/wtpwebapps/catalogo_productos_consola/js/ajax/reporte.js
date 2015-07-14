/**
 * 
 */
// Cambia estos parametros
// var seconds = 10; // el tiempo en que se refresca
var dividTablaReporte = "listado_productos"; // el div que quieres!
var urlTablaReporte = "/catalogo_productos_consola/jsp/plantillas/reporte_listado_producto.jsp"; // el
// archivo
// que ira en el
// div
// var secondsTablaReporte = 1800;
// //////////////////////////////
//
// Refreshing the DIV
//
// //////////////////////////////
function ajaxTablaReporte(qs, div, pagina, urlPagina, idTablaReporte) {
	if(urlPagina != null && urlPagina != undefined && urlPagina != "" && urlPagina != "null"){
		urlTablaReporte = urlPagina;
	}else{
		urlTablaReporte = "/catalogo_productos_consola/jsp/plantillas/reporte_listado_producto.jsp";
	}
	
	
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
	var nocacheurl = urlTablaReporte + "?t=" + timestamp + "&" + qs;

	// The code...
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var strRespuesta = xmlHttp.responseText; // OBTENGO LO QUE
			// IMPRIMIO MI JSP
			
			var inicioRedireccionar = "<REDIRECCIONAR>";
			var finRedireccionar = "</REDIRECCIONAR>";
			if (strRespuesta.indexOf(inicioRedireccionar) >= 0) {
				var urlRedireccion = strRespuesta.substring(strRespuesta
						.indexOf(inicioRedireccionar)
						+ inicioRedireccionar.length, strRespuesta.length);

				urlRedireccion = urlRedireccion.substring(0, urlRedireccion
						.indexOf(finRedireccionar));

				location.href = urlRedireccion;
			}else{
			
				var inicioError = "<ERROR>";
				var finError = "</ERROR>";
				if (strRespuesta.indexOf(inicioError) >= 0) {
					var mensajeError = strRespuesta.substring(strRespuesta
							.indexOf(inicioError)
							+ inicioError.length, strRespuesta.length);
	
					mensajeError = mensajeError.substring(0, mensajeError
							.indexOf(finError));
	
					mostrarMensaje(mensajeError, true);
					
					strRespuesta = strRespuesta.replace(inicioError + mensajeError + finError, "");
				}
				
				var inicioExito = "<EXITO>";
				var finExito = "</EXITO>";
				if (strRespuesta.indexOf(inicioExito) >= 0) {
					var mensajeExito = strRespuesta.substring(strRespuesta
							.indexOf(inicioExito)
							+ inicioExito.length, strRespuesta.length);
	
					mensajeExito = mensajeExito.substring(0, mensajeExito
							.indexOf(finExito));
	
					mostrarMensaje(mensajeExito, false);
					
					strRespuesta = strRespuesta.replace(inicioExito + mensajeExito + finExito, "");
				}
	
				div.innerHTML = strRespuesta;
				
				colocarPagina(pagina, idTablaReporte);
			}

			// setTimeout('refreshdiv()',secondsTablaReporte*1000);
		} else {
			// document.getElementById(dividTablaReporte).innerHTML="Cargando...";
			div.innerHTML = cargando + "...";
		}
	};
	xmlHttp.open("GET", nocacheurl, true);
	xmlHttp.send(null);
}
// Start the refreshing process
/*
 * window.onload = function startrefresh(){
 * setTimeout('refreshdivCartelera()',secondsTablaReporte*1000); }
 */
