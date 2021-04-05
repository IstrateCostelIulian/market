create database management_system;

CREATE TABLE `raw_materials` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` DOUBLE NOT NULL
);

CREATE TABLE `materials_for_product` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `raw_material_id` int NOT NULL,
  `quantity` INT NOT NULL
);

CREATE TABLE `products` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `materials_for_product_id` INT NOT NULL,
  `commercial_excess` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL
);

CREATE TABLE `customers` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `phone_number` VARCHAR(50) NOT NULL,
  `email_address` VARCHAR(50) NOT NULL
);

CREATE TABLE `orders` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `command_number` INT NOT NULL,
  `amount` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `customer_id` INT NOT NULL,
  `product_id` INT NOT NULL
);

CREATE TABLE `inventories` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `raw_material_id` INT NOT NULL,
  `quantity` INT NOT NULL
);

CREATE TABLE `accounting` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `incomme` DOUBLE NOT NULL,
  `costs` DOUBLE NOT NULL,
  `economic_balance` DOUBLE NOT NULL,
  `date` date NOT NULL
);

ALTER TABLE `materials_for_product` ADD FOREIGN KEY (`raw_material_id`) REFERENCES `raw_materials` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `products` ADD FOREIGN KEY (`materials_for_product_id`) REFERENCES `materials_for_product` (`id`);
