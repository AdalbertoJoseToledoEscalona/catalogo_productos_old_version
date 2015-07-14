INSERT INTO paises (nombre, codigo, deshabilitado, fecha_hora_creacion, usuario_bd_creador)
VALUES ("Venezuela", "VE", 0, NOW(), CURRENT_USER());

INSERT INTO estados (nombre, deshabilitado, id_pais, fecha_hora_creacion, usuario_bd_creador)
SELECT "Distrito Capital", 0, id_pais, NOW(), CURRENT_USER() FROM paises WHERE codigo = "VE";

INSERT INTO ciudades (nombre, deshabilitado, id_estado, fecha_hora_creacion, usuario_bd_creador)
SELECT "Caracas", 0, id_estado, NOW(), CURRENT_USER() FROM estados WHERE nombre = "Distrito Capital";

INSERT INTO usuarios (usuario, clave, nombre, apellido, email, telefono, direccion, codigo_postal, bloqueado, eliminado, id_ciudad, fecha_hora_creacion, usuario_bd_creador)
SELECT "admin", "12345678", "Adalberto", "Toledo", "adalberto.toledo@gmail.com", "05804160142958", "Quinta Crespo", 1010, 0, 0, id_ciudad, NOW(), CURRENT_USER()
FROM ciudades WHERE nombre = "Caracas";

INSERT INTO grupos_equipos (nombre, descripcion, fecha_hora_creacion, usuario_bd_creador)
VALUES ("Grupo 1", "Prueba Grupo 1", NOW(), CURRENT_USER());

INSERT INTO equipos (nombre, descripcion, direccion, id_ciudad, codigo_postal, id_grupo_equipo, numero_pantallas, tiempo_inactitividad, tiempo_actualizacion, fecha_hora_creacion, usuario_bd_creador)
SELECT "Equipo 1", "Prueba Equipo 1", "Quinta Crespo", id_ciudad, 1010, id_grupo_equipo, 1, 60, 60, NOW(), CURRENT_USER()
FROM ciudades, grupos_equipos WHERE ciudades.nombre = "Caracas" AND grupos_equipos.nombre = "Grupo 1";

INSERT INTO usuarios_x_grupos_equipos (usuario, id_grupo_equipo, fecha_hora_creacion, usuario_bd_creador)
SELECT usuario, id_grupo_equipo, NOW(), CURRENT_USER()
FROM usuarios, grupos_equipos WHERE usuario = "admin" AND grupos_equipos.nombre = "Grupo 1";