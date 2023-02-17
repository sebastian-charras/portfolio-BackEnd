START TRANSACTION;

CREATE DATABASE IF NOT EXISTS portfolio;

USE portfolio;

CREATE TABLE person (
	id INT NOT NULL,
    name VARCHAR(100),
    surname VARCHAR(100),
    title VARCHAR(100) NOT NULL,
	description VARCHAR(500) NOT NULL,
	email VARCHAR(500) DEFAULT NULL,
	github_url VARCHAR(500) DEFAULT NULL,
	linkedin_url VARCHAR(500) DEFAULT NULL
);

CREATE TABLE institution (
	id INT,
	name VARCHAR(100) NOT NULL,
	logo_url VARCHAR(500) DEFAULT NULL
);

CREATE TABLE work_experience (
	id INT,
	institution INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	period VARCHAR(100) NOT NULL,
	completed TINYINT,
	description VARCHAR(500) DEFAULT NULL
);

CREATE TABLE education (
	id INT,
	institution INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	period VARCHAR(100) NOT NULL,
	completed TINYINT,
	description VARCHAR(500) DEFAULT NULL
);

CREATE TABLE project (
	id INT,
	title VARCHAR(100) NOT NULL,
	period VARCHAR(100) NOT NULL,
	completed TINYINT,
	description VARCHAR(500) DEFAULT NULL,
	url VARCHAR(500)
);

CREATE TABLE skill (
	id INT,
	name VARCHAR(100) NOT NULL,
	percentage INT NOT NULL
);

ALTER TABLE person 
	ADD PRIMARY KEY (id),
    MODIFY id INT NOT NULL AUTO_INCREMENT;
    
ALTER TABLE institution 
	ADD PRIMARY KEY (id),
    MODIFY id INT NOT NULL AUTO_INCREMENT;
    
ALTER TABLE work_experience
	ADD PRIMARY KEY (id),
    MODIFY id INT NOT NULL AUTO_INCREMENT,
    ADD KEY institution (institution),
    ADD CONSTRAINT work_experience_fk_1 FOREIGN KEY (institution) REFERENCES institution (id);
    
ALTER TABLE education
	ADD PRIMARY KEY (id),
    MODIFY id INT NOT NULL AUTO_INCREMENT,
    ADD KEY institution (institution),
    ADD CONSTRAINT education_fk_1 FOREIGN KEY (institution) REFERENCES institution (id);
    
ALTER TABLE project
	ADD PRIMARY KEY (id),
    MODIFY id INT NOT NULL AUTO_INCREMENT;
    
ALTER TABLE skill
	ADD PRIMARY KEY (id),
    MODIFY id INT NOT NULL AUTO_INCREMENT;
    
COMMIT;