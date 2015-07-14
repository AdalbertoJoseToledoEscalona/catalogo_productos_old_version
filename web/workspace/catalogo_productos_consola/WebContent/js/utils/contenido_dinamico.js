/**
 * 
 */
var minContenido = new Array();
var numContenido = new Array();
var idDivContenedor = new Array();
var htmlContenido = new Array();

function agregarContenidoDinamico(indice) {
	var valoresCampos = new Array();
	obj = document.getElementById(idDivContenedor[indice]);
	var campos = obj.getElementsByTagName("input");
	for ( var i = 0; i < campos.length; i++) {
		if ((campos[i].type.toLowerCase() == "text"
				|| campos[i].type.toLowerCase() == "password"
				|| campos[i].type.toLowerCase() == "file"
				|| campos[i].type.toLowerCase() == "textarea"
				|| campos[i].type.toLowerCase() == "date"
				|| campos[i].type.toLowerCase() == "number" || campos[i].type
				.toLowerCase() == "email")
				&& (campos[i].value != "")) {
			valoresCampos[valoresCampos.length] = new Array(campos[i].name,
					campos[i].value);
		} else if ((campos[i].type.toLowerCase() == "checkbox" || campos[i].type
				.toLowerCase() == "radio")
				&& (campos[i].checked)) {
			valoresCampos[valoresCampos.length] = new Array(campos[i].name,
					campos[i].value, campos[i].checked);
		}
	}

	campos = obj.getElementsByTagName("select");
	for ( var i = 0; i < campos.length; i++) {
		if ((campos[i].multiple && campos[i].selectedIndex >= 0)
				|| (!campos[i].multiple && campos[i].options[campos[i].selectedIndex].value != "")) {
			valoresCampos[valoresCampos.length] = new Array(campos[i].name,
					campos[i].selectedIndex);
		}
	}

	campos = obj.getElementsByTagName("textarea");
	for ( var i = 0; i < campos.length; i++) {
		if (campos[i].value != "" || campos[i].innerHTML != "") {
			valoresCampos[valoresCampos.length] = new Array(campos[i].name,
					campos[i].value);
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////

	numContenido[indice]++;
	var strCampo = "<!--inicio_" + numContenido[indice] + "-->"
			+ htmlContenido[indice] + "<!--fin_" + numContenido[indice] + "-->";

	do {
		strCampo = strCampo.replace("numContenido", numContenido[indice]);
	} while (strCampo != strCampo.replace("numContenido", numContenido[indice]));

	document.getElementById(idDivContenedor[indice]).innerHTML += strCampo;

	// /////////////////////////////////////////////////////////////////////////////////////

	campos = obj.getElementsByTagName("input");
	for ( var i = 0; i < campos.length; i++) {
		if ((campos[i].type.toLowerCase() == "text"
				|| campos[i].type.toLowerCase() == "password"
				|| campos[i].type.toLowerCase() == "file"
				|| campos[i].type.toLowerCase() == "textarea"
				|| campos[i].type.toLowerCase() == "date"
				|| campos[i].type.toLowerCase() == "number" || campos[i].type
				.toLowerCase() == "email")
				&& (campos[i].value == "")) {
			for ( var j = 0; j < valoresCampos.length; j++) {
				if (campos[i].name == valoresCampos[j][0]) {
					campos[i].value = valoresCampos[j][1];
				}
			}
		} else if ((campos[i].type.toLowerCase() == "checkbox" || campos[i].type
				.toLowerCase() == "radio")
				&& (!campos[i].checked)) {
			for ( var j = 0; j < valoresCampos.length; j++) {
				if (campos[i].name == valoresCampos[j][0]
						&& campos[i].value == valoresCampos[j][1]) {
					campos[i].checked = valoresCampos[j][2];
				}
			}
		}
	}

	campos = obj.getElementsByTagName("select");
	for ( var i = 0; i < campos.length; i++) {
		if ((campos[i].multiple && campos[i].selectedIndex < 0)
				|| (!campos[i].multiple && campos[i].options[campos[i].selectedIndex].value == "")) {
			for ( var j = 0; j < valoresCampos.length; j++) {
				if (campos[i].name == valoresCampos[j][0]) {
					campos[i].selectedIndex = valoresCampos[j][1];
				}
			}
		}
	}

	campos = obj.getElementsByTagName("textarea");
	for ( var i = 0; i < campos.length; i++) {
		if (campos[i].value == "" && campos[i].innerHTML == "") {
			for ( var j = 0; j < valoresCampos.length; j++) {
				if (campos[i].name == valoresCampos[j][0]) {
					campos[i].value = valoresCampos[j][1];
				}
			}
		}
	}

}

function quitarContenidoDinamico(indice) {
	if (numContenido[indice] > minContenido[indice]) {

		var valoresCampos = new Array();
		obj = document.getElementById(idDivContenedor[indice]);
		var campos = obj.getElementsByTagName("input");
		for ( var i = 0; i < campos.length; i++) {
			if ((campos[i].type.toLowerCase() == "text"
					|| campos[i].type.toLowerCase() == "password"
					|| campos[i].type.toLowerCase() == "file"
					|| campos[i].type.toLowerCase() == "textarea"
					|| campos[i].type.toLowerCase() == "date"
					|| campos[i].type.toLowerCase() == "number" || campos[i].type
					.toLowerCase() == "email")
					&& (campos[i].value != "")) {
				valoresCampos[valoresCampos.length] = new Array(campos[i].name,
						campos[i].value);
			} else if ((campos[i].type.toLowerCase() == "checkbox" || campos[i].type
					.toLowerCase() == "radio")
					&& (campos[i].checked)) {
				valoresCampos[valoresCampos.length] = new Array(campos[i].name,
						campos[i].value, campos[i].checked);
			}
		}

		campos = obj.getElementsByTagName("select");
		for ( var i = 0; i < campos.length; i++) {
			if ((campos[i].multiple && campos[i].selectedIndex >= 0)
					|| (!campos[i].multiple && campos[i].options[campos[i].selectedIndex].value != "")) {
				valoresCampos[valoresCampos.length] = new Array(campos[i].name,
						campos[i].selectedIndex);
			}
		}

		campos = obj.getElementsByTagName("textarea");
		for ( var i = 0; i < campos.length; i++) {
			if (campos[i].value != "" || campos[i].innerHTML != "") {
				valoresCampos[valoresCampos.length] = new Array(campos[i].name,
						campos[i].value);
			}
		}

		// //////////////////////////////////////////////////////////////////////////////////////////

		var strCampo = document.getElementById(idDivContenedor[indice]).innerHTML;

		var bla = strCampo.split("<!--inicio_" + numContenido[indice] + "-->");

		strCampo = "<!--inicio_" + numContenido[indice] + "-->"
				+ bla[bla.length - 1];

		document.getElementById(idDivContenedor[indice]).innerHTML = document
				.getElementById(idDivContenedor[indice]).innerHTML.replace(
				strCampo, "");

		numContenido[indice]--;

		// /////////////////////////////////////////////////////////////////////////////////////

		campos = obj.getElementsByTagName("input");
		for ( var i = 0; i < campos.length; i++) {
			if ((campos[i].type.toLowerCase() == "text"
					|| campos[i].type.toLowerCase() == "password"
					|| campos[i].type.toLowerCase() == "file"
					|| campos[i].type.toLowerCase() == "textarea"
					|| campos[i].type.toLowerCase() == "date"
					|| campos[i].type.toLowerCase() == "number" || campos[i].type
					.toLowerCase() == "email")
					&& (campos[i].value == "")) {
				for ( var j = 0; j < valoresCampos.length; j++) {
					if (campos[i].name == valoresCampos[j][0]) {
						campos[i].value = valoresCampos[j][1];
					}
				}
			} else if ((campos[i].type.toLowerCase() == "checkbox" || campos[i].type
					.toLowerCase() == "radio")
					&& (!campos[i].checked)) {
				for ( var j = 0; j < valoresCampos.length; j++) {
					if (campos[i].name == valoresCampos[j][0]
							&& campos[i].value == valoresCampos[j][1]) {
						campos[i].checked = valoresCampos[j][2];
					}
				}
			}
		}

		campos = obj.getElementsByTagName("select");
		for ( var i = 0; i < campos.length; i++) {
			if ((campos[i].multiple && campos[i].selectedIndex < 0)
					|| (!campos[i].multiple && campos[i].options[campos[i].selectedIndex].value == "")) {
				for ( var j = 0; j < valoresCampos.length; j++) {
					if (campos[i].name == valoresCampos[j][0]) {
						campos[i].selectedIndex = valoresCampos[j][1];
					}
				}
			}
		}

		campos = obj.getElementsByTagName("textarea");
		for ( var i = 0; i < campos.length; i++) {
			if (campos[i].value == "" && campos[i].innerHTML == "") {
				for ( var j = 0; j < valoresCampos.length; j++) {
					if (campos[i].name == valoresCampos[j][0]) {
						campos[i].value = valoresCampos[j][1];
					}
				}
			}
		}

	}
}

function ocultarMostrar(chbx, nombresCampos1, nombresCampos2) {
	var objs1 = new Array();
	for ( var i = 0; i < nombresCampos1.length; i++) {
		objs1[i] = document.getElementById(nombresCampos1[i]);
	}

	var objs2 = new Array();
	for ( var i = 0; i < nombresCampos2.length; i++) {
		objs2[i] = document.getElementById(nombresCampos2[i]);
	}

	if (chbx.checked) {
		for ( var i = 0; i < objs1.length; i++) {
			objs1[i].style.visibility = "hidden";
			objs1[i].style.width = "0px";
			objs1[i].style.height = "0px";
			objs1[i].style.display = "none";

			if (objs1[i].tagName.toLowerCase() == "input"
					|| objs1[i].tagName.toLowerCase() == "textarea"
					|| objs1[i].tagName.toLowerCase() == "select") {
				objs1[i].removeAttribute("required");
			} else {
				var os = objs1[i].getElementsByTagName("input");
				for ( var j = 0; j < os.length; j++) {
					os[j].removeAttribute("required");
				}

				os = objs1[i].getElementsByTagName("textarea");
				for ( var j = 0; j < os.length; j++) {
					os[j].removeAttribute("required");
				}

				os = objs1[i].getElementsByTagName("select");
				for ( var j = 0; j < os.length; j++) {
					os[j].removeAttribute("required");
				}
			}

		}

		for ( var i = 0; i < objs2.length; i++) {
			objs2[i].style.visibility = "visible";
			objs2[i].style.width = "";
			objs2[i].style.height = "";
			objs2[i].style.display = "";

			if (objs2[i].tagName.toLowerCase() == "input"
					|| objs2[i].tagName.toLowerCase() == "textarea"
					|| objs2[i].tagName.toLowerCase() == "select") {

				if (objs2[i].name.indexOf("norequerido") < 0) {
					objs2[i].setAttribute("required", "required");
				}
			} else {
				var os = objs2[i].getElementsByTagName("input");
				for ( var j = 0; j < os.length; j++) {
					if (os[j].name.indexOf("norequerido") < 0) {
						os[j].setAttribute("required", "required");
					}
				}

				os = objs2[i].getElementsByTagName("textarea");
				for ( var j = 0; j < os.length; j++) {
					if (os[j].name.indexOf("norequerido") < 0) {
						os[j].setAttribute("required", "required");
					}
				}

				os = objs2[i].getElementsByTagName("select");
				for ( var j = 0; j < os.length; j++) {
					if (os[j].name.indexOf("norequerido") < 0) {
						os[j].setAttribute("required", "required");
					}
				}
			}
		}
	} else {
		for ( var i = 0; i < objs1.length; i++) {
			objs1[i].style.visibility = "visible";
			objs1[i].style.width = "";
			objs1[i].style.height = "";
			objs1[i].style.display = "";

			if (objs1[i].tagName.toLowerCase() == "input"
					|| objs1[i].tagName.toLowerCase() == "textarea"
					|| objs1[i].tagName.toLowerCase() == "select") {

				if (objs1[i].name.indexOf("norequerido") < 0) {
					objs1[i].setAttribute("required", "required");
				}
			} else {
				var os = objs1[i].getElementsByTagName("input");
				for ( var j = 0; j < os.length; j++) {
					if (os[j].name.indexOf("norequerido") < 0) {
						os[j].setAttribute("required", "required");
					}
				}

				os = objs1[i].getElementsByTagName("textarea");
				for ( var j = 0; j < os.length; j++) {
					if (os[j].name.indexOf("norequerido") < 0) {
						os[j].setAttribute("required", "required");
					}
				}

				os = objs1[i].getElementsByTagName("select");
				for ( var j = 0; j < os.length; j++) {
					if (os[j].name.indexOf("norequerido") < 0) {
						os[j].setAttribute("required", "required");
					}
				}
			}
		}

		for ( var i = 0; i < objs2.length; i++) {
			objs2[i].style.visibility = "hidden";
			objs2[i].style.width = "0px";
			objs2[i].style.height = "0px";
			objs2[i].style.display = "none";

			if (objs2[i].tagName.toLowerCase() == "input"
					|| objs2[i].tagName.toLowerCase() == "textarea"
					|| objs2[i].tagName.toLowerCase() == "select") {
				objs2[i].removeAttribute("required", "required");
			} else {
				var os = objs2[i].getElementsByTagName("input");
				for ( var j = 0; j < os.length; j++) {
					os[j].removeAttribute("required", "required");
				}

				os = objs2[i].getElementsByTagName("textarea");
				for ( var j = 0; j < os.length; j++) {
					os[j].removeAttribute("required", "required");
				}

				os = objs2[i].getElementsByTagName("select");
				for ( var j = 0; j < os.length; j++) {
					os[j].removeAttribute("required", "required");
				}
			}
		}
	}
}