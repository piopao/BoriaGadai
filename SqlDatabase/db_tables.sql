DROP DATABASE IF EXISTS db;

CREATE DATABASE db;
USE db;



CREATE TABLE IF NOT EXISTS users (
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	username CHAR(64) NOT NULL ,
	hashed_password CHAR(64) NOT NULL,
	email_address VARCHAR(254) NOT NULL UNIQUE,
	birthdate DATE,
	gender CHAR(8),
	avatar_filename VARCHAR(128),
	info TEXT
);
CREATE TABLE IF NOT EXISTS quiz (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    quiz_name TEXT
);
#dir_names for default avatar pictures
CREATE TABLE IF NOT EXISTS pictures (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	location NCHAR(128)
);

CREATE TABLE IF NOT EXISTS quiz_reviews (
	review_text TEXT CHARACTER SET utf8,
	review_rating INT,
	review_date DATETIME,
	user_id INT,
	quiz_id INT,
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
	FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON DELETE CASCADE
	
);

CREATE TABLE IF NOT EXISTS admin (
	email VARCHAR(64),
	FOREIGN KEY (email) REFERENCES users(email_address) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS banned_accounts (
	email VARCHAR(64),
	FOREIGN KEY (email) REFERENCES users(email_address) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS friend_list (
	userA_id INT,
    userB_id INT,
	FOREIGN KEY (userA_id) REFERENCES users(user_id) ON DELETE CASCADE,
	FOREIGN KEY (userB_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pending_friend_list (
	userA_id INT,
    userB_id INT,
	FOREIGN KEY (userA_id) REFERENCES users(user_id) ON DELETE CASCADE,
	FOREIGN KEY (userB_id) REFERENCES users(user_id) ON DELETE CASCADE
);


#quiz prediction history for users.
CREATE TABLE IF NOT EXISTS quiz_predictions (
	prediction_text TEXT CHARACTER SET utf8,
	prediction_date DATETIME,
    user_id INT,
    quiz_id INT,
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
	FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON DELETE CASCADE
);


#taror cards designs.
CREATE TABLE IF NOT EXISTS cards (
	card_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	designA char(128),
	designB char(128),
	designC char(128)
);

--
CREATE TABLE IF NOT EXISTS fortune_card (
	prediction_text TEXT CHARACTER SET utf8,
    card_id INT,
	FOREIGN KEY (card_id) REFERENCES cards(card_id) ON DELETE CASCADE
	
);
