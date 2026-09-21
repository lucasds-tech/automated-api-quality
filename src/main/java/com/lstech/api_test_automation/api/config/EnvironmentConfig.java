package com.lstech.api_test_automation.api.config;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Data
@Builder
@Log4j2
public class EnvironmentConfig {

    private String environment;
    private String baseUrl;
    private String nome;
    private String sobrenome;
    private String documento;
    private String residencia;

    public static EnvironmentConfig forEnvironment(String environment) {
        Properties props = loadProperties();

        return EnvironmentConfig.builder()
                .baseUrl(getProperty((props), "base.url"))
                .nome(getProperty((props), "resident.nome"))
                .sobrenome(getProperty((props), "resident.sobrenome"))
                .documento(getProperty((props), "resident.documento"))
                .residencia(getProperty((props), "resident.residencia"))
                .build();
    }

    private static Properties loadProperties() {
        Properties props = new Properties();

        try (InputStream input = EnvironmentConfig.class.getClassLoader()
                .getResourceAsStream("environment-config.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo 'environment-config.properties não encontrado");
            }
            props.load(input);
        } catch (IOException e) {
            log.error("Erro ao carregar configurações de ambiente: {}", e.getMessage());
            throw new RuntimeException("Falha ao carregar configuração, e");
        }
        return props;
    }

    public static String getProperty(Properties props, String key) {
        return getProperty(props, key);
    }
}
