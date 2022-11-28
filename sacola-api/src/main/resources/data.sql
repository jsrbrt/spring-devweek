INSERT INTO restaurante (id, cep, complemento, nome) VALUES
(1L, '0000001', 'Próximo à br', 'Restaurante de Sushi'),
(2L, '0000002', 'Na esquina da rua 2', 'Pizzaria');

INSERT INTO cliente (id, cep, complemento, nome) VALUES
(1L, '0000001', 'Casa, próximo à rua 1', 'Roberto');

INSERT INTO produto (id, disponivel, nome, valor_unitario, restaurante_id) VALUES
(1L, true, 'Sushi', 30.0, 1L),
(2L, true, 'Temaki', 35.0, 1L),
(3L, true, 'Pizza', 23.0, 2L);

INSERT INTO sacola (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
(1L, 0, false, 0.0, 1L);