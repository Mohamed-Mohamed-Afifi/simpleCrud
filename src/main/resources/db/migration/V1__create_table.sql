
create table core.users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    uname VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL unique,
    age INT,
    phone VARCHAR(11),
    PRIMARY KEY ( id )
);
