<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="modelo.utils.Traductor"%>
<%
	Traductor traductor = (Traductor) session.getAttribute("traductor");
	String[] idioma_pais = new String[2];
	String strIdiomaPais = "";
	if(traductor == null){
		String cookieName = "cookie_idioma_pais";
		Cookie cookies[] = request.getCookies();
		Cookie myCookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					myCookie = cookies[i];
					break;
				}
			}
		}
	
	
		if (myCookie == null) {
			traductor = new Traductor();
			idioma_pais[0] = traductor.getIdioma();
			idioma_pais[1] = traductor.getPais();
			myCookie = new Cookie(cookieName, idioma_pais[0] + "_"
					+ idioma_pais[1]);
			myCookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(myCookie);
		} else {
			idioma_pais = myCookie.getValue().split("_");
			traductor = new Traductor(idioma_pais[0], idioma_pais[1]);
		}
		
		
		
	}else{
		idioma_pais[0] = traductor.getIdioma();
		idioma_pais[1] = traductor.getPais();
	}
	
		strIdiomaPais = idioma_pais[0] + "_" + idioma_pais[1];


	String[] idiomasDisponibles = traductor
			.getIdiomasPaisesDisponibles();
%>