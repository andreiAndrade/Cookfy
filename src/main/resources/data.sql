INSERT INTO user_tab (date_created, date_updated, email, name, username)
VALUES ('2015-09-09 21:46:44', '2015-09-09 21:46:44', 'andrei@gmail.com', 'andrei andrade', 'andrei');
INSERT INTO user_tab (date_created, date_updated, email, name, username)
VALUES ('2015-09-09 21:46:44', '2015-09-09 21:46:44', 'paula@gmail.com', 'paula bol', 'paula');
INSERT INTO user_tab (date_created, date_updated, email, name, username)
VALUES ('2015-09-09 21:46:44', '2015-09-09 21:46:44', 'bruno@gmail.com', 'bruno fontenelle', 'bruno');
INSERT INTO user_tab (date_created, date_updated, email, name, username)
VALUES ('2015-09-09 21:46:44', '2015-09-09 21:46:44', 'thiago@gmail.com', 'thiago mazuhim', 'thiago');

INSERT INTO user_identity (user_id, hash, adapter, date_created, date_updated)
VALUES (1, 'andrei', 'application', '2015-09-09 21:46:44', '2015-09-09 21:46:44');
INSERT INTO user_identity (user_id, hash, adapter, date_created, date_updated)
VALUES (2, 'paula', 'application', '2015-09-09 21:46:44', '2015-09-09 21:46:44');
INSERT INTO user_identity (user_id, hash, adapter, date_created, date_updated)
VALUES (3, 'bruno', 'application', '2015-09-09 21:46:44', '2015-09-09 21:46:44');
INSERT INTO user_identity (user_id, hash, adapter, date_created, date_updated)
VALUES (4, 'thiago', 'application', '2015-09-09 21:46:44', '2015-09-09 21:46:44');


INSERT INTO ingredient (description, name) VALUES ('teste', 'arroz integral');
INSERT INTO ingredient (description, name) VALUES ('teste', 'feijão carioca');
INSERT INTO ingredient (description, name) VALUES ('teste', 'massa tipo espaguete');
INSERT INTO ingredient (description, name) VALUES ('teste', 'batata inglesa');
INSERT INTO ingredient (description, name) VALUES ('teste', 'carne bovina');
INSERT INTO ingredient (description, name) VALUES ('teste', 'ovo de galinha');
INSERT INTO ingredient (description, name) VALUES ('teste', 'sal');
INSERT INTO ingredient (description, name) VALUES ('teste', 'alho');
INSERT INTO ingredient (description, name) VALUES ('teste', 'cebola');
INSERT INTO ingredient (description, name) VALUES ('teste', 'molho de tomate');
INSERT INTO ingredient (description, name) VALUES ('teste', 'pimenta do reino');
INSERT INTO ingredient (description, name) VALUES ('teste', 'tempero verde');
INSERT INTO ingredient (description, name) VALUES ('teste', 'bacon');
INSERT INTO ingredient (description, name) VALUES ('teste', 'carne de frango');
INSERT INTO ingredient (description, name) VALUES ('teste', 'água');

INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'HARD', 'Ala minuta', '0:30', 1);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'MEDIUM', 'Ovo Frito', '0:30', 2);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'HARD', 'Massa com frango', '0:30', 1);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'MEDIUM', 'Bife a milanesa', '0:30', 2);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'EASY', 'Pizza de frango', '0:30', 3);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'MEDIUM', 'Lasanha', '0:30', 3);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'HARD', 'Risoto', '0:30', 4);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('1:00', 'teste', 'EASY', 'Carreteiro', '0:30', 4);

INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1/2 xícara', 1, 1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1/2 xícara', 2, 1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 bife', 5, 1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('4', 4, 1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1', 6, 1);


insert INTO recipe_book (name, user_id)
VALUES ('Cafe da manha', '3');