@rest @data_empty

@createResident
Feature: [SE_POST_AT] Cadastrar Um Morador

    @01
    Scenario: [SE_001] Cadastrar Um Morador Com Sucesso
        Given que o nome, sobrenome, documento, residencia sao validos
        When o sistema enviar uma requisicao POST com dados validos para API SafeEntry
        Then retorna status code 201 e uma mensagem de sucesso
