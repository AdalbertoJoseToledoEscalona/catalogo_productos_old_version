/**
 * 
 */

function setIdiomaPais(cmbIdiomas) {
	var dir = location.href;
	if(dir.indexOf("jsp/index.jsp") >= 0){
		var expires=new Date();
		expires.setDate(expires.getDate()+365);
		setCookie("cookie_idioma_pais", cmbIdiomas.options[cmbIdiomas.selectedIndex].value, null, null, expires);
		location.reload();
	}else{
		ajaxSetIdiomaPais(cmbIdiomas);
	}
}