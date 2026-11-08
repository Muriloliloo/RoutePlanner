# Resumo da refatoração

## Problemas encontrados
1. A TelaRota misturava interface, conexão e SQL.
2. A conexão possuía usuário e senha fixos.
3. Rota e Doca eram apenas campos sem encapsulamento.
4. A classe Sistema reunia várias responsabilidades.
5. O ID podia ser digitado manualmente.
6. Existia repetição na limpeza de campos.

## Princípios
- SRP: modelos guardam dados; serviços validam; repositórios armazenam; telas interagem com o usuário.
- DIP: os serviços dependem das interfaces RotaRepository e DocaRepository.
- OCP: outra forma de persistência pode ser criada sem alterar as regras.

## Refatorações
- Extração das classes de serviço.
- Criação do padrão Repository.
- Encapsulamento dos modelos.
- Conexão configurável.
- Uso de try-with-resources no JDBC.
- IDs automáticos.
- Testes no método main().
