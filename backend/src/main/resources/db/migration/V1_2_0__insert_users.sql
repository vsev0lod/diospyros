INSERT INTO users (id, email, password, rating, user_type, name, description, balance)
VALUES
  ('014ae07f-f7e2-4f12-bf76-4356f487f5cd', 'user1@example.com', 'password123', 4.5, 'user', 'John Doe', 'User 1 description', 100.00),
  ('014ae07f-f7e2-4f12-bf76-4356f487f5ce', 'user2@example.com', 'mypassword', 3.7, 'user', 'Jane Smith', 'User 2 description', 50.00),
  ('014ae07f-f7e2-4f12-bf76-4356f487f5cf', 'admin@example.com', 'adminpass', 5.0, 'goverment', 'Admin User', 'Admin description', 500.00),
  ('014ae07f-f7e2-4f12-bf76-4356f487f5d0', 'moderator@example.com', 'modpass', 4.2, 'moderator', 'Moderator User', 'Moderator description', 200.00);
-- You can add more INSERT statements for additional users as needed