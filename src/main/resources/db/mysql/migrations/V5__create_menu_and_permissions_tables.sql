CREATE TABLE IF NOT EXISTS menu
(
    id        INT         NOT NULL AUTO_INCREMENT,
    text      VARCHAR(100) NOT NULL,
    iconCls   VARCHAR(100) NULL,
    className VARCHAR(100) NULL,
    menu_id   INT         NULL,
    PRIMARY KEY (id),
    INDEX fk_menu_menu1_idx (menu_id ASC),
    CONSTRAINT fk_menu_menu1
        FOREIGN KEY (menu_id)
            REFERENCES menu (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS permissions
(
    menu_id  INT NOT NULL,
    group_id INT NOT NULL,
    PRIMARY KEY (menu_id, group_id),
    INDEX fk_permissions_groups1_idx (group_id ASC),
    CONSTRAINT fk_permissions_menu1
        FOREIGN KEY (menu_id)
            REFERENCES menu (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_permissions_groups1
        FOREIGN KEY (group_id)
            REFERENCES user_groups (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;
