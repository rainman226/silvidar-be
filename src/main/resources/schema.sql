-- noinspection SqlNoDataSourceInspectionForFile
CREATE TABLE _USERS (
                        id INT PRIMARY KEY AUTO_INCREMENT,  -- Auto-incrementing primary key
                        username VARCHAR(255) NOT NULL UNIQUE,  -- Unique username
                        password VARCHAR(255) NOT NULL,  -- Password (hashed)
                        email VARCHAR(255) NOT NULL UNIQUE,  -- Unique email
                        full_name VARCHAR(255),  -- Full name
                        phone_number VARCHAR(15),  -- Phone number
                        --role ENUM('USER', 'ADMIN') NOT NULL  -- Role (enum with possible values 'USER' and 'ADMIN')
                        role VARCHAR(255) NOT NULL
);

CREATE TABLE PRODUCT (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         animal_type VARCHAR(255), -- Assuming AnimalType is an enum or string
                         food_type VARCHAR(255),
                         price FLOAT NOT NULL,
                         weight INT NOT NULL,
                         is_available BOOLEAN NOT NULL,
                         code VARCHAR(255) NOT NULL UNIQUE,
                         quantity INT NOT NULL,
                         description TEXT,
                         image_url VARCHAR(2083) -- Assuming a typical URL length
);