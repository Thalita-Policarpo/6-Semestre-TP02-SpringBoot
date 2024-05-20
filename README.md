# 6-Semestre-TP02-SpringBoot
 Teste de Performace 2

# Introdução à API de Produtos
Esta API foi desenvolvida para gerenciar produtos em um sistema de cadastro. Ela é composta por um conjunto de endpoints que permitem a criação, consulta, atualização e exclusão de produtos.

A API é estruturada em torno do objeto Produto, que possui atributos como id, nome, descricao, preco e quantidade. O id é gerado automaticamente quando um novo produto é criado.

Os principais endpoints da API são:

• POST /produtos: Cria um novo produto.

• GET /produtos: Retorna uma lista de todos os produtos.

• GET /produtos/{id}: Retorna os detalhes de um produto específico.

• PUT /produtos/{id}: Atualiza os detalhes de um produto específico.

• DELETE /produtos/{id}: Exclui um produto específico.

Cada endpoint retorna uma resposta HTTP apropriada com base no resultado da operação. Por exemplo, se a criação de um produto for bem-sucedida, o endpoint POST /produtos retornará o status HTTP 201 (CREATED) junto com os detalhes do produto criado.
