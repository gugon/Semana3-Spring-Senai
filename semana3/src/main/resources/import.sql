INSERT INTO public.forma_pagamento(descricao) VALUES ('Credito, cartao VISA');
INSERT INTO public.forma_pagamento(descricao) VALUES ('Debitom, cartao Master Card');

INSERT INTO public.produto (data_hora_alteracao, data_hora_cadastro, descricao, preco_compra, preco_venda) VALUES (null,timezone('utc', CURRENT_TIMESTAMP(0)),'Bolacha de coco','3.00','8.96');
INSERT INTO public.produto (data_hora_alteracao, data_hora_cadastro, descricao, preco_compra, preco_venda) VALUES (null,timezone('utc', CURRENT_TIMESTAMP(0)),'Bolacha de chocolate','4.50','10.00');


-- INSERT INTO public.produto(data_hora_alteracao,data_hora_cadastro,descricao,preco_compra,preco_venda) VALUES (null,'22:43:35','comprou cois pkas','2.6','4.6');

-- INSERT INTO public.produto(descricao, preco_unitario) VALUES ('Laranja Suco', '4.40');
--
-- INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, nome, senha) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)),timezone('utc', CURRENT_TIMESTAMP(0)), 'brunomoura', 'Bruno Moura', '102030');
-- INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, nome, senha) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)),timezone('utc', CURRENT_TIMESTAMP(0)), 'rodrigoferreira', 'Rodrigo Ferreira', '907080');
-- INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, nome, senha) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)),timezone('utc', CURRENT_TIMESTAMP(0)), 'rafaelbastos', 'Rafael Bastos', '302010');
-- INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, nome, senha) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)),timezone('utc', CURRENT_TIMESTAMP(0)), 'danielamartins', 'Daniela Martins', '987465');
-