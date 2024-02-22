CREATE TABLE IF NOT EXISTS user_groups(
    id  INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS users
(
    id INT  NOT NULL AUTO_INCREMENT,
    name     VARCHAR(100) NOT NULL,
    username VARCHAR(20)  NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    picture  VARCHAR(100) NULL,
    group_id INT          NOT NULL,
    PRIMARY KEY (id, group_id),
    UNIQUE INDEX username_UNIQUE (username ASC),
    INDEX fk_User_Group1_idx (group_id ASC),
    CONSTRAINT fk_User_Group1
        FOREIGN KEY (group_id)
            REFERENCES user_groups (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;;