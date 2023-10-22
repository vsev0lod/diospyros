INSERT INTO task (id, title, description, task_type, created_at, reward, location, status, tag, creator_id)
VALUES
  ('014ae07f-f7e2-4f12-bf76-4356f487f5d1', 'Task 1 - remove garbage', 'remove garbage','private' , '2023-01-15', 25.00, '34.0522, -118.2437', 'defined', 'improve env', '014ae07f-f7e2-4f12-bf76-4356f487f5cd'),
  ('014ae07f-f7e2-4f12-bf76-4356f487f5d2', 'Task 2 - fix central heating', 'fix central heating','private', '2023-02-20', 30.00, '34.0522, -118.2437','inProgress'  , 'help people', '014ae07f-f7e2-4f12-bf76-4356f487f5ce'),
  ('014ae07f-f7e2-4f12-bf76-4356f487f5d3', 'Task 3 - bachelor graduation', 'Participate in bachelor graduation','state', '2023-03-25', 50.00, '34.0522, -118.2437', 'inProgress', 'events', '014ae07f-f7e2-4f12-bf76-4356f487f5cf'),
  ('014ae07f-f7e2-4f12-bf76-4356f487f5d4', 'Task 4 - charity event for cats', 'charity event for cats','company', '2023-04-30', 15.00, '34.0522, -118.2437', 'completed', 'other', '014ae07f-f7e2-4f12-bf76-4356f487f5cf');
-- You can add more INSERT statements for additional tasks as needed