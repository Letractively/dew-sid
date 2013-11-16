SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `condominio` ;
CREATE SCHEMA IF NOT EXISTS `condominio` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `condominio` ;

-- -----------------------------------------------------
-- Table `condominio`.`residente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`residente` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`residente` (
  `idresidente` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apellidos` VARCHAR(45) NULL ,
  `dni` CHAR(8) NULL ,
  `fecha_nac` DATETIME NULL ,
  `email` VARCHAR(45) NULL ,
  `password` VARCHAR(12) NULL ,
  PRIMARY KEY (`idresidente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `condominio`.`vivienda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`vivienda` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`vivienda` (
  `idvivienda` INT NOT NULL AUTO_INCREMENT ,
  `zona` VARCHAR(50) NULL ,
  `edificio` VARCHAR(50) NULL ,
  `numero` VARCHAR(4) NULL ,
  `metraje` DECIMAL(5,2) NULL ,
  `tipo` CHAR(1) NULL ,
  `direccion` VARCHAR(250) NULL ,
  `idresidente` INT NOT NULL ,
  PRIMARY KEY (`idvivienda`, `idresidente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `condominio`.`cuota`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`cuota` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`cuota` (
  `idcuota` INT(11) NOT NULL AUTO_INCREMENT ,
  `idvivienda` INT NOT NULL ,
  `periodo` CHAR(2) NULL ,
  `anio` INT NULL ,
  `importe` DECIMAL(12,2) NULL ,
  `fech_venc` DATE NULL ,
  `estado` CHAR(1) NULL ,
  `tipo_pago` CHAR(1) NULL ,
  `fech_pago` DATETIME NULL ,
  PRIMARY KEY (`idcuota`, `idvivienda`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `condominio`.`queja`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`queja` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`queja` (
  `idqueja` INT(11) NOT NULL AUTO_INCREMENT COMMENT '		' ,
  `tipo_queja` CHAR(1) NULL ,
  `motivo` TEXT NULL ,
  `fech_queja` DATE NULL ,
  `idresidente` INT NOT NULL ,
  PRIMARY KEY (`idqueja`, `idresidente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `condominio`.`mensajeria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`mensajeria` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`mensajeria` (
  `idmensajeria` INT(11) NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(50) NULL ,
  `contenido` TEXT NULL ,
  `fech_public` DATE NULL ,
  `idresidente` INT NOT NULL ,
  PRIMARY KEY (`idmensajeria`, `idresidente`) )
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `condominio`.`visita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`visita` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`visita` (
  `idvisita` INT NOT NULL AUTO_INCREMENT ,
  `dni_visita` INT(11) NULL ,
  `nombre` VARCHAR(50) NULL ,
  `fech_visita` DATE NULL ,
  `idresidente` INT NOT NULL ,
  PRIMARY KEY (`idvisita`, `idresidente`) )
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `condominio`.`junta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`junta` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`junta` (
  `idjunta` INT NOT NULL AUTO_INCREMENT ,
  `fecha` DATE NULL ,
  `hora` TIME NULL ,
  `expositor` VARCHAR(50) NULL ,
  `tema` TEXT NULL ,
  `acuerdo` TEXT NULL ,
  `idresidente` INT NOT NULL ,
  PRIMARY KEY (`idjunta`, `idresidente`) )
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `condominio`.`espaciocomun`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`espaciocomun` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`espaciocomun` (
  `idespaciocomun` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NULL ,
  `tipo` CHAR(1) NULL ,
  PRIMARY KEY (`idespaciocomun`) )
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `condominio`.`reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `condominio`.`reserva` ;

CREATE  TABLE IF NOT EXISTS `condominio`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT ,
  `fecha` DATE NULL ,
  `hora` TIME NULL ,
  `idespaciocomun` INT NOT NULL ,
  `idresidente` INT NOT NULL ,
  PRIMARY KEY (`idreserva`, `idespaciocomun`, `idresidente`) )
ENGINE = MyISAM;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
