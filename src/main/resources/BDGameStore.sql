-- MySQL Script generated by MySQL Workbench
-- Fri May  7 14:51:23 2021
-- Model: New Model    Version: 1.0
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
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Game` (
  `id_game` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id_game`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Promocao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Promocao` (
  `id_sale` INT NOT NULL AUTO_INCREMENT,
  `game_id_game` INT NOT NULL,
  `new_price` DOUBLE NOT NULL,
  PRIMARY KEY (`id_sale`, `game_id_game`),
  INDEX `fk_Sale_Game_idx` (`game_id_game` ASC) VISIBLE,
  CONSTRAINT `fk_Sale_Game`
    FOREIGN KEY (`game_id_game`)
    REFERENCES `mydb`.`Game` (`id_game`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Biblioteca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Biblioteca` (
  `id_biblioteca` INT NOT NULL AUTO_INCREMENT,
  `usuario_id_usuario` INT NOT NULL,
  `game_id_game` INT NOT NULL,
  PRIMARY KEY (`id_biblioteca`, `usuario_id_usuario`, `game_id_game`),
  INDEX `fk_User_has_Game_Game1_idx` (`game_id_game` ASC) VISIBLE,
  INDEX `fk_User_has_Game_User1_idx` (`usuario_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Game_User1`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `mydb`.`Usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Game_Game1`
    FOREIGN KEY (`game_id_game`)
    REFERENCES `mydb`.`Game` (`id_game`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
