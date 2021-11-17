CREATE DATABASE IF NOT EXISTS Tournament DEFAULT CHARSET = UTF8MB4;
USE Tournament;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS Team;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Teams(
team varchar(255),
player1 varchar(255),
player2 varchar(255)
);

INSERT INTO Teams (team, player1, player2)
VALUES ("Lucadors","Mads Herlevsen","Martin Lorentzen");
INSERT INTO Teams (team, player1, player2)
VALUES ("Postmændene","Per Jensen","Jens Persson");
INSERT INTO Teams (team, player1, player2)
VALUES ("Datamans","Geoff Nielsen","Mark Topson");
INSERT INTO Teams (team, player1, player2)
VALUES ("FlowerPower","Sofie Jacobsen","Brit Brittsen");
INSERT INTO Teams (team, player1, player2)
VALUES ("TheBots","Siri Apple","Alexsa Amazon");
INSERT INTO Teams (team, player1, player2)
VALUES ("TheNerds","Sheldon Copper","Leonard Hofstadter");
INSERT INTO Teams (team, player1, player2)
VALUES ("DesperateHousewives","Eva Longoria","Felicity Huffman");
INSERT INTO Teams (team, player1, player2)
VALUES ("PirateClan","Long John Silver","Bluebeard");
INSERT INTO Teams (team, player1, player2)
VALUES ("Avengers","Tony Stark","Steve Rogers");
INSERT INTO Teams (team, player1, player2)
VALUES ("Heroes","Clark kent","Diana Prince");
INSERT INTO Teams (team, player1, player2)
VALUES ("TheNoobs","Dupreeh","Gla1ve");
INSERT INTO Teams (team, player1, player2)
VALUES ("WalkingDead","Daryl Dixon","Rick Grimes");
INSERT INTO Teams (team, player1, player2)
VALUES ("BFF","Helge Jørgen","Ib Sørensen");
INSERT INTO Teams (team, player1, player2)
VALUES ("MVP","Torben Torbensen","Erika Eriksen");
INSERT INTO Teams (team, player1, player2)
VALUES ("Hustlers","Julie Jørgensen","Kristina Christensen");
INSERT INTO Teams (team, player1, player2)
VALUES ("Bulletproof","Mikkel Mikkelsen","Paula Oluffsson");