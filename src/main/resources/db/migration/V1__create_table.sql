create table user_db.users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL unique,
    age INT,
    phone VARCHAR(15),
    PRIMARY KEY ( id )
);
