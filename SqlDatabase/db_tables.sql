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

CREATE TABLE IF NOT EXISTS image_table (
	image_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    image_dir VARCHAR(32) not null unique
);

CREATE TABLE IF NOT EXISTS game_table (
	game_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    game_name VARCHAR(32) NOT NULL UNIQUE,
	game_description VARCHAR(512),
    image_name varchar(32) not null unique,
    game_url VARCHAR(32),
    FOREIGN KEY (image_name) REFERENCES image_table(image_dir) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS quiz_reviews (
	review_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	review_text TEXT CHARACTER SET utf8,
	review_rating INT,
	review_date DATETIME,
    game_name varchar(32),
	user_email VARCHAR(64),
	FOREIGN KEY (game_name) REFERENCES game_table(game_name) ON DELETE CASCADE,
	FOREIGN KEY (user_email) REFERENCES users(email_address) ON DELETE CASCADE
	
	
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
    user_emailB VARCHAR(64),
	FOREIGN KEY (user_emailA) REFERENCES users(email_address) ON DELETE CASCADE,
	FOREIGN KEY (user_emailB) REFERENCES users(email_address) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pending_friend_list (
	user_emailA VARCHAR(64),
    user_emailB VARCHAR(64),
	FOREIGN KEY (user_emailA) REFERENCES users(email_address) ON DELETE CASCADE,
	FOREIGN KEY (user_emailB) REFERENCES users(email_address) ON DELETE CASCADE
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
    request_status VARCHAR(8),
    FOREIGN KEY (init_user_email) REFERENCES users(email_address) ON DELETE CASCADE,
    FOREIGN KEY (receiver_user_email) REFERENCES users(email_address) ON DELETE CASCADE
    
);

CREATE TABLE IF NOT EXISTS new_chat_messages(
	init_user_email VARCHAR(64),
    receiver_user_email VARCHAR(64),
    text_message VARCHAR(512),
    FOREIGN KEY (init_user_email) REFERENCES users(email_address) ON DELETE CASCADE,
    FOREIGN KEY (receiver_user_email) REFERENCES users(email_address) ON DELETE CASCADE

);


CREATE TABLE IF NOT EXISTS fortune_texts(
	text_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    fortune_text VARCHAR(128)
);


CREATE TABLE IF NOT EXISTS tarot(
	text_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    dir_name VARCHAR(128)
);



CREATE TABLE IF NOT EXISTS fortune_histroy (
	user_email VARCHAR(64),
    fortune_text VARCHAR(128),
	FOREIGN KEY (user_email) REFERENCES users(email_address) ON DELETE CASCADE
	
);
