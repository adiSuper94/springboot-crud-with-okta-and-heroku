CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE SCHEMA IF NOT EXISTS core;
CREATE TABLE users (
            id UUID DEFAULT uuid_generate_v4 () PRIMARY KEY,
            first_name VARCHAR(100) NOT NULL,
            last_name VARCHAR(100) NOT NULL,
            username VARCHAR(100) NOT NULL,
            email_id VARCHAR(100)  NOT NULL,
            password_hash VARCHAR(200)  NOT NULL,
            enabled BOOLEAN NOT NULL DEFAULT FALSE,
            acc_locked BOOLEAN NOT NULL DEFAULT FALSE,
            acc_expired BOOLEAN NOT NULL DEFAULT FALSE,
            cred_expired BOOLEAN NOT NULL DEFAULT FALSE,
            CONSTRAINT email_unique UNIQUE (email_id),
            CONSTRAINT username_unique UNIQUE (username)
            );
