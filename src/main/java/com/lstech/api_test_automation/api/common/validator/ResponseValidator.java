package com.lstech.api_test_automation.api.common.validator;

public abstract class ResponseValidator {

    protected ResponseValidator() {
    }

    public enum StatusCode {
        OK(200, "OK"),
        CREATED(201, "Created"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found");

        private final int code;
        private final String description;

        StatusCode(int code, String description){
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum ErrorPath {
        ERRORS("error");

        private final String path;

        ErrorPath(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

}
