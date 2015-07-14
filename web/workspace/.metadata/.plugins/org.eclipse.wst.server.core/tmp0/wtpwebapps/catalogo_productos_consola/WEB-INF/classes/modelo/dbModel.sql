
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`tipos_archivos_x_extensiones`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`media_inactividad`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`precios_productos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`archivos_x_grupos_equipos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`personalizacion_mt`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`permisologia`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`productos_x_documentos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`productos_x_caracteristicas`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`productos_x_equipos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`usuarios_x_grupos_equipos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`pertenencia_datos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`productos_x_categorias`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`documentos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`productos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`usuarios`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`archivos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`equipos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`ciudades`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`estados`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`tipos_archivos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`elementos_mt`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`elementos_html`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`tipos_documentos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`categorias`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`caracteristicas`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`grupos_equipos`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`servidores`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`cambios_bd`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`monedas`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`paises`;
DROP TABLE IF EXISTS `catalogo_productos_servidor`.`extensiones`;

CREATE TABLE `catalogo_productos_servidor`.`extensiones` (
       `extension` VARCHAR(4) NOT NULL
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`extension`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`paises` (
       `id_pais` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `codigo` CHAR(2)
     , `deshabilitado` BOOLEAN NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_pais`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`monedas` (
       `codigo_moneda` VARCHAR(10) NOT NULL
     , `nombre` VARCHAR(100) NOT NULL
     , `valor` FLOAT NOT NULL
     , `deshabilitado` BOOLEAN NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`codigo_moneda`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`cambios_bd` (
       `id_cambio_bd` INTEGER NOT NULL AUTO_INCREMENT
     , `tabla` VARCHAR(100) NOT NULL
     , `accion` VARCHAR(100) NOT NULL
     , `campos` TEXT
     , `valores_viejos` TEXT
     , `valores_nuevos` TEXT
     , `condicion` TEXT
     , `sentencias` TEXT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_cambio_bd`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`servidores` (
       `id_servidor` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre_servidor` VARCHAR(100) NOT NULL
     , `url` TEXT NOT NULL
     , `puerto` INTEGER
     , `protocolo` VARCHAR(100)
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_servidor`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`grupos_equipos` (
       `id_grupo_equipo` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_grupo_equipo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`caracteristicas` (
       `id_caracteristica` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_caracteristica`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`categorias` (
       `id_categoria` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_categoria`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`tipos_documentos` (
       `id_tipo_documento` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `ruta_logo` VARCHAR(100)
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_tipo_documento`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`elementos_html` (
       `id_elemento_html` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_elemento_html`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`elementos_mt` (
       `id_elemento_mt` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_elemento_mt`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`tipos_archivos` (
       `id_tipo_archivo` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_tipo_archivo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`estados` (
       `id_estado` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `deshabilitado` BOOLEAN NOT NULL
     , `id_pais` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_estado`)
     , INDEX (`id_pais`)
     , CONSTRAINT `FK_estados_1` FOREIGN KEY (`id_pais`)
                  REFERENCES `catalogo_productos_servidor`.`paises` (`id_pais`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`ciudades` (
       `id_ciudad` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `deshabilitado` BOOLEAN NOT NULL
     , `id_estado` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_ciudad`)
     , INDEX (`id_estado`)
     , CONSTRAINT `FK_ciudades_1` FOREIGN KEY (`id_estado`)
                  REFERENCES `catalogo_productos_servidor`.`estados` (`id_estado`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`equipos` (
       `id_equipo` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `direccion` TEXT NOT NULL
     , `id_ciudad` INTEGER NOT NULL
     , `codigo_postal` INTEGER NOT NULL
     , `idioma_pais` VARCHAR(5)
     , `id_grupo_equipo` INTEGER NOT NULL
     , `numero_pantallas` INTEGER NOT NULL
     , `tiempo_inactitividad` INTEGER NOT NULL
     , `tiempo_actualizacion` INTEGER NOT NULL
     , `canonical_host_name` VARCHAR(100)
     , `host_address` VARCHAR(100)
     , `host_name` VARCHAR(100)
     , `is_any_local_address` BOOLEAN
     , `is_link_local_address` BOOLEAN
     , `is_loopback_address` BOOLEAN
     , `is_mc_global` BOOLEAN
     , `is_mc_link_local` BOOLEAN
     , `is_mc_node_local` BOOLEAN
     , `is_mc_org_local` BOOLEAN
     , `is_mc_site_local` BOOLEAN
     , `is_multicast_address` BOOLEAN
     , `is_site_local_address` BOOLEAN
     , `is_ipv4` BOOLEAN
     , `is_ipv6` BOOLEAN
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_equipo`)
     , INDEX (`id_grupo_equipo`)
     , CONSTRAINT `FK_equipos_1` FOREIGN KEY (`id_grupo_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`grupos_equipos` (`id_grupo_equipo`)
     , INDEX (`id_ciudad`)
     , CONSTRAINT `FK_equipos_2` FOREIGN KEY (`id_ciudad`)
                  REFERENCES `catalogo_productos_servidor`.`ciudades` (`id_ciudad`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`archivos` (
       `md5_archivo` VARCHAR(32) NOT NULL
     , `ruta` VARCHAR(100) NOT NULL
     , `id_tipo_archivo` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`md5_archivo`)
     , INDEX (`id_tipo_archivo`)
     , CONSTRAINT `FK_archivos_aplicaciones_1` FOREIGN KEY (`id_tipo_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`tipos_archivos` (`id_tipo_archivo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`usuarios` (
       `usuario` VARCHAR(100) NOT NULL
     , `clave` VARCHAR(100) NOT NULL
     , `nombre` VARCHAR(100) NOT NULL
     , `apellido` VARCHAR(100) NOT NULL
     , `email` VARCHAR(100) NOT NULL
     , `telefono` CHAR(14) NOT NULL
     , `direccion` TEXT NOT NULL
     , `codigo_postal` INTEGER NOT NULL
     , `idioma_pais` VARCHAR(5)
     , `bloqueado` BOOLEAN NOT NULL
     , `eliminado` BOOLEAN NOT NULL
     , `id_ciudad` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`usuario`)
     , INDEX (`id_ciudad`)
     , CONSTRAINT `FK_usuarios_2` FOREIGN KEY (`id_ciudad`)
                  REFERENCES `catalogo_productos_servidor`.`ciudades` (`id_ciudad`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`productos` (
       `id_producto` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `md5_archivo` VARCHAR(32) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_producto`)
     , INDEX (`md5_archivo`)
     , CONSTRAINT `FK_productos_1` FOREIGN KEY (`md5_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`archivos` (`md5_archivo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`documentos` (
       `id_documento` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `enlace_pagina_web` VARCHAR(100)
     , `texto_plano` TEXT
     , `texto_html` TEXT
     , `md5_archivo` VARCHAR(32)
     , `id_producto` INTEGER NOT NULL
     , `predeterminado` BOOLEAN NOT NULL
     , `id_tipo_documento` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_documento`)
     , INDEX (`md5_archivo`)
     , CONSTRAINT `FK_documentos_1` FOREIGN KEY (`md5_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`archivos` (`md5_archivo`)
     , INDEX (`id_tipo_documento`)
     , CONSTRAINT `FK_documentos_2` FOREIGN KEY (`id_tipo_documento`)
                  REFERENCES `catalogo_productos_servidor`.`tipos_documentos` (`id_tipo_documento`)
     , INDEX (`id_producto`)
     , CONSTRAINT `FK_documentos_3` FOREIGN KEY (`id_producto`)
                  REFERENCES `catalogo_productos_servidor`.`productos` (`id_producto`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`productos_x_categorias` (
       `id_producto_x_categoria` INTEGER NOT NULL AUTO_INCREMENT
     , `id_producto` INTEGER NOT NULL
     , `id_categoria` INTEGER NOT NULL
     , `valor` VARCHAR(100) NOT NULL
     , `md5_archivo` VARCHAR(32) NOT NULL
     , `id_producto_x_categoria_padre` INTEGER
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_producto_x_categoria`)
     , INDEX (`id_producto`)
     , CONSTRAINT `FK_productos_x_categorias_1` FOREIGN KEY (`id_producto`)
                  REFERENCES `catalogo_productos_servidor`.`productos` (`id_producto`)
     , INDEX (`id_categoria`)
     , CONSTRAINT `FK_productos_x_categorias_2` FOREIGN KEY (`id_categoria`)
                  REFERENCES `catalogo_productos_servidor`.`categorias` (`id_categoria`)
     , INDEX (`md5_archivo`)
     , CONSTRAINT `FK_productos_x_categorias_3` FOREIGN KEY (`md5_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`archivos` (`md5_archivo`)
     , INDEX (`id_producto_x_categoria_padre`)
     , CONSTRAINT `FK_productos_x_categorias_4` FOREIGN KEY (`id_producto_x_categoria_padre`)
                  REFERENCES `catalogo_productos_servidor`.`productos_x_categorias` (`id_producto_x_categoria`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`pertenencia_datos` (
       `id_pertenencia_datos` INTEGER NOT NULL AUTO_INCREMENT
     , `tabla` VARCHAR(100) NOT NULL
     , `id_clave_tabla` VARCHAR(100) NOT NULL
     , `id_equipo` INTEGER
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_pertenencia_datos`)
     , INDEX (`id_equipo`)
     , CONSTRAINT `FK_pertenencia_datos_1` FOREIGN KEY (`id_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`equipos` (`id_equipo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`usuarios_x_grupos_equipos` (
       `id_usuario_x_grupo_equipo` INTEGER NOT NULL AUTO_INCREMENT
     , `usuario` VARCHAR(100) NOT NULL
     , `id_grupo_equipo` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_usuario_x_grupo_equipo`)
     , INDEX (`usuario`)
     , CONSTRAINT `FK_usuarios_x_grupos_equipos_1` FOREIGN KEY (`usuario`)
                  REFERENCES `catalogo_productos_servidor`.`usuarios` (`usuario`)
     , INDEX (`id_grupo_equipo`)
     , CONSTRAINT `FK_usuarios_x_grupos_equipos_2` FOREIGN KEY (`id_grupo_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`grupos_equipos` (`id_grupo_equipo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`productos_x_equipos` (
       `id_producto_x_equipo` INTEGER NOT NULL AUTO_INCREMENT
     , `id_producto` INTEGER NOT NULL
     , `id_equipo` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_producto_x_equipo`)
     , INDEX (`id_producto`)
     , CONSTRAINT `FK_productos_x_equipos_1` FOREIGN KEY (`id_producto`)
                  REFERENCES `catalogo_productos_servidor`.`productos` (`id_producto`)
     , INDEX (`id_equipo`)
     , CONSTRAINT `FK_productos_x_equipos_2` FOREIGN KEY (`id_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`equipos` (`id_equipo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`productos_x_caracteristicas` (
       `id_producto_x_caracteristica` INTEGER NOT NULL AUTO_INCREMENT
     , `id_producto` INTEGER NOT NULL
     , `id_caracteristica` INTEGER NOT NULL
     , `valor` VARCHAR(100) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_producto_x_caracteristica`)
     , INDEX (`id_producto`)
     , CONSTRAINT `FK_productos_x_caracteristicas_1` FOREIGN KEY (`id_producto`)
                  REFERENCES `catalogo_productos_servidor`.`productos` (`id_producto`)
     , INDEX (`id_caracteristica`)
     , CONSTRAINT `FK_productos_x_caracteristicas_2` FOREIGN KEY (`id_caracteristica`)
                  REFERENCES `catalogo_productos_servidor`.`caracteristicas` (`id_caracteristica`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`productos_x_documentos` (
       `id_producto_x_documento` INTEGER NOT NULL AUTO_INCREMENT
     , `id_producto` INTEGER NOT NULL
     , `id_documento` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_producto_x_documento`)
     , INDEX (`id_documento`)
     , CONSTRAINT `FK_productos_x_documentos_1` FOREIGN KEY (`id_documento`)
                  REFERENCES `catalogo_productos_servidor`.`documentos` (`id_documento`)
     , INDEX (`id_producto`)
     , CONSTRAINT `FK_productos_x_documentos_2` FOREIGN KEY (`id_producto`)
                  REFERENCES `catalogo_productos_servidor`.`productos` (`id_producto`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`permisologia` (
       `id_permisologia` INTEGER NOT NULL AUTO_INCREMENT
     , `id_elemento_html` INTEGER NOT NULL
     , `usuario` VARCHAR(100) NOT NULL
     , `visible` BOOLEAN
     , `enable` BOOLEAN
     , `readonly` BOOLEAN
     , `solicitar_permiso` BOOLEAN
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_permisologia`)
     , INDEX (`usuario`)
     , CONSTRAINT `FK_permisologia_2` FOREIGN KEY (`usuario`)
                  REFERENCES `catalogo_productos_servidor`.`usuarios` (`usuario`)
     , INDEX (`id_elemento_html`)
     , CONSTRAINT `FK_permisologia_1` FOREIGN KEY (`id_elemento_html`)
                  REFERENCES `catalogo_productos_servidor`.`elementos_html` (`id_elemento_html`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`personalizacion_mt` (
       `id_personalizacion_mt` INTEGER NOT NULL AUTO_INCREMENT
     , `id_equipo` INTEGER NOT NULL
     , `id_elemento_mt` INTEGER NOT NULL
     , `vertical` BOOLEAN NOT NULL
     , `posicion_x_porcentaje` FLOAT
     , `posicion_y_porcentaje` FLOAT
     , `ancho_porcentaje` FLOAT
     , `alto_porcentaje` FLOAT
     , `md5_archivo` VARCHAR(32)
     , `tamano_letra_pt` FLOAT
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_personalizacion_mt`)
     , INDEX (`id_elemento_mt`)
     , CONSTRAINT `FK_personalizacion_pantalla_2` FOREIGN KEY (`id_elemento_mt`)
                  REFERENCES `catalogo_productos_servidor`.`elementos_mt` (`id_elemento_mt`)
     , INDEX (`id_equipo`)
     , CONSTRAINT `FK_personalizacion_pantalla_3` FOREIGN KEY (`id_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`equipos` (`id_equipo`)
     , INDEX (`md5_archivo`)
     , CONSTRAINT `FK_personalizacion_mt_3` FOREIGN KEY (`md5_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`archivos` (`md5_archivo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`archivos_x_grupos_equipos` (
       `id_archivo_x_grupo_equipo` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre_original` VARCHAR(100) NOT NULL
     , `md5_archivo` VARCHAR(32) NOT NULL
     , `id_grupo_equipo` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_archivo_x_grupo_equipo`)
     , INDEX (`id_grupo_equipo`)
     , CONSTRAINT `FK_archivos_x_grupos_equipos_1` FOREIGN KEY (`id_grupo_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`grupos_equipos` (`id_grupo_equipo`)
     , INDEX (`md5_archivo`)
     , CONSTRAINT `FK_archivos_x_grupos_equipos_2` FOREIGN KEY (`md5_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`archivos` (`md5_archivo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`precios_productos` (
       `id_precio_producto` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `id_producto` INTEGER NOT NULL
     , `codigo_moneda` VARCHAR(10) NOT NULL
     , `valor` FLOAT NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_precio_producto`)
     , INDEX (`id_producto`)
     , CONSTRAINT `FK_precios_productos_1` FOREIGN KEY (`id_producto`)
                  REFERENCES `catalogo_productos_servidor`.`productos` (`id_producto`)
     , INDEX (`codigo_moneda`)
     , CONSTRAINT `FK_precios_productos_2` FOREIGN KEY (`codigo_moneda`)
                  REFERENCES `catalogo_productos_servidor`.`monedas` (`codigo_moneda`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`media_inactividad` (
       `id_media_inactividad` INTEGER NOT NULL AUTO_INCREMENT
     , `tiempo` INTEGER
     , `md5_archivo` VARCHAR(32) NOT NULL
     , `id_equipo` INTEGER NOT NULL
     , PRIMARY KEY (`id_media_inactividad`)
     , INDEX (`md5_archivo`)
     , CONSTRAINT `FK_media_inactividad_1` FOREIGN KEY (`md5_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`archivos` (`md5_archivo`)
     , INDEX (`id_equipo`)
     , CONSTRAINT `FK_media_inactividad_2` FOREIGN KEY (`id_equipo`)
                  REFERENCES `catalogo_productos_servidor`.`equipos` (`id_equipo`)
) ENGINE InnoDB;

CREATE TABLE `catalogo_productos_servidor`.`tipos_archivos_x_extensiones` (
       `id_tipos_archivos_x_extensiones` INTEGER NOT NULL AUTO_INCREMENT
     , `fecha_creacion` DATETIME NOT NULL
     , `id_tipo_archivo` INTEGER NOT NULL
     , `extension` VARCHAR(4) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_tipos_archivos_x_extensiones`)
     , INDEX (`id_tipo_archivo`)
     , CONSTRAINT `FK_tipos_archivos_x_extensiones_1` FOREIGN KEY (`id_tipo_archivo`)
                  REFERENCES `catalogo_productos_servidor`.`tipos_archivos` (`id_tipo_archivo`)
     , INDEX (`extension`)
     , CONSTRAINT `FK_tipos_archivos_x_extensiones_2` FOREIGN KEY (`extension`)
                  REFERENCES `catalogo_productos_servidor`.`extensiones` (`extension`)
) ENGINE InnoDB;

