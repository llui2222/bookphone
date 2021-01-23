CREATE TABLE IF NOT EXISTS phones (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    phonename VARCHAR(256),
    bookedby int ,
    booktimestamp TIMESTAMP
);
CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(256)
);
INSERT INTO phones (phonename) VALUES ('Samsung Galaxy S9');
INSERT INTO phones (phonename) VALUES ('Motorola Nexus 6');
INSERT INTO phones (phonename) VALUES ('LG Nexus 5X');
INSERT INTO phones (phonename) VALUES ('Huawei Honor 7X');
INSERT INTO phones (phonename) VALUES ('Apple iPhone X');
INSERT INTO phones (phonename) VALUES ('Apple iPhone 8');
INSERT INTO phones (phonename) VALUES ('Apple iPhone 4s');
INSERT INTO phones (phonename) VALUES ('Nokia 331');
INSERT INTO users (username) VALUES ('Aleksei');
INSERT INTO users (username) VALUES ('Mikis');
INSERT INTO users (username) VALUES ('Tatsiana');