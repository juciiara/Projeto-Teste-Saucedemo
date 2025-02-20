@login @regressivo

Feature: Login

Background: Acessar a tela de login
Given que nao esteja logado

@positivo
Scenario: Login com sucesso
 
  When preencher campo nome
  And preencher senha
  And clicar no botao de login
  Then login realizado

@negativo
Scenario: Login senha errada

  When preencher campo nome
  And preencher senha errada
  And clicar no botao de login
  Then sistema exibe mensagem de erro

@negativo  
Scenario: Login com user invalido  
  
  When preencher campo user invalido  
  And preencher senha valida 
  And clicar no botao de login  
  Then sistema exibe mensagem de erro  

@negativo  
Scenario: Login com user bloqueado  

  When preencher campo nome user bloqueado  
  And preencher senha  
  And clicar no botao de login  
  Then sistema exibe mensagem de usuer bloqueado  
 


