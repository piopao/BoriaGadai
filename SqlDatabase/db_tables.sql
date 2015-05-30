DROP DATABBASE IF EXISTS db;

CREATE DATABASE db;
USE db;



CREATE TABLE IF NOT EXISTS users (
userid INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	username CHAR(64) NOT NULL ,
	hashed_password CHAR(64) NOT NULL,
	email_address VARCHAR(254) NOT NULL,
	birthdate DATE,
	gender CHAR(8),
	avatar_filename VARCHAR(128),
	info CHAR(512)
);

--dir_names for default avatar pictures.
CREATE TABLE IF NOT EXISTS pictures (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	location NCHAR(128);
);

CREATE TABLE IF NOT EXISTS quiz_reviews (
review_text TEXT CHARACTER SET utf8,
review_rating INT,
review_date DATETIME,
FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON DELETE CASCADE
	
);

CREATE TABLE IF NOT EXISTS admin (
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS banned_accounts (
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS friend_list (
	FOREIGN KEY (userA_id) REFERENCES users(user_id) ON DELETE CASCADE
	FOREIGN KEY (userB_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pending_friend_list (
	FOREIGN KEY (userA_id) REFERENCES users(user_id) ON DELETE CASCADE
	FOREIGN KEY (userB_id) REFERENCES users(user_id) ON DELETE CASCADE
);


--quiz prediction history for users.
CREATE TABLE IF NOT EXISTS quiz_predictions (
	prediction_text TEXT CHARACTER SET utf8,
	prediction_date DATETIME,
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
	FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON DELETE CASCADE
);


--taror cards designs.
CREATE TABLE IF NOT EXISTS cards (
	card_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	designA char(128),
	designB char(128),
	designC char(128)
);

--
CREATE TABLE IF NOT EXISTS fortune_card (
	prediction_text TEXT CHARACTER SET utf8,
	FOREIGN KEY (card_id) REFERENCES cards(card_id) ON DELETE CASCADE
	
);
