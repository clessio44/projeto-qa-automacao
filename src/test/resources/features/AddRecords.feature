# language: pt
Funcionalidade: Teste

  @tag1
  Cenário: Deve executar primeiro teste
    Dado que acesso o sistema
    Quando realizo o cadastro
    Então valido a finalizacao do teste

  @tag2
  Cenário: Deve executar segundo teste
    Dado que acesso o sistema
    E que realizei a primeira etapa de cadastro
    Quando realizo o retorno com botao
    Então valido a mensagem final
