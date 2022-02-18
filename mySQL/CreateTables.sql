drop schema if exists OnlineShop;
CREATE SCHEMA if not exists OnlineShop ;
#-------- See datasheet/DatabaseDiagram.ccd ---------
use OnlineShop;

    CREATE TABLE if not exists Users (
        id INT primary key NOT NULL auto_increment,
        username VARCHAR(45) not NULL,
        password VARCHAR(45) not NULL,
        role ENUM('Admin', 'Client','Worker') not NULL
    );

    CREATE TABLE if not exists Products (
        id INT primary key NOT NULL auto_increment,
        name VARCHAR(45) not NULL,
        price float not null,
        description varchar(600),
        pic1 varchar (200) not null ,
        pic2 varchar (200),
        pic3 varchar (200)
        );

    Create table if not exists Orders (
        id Int  primary key not null auto_increment,
        idUser Int not null,
        idProduct Int not null,
        quantity Int not null,
        seen_by_worker boolean not null,
        FOREIGN KEY (idUser) REFERENCES Users(id),
        FOREIGN KEY (idProduct) REFERENCES Products(id)
    );