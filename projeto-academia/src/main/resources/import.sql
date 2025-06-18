INSERT INTO tb_pessoa(nome, cpf, endereco, telefone) VALUES (' Fernanda Almeida', '123.456.789-00', 'Rua das Flores, 123 - Centro', '(31) 98765-4321')
INSERT INTO tb_pessoa(nome, cpf, endereco, telefone) VALUES ('Mariana Morais', '987.654.321-00', 'Av. Brasil, 456 - Bairro Novo', '(11) 99876-1234');
INSERT INTO tb_pessoa(nome, cpf, endereco, telefone) VALUES ('Marcela Freitas', '321.789.654-00', 'Rua Projetada, 89 - Jardim Esperança', '(21) 91234-5678');

INSERT INTO tb_plano(descricao,parcelas,valor) VALUES ('Plano Básico', 3, 150.00)
INSERT INTO tb_plano(descricao, parcelas, valor) VALUES ('Plano Intermediário', 6, 270.00);
INSERT INTO tb_plano(descricao, parcelas, valor) VALUES ('Plano Premium', 12, 480.00);

INSERT INTO tb_exercicio(nome) VALUES ('Supino Reto');
INSERT INTO tb_exercicio(nome) VALUES ('Agachamento Livre');
INSERT INTO tb_exercicio(nome) VALUES ('Leg Press');

INSERT INTO tb_ficha(data, descricao, situacao, id_pessoa) VALUES ('2025-06-10', 'Ficha de treino para iniciantes', 'Ativa', 1);
INSERT INTO tb_ficha(data, descricao, situacao, id_pessoa) VALUES ('2025-05-22', 'Treino de hipertrofia - nível intermediário', 'Ativa', 2);
INSERT INTO tb_ficha(data, descricao, situacao, id_pessoa) VALUES ('2025-04-15', 'Ficha desativada por inatividade', 'Inativa', 3);

INSERT INTO tb_matricula(numero, data, situacao, id_plano, id_pessoa) VALUES ('20250001', '2025-06-12', 'Ativa', 1, 1);
INSERT INTO tb_matricula(numero, data, situacao, id_plano, id_pessoa) VALUES ('20250002', '2025-06-12', 'Trancada', 2, 2);
INSERT INTO tb_matricula(numero, data, situacao, id_plano, id_pessoa) VALUES ('20250003', '2025-06-12', 'Cancelada', 3, 3);

INSERT INTO tb_pagamento(data_vencimento, data_pagamento, valor, id_matricula) VALUES ('2025-06-30', '2025-06-28', 150.00, 1);
INSERT INTO tb_pagamento(data_vencimento, data_pagamento, valor, id_matricula) VALUES ('2025-07-30', '2025-07-29', 200.00, 2);
INSERT INTO tb_pagamento(data_vencimento, data_pagamento, valor, id_matricula) VALUES ('2025-08-30', '2025-08-25', 250.00, 3);

-- tb_usuario
INSERT INTO tb_usuario(login, senha, tipo, id_pessoa) VALUES ('fernanda.a', 'abc123', 'ADM', 1);
INSERT INTO tb_usuario(login, senha, tipo, id_pessoa) VALUES ('mariana.m', 'def456', 'USER', 2);
INSERT INTO tb_usuario(login, senha, tipo, id_pessoa) VALUES ('marcela.f', 'ghi789', 'USER', 3);


INSERT INTO tb_ficha_exercicio(series, repeticoes, id_exercicio, id_ficha) VALUES (3, 12, 2, 1);
INSERT INTO tb_ficha_exercicio(series, repeticoes, id_exercicio, id_ficha) VALUES (4, 10, 1, 2);
INSERT INTO tb_ficha_exercicio(series, repeticoes, id_exercicio, id_ficha) VALUES (2, 15, 3, 3);
