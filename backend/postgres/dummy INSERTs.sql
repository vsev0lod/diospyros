INSERT INTO users (email, password, rating, user_type, name, description, balance)
VALUES
  ('user1@example.com', 'password123', 4.5, 'user', 'John Doe', 'User 1 description', 100.00),
  ('user2@example.com', 'mypassword', 3.7, 'user', 'Jane Smith', 'User 2 description', 50.00),
  ('admin@example.com', 'adminpass', 5.0, 'goverment', 'Admin User', 'Admin description', 500.00),
  ('moderator@example.com', 'modpass', 4.2, 'moderator', 'Moderator User', 'Moderator description', 200.00);
-- You can add more INSERT statements for additional users as needed

INSERT INTO entity (entity_type)
VALUES
  ('task'::entity_type),
  ('task'::entity_type),
  ('task'::entity_type),
  ('task'::entity_type),
  ('solution'::entity_type),
  ('solution'::entity_type),
  ('solution'::entity_type),
  ('solution'::entity_type);

INSERT INTO task (title, description, created_at, reward, tag, location_id, entity_id, creator_id)
VALUES
  ('Task 1', 'remove garbage', '2023-01-15', 25.00, 'improve env', 1, 1, 1),
  ('Task 2', 'fix central heating', '2023-02-20', 30.00, 'help people', 2, 2, 2),
  ('Task 3', 'bachelor graduation', '2023-03-25', 50.00, 'events', 3, 3, 3),
  ('Task 4', 'charity event for cats', '2023-04-30', 15.00, 'other', 4, 4, 4);
-- You can add more INSERT statements for additional tasks as needed


INSERT INTO location (decimal_degrees)
VALUES
  (POINT(40.7128, -74.0060)), -- New York City
  (POINT(34.0522, -118.2437)), -- Los Angeles
  (POINT(51.5074, -0.1278)), -- London
  (POINT(48.8566, 2.3522)); -- Paris
-- Add more INSERT statements for additional locations as needed


INSERT INTO solution (description, entity_id, task_id, creator_id)
VALUES
  ('space arround garbage has been cleaned', 5, 1, 1),
  ('central heatin has been fixed', 6, 2, 2),
  ('orginized and planned for 01-01-2024', 7, 3, 3),
  ('done at 05-05-2024', 8, 4, 4);
-- Add more INSERT statements for additional solutions as needed

-- Insert data into the 'attachment' table
INSERT INTO attachment (attachment)
VALUES
  (E'\\x89504e470d0a1a0a0000000d49484452000001000000010c080600000029a9b54d000000097048597300000b1300000b1301009a9c180000000647454e5200ae4260821e0000001989454e44ae426082'),
  (E'\\x89504e470d0a1a0a0000000d49484452000001000000010c080600000029a9b54d000000097048597300000b1300000b1301009a9c180000000647454e5200ae4260821e0000001989454e44ae426082'),
  (E'\\x89504e470d0a1a0a0000000d49484452000001000000010c080600000029a9b54d000000097048597300000b1300000b1301009a9c180000000647454e5200ae4260821e0000001989454e44ae426082');
-- Add more INSERT statements for additional attachments as needed

-- Insert data into the 'entity_attachment' table
INSERT INTO entity_attachment (entity_id, attachment_id)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);
-- Add more INSERT statements for additional entity_attachment relationships as needed

-- Insert data into the 'partner' table
INSERT INTO partner (name, description, website)
VALUES
  ('CoBa CZ', 'Description for Partner 1', 'https://www.partner1.com'),
  ('CVUT', 'Description for Partner 2', 'https://www.partner2.com'),
  ('Broadcomm', 'Description for Partner 3', NULL);

-- Insert data into the 'item' table
INSERT INTO item (cost, description, partner_id)
VALUES
  (25, 'Item 1', 1),
  (30, 'Item 2', 2),
  (20, 'Item 3', 1),
  (40, 'Item 4', 3);
