package com.lstech.api_test_automation.api.safeentry.logic;

import com.lstech.api_test_automation.api.common.http.HttpClient;
import com.lstech.api_test_automation.api.config.EnvironmentConfig;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ResidentRegistrationLogic {

    private final EnvironmentConfig envConfig;
    private final HttpClient httpClient;

    private Response response;
    private String step;

    public ResidentRegistrationLogic() {
        this.envConfig = new EnvironmentConfig();
        this.httpClient = new HttpClient(envConfig);
    }

    // Cenário 1: Cadastrar Um Morador Com Sucesso
    public void generateResidentData() {
        try {

        } catch (Exception e) {

        }
    }

    public void residentRegistration() {
        try {

        } catch (Exception e) {

        }
    }

    public void validateStatusCodeAndResponseBody() {
        try {

        } catch (Exception e) {

        }
    }

}
