@login @regressivo

Feature: Login

Background: Acessar a tela de login
Given que nao esteja logado

@positivo
Scenario: Login valido

When peencher campo nome
And preencher senha
And clicar no botao de login
Then login realizado

@negativo
Scenario: Login invalido

When peencher campo nome
And preencher senha errada
And clicar no botao de login
Then sistema exibe mensagem de erro
