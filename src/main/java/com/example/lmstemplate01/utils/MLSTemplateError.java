package com.example.lmstemplate01.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MLSTemplateError {
    private int statusCode;
    private String message;

    public MLSTemplateError(HttpStatus badRequest, String message) {
    }

    public MLSTemplateError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

}
