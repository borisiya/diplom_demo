package com.Project.diplom.shared.validation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Error {
    private String fieldName;
    private String errorCode;

    public static Error fieldValidationError(String fieldName, String errorCode) {
        Error error = new Error();
        error.fieldName = fieldName;
        error.errorCode = errorCode;
        return error;
    }

    @JsonGetter("fieldName")
    public String getFieldName() {
        return fieldName;
    }

    @JsonGetter("errorCode")
    public String getErrorCode() {
        return errorCode;
    }

}
