DROP TABLE IF EXISTS selection;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id_user int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    lang VARCHAR(20)
);

CREATE TABLE selection (
    id_selection int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    location_surname VARCHAR(255),
    city_name VARCHAR(255),
    state_code VARCHAR(20),
    country_code VARCHAR(20),
    lon float,
    lat float,
    min_max_temp bool,
    humidity bool,
    pressure bool,
    cloud bool,
    id_user int NOT NULL,
    FOREIGN KEY (id_user) REFERENCES user(id_user)
);