package com.lstech.api_test_automation.api.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            if (obj == null) {
                return "null";
            }
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("Erro na conversão do objeto para JSON: {}", e.getMessage());
            return "----- Erro ao gerar o JSON dos dados -----" + e.getMessage();
        }
    }
}
