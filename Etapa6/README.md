# RoutePlanner - Etapa 6

Refatoração do projeto desktop para separar interface, regras de negócio e acesso a dados.

## Estrutura
- modelo: classes Rota, Doca e ArquivoImportado.
- servico: regras e validações.
- repositorio: contratos de persistência e implementações em memória/JDBC.
- infra: conexão com banco de dados.
- Main: testes simples solicitados pela atividade.

## SOLID
Foi aplicado principalmente o SRP (Responsabilidade Única). Também foram usados DIP e OCP por meio das interfaces de repositório.

## Teste
Execute a classe Main. Os testes não dependem do MySQL porque usam repositórios em memória.
