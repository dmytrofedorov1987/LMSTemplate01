package com.example.lmstemplate01.dto;

import com.example.lmstemplate01.validators.uniqueValidators.FieldUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
    @FieldUnique(field = "id", table = "Role")
    private String id;
    private String label;

    @JsonCreator
    public RoleDTO(@JsonProperty String id,
                   @JsonProperty String label) {
        this.id = id;
        this.label = label;
    }

}
