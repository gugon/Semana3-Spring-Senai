INSERT INTO public.forma_pagamento(descricao) VALUES ('Credito, cartao VISA');
INSERT INTO public.forma_pagamento(descricao) VALUES ('Debitom, cartao Master Card');

INSERT INTO public.produto (data_hora_alteracao, data_hora_cadastro, descricao, preco_compra, preco_venda) VALUES (null,timezone('utc', CURRENT_TIMESTAMP(0)),'Bolacha de coco','3.00','8.96');
INSERT INTO public.produto (data_hora_alteracao, data_hora_cadastro, descricao, preco_compra, preco_venda) VALUES (null,timezone('utc', CURRENT_TIMESTAMP(0)),'Bolacha de chocolate','4.50','10.00');

INSERT INTO public.cliente(cpf, nome, rg) VALUES ('20202020202', 'João', '9898989898');
INSERT INTO public.cliente(cpf, nome, rg) VALUES ('23021154125', 'Pedro', '985232654');
