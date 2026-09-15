package com.lstech.api_test_automation.api.utils;

import com.lstech.api_test_automation.api.config.EnvironmentConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfig {

    public static void init(){
        RestAssured.baseURI = EnvironmentConfig.getBaseUrl().trim();
    }

    public static RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(EnvironmentConfig.getBaseUrl())
                .setContentType(ContentType.JSON)
                .build();
    }

}
