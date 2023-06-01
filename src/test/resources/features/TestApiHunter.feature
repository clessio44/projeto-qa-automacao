# language: pt
Funcionalidade: Criação de regressivos para testes de API da hunter

  @ct001
  Cenário: Deve executar primeiro teste com verbo GET
    Dado que valido o resultado positivo esperado com comando GET

  @ct002
  Cenário: Deve Recuperar todos leads cadastrados
    Dado que envio uma requisicao GET para recuperar todos os leads

  @ct003
  Cenário: Deve Recuperar lead específico
    Dado que envio uma requisicao GET para recuperar lead

  @ct004
  Cenário: Deve Criar novo lead
    Dado que envio uma requisicao POST para criacao de lead

  @ct005
  Cenário: Deve Editar lead
    Dado que envio uma requisicao PUT para editar o lead especifico

  @ct006
  Cenário: Deve Excluir lead
    Dado que envio uma requisicao DELETE para deletar o lead especifico

  @ct007
  Cenário: Deve Recuperar todas as listas de leads cadastradas
    Dado que envio uma requisicao GET para receber uma lista

  @ct008
  Cenário: Deve Recuperar listas de leads especifica
    Dado que envio uma requisicao GET para receber uma lista especifica

  @ct009
  Cenário: Deve Criar nova lista de lead
    Dado que envio uma requisicao POST para criar nova lista

  @ct010
  Cenário: Deve Editar lista de lead
    Dado que envio uma requisicao PUT para editar lista de lead

  @ct011
  Cenário: Deve Excluir lista de lead
    Dado que envio uma requisicao DELETE para deletar uma lista de lead especifica
