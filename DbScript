-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Proyecto` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Localización` VARCHAR(200) NULL,
  `Nombre` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Movimiento` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Proyecto_ID` INT NOT NULL,
  `Fecha` DATE NOT NULL,
  `Cantidad` FLOAT NOT NULL,
  `Descripcion` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Movimiento_Proyecto1_idx` (`Proyecto_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Movimiento_Proyecto1`
    FOREIGN KEY (`Proyecto_ID`)
    REFERENCES `mydb`.`Proyecto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ingreso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ingreso` (
  `Movimiento_ID` INT NOT NULL,
  `Procedencia` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Movimiento_ID`),
  CONSTRAINT `fk_Ingreso_Movimiento`
    FOREIGN KEY (`Movimiento_ID`)
    REFERENCES `mydb`.`Movimiento` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sede`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sede` (
  `Proyecto_ID` INT NOT NULL,
  `Provincia` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Proyecto_ID`),
  CONSTRAINT `fk_Sede_Proyecto1`
    FOREIGN KEY (`Proyecto_ID`)
    REFERENCES `mydb`.`Proyecto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Persona` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NULL,
  `Apellidos` VARCHAR(50) NULL,
  `Sexo` VARCHAR(10) NOT NULL,
  `Foto` VARBINARY(65000) NULL,
  `FechaNacimiento` DATE NULL,
  `FechaAlta` DATE NOT NULL,
  `FechaBaja` DATE NULL,
  `Comentarios` VARCHAR(300) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Coordinador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Coordinador` (
  `Persona_ID` INT NOT NULL,
  `Proyecto_ID` INT NOT NULL,
  `NivelPermisos` INT NOT NULL,
  `Posicion` VARCHAR(50) NOT NULL,
  `Telefono` VARCHAR(20) NULL,
  `Direccion` VARCHAR(200) NULL,
  PRIMARY KEY (`Persona_ID`, `Proyecto_ID`),
  INDEX `fk_Coordinador_Proyecto1_idx` (`Proyecto_ID` ASC) VISIBLE,
  UNIQUE INDEX `Persona_ID_UNIQUE` (`Persona_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Coordinador_Persona1`
    FOREIGN KEY (`Persona_ID`)
    REFERENCES `mydb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Coordinador_Proyecto1`
    FOREIGN KEY (`Proyecto_ID`)
    REFERENCES `mydb`.`Proyecto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Beneficiario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Beneficiario` (
  `Persona_ID` INT NOT NULL,
  `Proyecto_ID` INT NOT NULL,
  `Coordinador_Persona_ID` INT NOT NULL,
  `FechaAltaProyecto` DATE NULL,
  `FechaBajaProyecto` DATE NULL,
  `Beca` VARCHAR(50) NULL,
  `NotaCurso` FLOAT NULL,
  `ComunidadNacimiento` VARCHAR(50) NULL,
  `ComunidadResidencia` VARCHAR(50) NULL,
  PRIMARY KEY (`Persona_ID`, `Proyecto_ID`),
  INDEX `fk_Beneficiario_Proyecto1_idx` (`Proyecto_ID` ASC) VISIBLE,
  INDEX `fk_Beneficiario_Coordinador1_idx` (`Coordinador_Persona_ID` ASC) VISIBLE,
  UNIQUE INDEX `Persona_ID_UNIQUE` (`Persona_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Beneficiario_Persona1`
    FOREIGN KEY (`Persona_ID`)
    REFERENCES `mydb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Beneficiario_Proyecto1`
    FOREIGN KEY (`Proyecto_ID`)
    REFERENCES `mydb`.`Proyecto` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Beneficiario_Coordinador1`
    FOREIGN KEY (`Coordinador_Persona_ID`)
    REFERENCES `mydb`.`Coordinador` (`Persona_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Egreso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Egreso` (
  `Movimiento_ID` INT NOT NULL,
  `Beneficiario_Persona_ID` INT NOT NULL,
  `NombreBeneficiario` VARCHAR(50) NULL,
  PRIMARY KEY (`Movimiento_ID`),
  INDEX `fk_Egreso_Beneficiario1_idx` (`Beneficiario_Persona_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Egreso_Movimiento1`
    FOREIGN KEY (`Movimiento_ID`)
    REFERENCES `mydb`.`Movimiento` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Egreso_Beneficiario1`
    FOREIGN KEY (`Beneficiario_Persona_ID`)
    REFERENCES `mydb`.`Beneficiario` (`Persona_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Socio` (
  `Persona_ID` INT NOT NULL,
  `DNI` VARCHAR(10) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `CodigoPostal` INT NOT NULL,
  `Poblacion` VARCHAR(50) NOT NULL,
  `Provincia` VARCHAR(50) NOT NULL,
  `Direccion` VARCHAR(200) NOT NULL,
  `Telefono` VARCHAR(20) NULL,
  `Movil` VARCHAR(20) NULL,
  `Certificado` TINYINT NOT NULL,
  PRIMARY KEY (`Persona_ID`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE,
  CONSTRAINT `fk_Socio_Persona1`
    FOREIGN KEY (`Persona_ID`)
    REFERENCES `mydb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Apadrinamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Apadrinamiento` (
  `Beneficiario_Persona_ID` INT NOT NULL,
  `Socio_Persona_ID` INT NOT NULL,
  `Sede_Proyecto_ID` INT NOT NULL,
  INDEX `fk_Apadrinamiento_Beneficiario1_idx` (`Beneficiario_Persona_ID` ASC) VISIBLE,
  INDEX `fk_Apadrinamiento_Socio1_idx` (`Socio_Persona_ID` ASC) VISIBLE,
  INDEX `fk_Apadrinamiento_Sede1_idx` (`Sede_Proyecto_ID` ASC) VISIBLE,
  PRIMARY KEY (`Beneficiario_Persona_ID`),
  CONSTRAINT `fk_Apadrinamiento_Beneficiario1`
    FOREIGN KEY (`Beneficiario_Persona_ID`)
    REFERENCES `mydb`.`Beneficiario` (`Persona_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Apadrinamiento_Socio1`
    FOREIGN KEY (`Socio_Persona_ID`)
    REFERENCES `mydb`.`Socio` (`Persona_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Apadrinamiento_Sede1`
    FOREIGN KEY (`Sede_Proyecto_ID`)
    REFERENCES `mydb`.`Sede` (`Proyecto_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cartas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cartas` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NOT NULL,
  `Apadrinamiento_Beneficiario_Persona_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `Apadrinamiento_Beneficiario_Persona_ID`),
  INDEX `fk_Cartas_Apadrinamiento1_idx` (`Apadrinamiento_Beneficiario_Persona_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Cartas_Apadrinamiento1`
    FOREIGN KEY (`Apadrinamiento_Beneficiario_Persona_ID`)
    REFERENCES `mydb`.`Apadrinamiento` (`Beneficiario_Persona_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
