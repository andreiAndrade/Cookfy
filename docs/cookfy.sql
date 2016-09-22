CREATE SCHEMA `cookfy` ;
use cookfy;

CREATE TABLE `cookfy`.`identity` (
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `adapter` VARCHAR(45) NULL,
  `hash` VARCHAR(75) NULL,
  `date_updated` DATETIME NULL,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `cookfy`.`user` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
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
  `userId` INT(11) NOT NULL ,
  `token` VARCHAR(45) NOT NULL ,
  `date_created` DATETIME NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
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
  ADD UNIQUE INDEX `userId_UNIQUE` (`userId` ASC);
ALTER TABLE `cookfy`.`user`
  ADD COLUMN `username` VARCHAR(45) NOT NULL;
ALTER TABLE `cookfy`.`user`
  CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL ,
  CHANGE COLUMN `email` `email` VARCHAR(85) NOT NULL ,
  CHANGE COLUMN `date_updated` `date_updated` DATETIME NOT NULL ,
  CHANGE COLUMN `date_created` `date_created` DATETIME NOT NULL ,
  ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC);

ALTER TABLE `cookfy`.`identity`
  DROP FOREIGN KEY `id_user_id`;
ALTER TABLE `cookfy`.`identity`
  CHANGE COLUMN `user_id` `user_id` INT(11) NOT NULL ,
  CHANGE COLUMN `adapter` `adapter` VARCHAR(45) NOT NULL ,
  CHANGE COLUMN `hash` `hash` VARCHAR(75) NOT NULL ,
  CHANGE COLUMN `date_updated` `date_updated` DATETIME NOT NULL ,
  CHANGE COLUMN `date_created` `date_created` DATETIME NOT NULL ,
  ADD UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC);
ALTER TABLE `cookfy`.`identity`
  ADD CONSTRAINT `id_user_id`
FOREIGN KEY (`user_id`)
REFERENCES `cookfy`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;