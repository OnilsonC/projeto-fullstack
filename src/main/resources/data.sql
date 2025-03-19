insert into usuario values (1, 'Onilson', 'onilson', '1234', 'teste@teste.com');

ALTER SEQUENCE usuario_id_seq RESTART WITH 2;

insert into perfil values (1, 'Admin');

ALTER SEQUENCE perfil_id_seq RESTART WITH 2;

insert into recurso values (1, 'admin sistema','SHA32');

ALTER SEQUENCE recurso_id_seq RESTART WITH 2;

insert into perfil_usuario values (1, 1, 1);

ALTER SEQUENCE perfil_usuario_seq RESTART WITH 2;