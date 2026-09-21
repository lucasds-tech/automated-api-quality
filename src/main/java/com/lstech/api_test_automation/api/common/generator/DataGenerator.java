package com.lstech.api_test_automation.api.common.generator;

import com.lstech.api_test_automation.api.config.EnvironmentConfig;
import com.lstech.api_test_automation.api.safeentry.model.request.RequestResidentRegistration;
import lombok.Builder;
import lombok.Data;

public class DataGenerator {

    private final EnvironmentConfig environmentConfig;

    public DataGenerator(EnvironmentConfig environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    // ##### SAFEENTRY RESIDENT REGISTRATION ###################################################################
    public ResidentRegistrationData generateResidentData() {
        String nome = environmentConfig.getNome();
        String sobrenome = environmentConfig.getSobrenome();
        String documento = environmentConfig.getDocumento();
        String residencia = environmentConfig.getResidencia();

        RequestResidentRegistration requestResidentRegistration = RequestResidentRegistration.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .documento(documento)
                .residencia(residencia)
                .build();

        return ResidentRegistrationData.builder()
                .requestResidentRegistration(requestResidentRegistration)
                .build();
    }

    @Data
    @Builder
    public static class ResidentRegistrationData {
        private RequestResidentRegistration requestResidentRegistration;
    }

}
