# Desafio 1 - Engenharia de Dados

## Descrição

Este projeto consiste em uma série de queries SQL realizadas no banco de dados público **AdventureWorks**. O objetivo é responder a perguntas de negócio relacionadas às áreas de vendas, clientes e performance de vendedores.

O banco de dados **AdventureWorks** representa uma empresa fictícia de comércio de bicicletas e acessórios, e é amplamente utilizado para fins de aprendizado e testes de SQL e análise de dados.

## Tecnologias Utilizadas

- **MySQL**: Utilizado para executar as queries SQL.
- **HeidiSQL**: Ferramenta utilizada para gerenciar o banco de dados e exportar os resultados das queries.

## Desenvolvimento da Solução

1. **Configuração do Ambiente**:
   - O banco de dados **AdventureWorks** foi carregado no MySQL.
   - As queries foram desenvolvidas e testadas utilizando o HeidiSQL.

2. **Execução das Queries**:
   - As seguintes queries foram elaboradas para responder às perguntas de negócio:

     1. **Top 10 Produtos Mais Vendidos (Bicicletas)**:
        - Identificar os 10 produtos mais vendidos (em quantidade) na categoria "Bicicletas", considerando apenas vendas feitas nos últimos dois anos.

     2. **Cliente com Maior Número de Pedidos**:
        - Encontrar o cliente com o maior número de pedidos realizados, considerando apenas clientes que fizeram pelo menos um pedido em cada trimestre do último ano fiscal.

     3. **Mês com Maior Receita (Vendas Acima de 500)**:
        - Determinar em qual mês do ano ocorrem mais vendas (em valor total), considerando apenas os meses em que a receita média por venda foi superior a 500 unidades monetárias.

        - **Nota**: Esta query não retornou resultados, pois a receita média por venda em todos os meses analisados foi inferior a 500 unidades monetárias. Isso significa que, para os dados disponíveis no banco **AdventureWorks**, não há nenhum mês que atenda ao critério estabelecido.

     4. **Vendedores com Performance Acima da Média**:
        - Identificar os vendedores que tiveram vendas com valor acima da média no último ano fiscal e também tiveram um crescimento de vendas superior a 10% em relação ao ano anterior.

     5. **Extra - Pergunta de Negócio**:
        - Quais são os 5 produtos mais vendidos em termos de quantidade em cada categoria de produto no último ano fiscal, e qual é a média de vendas desses produtos dentro de suas respectivas categorias?

3. **Exportação dos Resultados**:
   - Os resultados das queries foram exportados para arquivos CSV utilizando a funcionalidade "Export Grid Data" do HeidiSQL.
   - Os arquivos CSV estão organizados na pasta `resultados/`, e cada arquivo é nomeado de acordo com a query correspondente.

## Instruções para Reproduzir

1. **Clonar o Repositório**:
   - Clone este repositório para o seu ambiente local usando o comando:
     ```bash
     git clone https://github.com/seuusuario/adventureworks-desafio.git
     ```

2. **Importar o Banco de Dados**:
   - Importe o banco de dados **AdventureWorks** no MySQL.

3. **Executar as Queries**:
   - Utilize os arquivos `.sql` para executar  as queries utilizadas neste desafio.
   - As queries podem ser executadas diretamente no MySQL ou através de uma ferramenta como o HeidiSQL, Workbench, etc.


