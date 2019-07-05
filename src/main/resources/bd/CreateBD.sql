SET FOREIGN_KEY_CHECKS=0 
;

/* Drop Tables */
DROP TABLE IF EXISTS `Docente` CASCADE
;

DROP TABLE IF EXISTS `Calendario` CASCADE
;

DROP TABLE IF EXISTS `SemestreAcademico` CASCADE
;

DROP TABLE IF EXISTS `Usuario` CASCADE
;

/* Create Tables */

CREATE TABLE `Calendario`
(
	`idcalendario` BIGINT NOT NULL AUTO_INCREMENT,
    `horastotales` INT NOT NULL,
    `horasteoria` INT NOT NULL,
    `horaspractica` INT NOT NULL,
    `horaslaboratorio` INT NOT NULL,
	CONSTRAINT `PK_Calendario` PRIMARY KEY (`idcalendario` ASC)
)

;

CREATE TABLE `Docente`
(
	`iddocente` BIGINT NOT NULL AUTO_INCREMENT,
	`idusuario` BIGINT,
    `idcalendario` BIGINT NOT NULL,
	`nombres` VARCHAR(50) NOT NULL,
	`apepaterno` VARCHAR(50) NOT NULL,
	`apematerno` VARCHAR(50) NOT NULL,
	`nrodoc` VARCHAR(8) NOT NULL,
	`fecha_nacimiento` DATETIME NOT NULL,
	`domicilio` VARCHAR(100) NULL,
	`celular` VARCHAR(9) NULL,
	`sexo` VARCHAR(1) NULL,
	CONSTRAINT `PK_Docente` PRIMARY KEY (`iddocente` ASC)
)

;

CREATE TABLE `SemestreAcademico`
(
	`idsemestre` BIGINT NOT NULL AUTO_INCREMENT,
	`iddocente` BIGINT NOT NULL,
	`idcalendario` BIGINT NOT NULL,
    `anho` VARCHAR(4) NOT NULL,
    `ciclo` VARCHAR(2) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL,
	CONSTRAINT `PK_SemestreAcademico` PRIMARY KEY (`idsemestre` ASC)
)

;

CREATE TABLE `Usuario`
(
	`idusuario` BIGINT NOT NULL AUTO_INCREMENT,
	`usuario` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	CONSTRAINT `PK_Usuario` PRIMARY KEY (`idusuario` ASC)
)

;

/* Create Foreign Key Constraints */

ALTER TABLE `Docente` 
 ADD CONSTRAINT `FK_Docente_Usuario`
	FOREIGN KEY (`idusuario`) REFERENCES `Usuario` (`idusuario`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Docente` 
 ADD CONSTRAINT `FK_Docente_Calendario`
	FOREIGN KEY (`idcalendario`) REFERENCES `Calendario` (`idcalendario`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `SemestreAcademico` 
 ADD CONSTRAINT `FK_Semestre_Calendario`
	FOREIGN KEY (`idcalendario`) REFERENCES `Calendario` (`idcalendario`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `SemestreAcademico` 
 ADD CONSTRAINT `FK_Semestre_Docente`
	FOREIGN KEY (`iddocente`) REFERENCES `Docente` (`iddocente`) ON DELETE Restrict ON UPDATE Restrict
;

DROP TRIGGER IF EXISTS check_trigger

;

DELIMITER //

CREATE TRIGGER check_trigger
  BEFORE INSERT ON calendario FOR EACH ROW
BEGIN
	IF (NEW.horastotales < 0 OR NEW.horastotales > 16) THEN
		CALL `Error: Wrong values for horastotales`;
	END IF;
END //

DELIMITER ;

SET FOREIGN_KEY_CHECKS=1 
;
