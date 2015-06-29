DROP DATABASE IF EXISTS db;

CREATE DATABASE db;
USE db;



CREATE TABLE IF NOT EXISTS users (
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	username CHAR(64) ,
    user_name CHAR(64) ,
    user_surname CHAR(64) ,
	hashed_password CHAR(64),
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
	user_emailA VARCHAR(64),
    user_emailB VARCHAR(76),
	FOREIGN KEY (user_emailA) REFERENCES users(email_address) ON DELETE CASCADE,
	FOREIGN KEY (user_emailB) REFERENCES users(email_address) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pending_friend_list (
	user_emailA VARCHAR(64),
    user_emailB VARCHAR(76),
	FOREIGN KEY (user_emailA) REFERENCES users(email_address) ON DELETE CASCADE,
	FOREIGN KEY (user_emailB) REFERENCES users(email_address) ON DELETE CASCADE
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


#tarot cards designs.
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

CREATE TABLE IF NOT EXISTS image_table (
	image_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    image_dir VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS game_table (
	game_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    game_name VARCHAR(32),
	game_description VARCHAR(512),
    image_id INT,
    game_url VARCHAR(32),
    FOREIGN KEY (image_id) REFERENCES image_table(image_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS weather_table (
	weather_id INT PRIMARY KEY UNIQUE,
    weather_text VARCHAR(128) NOT NULL UNIQUE,
	image_dir VARCHAR(64)
);




CREATE TABLE IF NOT EXISTS weather_history (
	user_email VARCHAR(64),
    text_weather VARCHAR(256),
	save_date VARCHAR(64),
	FOREIGN KEY (user_email) REFERENCES users(email_address) ON DELETE CASCADE
	
);


CREATE TABLE IF NOT EXISTS lottary_history (
	user_email VARCHAR(64),
    numbers VARCHAR(64),
	
	FOREIGN KEY (user_email) REFERENCES users(email_address) ON DELETE CASCADE
	
);

CREATE TABLE IF NOT EXISTS chat_requests(
	init_user_email VARCHAR(64),
    receiver_user_email VARCHAR(64),
    request_status INT,
    FOREIGN KEY (init_user_email) REFERENCES users(email_address) ON DELETE CASCADE,
    FOREIGN KEY (receiver_user_email) REFERENCES users(email_address) ON DELETE CASCADE
    
);

CREATE TABLE IF NOT EXISTS new_chat_messages(
	init_user_email VARCHAR(64),
    receiver_user_email VARCHAR(64),
    text_message VARCHAR(64),
    FOREIGN KEY (init_user_email) REFERENCES users(email_address) ON DELETE CASCADE,
    FOREIGN KEY (receiver_user_email) REFERENCES users(email_address) ON DELETE CASCADE

);


CREATE TABLE IF NOT EXISTS fortune_texts(
	text_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    fortune_text VARCHAR(128)
	
	
);


CREATE TABLE IF NOT EXISTS fortune_histroy (
	user_email VARCHAR(64),
    fortune_text VARCHAR(128),
	FOREIGN KEY (user_email) REFERENCES users(email_address) ON DELETE CASCADE
	
);
