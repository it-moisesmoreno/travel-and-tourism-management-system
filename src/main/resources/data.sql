

-- Inserting sample users
INSERT INTO users (username, password, email, role) VALUES
('admin', 'admin123', 'admin@example.com', 'admin'),
('user1', 'password1', 'user1@example.com', 'user'),
('user2', 'password2', 'user2@example.com', 'user');

-- Inserting sample destinations
INSERT INTO destinations (name, description, location, rating, price, image_url) VALUES
('Paris', 'The City of Lights', 'France', 4.5, 1500.00, 'paris.jpg'),
('Tokyo', 'Vibrant metropolis', 'Japan', 4.8, 2000.00, 'tokyo.jpg'),
('New York City', 'The Big Apple', 'USA', 4.7, 1800.00, 'nyc.jpg');

-- Inserting sample bookings
/*INSERT INTO bookings (user_id, destination_id, booking_date) VALUES
(2, 1, '2023-12-13 10:00:00'),
(3, 2, '2023-12-14 11:30:00'),
(3, 3, '2023-12-15 09:45:00');*/
