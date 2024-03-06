-- ttms-it_moisesmoreno-XEPDB1
SELECT * FROM destinations;

DROP TABLE destinations;

SELECT * FROM users;
SELECT * FROM bookings;

INSERT INTO destinations (name, description, location, rating, price, image_url, is_active) VALUES
('Paris', 'The City of Lights', 'France', 4.5, 1500.00, 'paris.jpg', 1);

INSERT INTO users (username, password, email, role, is_active) VALUES
('admin', 'admin123', 'admin@example.com', 'admin', 1);

INSERT INTO bookings (user_id, destination_id, booking_date) VALUES
(2, 1, to_timestamp('2023-12-13 10:00:00', 'YYYY-MM-DD HH:MI:SS'));

