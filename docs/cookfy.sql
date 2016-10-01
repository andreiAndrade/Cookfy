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

CREATE TABLE `cookfy`.`recipes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(1000) NULL,
  `execution_time` VARCHAR(45) NULL,
  `difficulty` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cookfy`.`igredients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `desctiption` VARCHAR(45) NULL,
  `nutritional_information` VARCHAR(120) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cookfy`.`igredients2recipes` (
  `igredient_id` INT NOT NULL,
  `recipes_id` INT NOT NULL,
  PRIMARY KEY (`igredient_id`, `recipes_id`));

ALTER TABLE `cookfy`.`igredients2recipes` 
ADD INDEX `id_idx` (`recipes_id` ASC);
ALTER TABLE `cookfy`.`igredients2recipes` 
ADD CONSTRAINT `id_recipes_id`
  FOREIGN KEY (`recipes_id`)
  REFERENCES `cookfy`.`recipes` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_igredients_id`
  FOREIGN KEY (`igredient_id`)
  REFERENCES `cookfy`.`igredients` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `cookfy`.`category` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cookfy`.`recipes2category` (
  `recipes_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`recipes_id`, `category_id`));

ALTER TABLE `cookfy`.`recipes2category` 
ADD INDEX `id_category_id_idx` (`category_id` ASC);
ALTER TABLE `cookfy`.`recipes2category` 
ADD CONSTRAINT `id_recipes2category_id`
  FOREIGN KEY (`recipes_id`)
  REFERENCES `cookfy`.`recipes` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_category_id`
  FOREIGN KEY (`category_id`)
  REFERENCES `cookfy`.`category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `cookfy`.`recipebook` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cookfy`.`recipebook2user` (
  `recipebook_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`recipebook_id`, `user_id`));

ALTER TABLE `cookfy`.`recipebook2user` 
ADD INDEX `id_user2recipebook_id_idx` (`user_id` ASC);
ALTER TABLE `cookfy`.`recipebook2user` 
ADD CONSTRAINT `id_recipebook2user_id`
  FOREIGN KEY (`recipebook_id`)
  REFERENCES `cookfy`.`recipebook` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_user2recipebook_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `cookfy`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  CREATE TABLE `cookfy`.`recipe2recipebook` (
  `recipe_id` INT NULL,
  `recipebook_id` INT NULL,
  PRIMARY KEY (`recipe_id`, `recipebook_id`));

ALTER TABLE `cookfy`.`recipe2recipebook` 
ADD INDEX `id_recipebook2recipe_id_idx` (`recipebook_id` ASC);
ALTER TABLE `cookfy`.`recipe2recipebook` 
ADD CONSTRAINT `id_recipe2recipebook_id`
  FOREIGN KEY (`recipe_id`)
  REFERENCES `cookfy`.`recipes` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_recipebook2recipe_id`
  FOREIGN KEY (`recipebook_id`)
  REFERENCES `cookfy`.`recipebook` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `cookfy`.`user2recipe` (
  `user_id` INT NULL,
  `recipe_id` INT NULL,
  PRIMARY KEY (`user_id`, `recipe_id`));

ALTER TABLE `cookfy`.`user2recipe` 
ADD INDEX `id_recipe2user_id_idx` (`recipe_id` ASC);
ALTER TABLE `cookfy`.`user2recipe` 
ADD CONSTRAINT `id_user2recipe_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `cookfy`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_recipe2user_id`
  FOREIGN KEY (`recipe_id`)
  REFERENCES `cookfy`.`recipes` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



