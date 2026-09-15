package com.lstech.api_test_automation.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = new Properties();
    static {
        try (InputStream input = EnvironmentConfig.class
                .getClassLoader()
                .getResourceAsStream("environment-config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel carregar environment-config.properties", e);
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }
}
