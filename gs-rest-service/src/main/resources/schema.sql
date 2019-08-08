-- schema.sql

use protodb;

-- drop table if exists category;
-- drop table if exists products;
-- drop table if exists order_items;
-- drop table if exists roles;
-- drop table if exists user_roles;
-- drop table if exists categories;
-- drop table if exists users;
-- drop table if exists product_images;
-- drop table if exists product_groups;
--
-- drop table if exists tags;
-- drop table if exists sales_orders;
-- drop table if exists coupons;
-- drop table if exists product_tags;
-- drop table if exists cc_transactions;
-- drop table if exists sessions;
-- drop table if exists product_statuses;
-- drop table if exists product_categories;
-- drop table if exists order_products;

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `group_variants`;
CREATE TABLE `group_variants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `variant_name` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjggn49ydnd0a0lusxeuhqutlp` (`group_id`),
  CONSTRAINT `FKjggn49ydnd0a0lusxeuhqutlp` FOREIGN KEY (`group_id`) REFERENCES `product_groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `group_variants` (`id`, `variant_name`, `group_id`) VALUES
(1,	'Blue',	1),
(2,	'White',	1);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` varchar(255) DEFAULT NULL,
  `product_variant_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrftu5hh0vupk70occwy3rx8on` (`product_variant_id`),
  KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  KEY `FKocimc7dtr037rh4ls4l95nlfi` (`product_id`),
  CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKocimc7dtr037rh4ls4l95nlfi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKrftu5hh0vupk70occwy3rx8on` FOREIGN KEY (`product_variant_id`) REFERENCES `group_variants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` varchar(5) DEFAULT NULL,
  `description` text,
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9an6554j5j7f3x8rifrgh4phr` (`group_id`),
  KEY `FKdb050tk37qryv15hd932626th` (`user_id`),
  CONSTRAINT `FK9an6554j5j7f3x8rifrgh4phr` FOREIGN KEY (`group_id`) REFERENCES `product_groups` (`id`),
  CONSTRAINT `FKdb050tk37qryv15hd932626th` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `products` (`id`, `name`, `price`, `description`, `created`, `group_id`, `user_id`) VALUES
(6,	'Shirt',	'24',	NULL,	'2017-05-02 15:58:11',	13,	1),
(7,	'Sweat Shirt',	'60',	NULL,	'2017-05-02 15:58:18',	13,	1),
(8,	'Flag',	'24',	NULL,	'2017-05-02 16:05:46',	1,	1),
(9,	'Golf V',	'20000',	NULL,	'2017-04-19 15:53:40',	1,	1);

DROP TABLE IF EXISTS `product_groups`;
CREATE TABLE `product_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` varchar(255) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `product_groups` (`id`, `created`, `group_name`, `price`) VALUES
(1,	'2017-04-19 12:47:33',	'Vehicles',	''),
(13,	'2017-05-02 10:30:22',	'Clothes',	NULL);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(255) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
