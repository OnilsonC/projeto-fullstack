insert into usuario (id, nome, login, senha, email, situacao) values (1, 'Onilson', 'onilson', '1234', 'teste@teste.com', 'ATIVO');
ALTER SEQUENCE usuario_id_seq RESTART WITH 2;

insert into perfil (id, descricao)  values (1, 'Admin');
ALTER SEQUENCE perfil_id_seq RESTART WITH 2;

insert into recurso (id, nome, chave) values (1, 'Tela usuário','usuario');
ALTER SEQUENCE recurso_id_seq RESTART WITH 2;

insert into perfil_usuario (id, usuario_id, perfil_id) values (1, 1, 1);
ALTER SEQUENCE perfil_usuario_seq RESTART WITH 2;
