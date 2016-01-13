-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nile
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nile` ;

-- -----------------------------------------------------
-- Schema nile
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nile` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
USE `nile` ;

-- -----------------------------------------------------
-- Table `nile`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Product` (
  `sku` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` DECIMAL(10,2) UNSIGNED NOT NULL,
  `stock` MEDIUMINT UNSIGNED NOT NULL,
  `added_on` TIMESTAMP NOT NULL,
  `description` VARCHAR(250) NULL,
  `image` MEDIUMBLOB NULL,
  PRIMARY KEY (`sku`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Customer` (
  `customer_id` INT UNSIGNED NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `pword_hash` CHAR(8) NOT NULL,
  `pword_salt` CHAR(4) NOT NULL,
  `added_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `last_login` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Order` (
  `customer` INT UNSIGNED NOT NULL,
  `order_id` SMALLINT UNSIGNED NOT NULL,
  `status` ENUM('pendiente', 'completada', 'cancelada', 'enviada', 'entregada') NOT NULL DEFAULT 'pendiente',
  `opened_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `closed_on` TIMESTAMP NULL,
  `unique_products` TINYINT UNSIGNED NULL COMMENT 'number of different products ordered',
  `total` DECIMAL(10,2) UNSIGNED NULL,
  PRIMARY KEY (`customer`, `order_id`),
  CONSTRAINT `fk_Sale_ Customer 1`
    FOREIGN KEY (`customer`)
    REFERENCES `nile`.`Customer` (`customer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Category` (
  `category_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Magnitude`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Magnitude` (
  `magni_id` SMALLINT UNSIGNED NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(250) NULL,
  PRIMARY KEY (`magni_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Attribute` (
  `attribute_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NULL,
  `magni` SMALLINT UNSIGNED NULL,
  PRIMARY KEY (`attribute_id`),
  INDEX `fk_Attribute_AttrMagnitude1_idx` (`magni` ASC),
  CONSTRAINT `fk_Attribute_AttrMagnitude1`
    FOREIGN KEY (`magni`)
    REFERENCES `nile`.`Magnitude` (`magni_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`ProductCategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`ProductCategory` (
  `product` INT UNSIGNED NOT NULL,
  `category` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`product`, `category`),
  INDEX `fk_ProductCategory_Category1_idx` (`category` ASC),
  CONSTRAINT `fk_ProductCategory_Product1`
    FOREIGN KEY (`product`)
    REFERENCES `nile`.`Product` (`sku`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ProductCategory_Category1`
    FOREIGN KEY (`category`)
    REFERENCES `nile`.`Category` (`category_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Unit` (
  `magni` SMALLINT UNSIGNED NOT NULL,
  `unit_id` SMALLINT UNSIGNED NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `abbreviation` VARCHAR(10) NOT NULL,
  `shown_as_prefix` TINYINT(1) NOT NULL DEFAULT 0,
  `description` VARCHAR(250) NULL,
  PRIMARY KEY (`magni`, `unit_id`),
  INDEX `fk_CategoryUnits_AttrMagnitude1_idx` (`magni` ASC),
  CONSTRAINT `fk_CategoryUnits_AttrMagnitude1`
    FOREIGN KEY (`magni`)
    REFERENCES `nile`.`Magnitude` (`magni_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`CategoryDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`CategoryDetail` (
  `category` SMALLINT UNSIGNED NOT NULL,
  `attribute` INT UNSIGNED NOT NULL,
  `magni` SMALLINT UNSIGNED NULL,
  `unit` SMALLINT UNSIGNED NULL,
  PRIMARY KEY (`category`, `attribute`),
  INDEX `fk_CategoryDetail_Attribute1_idx` (`attribute` ASC),
  INDEX `fk_CategoryDetail_CategoryUnits1_idx` (`magni` ASC, `unit` ASC),
  CONSTRAINT `fk_CategoryDetail_Category1`
    FOREIGN KEY (`category`)
    REFERENCES `nile`.`Category` (`category_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_CategoryDetail_Attribute1`
    FOREIGN KEY (`attribute`)
    REFERENCES `nile`.`Attribute` (`attribute_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_CategoryDetail_CategoryUnits1`
    FOREIGN KEY (`magni` , `unit`)
    REFERENCES `nile`.`Unit` (`magni` , `unit_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`ProductDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`ProductDetail` (
  `product` INT UNSIGNED NOT NULL,
  `attribute` INT UNSIGNED NOT NULL,
  `value` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`product`, `attribute`),
  INDEX `fk_ProductDetail_Attribute1_idx` (`attribute` ASC),
  CONSTRAINT `fk_ProductDetail_Product1`
    FOREIGN KEY (`product`)
    REFERENCES `nile`.`Product` (`sku`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ProductDetail_Attribute1`
    FOREIGN KEY (`attribute`)
    REFERENCES `nile`.`Attribute` (`attribute_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`Address` (
  `customer` INT UNSIGNED NOT NULL,
  `type` ENUM('envío', 'facturación') NOT NULL,
  `state` ENUM('Aguascalientes', 'Baja California', 'Baja California Sur', 'Campeche', 'Chiapas', 'Chihuahua', 'Coahuila', 'Colima', 'Distrito Federal', 'Durango', 'Estado de México', 'Guanajuato', 'Guerrero', 'Hidalgo', 'Jalisco', 'Michoacán', 'Morelos', 'Nayarit', 'Nuevo León', 'Oaxaca', 'Puebla', 'Querétaro', 'Quintana Roo', 'San Luis Potosí', 'Sinaloa', 'Sonora', 'Tabasco', 'Tamaulipas', 'Tlaxcala', 'Veracruz', 'Yucatán', 'Zacatecas') NOT NULL DEFAULT 'Distrito Federal',
  `line1` VARCHAR(100) NOT NULL,
  `line2` VARCHAR(100) NULL,
  `postcode` DECIMAL(5,0) UNSIGNED NULL,
  PRIMARY KEY (`customer`, `type`),
  INDEX `fk_Address_ Customer_idx` (`customer` ASC),
  CONSTRAINT `fk_Address_ Customer`
    FOREIGN KEY (`customer`)
    REFERENCES `nile`.`Customer` (`customer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nile`.`OrderDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nile`.`OrderDetail` (
  `customer` INT UNSIGNED NOT NULL,
  `order` SMALLINT UNSIGNED NOT NULL,
  `product` INT UNSIGNED NOT NULL,
  `quantity` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`customer`, `order`, `product`),
  INDEX `fk_OrderDetail_Product1_idx` (`product` ASC),
  CONSTRAINT `fk_ OrderDetaill_Order1`
    FOREIGN KEY (`customer` , `order`)
    REFERENCES `nile`.`Order` (`customer` , `order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk OrderDetail_Product1`
    FOREIGN KEY (`product`)
    REFERENCES `nile`.`Product` (`sku`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `nile`.* TO 'nile_app';
GRANT SELECT, INSERT, TRIGGER ON TABLE `nile`.* TO 'nile_app';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `nile`;

DELIMITER $$
SHOW WARNINGS$$
USE `nile`$$
CREATE DEFINER = CURRENT_USER TRIGGER `nile`.`CategoryDetail_BEFORE_INSERT` BEFORE INSERT ON `CategoryDetail` FOR EACH ROW
	BEGIN
		IF (SELECT a.`magni` from `Attribute` a WHERE a.`attribute_id` = NEW.`attribute`) != NEW.`magni` THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'No se puede añadir fila: la magnitud tiene que corresponder al atributo.';
		END IF;
	END;$$

SHOW WARNINGS$$
SHOW WARNINGS$$
USE `nile`$$
CREATE DEFINER = CURRENT_USER TRIGGER `nile`.`CategoryDetail_BEFORE_UPDATE` BEFORE UPDATE ON `CategoryDetail` FOR EACH ROW
	BEGIN
		IF (SELECT a.`magni` from `Attribute` a WHERE a.`attribute_id` = NEW.`attribute`) != NEW.`magni` THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'No se puede añadir fila: la magnitud tiene que corresponder al atributo.';
		END IF;
	END;$$

SHOW WARNINGS$$

DELIMITER ;
