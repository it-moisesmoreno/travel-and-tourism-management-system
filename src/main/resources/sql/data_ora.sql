-- Inserting sample users
INSERT INTO users(username, password, email, role, is_active)
WITH records_data (username, password, email, role, is_active) AS (
    SELECT 'admin', 'admin123', 'admin@example.com', 'admin', 1 FROM dual UNION ALL
    SELECT 'user2', 'password2', 'user2@example.com', 'user', 1 FROM dual UNION ALL
    SELECT 'user1', 'password1', 'user1@example.com', 'user', 1 FROM dual
)
SELECT * FROM records_data;

-- Inserting sample destinations
INSERT INTO destinations (name, description, location, rating, price, image_url, is_active)
WITH records_data (name, description, location, rating, price, image_url, is_active) AS (
    SELECT 'Paris', 'The City of Lights', 'France', 4.5, 1500.00, 'paris.jpg', 1 FROM dual UNION 
    SELECT 'Tokyo', 'Vibrant metropolis', 'Japan', 4.8, 2000.00, 'tokyo.jpg', 1 FROM dual UNION 
    SELECT 'New York City', 'The Big Apple', 'USA', 4.7, 1800.00, 'nyc.jpg', 1 FROM dual
)
SELECT * FROM records_data;

-- Inserting sample bookings
INSERT INTO bookings (user_id, destination_id, booking_date)
WITH records_data (user_id, destination_id, booking_date) AS (
    SELECT 2, 1, to_timestamp('2023-12-13 10:00:00', 'YYYY-MM-DD HH:MI:SS') FROM dual UNION ALL
    SELECT 3, 2, to_timestamp('2023-12-14 11:30:00', 'YYYY-MM-DD HH:MI:SS') FROM dual UNION ALL
    SELECT 3, 3, to_timestamp('2023-12-15 09:45:00', 'YYYY-MM-DD HH:MI:SS') FROM dual
)
SELECT * FROM records_data;
