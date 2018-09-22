USE test;
DROP TABLE IF EXISTS part;
CREATE TABLE part(
id INT(11) NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
is_necessary bit(1) not NUll,
count INT(11) not NULL,
PRIMARY KEY (id))
COLLATE='utf8_general_ci'
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO part (name, is_necessary, count) VALUES ('Материнская плата', true, '5');
INSERT INTO part (name, is_necessary, count) VALUES ('Видеокарта', true, '10');
INSERT INTO part (name, is_necessary, count) VALUES ('Оперативная память', true, '6');
INSERT INTO part (name, is_necessary, count) VALUES ('Жесткий диск', true, '9');
INSERT INTO part (name, is_necessary, count) VALUES ('Блок питания', true, '5');
INSERT INTO part (name, is_necessary, count) VALUES ('Звуковая плата', false, '5');
INSERT INTO part (name, is_necessary, count) VALUES ('Оптический привод', false, '20');
INSERT INTO part (name, is_necessary, count) VALUES ('Процессор', true, '7');
INSERT INTO part (name, is_necessary, count) VALUES ('Кулер для процессора', true, '15');
INSERT INTO part (name, is_necessary, count) VALUES ('Вентилятор для корпуса', false, '10');
INSERT INTO part (name, is_necessary, count) VALUES ('SATA-кабель', true, '22');
INSERT INTO part (name, is_necessary, count) VALUES ('Клавиатура', true, '17');
INSERT INTO part (name, is_necessary, count) VALUES ('Компьютерная мышь', true, '15');
INSERT INTO part (name, is_necessary, count) VALUES ('Компьютерные колонки', false, '11');
INSERT INTO part (name, is_necessary, count) VALUES ('Монитор', true, '6');
INSERT INTO part (name, is_necessary, count) VALUES ('Корпус', true, '5');
INSERT INTO part (name, is_necessary, count) VALUES ('Вэб-камера', false, '3');
INSERT INTO part (name, is_necessary, count) VALUES ('Подсветка корпуса', false, '2');
INSERT INTO part (name, is_necessary, count) VALUES ('Батарейка BIOS CR2032', true, '9');
INSERT INTO part (name, is_necessary, count) VALUES ('Кабель питания', true, '19');
INSERT INTO part (name, is_necessary, count) VALUES ('VGA-кабель', true, '12');
INSERT INTO part (name, is_necessary, count) VALUES ('Сетевой фильтр', true, '10');
INSERT INTO part (name, is_necessary, count) VALUES ('Блок бесперебойного питания', false, '4');
INSERT INTO part (name, is_necessary, count) VALUES ('Картридер', false, '0');