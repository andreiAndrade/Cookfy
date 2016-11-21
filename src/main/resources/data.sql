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
INSERT INTO ingredient (description, name) VALUES ('teste', 'batata');
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
INSERT INTO ingredient (description, name) VALUES ('teste','miolo de alcatra');
INSERT INTO ingredient (description, name) VALUES ('teste','farinha de trigo');
INSERT INTO ingredient (description, name) VALUES ('teste','pimenta do reino');
INSERT INTO ingredient (description, name) VALUES ('teste','margarina');
INSERT INTO ingredient (description, name) VALUES ('teste','azeite');
INSERT INTO ingredient (description, name) VALUES ('teste','cerveja');
INSERT INTO ingredient (description, name) VALUES ('teste','limao');
INSERT INTO ingredient (description, name) VALUES ('teste','creme de leite');
INSERT INTO ingredient (description, name) VALUES ('teste','alcatra');
INSERT INTO ingredient (description, name) VALUES ('teste','salsinha');
INSERT INTO ingredient (description, name) VALUES ('teste','queijo parmesao');
INSERT INTO ingredient (description, name) VALUES ('teste','farinha de rosca');
INSERT INTO ingredient (description, name) VALUES ('teste','oleo');
INSERT INTO ingredient (description, name) VALUES ('teste','feijao');
INSERT INTO ingredient (description, name) VALUES ('teste','brocolis');
INSERT INTO ingredient (description, name) VALUES ('teste','amido de milho');
INSERT INTO ingredient (description, name) VALUES ('teste','acucar');
INSERT INTO ingredient (description, name) VALUES ('teste','leite');
INSERT INTO ingredient (description, name) VALUES ('teste','fermento');
INSERT INTO ingredient (description, name) VALUES ('teste','coco');
INSERT INTO ingredient (description, name) VALUES ('teste','chocolate granulado');
INSERT INTO ingredient (description, name) VALUES ('teste','amora');
INSERT INTO ingredient (description, name) VALUES ('teste','leite condensado');

INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('10', 'Tempere os bifes com sal e pimenta, e passe na farinha;Frite de ambos os lados na margarina misturada com o azeite; Reserve ainda quentes;A gordura que ficou, acrescente a cerveja e deixe ferver ate reduzir a metade;Adicione o suco de limao e o creme de leite;Ferva por mais 2 minutos;Tempere com sal e pimenta, regue os bifes com este molho e sirva;', 'EASY', 'Bife com cerveja', '30', 1);
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('10', 'Elimine as gorduras dos bifes;Tempere com sal, pimenta, alho e salsinha. Reserve por 30 minutos;Bata os ovos, adicione a agua, sal e o queijo;Empane os vifes, um a um, passe o primeiro na farinha de trigo, depois no preparado de ovos e, por ultimo, na farinha de rosca;Aqueca o oleo numa frigideira e frite os bifes ate dourarem de um lado;Vire e frite do outro lado;Escorra em papel-toalha e sirva;', 'EASY', 'Bife a milanesa', '30',2 );
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('15', 'Coloque o feijao, a batata e a agua numa panela grande e leve ao fogo;Cozinhe ate a batata ficar macia;Bata no liquidificador e leve de volta ao fogo;A parte, aqueca o oleo;Refogue o alho e a cebola;Junte esse tempero a panela com o feijao e tempere com sal;Quando estiver no ponto desejado de cozimento, tire do fogo e sirva;Regue cada porcao com um fio de azeite;', 'EASY', 'Sopa Caipira', '15',3 );
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('10', 'Pegue a cebola e refogue em um pouco de azeite;Limpe os brocolis e separe em buques;Misture ao refogado junto com as batatas descascadas e cortadas em pequenos pedacos;Acrescente a agua, tempere e cozinhe;Quando tudo estiver cozido bata no liquidificador e passe por uma peneira grossa;Junte a margarina e sirva;', 'EASY', 'Creme de brocolis', '15',4 );
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('20', 'Misture todos os ingredientes ate a massa ficar homogenea;Faca bolinhas e amasse com um garfo;Preaqueca o forno;Coloque a massa numa forma levemente untada com margarina;Asse em forno medio;', 'EASY', 'Biscoitos da vovo', '10',1 );
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('25', 'Bata as claras em neve e reserve;Bata as gemas, o acucar e o amido de milho;Acrescente, sem bater, a farinha, o leite e o fermento;Adicione o coco e o chocolate granulado;Envolva delicadamente as claras em neve;Unte uma forma com furo central e leve ao forno preaquecido por 25 minutos;', 'EASY', 'Bolo formigueiro', '20',2 );
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('15', 'Lave as amoras;Coloque numa panela com a agua e ferva ate que fiquem macias e se desmanchando;Passe tudo por um pano fino;Leve ao fogo com o acucar e ferva mais um pouco ate engrossar;Se quiser conservar essa geleia, coloque em vidros e esterilize em banho-maria;', 'EASY', 'Geleia de amora', '15',3 );
INSERT INTO recipe (cook_time, description, difficulty, name, prep_time, chef_id)
VALUES ('30', 'Coloque todos os ingredientes em uma panela grossa;Misture bem e leve ao fogo baixo, mexendo sempre com uma colher de pau;Quando comecar a engrossar e soltar da panela, esta pronto;Unte a pedra da pia com manteiga e, com duas colheres de sopa, va pingando a massa;Deixe esfriar para retirar;', 'EASY', 'Cocada', '30',4 );


INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('4 bifes',16,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto',17,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto',18,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto',7,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 colheres de sopa',19,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 colheres de sopa',20,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1/2 xicara de cha',21,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('suce de 1/2',22,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 colheres de sopa',23,1);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('8 bifes finos', 24, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto', 7, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto', 18, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 dentes', 8, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 colher de sopa', 25, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2', 6, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('4 colheres de sopa', 15, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('50 gramas', 26, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('o suficiente', 17, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('o suficiente', 27, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('o suficiente', 28, 2);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 xicaras de cha', 29, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 descascadas e picadas', 4, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('5 xicaras de cha', 15, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 colheres de sopa', 28, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 dentes picados', 8, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 picada', 9, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto', 7, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('4 xicaras de cha picado', 3, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto', 20, 3);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1', 9, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 colher de sopa', 20, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 kg', 30, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('300 gramas', 4, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1,5 litros', 15, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 colheres de sopa', 19, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto', 7, 4);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 xicaras de cha', 31, 5);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 colheres de sopa', 19, 5);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1', 6, 5);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 pitada', 7, 5);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('a gosto', 32, 5);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('4', 6, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 xicaras de cha', 32, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1/2 xicara de cha', 31, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('3 xicaras de cha', 17, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 xicara de cha', 33, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 colheres de sopa', 34, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('50 gramas', 35, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 xicara de cha', 36, 6);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 1/2 xicara de cha', 15, 7);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('500 gramas', 32, 7);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 kg', 37, 7);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1', 35, 8);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('2 latas', 38, 8);
INSERT INTO recipe_ingredient (measure, ingredient_id, recipe_id)
VALUES ('1 xicara de cha', 32, 8);


insert INTO recipe_book (name, user_id)
VALUES ('Cafe da manha', '3');

insert INTO category (name, description)
VALUES ('Comida Mexicana', 'Coma assistindo RBD');
insert INTO category (name, description)
VALUES('Comida italiana','Mamamia! Toda a cultura italiana no seu prato. Massas, molhos e morangos');
insert INTO category (name, description)
VALUES('Comida caseira','Comida com gostinho de casa.');
insert INTO category (name, description)
VALUES('Comida tailandesa','DESCRICAO DA COMIDA TAILANDESA');
insert INTO category (name, description)
VALUES('Cafe da manha','Tudo para comecar o dia com energia');
insert INTO category (name, description)
VALUES('Sopas','Sopas, cremes e caldos');
insert INTO category (name, description)
VALUES('Sobremesas','Sobremesas e doces');
insert INTO category (name, description)
VALUES('Lanche','Para o lanche');
insert INTO category (name, description)
VALUES('Carnes','As carnes constituem um dos elementos basicos mais importantes da nossa culinaria!');
insert INTO category(name, description)
VALUES('Todas', 'Todas as receitas numa categoria');

insert INTO recipe_category (category_id, recipe_id)
VALUES(9, 1);
insert INTO recipe_category (category_id, recipe_id)
VALUES(9, 2);
insert INTO recipe_category (category_id, recipe_id)
VALUES(6, 3);
insert INTO recipe_category (category_id, recipe_id)
VALUES(6, 4);
insert INTO recipe_category (category_id, recipe_id)
VALUES(8, 5);
insert INTO recipe_category (category_id, recipe_id)
VALUES(8, 6);
insert INTO recipe_category (category_id, recipe_id)
VALUES(7, 7);
insert INTO recipe_category (category_id, recipe_id)
VALUES(7, 8);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 1);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 2);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 3);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 4);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 5);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 6);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 7);
insert INTO recipe_category (category_id, recipe_id)
VALUES(10, 8);

insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 1, 'Tempere os bifes com sal e pimenta, e passe na farinha;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 1, 'Frite de ambos os lados na margarina misturada com o azeite; Reserve ainda quentes;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 1, 'A gordura que ficou, acrescente a cerveja e deixe ferver ate reduzir a metade;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 1, 'Adicione o suco de limao e o creme de leite;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 1, 'Ferva por mais 2 minutos;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(6, 1, 'Tempere com sal e pimenta, regue os bifes com este molho e sirva;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 2, 'Elimine as gorduras dos bifes;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 2, 'Tempere com sal, pimenta, alho e salsinha. Reserve por 30 minutos;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 2, 'Bata os ovos, adicione a agua, sal e o queijo;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 2, 'Empane os vifes, um a um, passe o primeiro na farinha de trigo, depois no preparado de ovos 
				e, por ultimo, na farinha de rosca;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 2, 'Aqueca o oleo numa frigideira e frite os bifes ate dourarem de um lado;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(6, 2, 'Vire e frite do outro lado;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(7, 2, 'Escorra em papel-toalha e sirva;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 3, 'Coloque o feijao, a batata e a agua numa panela grande e leve ao fogo;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 3, 'Cozinhe ate a batata ficar macia;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 3, 'Bata no liquidificador e leve de volta ao fogo;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 3, 'A parte, aqueca o oleo;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 3, 'Refogue o alho e a cebola;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(6, 3, 'Junte esse tempero a panela com o feijao e tempere com sal;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(7, 3, 'Quando estiver no ponto desejado de cozimento, tire do fogo e sirva;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(8, 3, 'Regue cada porcao com um fio de azeite;');		
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 4, 'Pegue a cebola e refogue em um pouco de azeite;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 4, 'Limpe os brocolis e separe em buques;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 4, 'Misture ao refogado junto com as batatas descascadas e cortadas em pequenos pedacos;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 4, 'Acrescente a agua, tempere e cozinhe;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 4, 'Quando tudo estiver cozido bata no liquidificador e passe por uma peneira grossa;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(6, 4, 'Junte a margarina e sirva;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 5, 'Misture todos os ingredientes ate a massa ficar homogenea;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 5, 'Faca bolinhas e amasse com um garfo;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 5, 'Preaqueca o forno;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 5, 'Coloque a massa numa forma levemente untada com margarina;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 5, 'Asse em forno medio;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 6, 'Bata as claras em neve e reserve;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 6, 'Bata as gemas, o acucar e o amido de milho;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 6, 'Acrescente, sem bater, a farinha, o leite e o fermento;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 6, 'Adicione o coco e o chocolate granulado;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 6, 'Envolva delicadamente as claras em neve;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(6, 6, 'Unte uma forma com furo central e leve ao forno preaquecido por 25 minutos;');
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 7, 'Lave as amoras;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 7, 'Coloque numa panela com a agua e ferva ate que fiquem macias e se desmanchando;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 7, 'Passe tudo por um pano fino;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 7, 'Leve ao fogo com o acucar e ferva mais um pouco ate engrossar;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 7, 'Se quiser conservar essa geleia, coloque em vidros e esterilize em banho-maria;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(1, 8, 'Coloque todos os ingredientes em uma panela grossa;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(2, 8, 'Misture bem e leve ao fogo baixo, mexendo sempre com uma colher de pau;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(3, 8, 'Quando comecar a engrossar e soltar da panela, esta pronto;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(4, 8, 'Unte a pedra da pia com manteiga e, com duas colheres de sopa, va pingando a massa;');	
insert INTO RECIPE_STEP (STEP_ORDER, recipe_id, description)
VALUES(5, 8, 'Deixe esfriar para retirar;');