CREATE DATABASE file_hider;
USE file_hider;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(255) UNIQUE
);

CREATE TABLE data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    path VARCHAR(500),
    email VARCHAR(255),
    bin_data LONGBLOB
);