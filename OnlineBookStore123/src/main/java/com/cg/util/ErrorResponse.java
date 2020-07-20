package com.cg.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    private final String error;

    private final String errordescription;

    @JsonCreator
    public ErrorResponse(@JsonProperty("error") String error, @JsonProperty("errordescription") String errordescription) {
        if (error != null) error = error.toLowerCase();
        this.error = error;
        this.errordescription = errordescription;
    }

    public String getError() {
        return error;
    }

    public String getErrordescription() {
        return errordescription;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "error='" + error + '\'' +
                ", errordescription='" + errordescription + '\'' +
                '}';
    }
}