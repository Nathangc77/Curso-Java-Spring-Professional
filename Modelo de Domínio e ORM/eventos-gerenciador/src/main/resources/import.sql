INSERT INTO tb_participant(name, email) VALUES ('José Silva', 'jose@gmail.com');
INSERT INTO tb_participant(name, email) VALUES ('Tiago Faria', 'thiago@gmail.com');
INSERT INTO tb_participant(name, email) VALUES ('Maria do Rosário', 'maria@gmail.com');
INSERT INTO tb_participant(name, email) VALUES ('Teresa Silva', 'Teresa@gmail.com');

INSERT INTO tb_category(description) VALUES ('Curso');
INSERT INTO tb_category(description) VALUES ('Oficina');

INSERT INTO tb_activity(name, description, price, category_id) VALUES ('Curso de HTML', 'Aprenda HTML de forma prática', 80.00, 1);
INSERT INTO tb_activity(name, description, price, category_id) VALUES ('Oficina de Github', 'Controle versões de seus projetos', 50.00, 2);

INSERT INTO tb_activity_participant(activity_id, participant_id) VALUES (1, 1);
INSERT INTO tb_activity_participant(activity_id, participant_id) VALUES (2, 1);
INSERT INTO tb_activity_participant(activity_id, participant_id) VALUES (1, 2);
INSERT INTO tb_activity_participant(activity_id, participant_id) VALUES (1, 3);
INSERT INTO tb_activity_participant(activity_id, participant_id) VALUES (2, 3);
INSERT INTO tb_activity_participant(activity_id, participant_id) VALUES (2, 4);

INSERT INTO tb_session(start_time, end_time, activity_id) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-25T08:00:00Z', TIMESTAMP WITH TIME ZONE '2017-09-25T11:00:00Z', 1);
INSERT INTO tb_session(start_time, end_time, activity_id) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-25T14:00:00Z', TIMESTAMP WITH TIME ZONE '2017-09-25T18:00:00Z', 2);
INSERT INTO tb_session(start_time, end_time, activity_id) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-26T08:00:00Z', TIMESTAMP WITH TIME ZONE '2017-09-26T11:00:00Z', 2);