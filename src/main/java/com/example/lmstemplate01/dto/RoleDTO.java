package com.example.lmstemplate01.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
    private String id;
    private String label;

    @JsonCreator
    public RoleDTO(@JsonProperty String id,
                   @JsonProperty String label) {
        this.id = id;
        this.label = label;
    }
}
