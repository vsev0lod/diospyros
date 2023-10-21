INSERT INTO users (email, password, rating, user_type, name, description, balance)
VALUES
  ('user1@example.com', 'password123', 4.5, 'user', 'John Doe', 'User 1 description', 100.00),
  ('user2@example.com', 'mypassword', 3.7, 'user', 'Jane Smith', 'User 2 description', 50.00),
  ('admin@example.com', 'adminpass', 5.0, 'goverment', 'Admin User', 'Admin description', 500.00),
  ('moderator@example.com', 'modpass', 4.2, 'moderator', 'Moderator User', 'Moderator description', 200.00);
-- You can add more INSERT statements for additional users as needed