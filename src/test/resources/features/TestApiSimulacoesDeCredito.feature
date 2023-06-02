# language: pt
Funcionalidade: Criação de regressivos para testes de API de Simulacoes de Credito

  @ct012
  Cenário: Deve Consultar uma restricao via CPF
    Dado que envio uma request para consultar uma restricao via CPF

  @ct013
  Cenário: Deve Criar uma simulacao
    Dado que envio uma request para criar uma simulacao

  @ct014
  Cenário: Deve Alterar uma simulacao
    Dado que envio uma request para alterar uma simulacao

  @ct015
  Cenário: Deve Consultar todas as simulacoes cadastradas
    Dado que envio uma request para consultar todas as simulacoes cadastradas

  @ct016
  Cenário: Deve Consultar uma simulacao via CPF
    Dado que envio uma request para consultar uma simulacao cadastrada pelo cpf

  @ct017
  Cenário: Deve Remover uma simulacao
    Dado que envio uma request para remover uma simulacao cadastrada via id
