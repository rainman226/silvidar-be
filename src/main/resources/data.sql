INSERT INTO _USERS (username, password, email, full_name, phone_number, role)
VALUES (
           'jogoat@gmail.com', -- username
           '$2a$10$8mNAauzYAJbatkHAlmgfzOb.0biD5EDEqGQSYjRQJE5nUsLHzAxuq', -- password (hashed)
           'jogoat@gmail.com', -- email
           'Jogoat', -- fullName (placeholder)
           '1234567890', -- phoneNumber (placeholder)
           'USER' -- role (default role)
       );

INSERT INTO _USERS (username, password, email, full_name, phone_number, role)
VALUES (
           'admin@yahoo.com', -- username
           '$2a$10$BE0o4y9VgQX46ViwST7wpOBqRqLaIJVOPSUUbRzdq13rQ4m4TgU3C', -- password (hashed)
           'admin@yahoo.com', -- email
           'Admin User', -- fullName (placeholder)
           '0987654321', -- phoneNumber (placeholder)
           'ADMIN' -- role (set to ADMIN)
       );

INSERT INTO PRODUCT (name, animal_type, food_type, price, weight, is_available, code, quantity, description, image_url)
VALUES
    ('Dog Biscuits',
     'CAINE_ADULT',
     'Dry',
     15.99,
     500,
     TRUE,
     'P001',
     50,
     'Crunchy and nutritious biscuits for dogs.',
     'https://cdn.dribbble.com/userupload/12904548/file/original-1bd26c984d2cfcf29b7b2fe171f12b38.jpg');

INSERT INTO PRODUCT (name, animal_type, food_type, price, weight, is_available, code, quantity, description, image_url)
VALUES
    ('Cat Wet Food', 'PISICA', 'Wet', 25.49, 300, TRUE, 'P002', 30, 'Premium wet food with real tuna and salmon.', 'https://cdn.dribbble.com/userupload/8572409/file/original-4ba6d50e3c4b8d2c073db4776eed66ba.jpg');

INSERT INTO PRODUCT (name, animal_type, food_type, price, weight, is_available, code, quantity, description, image_url)
VALUES
    ('Bird Seed Mix', 'CAINE_JUNIOR', 'Dry', 9.99, 1000, FALSE, 'P003', 0, 'A mix of seeds for various bird species.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg');

INSERT INTO PRODUCT (name, animal_type, food_type, price, weight, is_available, code, quantity, description, image_url)
VALUES
    ('Sunny Cat', 'PISICA', 'Dry Food', 15.99, 10, TRUE, 'SCAT10KG001', 50, 'Affordable Ukrainian cat food.', 'https://cdn.dribbble.com/userupload/4247077/file/original-ee71ef3ce12c86e4dc3769ab6fdd8cf5.jpg'),

    ('Whiskas Junior', 'PISICA_JUNIOR', 'Dry Food', 29.99, 14, TRUE, 'WHISKJ14KG002', 40, 'Whiskas Junior formula for growing kittens.', 'https://cdn.dribbble.com/userupload/12904548/file/original-1bd26c984d2cfcf29b7b2fe171f12b38.jpg'),

    ('Versele Laga Classic de Pui', 'CAINE_ADULT', 'Dry Food', 39.99, 20, TRUE, 'VLCP20KG003', 30, 'Classic chicken flavor for adult dogs.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg'),

    ('Versele Laga Classic de Miel', 'CAINE_ADULT', 'Dry Food', 42.99, 20, TRUE, 'VLCL20KG004', 25, 'Classic lamb flavor for adult dogs.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg'),

    ('Versele Laga Opti-Life Mini Adult cu Somon', 'CAINE_ADULT_TALIE_MICA', 'Dry Food', 34.99, 7.5, TRUE, 'VLOL7.5KG005', 20, 'Opti-Life salmon flavor for small breed adult dogs.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg'),

    ('Vincent Uno Junior cu Rață Mediterranean Monoprotein Dog Food', 'CAINE_JUNIOR', 'Dry Food', 49.99, 12, TRUE, 'VUJM12KG006', 15, 'High-quality monoprotein duck recipe for junior dogs.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg'),

    ('Ukrainian Sac Verde Junior', 'CAINE_JUNIOR', 'Dry Food', 19.99, 10, TRUE, 'USVJ10KG007', 35, 'Affordable Ukrainian junior dog food in a green bag.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg'),

    ('Versele Laga Classic Puppy', 'MINI_PUPPY', 'Dry Food', 27.99, 10, TRUE, 'VLCPUP10KG008', 45, 'Classic puppy food for mini breeds.', 'https://cdn.dribbble.com/userupload/11692145/file/original-aac929bed542863f1660afbfcabca888.jpg');

-- Insert orders
INSERT INTO orders (oid, user_id, order_date, order_status, pick_up_deadline, total_price)
VALUES
    (1, 1, CURRENT_TIMESTAMP, 'CONFIRMED', CURRENT_TIMESTAMP + INTERVAL '3' DAY, 57.47), -- 2x15.99 + 25.49
    (2, 1, CURRENT_TIMESTAMP, 'CONFIRMED', CURRENT_TIMESTAMP + INTERVAL '5' DAY, 184.96); -- 1x34.99 + 3x49.99

-- Insert order items for Order 1
INSERT INTO order_item (id, order_id, product_id, quantity, unit_price)
VALUES
    (1, 1, 1, 2, 15.99),  -- Dog Biscuits
    (2, 1, 2, 1, 25.49);  -- Cat Wet Food

-- Insert order items for Order 2
INSERT INTO order_item (id, order_id, product_id, quantity, unit_price)
VALUES
    (3, 2, 8, 1, 34.99),  -- Versele Laga Opti-Life
    (4, 2, 9, 3, 49.99);  -- Vincent Uno Junior