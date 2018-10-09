# play schema

# --- !Ups
CREATE TABLE Persons (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    lastName varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs
DROP TABLE Persons;