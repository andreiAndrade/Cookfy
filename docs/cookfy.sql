
CREATE SCHEMA `cookfy` ;
use cookfy;

CREATE TABLE `cookfy`.`identity` (
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `adpter` VARCHAR(45) NULL,
  `hash` VARCHAR(75) NULL,
  `date_updated` DATETIME NULL,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `cookfy`.`user` (
  `id` INT NOT NULL,
  ` name` VARCHAR(45) NULL,
  `email` VARCHAR(85) NULL,
  `date_updated` DATETIME NULL,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `cookfy`.`identity` 
ADD INDEX `id_idx` (`user_id` ASC);
ALTER TABLE `cookfy`.`identity` 
ADD CONSTRAINT `id_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `cookfy`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
CREATE TABLE `cookfy`.`authentication` (
  `id` INT NOT NULL,
  `userId` INT NULL,
  `token` VARCHAR(45) NULL,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `cookfy`.`authentication` 
ADD INDEX `id_userID_idx` (`userId` ASC);
ALTER TABLE `cookfy`.`authentication` 
ADD CONSTRAINT `id_userID`
  FOREIGN KEY (`userId`)
  REFERENCES `cookfy`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
ALTER TABLE `cookfy`.`authentication` 
ADD COLUMN `status` BINARY(1) NULL AFTER `date_created`;