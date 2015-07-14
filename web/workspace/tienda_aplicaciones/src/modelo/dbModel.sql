
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`compatibilidad_instaladores`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`pertenencia_datos`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`videos_youtube`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`tipos_archivos_x_extensiones`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`aplicaciones_x_archivos`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`inet_addresses`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`instalaciones`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`descargas`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`items_cart`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`archivos_aplicaciones`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`network_interfaces`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`licencias`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`equipos`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`cartinfo`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`usuarios`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`ciudades`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`estados`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`instaladores`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`aplicaciones`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`servidores`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`cambios_bd`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`monedas`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`paises`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`extensiones`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`tipos_archivos`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`arquitecturas_sistemas_operativos`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`sistemas_operativos`;
DROP TABLE IF EXISTS `tienda_aplicaciones_servidor`.`tipos_usuarios`;

CREATE TABLE `tienda_aplicaciones_servidor`.`tipos_usuarios` (
       `id_tipo_usuario` INTEGER NOT NULL AUTO_INCREMENT
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
     , PRIMARY KEY (`id_tipo_usuario`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`sistemas_operativos` (
       `id_sistema_operativo` INTEGER NOT NULL
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
     , PRIMARY KEY (`id_sistema_operativo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`arquitecturas_sistemas_operativos` (
       `id_arquitectura_sistema_operativo` INTEGER NOT NULL AUTO_INCREMENT
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
     , PRIMARY KEY (`id_arquitectura_sistema_operativo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`tipos_archivos` (
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

CREATE TABLE `tienda_aplicaciones_servidor`.`extensiones` (
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

CREATE TABLE `tienda_aplicaciones_servidor`.`paises` (
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

CREATE TABLE `tienda_aplicaciones_servidor`.`monedas` (
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

CREATE TABLE `tienda_aplicaciones_servidor`.`cambios_bd` (
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

CREATE TABLE `tienda_aplicaciones_servidor`.`servidores` (
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

CREATE TABLE `tienda_aplicaciones_servidor`.`aplicaciones` (
       `id_aplicacion` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `ruta_logo` VARCHAR(100) NOT NULL
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
     , PRIMARY KEY (`id_aplicacion`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`instaladores` (
       `id_instalador` INTEGER NOT NULL AUTO_INCREMENT
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `ruta_icono` VARCHAR(100)
     , `deshabilitado` BOOLEAN NOT NULL
     , `id_aplicacion` INTEGER NOT NULL
     , `precio` FLOAT NOT NULL
     , `codigo_moneda` VARCHAR(10) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_instalador`)
     , INDEX (`id_aplicacion`)
     , CONSTRAINT `FK_instaladores_1` FOREIGN KEY (`id_aplicacion`)
                  REFERENCES `tienda_aplicaciones_servidor`.`aplicaciones` (`id_aplicacion`)
     , INDEX (`codigo_moneda`)
     , CONSTRAINT `FK_instaladores_2` FOREIGN KEY (`codigo_moneda`)
                  REFERENCES `tienda_aplicaciones_servidor`.`monedas` (`codigo_moneda`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`estados` (
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
                  REFERENCES `tienda_aplicaciones_servidor`.`paises` (`id_pais`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`ciudades` (
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
                  REFERENCES `tienda_aplicaciones_servidor`.`estados` (`id_estado`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`usuarios` (
       `usuario` VARCHAR(100) NOT NULL
     , `clave` VARCHAR(100) NOT NULL
     , `nombre` VARCHAR(100) NOT NULL
     , `apellido` VARCHAR(100) NOT NULL
     , `email` VARCHAR(100) NOT NULL
     , `telefono` VARCHAR(100) NOT NULL
     , `direccion` TEXT NOT NULL
     , `codigo_postal` INTEGER NOT NULL
     , `bloqueado` BOOLEAN NOT NULL
     , `eliminado` BOOLEAN NOT NULL
     , `id_tipo_usuario` INTEGER NOT NULL
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
     , INDEX (`id_tipo_usuario`)
     , CONSTRAINT `FK_usuarios_1` FOREIGN KEY (`id_tipo_usuario`)
                  REFERENCES `tienda_aplicaciones_servidor`.`tipos_usuarios` (`id_tipo_usuario`)
     , INDEX (`id_ciudad`)
     , CONSTRAINT `FK_usuarios_2` FOREIGN KEY (`id_ciudad`)
                  REFERENCES `tienda_aplicaciones_servidor`.`ciudades` (`id_ciudad`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`cartinfo` (
       `idcartinfo` INTEGER NOT NULL AUTO_INCREMENT
     , `usuario` VARCHAR(100) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`idcartinfo`)
     , INDEX (`usuario`)
     , CONSTRAINT `FK_cartinfo_1` FOREIGN KEY (`usuario`)
                  REFERENCES `tienda_aplicaciones_servidor`.`usuarios` (`usuario`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`equipos` (
       `id_equipo` INTEGER NOT NULL AUTO_INCREMENT
     , `direccion` TEXT NOT NULL
     , `id_ciudad` INTEGER NOT NULL
     , `codigo_postal` INTEGER NOT NULL
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
     , INDEX (`id_ciudad`)
     , CONSTRAINT `FK_equipos_1` FOREIGN KEY (`id_ciudad`)
                  REFERENCES `tienda_aplicaciones_servidor`.`ciudades` (`id_ciudad`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`licencias` (
       `id_licencia` INTEGER NOT NULL AUTO_INCREMENT
     , `numero_equipos` INTEGER NOT NULL
     , `dias_validez` INTEGER NOT NULL
     , `precio` FLOAT NOT NULL
     , `codigo_moneda` VARCHAR(10) NOT NULL
     , `valor_moneda` FLOAT NOT NULL
     , `id_instalador` INTEGER NOT NULL
     , `usuario` VARCHAR(100) NOT NULL
     , `remote_address` VARCHAR(100)
     , `remote_host` VARCHAR(100)
     , `remote_port` INTEGER
     , `remote_user` VARCHAR(100)
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_licencia`)
     , INDEX (`id_instalador`)
     , CONSTRAINT `FK_licencias_1` FOREIGN KEY (`id_instalador`)
                  REFERENCES `tienda_aplicaciones_servidor`.`instaladores` (`id_instalador`)
     , INDEX (`usuario`)
     , CONSTRAINT `FK_licencias_2` FOREIGN KEY (`usuario`)
                  REFERENCES `tienda_aplicaciones_servidor`.`usuarios` (`usuario`)
     , INDEX (`codigo_moneda`)
     , CONSTRAINT `FK_licencias_3` FOREIGN KEY (`codigo_moneda`)
                  REFERENCES `tienda_aplicaciones_servidor`.`monedas` (`codigo_moneda`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`network_interfaces` (
       `hardware_address` VARCHAR(17) NOT NULL
     , `display_name` VARCHAR(100)
     , `index_hardware` INTEGER
     , `mtu` INTEGER
     , `name` VARCHAR(100)
     , `is_loopback` BOOLEAN
     , `is_point_to_point` BOOLEAN
     , `is_up` BOOLEAN
     , `is_virtual` BOOLEAN
     , `supports_multicast` BOOLEAN
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
     , PRIMARY KEY (`hardware_address`)
     , INDEX (`id_equipo`)
     , CONSTRAINT `FK_network_interfaces_1` FOREIGN KEY (`id_equipo`)
                  REFERENCES `tienda_aplicaciones_servidor`.`equipos` (`id_equipo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`archivos_aplicaciones` (
       `md5_archivo_aplicacion` VARCHAR(32) NOT NULL
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
     , PRIMARY KEY (`md5_archivo_aplicacion`)
     , INDEX (`id_tipo_archivo`)
     , CONSTRAINT `FK_archivos_aplicaciones_1` FOREIGN KEY (`id_tipo_archivo`)
                  REFERENCES `tienda_aplicaciones_servidor`.`tipos_archivos` (`id_tipo_archivo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`items_cart` (
       `id_Item_cart` INTEGER NOT NULL AUTO_INCREMENT
     , `numero_equipos` INTEGER NOT NULL
     , `dias_validez` INTEGER NOT NULL
     , `id_instalador` INTEGER NOT NULL
     , `idcartinfo` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_Item_cart`)
     , INDEX (`id_instalador`)
     , CONSTRAINT `FK_carts_1` FOREIGN KEY (`id_instalador`)
                  REFERENCES `tienda_aplicaciones_servidor`.`instaladores` (`id_instalador`)
     , INDEX (`idcartinfo`)
     , CONSTRAINT `FK_carts_2` FOREIGN KEY (`idcartinfo`)
                  REFERENCES `tienda_aplicaciones_servidor`.`cartinfo` (`idcartinfo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`descargas` (
       `id_descarga` INTEGER NOT NULL AUTO_INCREMENT
     , `id_licencia` INTEGER NOT NULL
     , `remote_address` VARCHAR(100)
     , `remote_host` VARCHAR(100)
     , `remote_port` INTEGER
     , `remote_user` VARCHAR(100)
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_descarga`)
     , INDEX (`id_licencia`)
     , CONSTRAINT `FK_descargas_1` FOREIGN KEY (`id_licencia`)
                  REFERENCES `tienda_aplicaciones_servidor`.`licencias` (`id_licencia`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`instalaciones` (
       `id_instalacion` INTEGER NOT NULL AUTO_INCREMENT
     , `id_licencia` INTEGER NOT NULL
     , `remote_address` VARCHAR(100)
     , `remote_host` VARCHAR(100)
     , `remote_port` INTEGER
     , `remote_user` VARCHAR(100)
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
     , PRIMARY KEY (`id_instalacion`)
     , INDEX (`id_licencia`)
     , CONSTRAINT `FK_instalaciones_1` FOREIGN KEY (`id_licencia`)
                  REFERENCES `tienda_aplicaciones_servidor`.`licencias` (`id_licencia`)
     , INDEX (`id_equipo`)
     , CONSTRAINT `FK_instalaciones_2` FOREIGN KEY (`id_equipo`)
                  REFERENCES `tienda_aplicaciones_servidor`.`equipos` (`id_equipo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`inet_addresses` (
       `id_inet_addresses` INTEGER NOT NULL AUTO_INCREMENT
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
     , `hardware_address` VARCHAR(17) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_inet_addresses`)
     , INDEX (`hardware_address`)
     , CONSTRAINT `FK_inet_addresses_1` FOREIGN KEY (`hardware_address`)
                  REFERENCES `tienda_aplicaciones_servidor`.`network_interfaces` (`hardware_address`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`aplicaciones_x_archivos` (
       `id_aplicaciones_x_archivos` INTEGER NOT NULL AUTO_INCREMENT
     , `id_aplicacion` INTEGER NOT NULL
     , `md5_archivo_aplicacion` VARCHAR(32) NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_aplicaciones_x_archivos`)
     , INDEX (`id_aplicacion`)
     , CONSTRAINT `FK_aplicaciones_x_archivos_1` FOREIGN KEY (`id_aplicacion`)
                  REFERENCES `tienda_aplicaciones_servidor`.`aplicaciones` (`id_aplicacion`)
     , INDEX (`md5_archivo_aplicacion`)
     , CONSTRAINT `FK_aplicaciones_x_archivos_2` FOREIGN KEY (`md5_archivo_aplicacion`)
                  REFERENCES `tienda_aplicaciones_servidor`.`archivos_aplicaciones` (`md5_archivo_aplicacion`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`tipos_archivos_x_extensiones` (
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
                  REFERENCES `tienda_aplicaciones_servidor`.`tipos_archivos` (`id_tipo_archivo`)
     , INDEX (`extension`)
     , CONSTRAINT `FK_tipos_archivos_x_extensiones_2` FOREIGN KEY (`extension`)
                  REFERENCES `tienda_aplicaciones_servidor`.`extensiones` (`extension`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`videos_youtube` (
       `id_video_youtube` INTEGER NOT NULL AUTO_INCREMENT
     , `url_youtube` VARCHAR(100) NOT NULL
     , `nombre` VARCHAR(100) NOT NULL
     , `descripcion` TEXT
     , `id_aplicacion` INTEGER NOT NULL
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_video_youtube`)
     , INDEX (`id_aplicacion`)
     , CONSTRAINT `FK_videos_youtube_1` FOREIGN KEY (`id_aplicacion`)
                  REFERENCES `tienda_aplicaciones_servidor`.`aplicaciones` (`id_aplicacion`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`pertenencia_datos` (
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
                  REFERENCES `tienda_aplicaciones_servidor`.`equipos` (`id_equipo`)
) ENGINE InnoDB;

CREATE TABLE `tienda_aplicaciones_servidor`.`compatibilidad_instaladores` (
       `id_compatibilidad_instalador` INTEGER NOT NULL AUTO_INCREMENT
     , `id_instalador` INTEGER NOT NULL
     , `id_sistema_operativo` INTEGER NOT NULL
     , `id_arquitectura_sistema_operativo` INTEGER
     , `fecha_hora_creacion` DATETIME NOT NULL
     , `fecha_hora_actualizacion` DATETIME
     , `id_usuario_creador` INTEGER
     , `id_usuario_actualizacion` INTEGER
     , `id_origen` INTEGER
     , `id_equipo_origen` INTEGER
     , `id_equipo_actualizacion` INTEGER
     , `usuario_bd_creador` VARCHAR(100) NOT NULL
     , `usuario_bd_actualizacion` VARCHAR(100)
     , PRIMARY KEY (`id_compatibilidad_instalador`)
     , INDEX (`id_instalador`)
     , CONSTRAINT `FK_compatibilidad_instaladores_1` FOREIGN KEY (`id_instalador`)
                  REFERENCES `tienda_aplicaciones_servidor`.`instaladores` (`id_instalador`)
     , INDEX (`id_sistema_operativo`)
     , CONSTRAINT `FK_compatibilidad_instaladores_2` FOREIGN KEY (`id_sistema_operativo`)
                  REFERENCES `tienda_aplicaciones_servidor`.`sistemas_operativos` (`id_sistema_operativo`)
     , INDEX (`id_arquitectura_sistema_operativo`)
     , CONSTRAINT `FK_compatibilidad_instaladores_3` FOREIGN KEY (`id_arquitectura_sistema_operativo`)
                  REFERENCES `tienda_aplicaciones_servidor`.`arquitecturas_sistemas_operativos` (`id_arquitectura_sistema_operativo`)
) ENGINE InnoDB;

