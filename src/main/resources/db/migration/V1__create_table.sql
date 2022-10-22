create table core.users(
                           id INT NOT NULL AUTO_INCREMENT,
                           name VARCHAR(100) NOT NULL,
                           email VARCHAR(40) NOT NULL,
                           dob DATE,
                           phone VARCHAR(15),
                           PRIMARY KEY ( id )
);
