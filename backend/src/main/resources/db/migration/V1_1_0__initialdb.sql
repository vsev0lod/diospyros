-- Create the 'user' table
-- CREATE TYPE user_type AS ENUM ('user', 'goverment', 'moderator');

CREATE TABLE users (
    id UUID PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    rating NUMERIC(2, 1) DEFAULT 0.0 CHECK (rating >= 0 AND rating <= 5),
    user_type VARCHAR(20) NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    balance NUMERIC(10, 2) DEFAULT 0.00
    -- Add other user-related fields here
);

-- CREATE TYPE entity_type AS ENUM ('user', 'task', 'solution');

-- Create the 'task' table
-- Create the ENUM types if they don't already exist
-- CREATE TYPE task_type AS ENUM ('private state company);
-- CREATE TYPE status AS ENUM ('defined', 'inProgress', 'inReview', 'reworkRequested', 'dispute', 'completed');
-- CREATE TYPE tag AS ENUM ('improve env', 'help people', 'events', 'emergency', 'other');

-- Create the 'location' table
-- CREATE TABLE location (
--     id UUID PRIMARY KEY,
--     decimal_degrees POINT NOT NULL
--     -- Add other location item-related fields here
-- );

-- Create the task table
CREATE TABLE task (
    id UUID PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    task_type VARCHAR(50),
    created_at DATE NOT NULL,
    reward DECIMAL(10, 2) DEFAULT 0.0 NOT NULL,
    location VARCHAR(50),
    status VARCHAR(50) NOT NULL,
    tag VARCHAR(50) NOT NULL,
    creator_id UUID REFERENCES users(id)
--     location_id INT REFERENCES location(id),
    -- Add other task-related fields here
);

-- Create the 'solution' table
CREATE TABLE solution (
    id UUID PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
--     entity_id INT REFERENCES entity(id),
    task_id UUID REFERENCES task(id),
    creator_id UUID REFERENCES users(id)
    -- Add other solution item-related fields here
);

-- Create the 'attachment' table
CREATE TABLE attachment (
    id UUID PRIMARY KEY,
    owner_id UUID,
    attachment BYTEA NOT NULL
    -- Add other attachment item-related fields here
);

-- Create the 'entity_attachment' table
-- CREATE TABLE entity_attachment (
--     entity_id INT REFERENCES entity(id),
--     attachment_id INT REFERENCES attachment(id)
--     -- Add other entity_attachment item-related fields here
-- );

-- Create the 'partner' table
CREATE TABLE partner (
    id UUID PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(100) NOT NULL,
    website VARCHAR(100)
    -- Add other partner item-related fields here
);

-- Create the 'item' table
CREATE TABLE item (
    id UUID PRIMARY KEY,
    cost INT NOT NULL,
    description VARCHAR(100) NOT NULL,
    partner_id UUID REFERENCES partner(id)
    -- Add other item item-related fields here
);