package com.example.lmstemplate01.dto.ResultDTOPackege;

public abstract class ResultDTO {
    protected String responseMassage = "OK";

    public ResultDTO() {
    }

    public ResultDTO(String responseMassage) {
        this.responseMassage = responseMassage;
    }

    public String getResponseMassage() {
        return responseMassage;
    }

    public void setResponseMassage(String responseMassage) {
        this.responseMassage = responseMassage;
    }
}
