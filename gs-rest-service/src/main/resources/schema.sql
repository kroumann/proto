-- schema.sql
USE protodb;
DROP TABLE IF EXISTS category;
CREATE TABLE category(
  id            INT PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(50),
  description   TEXT,
  imageurl      VARCHAR(100)
);

DROP TABLE IF EXISTS produits;
CREATE TABLE produits(
  id            INT PRIMARY KEY AUTO_INCREMENT,
);