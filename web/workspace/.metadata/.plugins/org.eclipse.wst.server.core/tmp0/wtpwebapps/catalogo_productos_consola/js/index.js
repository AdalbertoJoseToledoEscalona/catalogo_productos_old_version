/**
 * 
 */

function llenarGrupoEquipos() {
	strUsuario = document.getElementById("txtUsuario").value;
	strClave = document.getElementById("pwdClave").value;
	objCmbGrupoEquipos = document.getElementById("cmbGrupoEquipos");
	
	objCmbGrupoEquipos.setAttribute("disabled", "disabled");

	if (strUsuario.length == 0 || strClave.length == 0) {
		objCmbGrupoEquipos.options[0].selected = true;
	} else {
		ajaxLlenarGrupoEquipos(strUsuario, strClave, objCmbGrupoEquipos);
	}
}