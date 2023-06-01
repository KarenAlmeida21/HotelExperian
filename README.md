# Hotel Serasa Experian

## Descrição
O Hotel Serasa é um sistema de gerenciamento de hospedagem em um hotel fictício. Ele permite cadastrar hóspedes, realizar check-ins e check-outs, e calcular custos de hospedagem.

## Tecnologias utilizadas
- Spring Web
- Java 11
- Spring Boot
- PostgreSQL
- Lombok
- Validation
- JUnit 4
- Mockito
- ModelMapper

## Endpoints

### Hospedes

- Cadastrar hóspede: [POST /hospedes/cadastrar-hospede](http://localhost:8080/hospedes/cadastrar-hospede)
- Listar hóspedes: [GET /hospedes/listar-hospedes](http://localhost:8080/hospedes/listar-hospedes)
- Detalhes do hóspede: [GET /hospedes/{id}](http://localhost:8080/hospedes/33)
- Atualizar hóspede: [PUT /hospedes/atualizar-hospede/{id}](http://localhost:8080/hospedes/atualizar-hospede/777777)

### Check-ins

- Realizar check-in: [POST /check-ins/realiza-check-in](http://localhost:8080/check-ins/realiza-check-in)
- Buscar hóspede por documento: [GET /check-ins/busca-hospede-documento/{documento}](http://localhost:8080/check-ins/busca-hospede-documento/90)
- Buscar por telefone: [GET /check-ins/buscar-por-telefone/{telefone}](http://localhost:8080/check-ins/buscar-por-telefone/767676789)
- Buscar hóspede por nome: [GET /check-ins/buscar-hospede-nome/{nome}](http://localhost:8080/check-ins/buscar-hospede-nome/Carlos)
- Calcular previsão de custo: [GET /check-ins/calcular-previsao-custo/{id}](http://localhost:8080/check-ins/calcular-previsao-custo/23)

### Check-outs

- Realizar check-out: [POST /checkouts/realiza-checkout](http://localhost:8080/checkouts/realiza-checkout)
- Listar check-outs: [GET /checkouts/listar-checkouts](http://localhost:8080/checkouts/listar-checkouts)
- Deletar check-out: [DELETE /checkouts/deleta-checkout/{id}](http://localhost:8080/checkouts/deleta-checkout/37)
- Documento do hóspede no check-out: [GET /checkouts/documento-hospede/{id}](http://localhost:8080/checkouts/documento-hospede/098)
- Calcular valor da hospedagem: [GET /checkouts/calcular-valor-hospedagem/{id}](http://localhost:8080/checkouts/calcular-valor-hospedagem/37)

## Configuração do ambiente
1. Clone o repositório.
2. Configure o banco de dados PostgreSQL.
3. Execute o projeto no ambiente de desenvolvimento.

## Contribuição
Contribuições são sempre bem-vindas! Sinta-se à vontade para enviar pull requests e relatar problemas.

## Licença
Este projeto está licenciado sob a licença [MIT](LICENSE).
