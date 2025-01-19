-- noinspection SqlNoDataSourceInspectionForFile

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