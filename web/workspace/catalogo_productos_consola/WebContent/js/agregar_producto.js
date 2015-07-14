/**
 * 
 */
function validarAgregarProducto(f) {
	var error;
	if (!validarFormulario(f)) {
		error = true;
	} else {
		var objLogotipo = document.getElementById("logotipo");
		var objsCheckBoxLogos = document.getElementsByName("checkbox_logo");

		if (objsCheckBoxLogos.length > 0) {
			if (objLogotipo.value == "") {

				error = true;
				var checkBox = 0;
				for ( var i = 0; i < objsCheckBoxLogos.length; i++) {
					if (objsCheckBoxLogos[i].checked) {
						checkBox++;
						if (checkBox > 1) {
							error = true;
							break;
						} else {
							error = false;
						}
					}
				}

				if (error) {
					mostrarMensaje(agregar_producto_error1, true);
				}

			} else {

				error = false;
				for ( var i = 0; i < objsCheckBoxLogos.length; i++) {
					if (objsCheckBoxLogos[i].checked) {
						error = true;
						break;
					}
				}

				if (error) {
					mostrarMensaje(agregar_producto_error2, true);
				} else {
					if (!validarImagen(objLogotipo)) {
						error = true;
					}
				}
			}
		} else {
			if (!validarImagen(objLogotipo)) {
				error = true;
			} else {
				error = false;
			}
		}
	}
	return !error;
}

function llenoArchivoLogo(objArchivoLogo) {
	var checkBoxLogos = document.getElementsByName("checkbox_logo");
	if (objArchivoLogo.value == "") {
		objArchivoLogo.setAttribute("required", "required");
		for ( var i = 0; i < checkBoxLogos.length; i++) {
			//checkBoxLogos[i].setAttribute("required", "required");
		}
	} else {
		objArchivoLogo.setAttribute("required", "required");
		for ( var i = 0; i < checkBoxLogos.length; i++) {
			checkBoxLogos[i].checked = false;
			//checkBoxLogos[i].removeAttribute("required");
		}
	}
}

function seleccionoCheckBoxLogo(objcheckBoxLogo) {
	var objArchivoLogo = document.getElementById("logotipo");
	var checkBoxLogos = document.getElementsByName("checkbox_logo");
	if (objcheckBoxLogo.checked) {
		objArchivoLogo.value = "";
		objArchivoLogo.removeAttribute("required");
		for ( var i = 0; i < checkBoxLogos.length; i++) {
			//checkBoxLogos[i].setAttribute("required", "required");
			if (checkBoxLogos[i].value != objcheckBoxLogo.value) {
				checkBoxLogos[i].checked = false;
			}
		}
	} else {
		if (objArchivoLogo.value == "") {
			var hayChecked = false;
			for ( var i = 0; i < checkBoxLogos.length; i++) {
				//checkBoxLogos[i].setAttribute("required", "required");
				if (checkBoxLogos[i].checked) {
					hayChecked = true;
				}
			}

			if (hayChecked) {
				objArchivoLogo.removeAttribute("required");
			} else {
				objArchivoLogo.setAttribute("required", "required");
			}
		} else {
			objArchivoLogo.setAttribute("required", "required");
			for ( var i = 0; i < checkBoxLogos.length; i++) {
				//checkBoxLogos[i].removeAttribute("required");
				checkBoxLogos[i].checked = false;
			}
		}
	}
}

function verificarEstadoCampos() {
	var obj = document.getElementById("logotipo");
	llenoArchivoLogo(obj);
	obj = checkBoxLogos = document.getElementsByName("checkbox_logo")[0];
	seleccionoCheckBoxLogo(obj);
}