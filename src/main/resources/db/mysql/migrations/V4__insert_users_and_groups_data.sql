INSERT INTO user_groups (name) VALUES ('admin');
INSERT INTO users (name, username,
                             user_password,
                             email, group_id)
VALUES ('Loiane Groner', 'loiane',
        '$2a$10$2a4e8803c91cc5edca222evoNPfhdRyGEG9RZcg7.qGqTjuCgXKda',
        'me@loiane.com', '1');