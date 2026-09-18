package com.lstech.api_test_automation.api.safeentry.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lstech.api_test_automation.api.safeentry.logic.ResidentRegistrationLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResidentRegistrationSteps {

    private final ResidentRegistrationLogic residentRegistrationLogic;

    public ResidentRegistrationSteps() {
        residentRegistrationLogic = new ResidentRegistrationLogic();
    }

    // Cenário 1: Cadastrar Um Morador Com Sucesso
    @Given("que o nome, sobrenome, documento, residencia sao validos")
    public void que_o_nome_sobrenome_documento_residencia_sao_validos() {
        residentRegistrationLogic.generateResidentData();
    }

    @When("o sistema enviar uma requisicao POST com dados validos para API SafeEntry")
    public void o_sistema_enviar_uma_requisicao_post_com_dados_validos_para_api_safe_entry() throws JsonProcessingException {
        residentRegistrationLogic.residentRegistration();
    }

    @Then("retorna status code {int} e uma mensagem de sucesso")
    public void retorna_status_code_e_uma_mensagem_de_sucesso(int int1) {
        residentRegistrationLogic.validateStatusCodeAndResponseBody();
    }

}
