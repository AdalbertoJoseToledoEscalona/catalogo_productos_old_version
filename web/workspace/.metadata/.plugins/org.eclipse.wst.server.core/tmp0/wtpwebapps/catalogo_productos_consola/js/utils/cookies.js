/**
 * 
 */
function getCookie(nombreCookie) {
	var retorno = null;
	var data = document.cookie;
	var completo = data.split(";");
	var bandera = false;
	var partes = new Array();
	for ( var i = 0; i < completo.length; i++) {
		partes[i] = completo[i].split("=");

	}
	for ( var i = 0; i < partes.length; i++) {
		if (partes[i][0].indexOf(nombreCookie) != -1) {
			// alert(partes[i][1]); // tambien podemos devolver esto.
			retorno = partes[i][1];
			bandera = true;
		}
		;
	}
	if (!bandera) { // si no es encontrado, se mostrará mensaje de error
		// alert("¡Nombre de cookie errado!");
		retorno = null;
	}

	return retorno;
} // fin de la función getCookie

/**
 * crea una cookie
 * nombreCookie = El nombre de la Cookie (No puede ser null)
 * valor = El valor de la Cookie
 * path = ruta donde se almacena la cookie
 * domain = usado para identificar una cookie
 * expires = tiempo de vida de una cookie
 */
function setCookie(nombreCookie, valor, path, domain, expires) {
	var exito = false;
	if (nombreCookie != null) {
		var strCookie = nombreCookie + "=" + valor;
		if (path != null) {
			strCookie += "; path=" + path;
		}

		if (domain != null) {
			strCookie += "; domain=" + domain;
		}

		if (expires != null && expires instanceof Date) {
			strCookie += "; expires=" + expires.toGMTString();
		}

		document.cookie = strCookie;
		exito = true;
	}

	return exito;
} // fin de la función setCookie

function eliminarCookie(nombreCookie) {
	return setCookie(nombreCookie, null, null, null, new Date(1970, 1, 1, 0, 0, 0, 0));
} // fin de la función setCookie