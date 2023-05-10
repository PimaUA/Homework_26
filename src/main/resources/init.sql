CREATE DATABASE homework_26;

USE homework_26;

CREATE TABLE Homework(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
description TEXT
);

CREATE TABLE Lesson (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
updatedAt TIMESTAMP,
homework_id INT,
FOREIGN KEY(homework_id) REFERENCES Homework(id)
);

INSERT INTO Homework(name, description) VALUES
('HW1','description1'),
('HW2','description2'),
('HW3','description3'),
('HW4','description4'),
('HW5','description5');

INSERT INTO lesson( name,updatedAt,homework_id) VALUES
('lesson1','2023-05-08 13:10:14',1),
('lesson2','2023-05-09 12:14:45',2),
('lesson3','2023-05-10 10:13:30',3),
('lesson4','2023-05-11 09:48:30',4),
('lesson5','2023-05-11 12:43:25',5);