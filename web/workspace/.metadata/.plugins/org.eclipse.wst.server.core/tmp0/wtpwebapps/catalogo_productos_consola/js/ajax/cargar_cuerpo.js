// Cambia estos parametros
//var seconds = 5; // el tiempo en que se refresca
var divid_cargar_cuerpo = "cuerpo"; // el div que quieres!
var url_cargar_cuerpo = "../php/plantillas/"; // el archivo que ira en el div
////////////////////////////////
//
// Refreshing the DIV
//
////////////////////////////////
function ajaxCargarCuerpo(nombreCuerpo){
// The XMLHttpRequest object
	url_cargar_cuerpo = "../php/plantillas/"+nombreCuerpo;
var xmlHttp;
try{
xmlHttp=new XMLHttpRequest(); // Firefox, Opera 8.0+, Safari
}
catch (e){
try{
xmlHttp=new ActiveXObject("Msxml2.XMLHTTP"); // Internet Explorer
}
catch (e){
try{
xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
}
catch (e){
alert("Tu explorador no soporta AJAX.");
return false;
}
}
}
// Timestamp for preventing IE caching the GET request
fetch_unix_timestamp = function()
{
return parseInt(new Date().getTime().toString().substring(0, 10));
};
var timestamp = fetch_unix_timestamp();
//var q = location.href.split("?");
var nocacheurl = url_cargar_cuerpo+"?t="+timestamp;
// The code...
xmlHttp.onreadystatechange=function(){
if(xmlHttp.readyState==4){
		
	var resultado = xmlHttp.responseText.replace("/^\s*|\s*$\g","");
	
	if (resultado.indexOf("<expiro_sesion>") != -1) {
		str_error = resultado.split("<expiro_sesion>")[1].split("</fin_error>")[0];
		location.href="../../../entrada_apps_web_service/vista/php/index.php?"+str_error;
	}else{
		

	
	document.getElementById(divid_cargar_cuerpo).innerHTML = resultado;
	
	if(nombreCuerpo.indexOf("cuentas_usuarios") != -1){
		var datosFiltros = document.getElementsByName("hidden_filtros");
		

		
		for ( var i = 0; i < datosFiltros.length; i++) {

			var datos = datosFiltros[i].value.split("&");
			for ( var j = 0; j < datos.length; j++) {
					
				
				var obj = document.getElementById(datos[j].split("=")[0]);

				
				var opciones = obj.options;
				
				var poner = true;
				
				for ( var k = 0; k < opciones.length; k++) {
					if(datos[j].split("=")[1] == opciones[k].value){
						poner = false;
						break;
					}
				}
				
				if(poner){
					
					obj.options[obj.options.length] = new Option(datos[j].split("=")[1], datos[j].split("=")[1]);
				}

			}
		}
		
		cargarCalendarioFechaDesde("fecha_desde", "f_btn1", 0);
		
		cargarCalendarioFechaHasta("fecha_hasta", "f_btn2", 1);
		
	}
	
	}
	//setTimeout("aparecerEventos('"+salon+"');", 12000);
//setTimeout('refreshdiv()',seconds*1000);
}else{
	//Cargando...
	document.getElementById(divid_cargar_cuerpo).innerHTML = "Cargando...";
}
};
xmlHttp.open("GET",nocacheurl,true);
xmlHttp.send(null);
}
// Start the refreshing process
/*window.onload = function startrefresh(){
setTimeout('refreshdiv()',seconds*1000);
setTimeout('refreshdivClima()',secondsClima*1000);
setTimeout('refreshdivCartelera()',secondsClima*1000);
}*/