-- =====================================================
-- HomeLibrary Database Schema
-- Author: Giacomo Colombo
-- Version: 1.0
-- Description: Database schema for the HomeLibrary project
-- =====================================================

DROP DATABASE IF EXISTS home_library;

CREATE DATABASE home_library
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE home_library;

-- =====================================================
-- TABLE: AUTHORS
-- =====================================================

CREATE TABLE authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL UNIQUE,
    birth_date DATE,
    nationality CHAR(2)
);


-- =====================================================
-- TABLE: PUBLISHERS
-- =====================================================

CREATE TABLE publishers (
    publisher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    country CHAR(2)
);


-- =====================================================
-- TABLE: GENRES
-- =====================================================

CREATE TABLE genres (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
);


-- =====================================================
-- TABLE: BOOKS
-- =====================================================

CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(17) UNIQUE,
    publication_year YEAR,
    number_of_pages INT NOT NULL CHECK (number_of_pages > 0),
    language CHAR(2) NOT NULL, -- ISO 639-1 language code (IT, EN, FR...)
    reading_status INT NOT NULL CHECK (reading_status > 0),
    rating TINYINT CHECK (rating BETWEEN 1 AND 5),
    notes TEXT,
    review TEXT,
    author_id INT NOT NULL,
    publisher_id INT NOT NULL,
    genre_id INT NOT NULL,

    CONSTRAINT fk_books_author
        FOREIGN KEY (author_id)
        REFERENCES authors(author_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_books_publisher
        FOREIGN KEY (publisher_id)
        REFERENCES publishers(publisher_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_books_genre
        FOREIGN KEY (genre_id)
        REFERENCES genres(genre_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- =====================================================
-- END OF SCHEMA
-- =====================================================
