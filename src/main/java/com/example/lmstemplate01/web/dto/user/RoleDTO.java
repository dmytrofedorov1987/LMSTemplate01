package com.example.lmstemplate01.web.dto.user;

import com.example.lmstemplate01.web.dto.validators.uniqueValidators.FieldUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
